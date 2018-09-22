package com.ds.live.gameservice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.live.entity.BBINGameVo;
import com.kg.live.entity.ApiInfoEntity;

public class GameThreadService implements Runnable {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	private GameDBService bbService;
	private JSONObject obj;
	private ApiInfoEntity configApiInfo;
	private Integer gamekind;
	private Integer subgamekind;
	private String thread_no;
	public GameThreadService(ApiInfoEntity configApiInfo, GameDBService bbService, JSONObject obj, String httpAction, Integer gamekind, Integer subgamekind,String thread_no) {
		this.bbService = bbService;
		this.configApiInfo = configApiInfo;
		this.obj = obj;
		this.gamekind = gamekind;
		this.subgamekind = subgamekind;
		this.thread_no=thread_no;
	}

	@Override
	public void run() {
		try {
			logger.info(thread_no+"线程开始入库");
			List<BBINGameVo> list = JSONArray.parseArray(obj.getString("data"), BBINGameVo.class);
			if(list == null || list.size() == 0) {
				return;
			}
			setAttr(list);
			bbService.insertOrUpdate(list);
			//插入稽核表
			bbService.insertOrUpdateTempAuditTotal(list);
			logger.info(thread_no+"线程入库完成,执行数量:"+list.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info(thread_no+"入库失败:",e);
		}
		
		
	}
	/**
	 * 设置下其他属性
	 */
	private void setAttr(List<BBINGameVo> list) throws Exception{
		Date date=new Date();
		list.stream().forEach(vo ->{
			vo.setUppername(configApiInfo.getLiveKey());
			vo.setSiteId(configApiInfo.getSiteId());
			String playName = vo.getUserName();
			vo.setUserName(StringUtils.substring(playName, configApiInfo.getPrefix().length()));
			BigDecimal payoff = vo.getPayOff();
			if(payoff.doubleValue()>0) {
				vo.setWinLossType(2);//1:输，2：赢，3：和
			}else if(payoff.doubleValue()<0) {
				vo.setWinLossType(1);
			}else {
				vo.setWinLossType(3);
			}
			vo.setCreateTime(date);
			vo.setUpdateTime(date);
		});
	}
}
