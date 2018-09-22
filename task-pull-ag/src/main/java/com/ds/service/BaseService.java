package com.ds.service;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ds.common.AGApplication;
import com.ds.common.AGCommon;
import com.ds.dao.AGRecordDaoImpl;
import com.ds.message.MsgManger;
import com.ds.po.AGPullRecordPO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.ds.util.ErrorUtil;
import com.kg.live.entity.ApiInfoEntity;


public abstract class BaseService<M>  {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired 
	TempAuditTotalMapper tempAuditTotalMapper;
	@Autowired
	public AGRecordDaoImpl recordDao;
	@Autowired
	private MsgManger msgManager;
	
	public abstract M setEntityByElement(Element info,String namepre,ApiInfoEntity apiInfo);
	public abstract void setAuditEntity(Element info,M m,ApiInfoEntity apiInfo);
	public abstract M getEntityByBillno(String billno,String namepre);
	public void insertOrupdateRecord(List<AGPullRecordPO> recordList) {
		recordDao.insertOrupdateRecord(recordList);
	}
	public Map<String,AGPullRecordPO> getAGPullRecord(String agPath,String date){
		List<AGPullRecordPO> recordList = recordDao.getAGPullRecord(agPath, date);
		return recordList.stream().collect(Collectors.toMap(AGPullRecordPO::getUniqueKey, a -> a));
	} 
	private Document formatXml(String strXml) {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
		Document document = null;
		try {
			document = DocumentHelper.parseText(xml + "<rows>"
					+ strXml.toString() + "</rows>");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}
	/**
	 * 
	 * @param fileName
	 * @param strXml
	 * @return
	 */
	public boolean xmlReader(String fileName,String strXml) {
		try {
			Document document = formatXml(strXml);
			Element root = document.getRootElement();
			Iterator<Element> it = root.elements().iterator();
			if (AGApplication.fileMap.getIfPresent(fileName) == null) {
				log.info("fileMap中不包含文件名" + fileName + "，将添加到fileMap......");
				AGApplication.fileMap.put(fileName, 0);// 0代表当前文件读到0行
			}
			Integer currentRow = AGApplication.fileMap.getIfPresent(fileName);
			Integer initRow = 0;
			boolean positionFlag = false;
			log.info(fileName+"文件上次已读到"+currentRow+"行");
			while (it.hasNext()) {
				Element info = (Element) it.next();
				if(!positionFlag){//未定位到上次读取的位置
					if (currentRow > initRow) {
						initRow++;// 跳过当前行
						continue;
					}else{
						positionFlag = true;
					}
				}
				String namepre = info.attributeValue("playerName")
						.substring(0, AGCommon.AG_GAME_NAME_PRE_LENGTH);
				ApiInfoEntity apiInfo = getApiInfoByNamePre(namepre);
				if(apiInfo == null){//不在配置的网站，不读取到数据库
					log.info("文件"+fileName+"不包含前缀"+namepre+",currentRow:"+currentRow);
					currentRow++;
					continue;
				}
				setAuditEntity(info, setEntityByElement(info,namepre,apiInfo), apiInfo);
				currentRow++;
			}// end while循环
			AGApplication.fileMap.put(fileName, currentRow);
			log.info(fileName+"文件此次已读到"+currentRow+"行");
			return true;
		} catch (Exception e) {
			msgManager.sendMessage("DBException", "AG数据库插入出错："+ErrorUtil.LogExceptionStack(e));
			e.printStackTrace();
			log.info("插入出错：",e);
			return false;
		}
	}
	
	public ApiInfoEntity getApiInfoByNamePre(String namepre) {
		List<ApiInfoEntity> aipInfoList = AGApplication.list;
		for (ApiInfoEntity apiInfo : aipInfoList) {
			if (StringUtils.isNotBlank(apiInfo.getPrefix())
					&& apiInfo.getPrefix().equals(namepre)) {
				return apiInfo;
			}
		}
		return null;
	}
	
	public List<ApiInfoEntity> getApiInfoList() {
		return AGApplication.list;
	}
	/**
	 * 动态可变的类型要写在配置文件中
	 * @param gameType
	 * @return
	 */
	public Byte getAgLiveGameKind(String gameType) {
		if(StringUtils.isBlank(gameType)){
			return null;
		}
		if(AGApplication.liveGameList.contains(gameType)){
			return AGCommon.AG_GAME_KIND_LIVE;
		}
		return AGCommon.AG_GAME_KIND_OTHER;
	}
	public Byte setWinLoseType(Element info,String flag) {
		// 1=已结算 0=未结算 -1=重置试玩额度 -2=注单被篡改 -8=取消指定局注单 -9=取消注单
		BigDecimal netAmount = new BigDecimal(info.attributeValue("netAmount")).setScale(2, BigDecimal.ROUND_HALF_UP);
		if ("1".equals(info.attributeValue("flag"))) {
			if (netAmount.doubleValue() > 0) {
				return AGCommon.LIVE_RESULT_TYPE_WIN;
			} else if (netAmount.doubleValue() < 0) {
				return AGCommon.LIVE_RESULT_TYPE_LOSE;
			} else if (netAmount.doubleValue() == 0) {
				return AGCommon.LIVE_RESULT_TYPE_HE;
			}
		}else if ("-1".equals(flag)|| "-8".equals(flag)
				|| "-9".equals(flag)|| "-2".equals(flag)) {
			return AGCommon.LIVE_RESULT_TYPE_CANCEL;
		}
		return AGCommon.LIVE_RESULT_TYPE_OTHER;
	}
}
