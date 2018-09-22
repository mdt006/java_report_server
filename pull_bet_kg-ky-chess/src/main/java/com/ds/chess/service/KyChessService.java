package com.ds.chess.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.chess.common.BaseCommon;
import com.ds.chess.dao.DsKyChessMapper;
import com.ds.chess.dao.DsKyRecordTimeMapper;
import com.ds.chess.entity.DsKyChess;
import com.ds.chess.util.ChessConfig;
import com.ds.chess.util.Encrypt;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;

/**
 *
 * @author worf
 * @date 2018年4月27日 上午9:04:18
 */
@Service
public class KyChessService {
	
	private Logger logger = LoggerFactory.getLogger(KyChessService.class);

	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;

	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;

	@Autowired
	private DsKyRecordTimeMapper dsKyRecordTimeMapper;
	
	@Autowired
	private DsKyChessMapper dsKyChessMapper;

	private String deskey = ChessConfig.kyChessDeskey;
	private String md5key = ChessConfig.kyChessMd5key;
	
	/**
	 * 获取api配置列表
	 * 
	 * @return
	 */
	public List<ApiInfoEntity> getDbApiInfoList() {
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(ChessConfig.CHESS_LIVE_ID).andStateEqualTo(ChessConfig.NORMAL_STATE);
		return apiInfoMapper.selectByExample(e);
	}
	
	public ApiInfoEntity getApiInfoBySiteId(Integer siteId){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andStateEqualTo(ChessConfig.NORMAL_STATE).andLiveIdEqualTo(ChessConfig.CHESS_LIVE_ID).andSiteIdEqualTo(siteId);
		List<ApiInfoEntity> list = apiInfoMapper.selectByExample(e);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 获取请求参数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public String getSendParams(long startTime, long endTime, ApiInfoEntity apiConfig) {
		Long timestamp = System.currentTimeMillis();
		String param = getParam(startTime, endTime);
		String key = getKey(apiConfig.getAgent(), timestamp);
		StringBuffer sb = new StringBuffer();
		sb.append("agent=").append(apiConfig.getAgent());
		sb.append("&timestamp=").append(timestamp);
		sb.append("&param=").append(param);
		sb.append("&key=").append(key);
		return sb.toString();
	}

	public String getParam(long startTime, long endTime) {
		StringBuffer sb = new StringBuffer();
		sb.append("s=6&startTime=").append(startTime).append("&endTime=").append(endTime);
		try {
			return Encrypt.AESEncrypt(sb.toString(), deskey);
		} catch (Exception e) {
			logger.error("getParam error:{}", e);
		}
		return "";
	}

	public String getKey(String agent, long timestamp) {
		StringBuffer sb = new StringBuffer();
		sb.append(agent).append(timestamp).append(md5key);
		return Encrypt.MD5(sb.toString());
	}

	public DsKyRecordTimeMapper getDsKyRecordTimeMapper() {
		return dsKyRecordTimeMapper;
	}

	public void setDsKyRecordTimeMapper(DsKyRecordTimeMapper dsKyRecordTimeMapper) {
		this.dsKyRecordTimeMapper = dsKyRecordTimeMapper;
	}

	public DsKyChessMapper getDsKyChessMapper() {
		return dsKyChessMapper;
	}

	public void setDsKyChessMapper(DsKyChessMapper dsKyChessMapper) {
		this.dsKyChessMapper = dsKyChessMapper;
	}

	public TempAuditTotalMapper getTempAuditTotalMapper() {
		return tempAuditTotalMapper;
	}

	public void setTempAuditTotalMapper(TempAuditTotalMapper tempAuditTotalMapper) {
		this.tempAuditTotalMapper = tempAuditTotalMapper;
	}
	
	/**
	 * 保存注单数据
	 * @param listObject
	 * @throws ParseException
	 */
	public void saveData(JSONObject listObject, ApiInfoEntity apiConfig) throws ParseException{
		int insertCount = 0;
//		JSONArray lineCodeArray = listObject.getJSONArray("LineCode");
		JSONArray gameIdArray = listObject.getJSONArray("GameID");
		JSONArray accountArray = listObject.getJSONArray("Accounts");
		JSONArray serverArray = listObject.getJSONArray("ServerID");
		JSONArray kindIdArray = listObject.getJSONArray("KindID");
		JSONArray tabelIdArray = listObject.getJSONArray("TableID");
		JSONArray chariIdArray = listObject.getJSONArray("ChairID");
		JSONArray userCountArray = listObject.getJSONArray("UserCount");
		JSONArray allBetArray = listObject.getJSONArray("AllBet");
		JSONArray profitArray = listObject.getJSONArray("Profit");
		JSONArray revenueArray = listObject.getJSONArray("Revenue");
		JSONArray gameStartTimeArray = listObject.getJSONArray("GameStartTime");
		JSONArray gameEndTimeArray = listObject.getJSONArray("GameEndTime");
		JSONArray channelIDArray = listObject.getJSONArray("ChannelID");
		
		JSONArray cardValueArray = listObject.getJSONArray("CardValue");
		JSONArray cellScoreArray = listObject.getJSONArray("CellScore");
		
		DsKyChess dsKyChess = null;
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < gameIdArray.size(); i++) {
//			String lineCode = lineCodeArray.getString(i);
//			Integer siteId = null;
//			if (StringUtils.isNotBlank(lineCode)) {
//				String[] lineCodeArr = lineCode.split("_");
//				if(StringUtils.isNotBlank(lineCodeArr[1]) && NumberUtils.isNumber(lineCodeArr[1])){
//					siteId = Integer.parseInt(lineCodeArr[1]);
//				}
//			}
			String gameId = gameIdArray.getString(i);
			//查询局号是否存在  存在则跳过  不存在新增
			String cacheGameId = BaseCommon.record_map.getIfPresent(gameId);
			if(StringUtils.isBlank(cacheGameId)){
				dsKyChess = dsKyChessMapper.selectByGameId(gameId);
			}
			if(dsKyChess != null || StringUtils.isNotBlank(cacheGameId)){
//				logger.info("游戏局号已存在：{}",gameId);
				BaseCommon.record_map.put(gameId, gameId);
				continue;
			}
			dsKyChess = new DsKyChess();		
			String account = accountArray.getString(i);
			String userName = account;
			if(StringUtils.isNotBlank(account) && account.indexOf("_") != -1){
				userName = account.split("_")[1];
				if(StringUtils.isNotBlank(userName)){
					userName = userName.substring(ChessConfig.CHESS_NAME_PRE_LENGTH,userName.length());
				}
			}
			Integer serverId = serverArray.getInteger(i);
			Integer kindId = kindIdArray.getInteger(i);
			Integer tabelId = tabelIdArray.getInteger(i);
			Integer chairId = chariIdArray.getInteger(i);
			Integer userCount = userCountArray.getInteger(i);
			BigDecimal allBet = new BigDecimal(allBetArray.getString(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal profit = new BigDecimal(profitArray.getString(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal revenue = new BigDecimal(revenueArray.getString(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
			Date gameStartTime = null;
			Date gameEndTime = null;
			if(StringUtils.isNotBlank(gameStartTimeArray.getString(i))){
				gameStartTime = sim.parse(gameStartTimeArray.getString(i));
			}
			if(StringUtils.isNotBlank(gameEndTimeArray.getString(i))){
				gameEndTime = sim.parse(gameEndTimeArray.getString(i));
			}
			Integer channelId = channelIDArray.getInteger(i);
			String cardValue = cardValueArray.getString(i);
			BigDecimal cellScore = new BigDecimal(cellScoreArray.getString(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
			
			dsKyChess.setSiteId(apiConfig.getSiteId());
			dsKyChess.setGameId(gameId);
			dsKyChess.setAccount(userName);
			dsKyChess.setServerId(serverId);
			dsKyChess.setKindId(kindId);
			dsKyChess.setTableId(tabelId);
			dsKyChess.setChairId(chairId);
			dsKyChess.setUserCount(userCount);
			dsKyChess.setCardValue(cardValue);
			dsKyChess.setCellScore(cellScore);
			dsKyChess.setAllBet(allBet);
			dsKyChess.setProfit(profit);
			dsKyChess.setRevenue(revenue);
			if(gameStartTime != null){
				gameStartTime = new Date(gameStartTime.getTime()-1000*60*60*12);
			}
			if(gameEndTime != null){
				gameEndTime = new Date(gameEndTime.getTime()-1000*60*60*12);
			}
			dsKyChess.setGameStartTime(gameStartTime);
			dsKyChess.setGameEndTime(gameEndTime);
			dsKyChess.setChannelId(channelId);
			//判断输赢
			if(profit.doubleValue() >0){
				dsKyChess.setWinLossType(ChessConfig.CHESS_RESULT_TYPE_WIN);
			}else if(profit.doubleValue() < 0){
				dsKyChess.setWinLossType(ChessConfig.CHESS_RESULT_TYPE_LOSE);
			}else if(profit.doubleValue() == 0){
				dsKyChess.setWinLossType(ChessConfig.CHESS_RESULT_TYPE_HE);
			}
			
			dsKyChessMapper.insert(dsKyChess);
			insertCount++;
			logger.info("ky游戏局号{}----------注单新增操作........", gameId);			
			
			logger.info("temp_audit_total start");
			insertOrUpdateTempAuditTotal(dsKyChess);
			logger.info("temp_audit_total end");
			BaseCommon.record_map.put(gameId, gameId);//加入缓存
		}
		//缓存打印
		Long cacheGcCount=BaseCommon.record_map.stats().evictionCount();
		logger.info("cache gc total:"+cacheGcCount+",cache data count:"+BaseCommon.record_map.size());			
		logger.info("网站 {}，本次插入数据 {} 条", apiConfig.getSiteName(), insertCount);
	}
	
	public void insertOrUpdateTempAuditTotal(DsKyChess dsKyChess) {
		AuditTotalVO audit = new AuditTotalVO();
		audit.setBetTime(dsKyChess.getGameEndTime());
		audit.setUsername(dsKyChess.getAccount());
		audit.setLiveId(PlatFormEnum.KYCHESS.getValue());
		audit.setGameName(AuditGameNameEnum.KY_CHESS.toString());
		audit.setType(PlatformTypeEnum.CHESS.getValue());
		audit.setOrderNo(dsKyChess.getGameId());
		audit.setPayAmount(dsKyChess.getProfit());
		audit.setBetAmount(dsKyChess.getAllBet());
		audit.setValidAmount(dsKyChess.getCellScore());
		tempAuditTotalMapper.insertOrupdate(audit, dsKyChess.getSiteId());
	}
	
	public void saveManData(JSONObject listObject, ApiInfoEntity apiConfig) throws ParseException{
		JSONArray gameIdArray = listObject.getJSONArray("GameID");
		JSONArray accountArray = listObject.getJSONArray("Accounts");
		JSONArray serverArray = listObject.getJSONArray("ServerID");
		JSONArray kindIdArray = listObject.getJSONArray("KindID");
		JSONArray tabelIdArray = listObject.getJSONArray("TableID");
		JSONArray chariIdArray = listObject.getJSONArray("ChairID");
		JSONArray userCountArray = listObject.getJSONArray("UserCount");
		JSONArray allBetArray = listObject.getJSONArray("AllBet");
		JSONArray profitArray = listObject.getJSONArray("Profit");
		JSONArray revenueArray = listObject.getJSONArray("Revenue");
		JSONArray gameStartTimeArray = listObject.getJSONArray("GameStartTime");
		JSONArray gameEndTimeArray = listObject.getJSONArray("GameEndTime");
		JSONArray channelIDArray = listObject.getJSONArray("ChannelID");
		
		JSONArray cardValueArray = listObject.getJSONArray("CardValue");
		JSONArray cellScoreArray = listObject.getJSONArray("CellScore");
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < gameIdArray.size(); i++) {
			try {
				String gameId = gameIdArray.getString(i);
				//查询局号是否存在  存在则更新  不存在新增
				DsKyChess dsKyChess = dsKyChessMapper.selectByGameId(gameId);
				if(dsKyChess == null){
					dsKyChess = new DsKyChess();
				}else{
					continue;
				}
				String account = accountArray.getString(i);
				String userName = account;
				if(StringUtils.isNotBlank(account) && account.indexOf("_") != -1){
					userName = account.split("_")[1];
					if(StringUtils.isNotBlank(userName)){
						userName = userName.substring(ChessConfig.CHESS_NAME_PRE_LENGTH,userName.length());
					}
				}
				Integer serverId = serverArray.getInteger(i);
				Integer kindId = kindIdArray.getInteger(i);
				Integer tabelId = tabelIdArray.getInteger(i);
				Integer chairId = chariIdArray.getInteger(i);
				Integer userCount = userCountArray.getInteger(i);
				BigDecimal allBet = new BigDecimal(allBetArray.getString(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal profit = new BigDecimal(profitArray.getString(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal revenue = new BigDecimal(revenueArray.getString(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
				Date gameStartTime = null;
				Date gameEndTime = null;
				if(StringUtils.isNotBlank(gameStartTimeArray.getString(i))){
					gameStartTime = sim.parse(gameStartTimeArray.getString(i));
				}
				if(StringUtils.isNotBlank(gameEndTimeArray.getString(i))){
					gameEndTime = sim.parse(gameEndTimeArray.getString(i));
				}
				
				Integer channelId = channelIDArray.getInteger(i);
				String cardValue = cardValueArray.getString(i);
				BigDecimal cellScore = new BigDecimal(cellScoreArray.getString(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				dsKyChess.setSiteId(apiConfig.getSiteId());
				dsKyChess.setGameId(gameId);
				dsKyChess.setAccount(userName);
				dsKyChess.setServerId(serverId);
				dsKyChess.setKindId(kindId);
				dsKyChess.setTableId(tabelId);
				dsKyChess.setChairId(chairId);
				dsKyChess.setUserCount(userCount);
				dsKyChess.setCardValue(cardValue);
				dsKyChess.setCellScore(cellScore);
				dsKyChess.setAllBet(allBet);
				dsKyChess.setProfit(profit);
				dsKyChess.setRevenue(revenue);
				if(gameStartTime != null){
					gameStartTime = new Date(gameStartTime.getTime()-1000*60*60*12);
				}
				if(gameEndTime != null){
					gameEndTime = new Date(gameEndTime.getTime()-1000*60*60*12);
				}
				dsKyChess.setGameStartTime(gameStartTime);
				dsKyChess.setGameEndTime(gameEndTime);
				dsKyChess.setChannelId(channelId);
				//判断输赢
				if(profit.doubleValue() >0){
					dsKyChess.setWinLossType(ChessConfig.CHESS_RESULT_TYPE_WIN);
				}else if(profit.doubleValue() < 0){
					dsKyChess.setWinLossType(ChessConfig.CHESS_RESULT_TYPE_LOSE);
				}else if(profit.doubleValue() == 0){
					dsKyChess.setWinLossType(ChessConfig.CHESS_RESULT_TYPE_HE);
				}
				
				if(dsKyChess.getId() != null && dsKyChess.getId() > 0){
					dsKyChessMapper.updateByPrimaryKey(dsKyChess);
					logger.info("{}，手动拉取注单更新操作........{}",apiConfig.getSiteId(), gameId);
				}else{
					dsKyChessMapper.insert(dsKyChess);
					logger.info("{}，手动拉取注单新增操作........{}",apiConfig.getSiteId(), gameId);			
				}
				logger.info("temp_audit_total start");
//				insertOrUpdateTempAuditTotal(dsKyChess);
				logger.info("temp_audit_total end");
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("{}，手动拉取出错：{}",apiConfig.getSiteId(),e.getMessage());
			}
		}
	}
	
}
