package com.ds.sgs.service;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ds.msg.TelegramMessage;
import com.ds.sgs.common.BaseCommon;
import com.ds.sgs.dao.DsSgsConfigMapper;
import com.ds.sgs.dao.DsSgsGameMapper;
import com.ds.sgs.dao.DsSgsLiveMapper;
import com.ds.sgs.dao.DsSgsRecordTimeMapper;
import com.ds.sgs.entity.DsSgsConfig;
import com.ds.sgs.entity.DsSgsGame;
import com.ds.sgs.entity.DsSgsLive;
import com.ds.sgs.util.DateUtils;
import com.ds.sgs.util.ErrorUtil;
import com.ds.sgs.util.SgsConfig;
import com.ds.sgs.vo.SgsCsvVo;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

/**
 * sgs注单拉取service
 *
 * @author worf
 * @date 2018年6月7日 下午4:41:18
 */
@Service
public class SgsService {

	private Logger logger = LoggerFactory.getLogger(SgsService.class);

	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;

	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;

	@Autowired
	private DsSgsRecordTimeMapper dsSgsRecordTimeMapper;

	@Autowired
	private DsSgsLiveMapper dsSgsLiveMapper;

	@Autowired
	private DsSgsGameMapper dsSgsGameMapper;

	@Autowired
	private DsSgsConfigMapper dsSgsConfigMapper;

	private List<ApiInfoEntity> apiInfoList = new ArrayList<ApiInfoEntity>();

	/** key=前缀，value=siteId */
	private Map<String, Integer> apiMap = new HashMap<String, Integer>();

//	private Map<Integer, List<DsSgsLive>> sgsLiveMap = new HashMap<Integer, List<DsSgsLive>>();
//	private Map<Integer, List<DsSgsGame>> sgsGameMap = new HashMap<Integer, List<DsSgsGame>>();

	/**
	 * 获取api配置列表
	 *
	 * @return
	 */
	public void getDbApiInfoList() {
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(SgsConfig.SGS_LIVE_ID).andStateEqualTo(SgsConfig.NORMAL_STATE);
		apiInfoList = apiInfoMapper.selectByExample(e);
	}

	public void putApiInfoMap() {
		if (apiInfoList != null) {
			for (ApiInfoEntity apiInfoEntity : apiInfoList) {
				apiMap.put(apiInfoEntity.getPrefix(), apiInfoEntity.getSiteId());
			}
		}
	}

	public Integer getApiInfoMap(String preFix) {
		if (StringUtils.isBlank(preFix)) {
			return null;
		}
		return apiMap.get(preFix);
	}

	public ApiInfoEntity getApiInfoBySiteId(Integer siteId){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andStateEqualTo(SgsConfig.NORMAL_STATE).andLiveIdEqualTo(SgsConfig.SGS_LIVE_ID).andSiteIdEqualTo(siteId);
		List<ApiInfoEntity> list = apiInfoMapper.selectByExample(e);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<DsSgsConfig> getSgsConfigList(){
		return dsSgsConfigMapper.selectAll();
	}

	public List<ApiInfoEntity> getApiInfoList() {
		return apiInfoList;
	}

	public void setApiInfoList(List<ApiInfoEntity> apiInfoList) {
		this.apiInfoList = apiInfoList;
	}

	public DsSgsRecordTimeMapper getDsSgsRecordTimeMapper() {
		return dsSgsRecordTimeMapper;
	}

	public void setDsSgsRecordTimeMapper(DsSgsRecordTimeMapper dsSgsRecordTimeMapper) {
		this.dsSgsRecordTimeMapper = dsSgsRecordTimeMapper;
	}

	/**
	 * 获取请求连接
	 * @param url
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public String getSendUrl(String url, String startDate, String endDate){
		StringBuffer sb = new StringBuffer();
		sb.append(url).append("?");
		sb.append("startdate=").append(startDate);
		sb.append("&enddate=").append(endDate);
		sb.append("&includetestplayers=true").append("&issettled=true");
		return sb.toString();
	}

	/**
	 * 字符串转换json对象
	 * @param content
	 * @return  返回JSONObject
	 */
	public String convertJsonObject(String content){
		try {
			logger.info("字符串转换json对象前============"+content);
			JSONObject jsonStr = JSONObject.parseObject(content);
			logger.info("字符串转换json对象后============"+content);
			return jsonStr.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 保存注单数据
	 * @param listObject
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	public void saveData(String result) {
		//解析csv
		HeaderColumnNameMappingStrategy<SgsCsvVo> mapper = new HeaderColumnNameMappingStrategy<SgsCsvVo>();
		mapper.setType(SgsCsvVo.class);
		CsvToBean<SgsCsvVo> csvToBean = new CsvToBean<SgsCsvVo>();
		List<SgsCsvVo> sgsList = csvToBean.parse(mapper,new StringReader(result));
		logger.info("拉取返回数据数量："+sgsList.size());
		if(sgsList.size() == 0){
			return;
		}
		int insertCount=0;
		for (SgsCsvVo sgs : sgsList) {
			try {
				//判断用户是否在配置网站内
				String username = sgs.getUserid();
				String usernamepre = username.substring(0,SgsConfig.SGS_NAME_PRE_LENGTH);
				Integer siteId = getApiInfoMap(usernamepre);
				if(siteId == null){
					logger.info("不包含前缀："+usernamepre+"，注单号："+sgs.getUgsBetId());
					continue;
				}
				//查询注单是否存在  存在则跳过  不存在新增
				String ugsBetId = sgs.getUgsBetId();
				String cacheUgsBetId = BaseCommon.recordCache.getIfPresent(ugsBetId);
				if(StringUtils.isBlank(cacheUgsBetId)){
					if("SB".equals(sgs.getGameProviderCode())){
						DsSgsLive existLive = dsSgsLiveMapper.selectByUgsBetId(ugsBetId);
						if(existLive != null){
							BaseCommon.recordCache.put(ugsBetId, ugsBetId);
							continue;
						}
					}else{
						DsSgsGame existGame = dsSgsGameMapper.selectByUgsBetId(ugsBetId);
						if(existGame != null){
							BaseCommon.recordCache.put(ugsBetId, ugsBetId);
							continue;
						}
					}
				}else{
					continue;
				}

				//判断电子还是视讯
				if("SB".equals(sgs.getGameProviderCode())){
					DsSgsLive dsSgs = sgsCvsToDsSgsLive(sgs, siteId, null);
					dsSgsLiveMapper.insert(dsSgs);
					logger.info("sgs视讯注单新增操作，注单号------{}", sgs.getUgsBetId());
				}else{
					DsSgsGame dsSgs = sgsCvsToDsSgsGame(sgs, siteId, null);
					dsSgsGameMapper.insert(dsSgs);
					logger.info("sgs电子注单新增操作，注单号------{}", sgs.getUgsBetId());
				}
				insertCount++;
				insertOrUpdateTempAuditTotal(sgs, siteId);
				BaseCommon.recordCache.put(ugsBetId, ugsBetId);//加入缓存
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("数据处理异常："+ e.getMessage());
				TelegramMessage telegramMessage = TelegramMessage.getInstance();
				telegramMessage.sendMessage(BaseCommon.BOT_A, BaseCommon.GROUP_JAVA, SgsConfig.TELEGRAM_DATA_ERROR,
						"SGS注单拉取数据处理异常："+ErrorUtil.LogExceptionStack(e));

			}
		}
		logger.info("本次插入数据条数: "+ insertCount);
		Long cacheGcCount=BaseCommon.recordCache.stats().evictionCount();
		logger.info("cache gc total:"+cacheGcCount+",cache data count:"+BaseCommon.recordCache.size());
	}

	/**
	 * csv对象转换
	 * @param sgsCsv
	 * @return
	 * @return
	 * @return
	 */
	private DsSgsLive sgsCvsToDsSgsLive(SgsCsvVo sgs, Integer siteId, DsSgsLive dsSgs){
		if(dsSgs == null){
			dsSgs = new DsSgsLive();
		}

		dsSgs.setSiteId(siteId);
		//判断输赢
		BigDecimal winloss = sgs.getWinloss();
		if(winloss.doubleValue() >0){
			dsSgs.setWinLossType(SgsConfig.SGS_RESULT_TYPE_WIN);
		}else if(winloss.doubleValue() < 0){
			dsSgs.setWinLossType(SgsConfig.SGS_RESULT_TYPE_LOSE);
		}else if(winloss.doubleValue() == 0){
			dsSgs.setWinLossType(SgsConfig.SGS_RESULT_TYPE_HE);
		}

		dsSgs.setBetOn(DateUtils.getGMT8Date(sgs.getBetOn()));
		dsSgs.setBetClosedOn(DateUtils.getGMT8Date(sgs.getBetClosedOn()));
		dsSgs.setBetUpdatedOn(DateUtils.getGMT8Date(sgs.getBetUpdatedOn()));
		dsSgs.setTimestamp(DateUtils.getGMT8Date(sgs.getTimestamp()));
		//下注金额取正
		dsSgs.setRiskamt(sgs.getRiskamt().negate());

		dsSgs.setUgsBetId(sgs.getUgsBetId());
		dsSgs.setTxid(sgs.getTxid());
		dsSgs.setBetId(sgs.getBetId());
		dsSgs.setRoundid(sgs.getRoundid());
		dsSgs.setRoundStatus(sgs.getRoundStatus());
		dsSgs.setUserid(sgs.getUserid());
		dsSgs.setUsername(sgs.getUsername());
		dsSgs.setWinamt(sgs.getWinamt());
		dsSgs.setWinloss(sgs.getWinloss());
		dsSgs.setBeforebal(sgs.getBeforebal());
		dsSgs.setPostbal(sgs.getPostbal());
		dsSgs.setCurrency(sgs.getCurrency());
		dsSgs.setGameProvider(sgs.getGameProvider());
		dsSgs.setGameProviderCode(sgs.getGameProviderCode());
		dsSgs.setGameName(sgs.getGameName());
		dsSgs.setGameId(sgs.getGameId());
		dsSgs.setPlatformType(sgs.getPlatformType());
		dsSgs.setIpAddress(sgs.getIpAddress());
		dsSgs.setBetType(sgs.getBetType());
		dsSgs.setPlayType(sgs.getPlayType());
		dsSgs.setPlayerType(sgs.getPlayerType());
		dsSgs.setTurnover(sgs.getTurnover());
		dsSgs.setValidbet(sgs.getValidbet());
		dsSgs.setCreateTime(new Date());

		return dsSgs;
	}

	private DsSgsGame sgsCvsToDsSgsGame(SgsCsvVo sgs, Integer siteId, DsSgsGame dsSgs){
		if(dsSgs == null){
			dsSgs = new DsSgsGame();
		}

		dsSgs.setSiteId(siteId);
		//判断输赢
		BigDecimal winloss = sgs.getWinloss();
		if(winloss.doubleValue() >0){
			dsSgs.setWinLossType(SgsConfig.SGS_RESULT_TYPE_WIN);
		}else if(winloss.doubleValue() < 0){
			dsSgs.setWinLossType(SgsConfig.SGS_RESULT_TYPE_LOSE);
		}else if(winloss.doubleValue() == 0){
			dsSgs.setWinLossType(SgsConfig.SGS_RESULT_TYPE_HE);
		}

		dsSgs.setBetOn(DateUtils.getGMT8Date(sgs.getBetOn()));
		dsSgs.setBetClosedOn(DateUtils.getGMT8Date(sgs.getBetClosedOn()));
		dsSgs.setBetUpdatedOn(DateUtils.getGMT8Date(sgs.getBetUpdatedOn()));
		dsSgs.setTimestamp(DateUtils.getGMT8Date(sgs.getTimestamp()));
		//下注金额取正
		dsSgs.setRiskamt(sgs.getRiskamt().negate());

		dsSgs.setUgsBetId(sgs.getUgsBetId());
		dsSgs.setTxid(sgs.getTxid());
		dsSgs.setBetId(sgs.getBetId());
		dsSgs.setRoundid(sgs.getRoundid());
		dsSgs.setRoundStatus(sgs.getRoundStatus());
		dsSgs.setUserid(sgs.getUserid());
		dsSgs.setUsername(sgs.getUsername());
		dsSgs.setWinamt(sgs.getWinamt());
		dsSgs.setWinloss(sgs.getWinloss());
		dsSgs.setBeforebal(sgs.getBeforebal());
		dsSgs.setPostbal(sgs.getPostbal());
		dsSgs.setCurrency(sgs.getCurrency());
		dsSgs.setGameProvider(sgs.getGameProvider());
		dsSgs.setGameProviderCode(sgs.getGameProviderCode());
		dsSgs.setGameName(sgs.getGameName());
		dsSgs.setGameId(sgs.getGameId());
		dsSgs.setPlatformType(sgs.getPlatformType());
		dsSgs.setIpAddress(sgs.getIpAddress());
		dsSgs.setBetType(sgs.getBetType());
		dsSgs.setPlayType(sgs.getPlayType());
		dsSgs.setPlayerType(sgs.getPlayerType());
		dsSgs.setTurnover(sgs.getTurnover());
		dsSgs.setValidbet(sgs.getValidbet());
		dsSgs.setCreateTime(new Date());

		return dsSgs;
	}

	public void insertOrUpdateTempAuditTotal(SgsCsvVo sgs, Integer siteId) {
		AuditTotalVO audit = new AuditTotalVO();
		audit.setBetTime(DateUtils.getGMT8Date(sgs.getBetOn()));
		audit.setUsername(sgs.getUsername());
		audit.setLiveId(SgsConfig.SGS_LIVE_ID);
		if("SB".equals(sgs.getGameProviderCode())){
			audit.setType(PlatformTypeEnum.LIVE.getValue());
			audit.setGameName("sgs_live");
		}else{
			audit.setType(PlatformTypeEnum.GAME.getValue());
			audit.setGameName("sgs_game");
		}
		audit.setOrderNo(sgs.getUgsBetId());
		audit.setBetAmount(sgs.getRiskamt().negate());
		audit.setValidAmount(sgs.getValidbet());
		audit.setPayAmount(sgs.getWinloss());
		tempAuditTotalMapper.insertOrupdate(audit, siteId);
	}

	@SuppressWarnings("deprecation")
	public void saveManData(String result) {
		//解析csv
		HeaderColumnNameMappingStrategy<SgsCsvVo> mapper = new HeaderColumnNameMappingStrategy<SgsCsvVo>();
		mapper.setType(SgsCsvVo.class);
		CsvToBean<SgsCsvVo> csvToBean = new CsvToBean<SgsCsvVo>();
		List<SgsCsvVo> sgsList = csvToBean.parse(mapper,new StringReader(result));
		logger.info("手动拉取返回数据数量："+sgsList.size());
		if(sgsList.size() == 0){
			return;
		}
		int insertCount=0;
		for (SgsCsvVo sgs : sgsList) {
			try {
				//判断用户是否在配置网站内
				String username = sgs.getUserid();
				String usernamepre = username.substring(0,SgsConfig.SGS_NAME_PRE_LENGTH);
				Integer siteId = getApiInfoMap(usernamepre);
				if(siteId == null){
					logger.info("不包含前缀："+usernamepre+"，注单号："+sgs.getUgsBetId());
					continue;
				}
				//查询注单是否存在  存在则更新  不存在新增
				String ugsBetId = sgs.getUgsBetId();
				DsSgsLive dsSgsLive = null;
				DsSgsGame dsSgsGame = null;
				if("SB".equals(sgs.getGameProviderCode())){
					dsSgsLive = dsSgsLiveMapper.selectByUgsBetId(ugsBetId);
					if(dsSgsLive == null){
						dsSgsLive = new DsSgsLive();
					}
					dsSgsLive = sgsCvsToDsSgsLive(sgs, siteId, dsSgsLive);
					if(dsSgsLive.getId() != null && dsSgsLive.getId() > 0){
						dsSgsLive.setUpdateTime(new Date());
						dsSgsLiveMapper.updateByPrimaryKey(dsSgsLive);
						logger.info("手动拉取sgs视讯注单更新操作，注单号------{}", sgs.getUgsBetId());
					}else{
						dsSgsLiveMapper.insert(dsSgsLive);
						logger.info("手动拉取sgs视讯注单新增操作，注单号------{}", sgs.getUgsBetId());
					}
				}else{
					dsSgsGame = dsSgsGameMapper.selectByUgsBetId(ugsBetId);
					if(dsSgsGame == null){
						dsSgsGame = new DsSgsGame();
					}
					dsSgsGame = sgsCvsToDsSgsGame(sgs, siteId, dsSgsGame);
					if(dsSgsGame.getId() != null && dsSgsGame.getId() > 0){
						dsSgsGame.setUpdateTime(new Date());
						dsSgsGameMapper.updateByPrimaryKey(dsSgsGame);
						logger.info("手动拉取sgs电子注单更新操作，注单号------{}", sgs.getUgsBetId());
					}else{
						dsSgsGameMapper.insert(dsSgsGame);
						logger.info("手动拉取sgs电子注单新增操作，注单号------{}", sgs.getUgsBetId());
					}
				}
				insertCount++;
				insertOrUpdateTempAuditTotal(sgs, siteId);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("手动拉取数据处理异常："+ e.getMessage());
			}
		}
		logger.info("手动拉取本次插入数据条数: "+ insertCount);
	}
}
