package com.ds.live.task;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.onetwo.common.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import com.alibaba.druid.util.Base64;
import com.ds.live.dao.DsLiveDao;
import com.ds.live.service.DsLiveServiceImp;
import com.ds.live.until.LiveConfig;
import com.ds.live.until.RequestUtils;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.OGLiveEntity;
import com.kg.live.entity.OGLiveEntityExample;
import com.kg.live.mapper.OGLiveEntityMapper;

public class LiveTask implements Runnable {
	private Logger logger = Logger.getLogger(this.getClass());
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
	SimpleDateFormat mat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",Locale.US);
	private DsLiveServiceImp liveService;
	private OGLiveEntityMapper liveMapper;
	private Map<String,Integer> siteIdMap;
	private DsLiveDao liveDao;
	private String reportUrl;
	private String agent;
	private String liveKey;
	private TempAuditTotalMapper tempAuditTotalMapper;
	private long maxVendorId=0;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public LiveTask(DsLiveServiceImp liveService,String reportUrl,Map<String,Integer> siteIdMap,String agent,String liveKey) {
		super();
		this.liveService = liveService;
		this.reportUrl=reportUrl;
		this.siteIdMap=siteIdMap;
		this.agent=agent;
		this.liveKey=liveKey;
		liveMapper = liveService.getLiveMapper();
		liveDao = liveService.getLiveDao();
		this.tempAuditTotalMapper = liveService.getTempAuditTotalMapper();
	}

	@Override
	public void run() {
		//Thread.currentThread().setName(siteName);
		while (liveService.getAipInfoList() != null && liveService.getAipInfoList().size() > 0) {
			logger.info("开始拉视讯请求地址：" + reportUrl + ",请求agent:" + agent+",userKey:"+liveKey);
			try {
				getBet(siteIdMap,reportUrl,agent,liveKey); //视讯拉取数据
				logger.info("网站数据一次拉取完成，休眠一分钟......");
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("网站拉取出错" + reportUrl + "错误信息：" + e.getMessage());
			}
		}
		//线程已经停止，线程计数器+1
		DsLiveServiceImp.stopCount.getAndIncrement();
		logger.info("线程" + Thread.currentThread().getName() + "已停止......");
	}

	public void getBet(Map<String,Integer> siteIdMap,String reportUrl, String agent,String userKey) {
		try {
			if(maxVendorId==0){
				String beginid = liveDao.getMaxOGLiveBillno();
				logger.info("max beginid:" + beginid);
				if (StringUtils.isEmpty(beginid))beginid = "0";
				maxVendorId= Long.parseLong(beginid);
			}
			String param = "$agent="+agent + "$vendorid="+maxVendorId+"$method=gbrbv";
			String params = Base64.byteArrayToBase64(param.getBytes());
			String key = toMD5(params+userKey);
			logger.info("params="+param+",key="+key);
			
			String resultObj = RequestUtils.sendGet(reportUrl+"?params="+params+"&key="+key);
			parseXml(resultObj,siteIdMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("网站拉取数据发生异常，线程降休眠30s，异常信息：" + e.getMessage());
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		logger.info("视讯：" + reportUrl + "拉取数据成功.....");
	}

	public void parseXml(String resultObj,Map<String,Integer> siteIdMap)throws Exception{
		if(!resultObj.contains("Data")){
			logger.info("resultObj:"+resultObj);
			throw new Exception("拉取OG数据异常");
		}
		Document document = DocumentHelper.parseText(resultObj);
		Element root = document.getRootElement();
		List<Element> dataList = root.selectNodes("Data");
		if(dataList != null && dataList.size()>0){
			for (Element e : dataList) {
				boolean updateFLag = false;
				OGLiveEntity liveEntity = new OGLiveEntity();
				//liveEntity.setSiteId(siteId);
				Iterator<Element> iter = e.nodeIterator();
				while(iter.hasNext()){
					Element proEl = (Element)iter.next();//<properties name="ProductID">10548970</properties>
					String attrName = proEl.attributeValue("name");
					String value = proEl.getText();
					switch (attrName) {
					case "ProductID":
						liveEntity.setProductId(Long.valueOf(value));
						break;
					case "UserName":
						liveEntity.setPlayName(value);
						//liveEntity.setUsername(StringUtils.substringAfter(value, pre));
						break;
					case "GameRecordID":
						liveEntity.setGameRecordId(value);
						break;
					case "OrderNumber":
						liveEntity.setOrderNumber(value);
						break;
					case "TableID":
						liveEntity.setTableId(value);
						break;
					case "Stage":
						liveEntity.setStage(value);
						break;
					case "Inning":
						liveEntity.setInning(value);
						break;
					case "GameNameID":
						liveEntity.setGameNameId(value);
						break;
					case "GameBettingKind":
						liveEntity.setGameBettingKind(value);
						break;
					case "GameBettingContent":
						liveEntity.setGameBettingContent(value);
						break;
					case "ResultType"://：1表示输，2表示赢3表示和，4表示无效
						liveEntity.setResultType(value);
						if(value.equals("1")){
							liveEntity.setWinLoseType(Integer.valueOf(LiveConfig.LIVE_RESULT_TYPE_LOSE));
						}else if(value.equals("2")){
							liveEntity.setWinLoseType(Integer.valueOf(LiveConfig.LIVE_RESULT_TYPE_WIN));
						}else if(value.equals("3")){
							liveEntity.setWinLoseType(Integer.valueOf(LiveConfig.LIVE_RESULT_TYPE_HE));
						}else if(value.equals("4")){
							liveEntity.setWinLoseType(Integer.valueOf(LiveConfig.LIVE_RESULT_TYPE_CANCEL));
						}
						break;
					case "BettingAmount":
						liveEntity.setBettingAmount(new BigDecimal(Double.valueOf(value)));
						break;
					case "CompensateRate":
						liveEntity.setCompensateRate(value);
						break;
					case "WinLoseAmount":
						liveEntity.setWinLoseAmount(new BigDecimal(Double.valueOf(value)));
						break;
					case "Balance":
						liveEntity.setBalance(new BigDecimal(Double.valueOf(value)));
						break;
					case "AddTime":
						liveEntity.setAddTime(DateUtil.addHours(Timestamp.valueOf(sdf.format(mat.parse(value).getTime())), -12));
						break;
					case "PlatformID":
						liveEntity.setPlatformId(value);
						break;
					case "VendorId":
						liveEntity.setVendorId(Long.valueOf(value));
						if(!StringUtils.isEmpty(value)){
							maxVendorId=Long.valueOf(value);
						}else{
							maxVendorId=0;
						}
						break;
//					case "ValidAmount":
//						liveEntity.setValidAmount(new BigDecimal(Double.valueOf(value)));
//						break;
					case "GameResult":
						liveEntity.setGameResult(value);
						break;
					default:
						break;
						
					}//end switch
				}//end while
				
				Integer siteId = null;
				if(!StringUtils.isEmpty(liveEntity.getPlayName())){
					String pre = liveEntity.getPlayName().substring(0,2);
					if(!pre.equals("") && pre != null){
						siteId = siteIdMap.get(pre);
						liveEntity.setUsername(StringUtils.substringAfter(liveEntity.getPlayName(), pre));
					}
				}
				
				liveEntity.setSiteId(siteId);
				if(siteId == null){
					logger.info("PlayName:"+liveEntity.getPlayName()+",SiteId is NULL 不存储此数据项！");
					continue;
				}
				
				//有效投注金额需要计算
				String reslutType = liveEntity.getResultType();
				if(reslutType.equals("1")||reslutType.equals("2")){
					liveEntity.setValidAmount(liveEntity.getBettingAmount());
				}else{
					liveEntity.setValidAmount(new BigDecimal(0));
				}
				OGLiveEntity dbLiveEntity = getOGLiveByBillno(liveEntity.getProductId(), siteId);
				if(dbLiveEntity == null){
					dbLiveEntity = new OGLiveEntity();
					liveEntity.setCreateTime(new Date());
				}else{
					updateFLag = true;
					liveEntity.setUpdateTime(new Date());
				}
				BeanUtils.copyProperties(liveEntity,dbLiveEntity);
				
				if (updateFLag) {//更新
					liveEntity.setUpdateTime(new Date());
					liveMapper.updateByPrimaryKey(liveEntity);
				} else {
					liveEntity.setCreateTime(new Date());
					liveMapper.insert(liveEntity);
				}
				//插入日志
				logger.info("temp_audit_total start");
				BigDecimal betAmount = liveEntity.getBettingAmount().setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal validAmount = liveEntity.getValidAmount().setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal payAmount = liveEntity.getWinLoseAmount().setScale(2, BigDecimal.ROUND_HALF_UP);
				AuditTotalVO audit = new AuditTotalVO();
				audit.setBetTime(liveEntity.getAddTime());
				audit.setUsername(liveEntity.getUsername());
				audit.setLiveId(PlatFormEnum.OG.getValue());
				audit.setGameName(AuditGameNameEnum.OG_LIVE.toString());
				audit.setType(PlatformTypeEnum.LIVE.getValue());
				audit.setOrderNo(liveEntity.getProductId()+"");
				audit.setPayAmount(payAmount);
				audit.setBetAmount(betAmount);
				audit.setValidAmount(validAmount);
				tempAuditTotalMapper.insertOrupdate(audit, siteId);
				
				logger.info("temp_audit_total end");
			/******************************/
				
			}//end for
		}else{
			logger.info(">>>>>>>>>>没有拉取到数");
		}
		//判断数据量，如果数量小于200，线程休眠1分钟
		if(dataList.size() < 200){
			Thread.sleep(1000*60);
		}
	}
	
	private OGLiveEntity getOGLiveByBillno(Long billno, Integer siteId){
		OGLiveEntityExample e = new OGLiveEntityExample();
		e.createCriteria().andProductIdEqualTo(billno).andSiteIdEqualTo(siteId);
		List<OGLiveEntity> list = liveMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	private String toMD5(String str){
	     try
	     {
	       MessageDigest md = MessageDigest.getInstance("MD5");
	       md.update(str.getBytes());
	       byte[] byteDigest = md.digest();
	 
	       StringBuffer buf = new StringBuffer("");
	       for (int offset = 0; offset < byteDigest.length; offset++) {
	         int i = byteDigest[offset];
	         if (i < 0)
	           i += 256;
	         if (i < 16)
	           buf.append("0");
	         buf.append(Integer.toHexString(i));
	       }
	 
	       return buf.toString();
	     } catch (NoSuchAlgorithmException e) {
	       e.printStackTrace();
	     }return null;
	}
}
