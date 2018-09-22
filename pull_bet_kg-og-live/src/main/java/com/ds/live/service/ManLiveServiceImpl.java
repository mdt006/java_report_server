package com.ds.live.service;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.onetwo.common.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.Base64;
import com.ds.live.dao.DsLiveDao;
import com.ds.live.until.LiveConfig;
import com.ds.live.until.RequestUtils;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.contants.AuditGameNameEnum;
import com.kg.live.contants.PlatFormEnum;
import com.kg.live.contants.PlatformTypeEnum;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.entity.OGLiveEntity;
import com.kg.live.entity.OGLiveEntityExample;
import com.kg.live.mapper.ApiInfoEntityMapper;
import com.kg.live.mapper.OGLiveEntityMapper;

/**
 * 
 * @author Arron
 *	项目描述：手动拉取OG注单
 */

@Service
public class ManLiveServiceImpl {
	final static Logger logger = Logger.getLogger(DsLiveServiceImp.class);
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
	SimpleDateFormat mat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",Locale.US);
	@Autowired
	private OGLiveEntityMapper liveMapper;
	
	@Autowired
	private ApiInfoEntityMapper apiInfoMapper;
	@Autowired
	private DsLiveDao liveDao;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	//ds相关配置参数
	private List<ApiInfoEntity> aipInfoList;

	
	public void manGetRecord(String startDate,String endDate){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andLiveIdEqualTo(LiveConfig.OG_LIVE_ID).andStateEqualTo(LiveConfig.NORMAL_STATE);
		aipInfoList = apiInfoMapper.selectByExample(e);
		logger.info("初始化配置信息");
		for (ApiInfoEntity api : aipInfoList) {
			Integer siteId = api.getSiteId();
			String siteName = api.getSiteName();
			String reportUrl = api.getReporturl();//视讯请求地址
			String agent = api.getAgent();
			String userKey = api.getLiveKey();
			String pre = api.getPrefix();
			Long vendorid=liveDao.getMaxVendoridByDate(startDate,siteId);
			Long endVendorid=liveDao.getMinVendoridByDate(endDate,siteId);
			if(vendorid==null){
				vendorid= 0L;
			}
			if(endVendorid==null){
				endVendorid=0L;				
			}
			logger.info("开始拉取网站id：" + siteId + ",网站名称：" + siteName + ",视讯请求地址：" + reportUrl + ",请求agent:" + agent+",userKey:"+userKey);
			logger.info("拉取日期:"+startDate+"----结束日期:"+endDate+"************开始ID:"+vendorid+"----结束ID:"+endVendorid);
			getBet(vendorid,endVendorid,siteId, siteName, reportUrl, agent,userKey,pre); //视讯拉取数据
		}
	}
	
	public void getBet(Long vendorid,Long endVendorid,Integer siteId, String siteName, String reportUrl, String agent,String userKey,String pre) {
		try {
			logger.info("网站" + siteName + ",max beginid:" + vendorid+",endId:"+endVendorid);
			String param = "$agent="+agent + "$vendorid="+vendorid+"$method=gbrbv";
			String params = Base64.byteArrayToBase64(param.getBytes());
			String key = toMD5(params+userKey);
			String resultObj = RequestUtils.sendGet(reportUrl+"?params="+params+"&key="+key);
			parseXml(resultObj, siteId, pre,endVendorid);

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("网站：" + siteName + "拉取数据发生异常，线程降休眠30s，异常信息：" + e.getMessage());
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		logger.info("网站：" + siteName + "手动拉取数据成功.....");
	}

	public void parseXml(String resultObj,Integer siteId,String pre,Long endVendorid)throws Exception{
		if(!resultObj.contains("Data")){
			logger.info("resultObj:"+resultObj);
			throw new Exception("拉取OG数据异常");
		}
		Document document = DocumentHelper.parseText(resultObj);
		Element root = document.getRootElement();
		List<Element> dataList = root.selectNodes("Data");
		for (Element e : dataList) {
			boolean updateFLag = false;
			OGLiveEntity liveEntity = new OGLiveEntity();
			liveEntity.setSiteId(siteId);
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
					liveEntity.setUsername(StringUtils.substringAfter(value, pre));
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
					break;
//				case "ValidAmount":
//					liveEntity.setValidAmount(new BigDecimal(Double.valueOf(value)));
//					break;
				case "GameResult":
					liveEntity.setGameResult(value);
					break;
				default:
					break;
					
				}//end switch
				
			}//end while
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
			if(endVendorid.equals(liveEntity.getVendorId()))
			{
				return;
			}
			
			
		}//end for
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