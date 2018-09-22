package com.ds.live.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.live.common.BaseCommon;
import com.kg.live.entity.TotalReportConfigExample;
import com.kg.live.entity.TotalReportConfigWithBLOBs;
import com.kg.live.mapper.TotalReportConfigMapper;

@Service
public class BaseService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TotalReportConfigMapper reportConfigMapper;
	
	
	
	public List<TotalReportConfigWithBLOBs> loadConfigList(){
		List<TotalReportConfigWithBLOBs> configList=new ArrayList<TotalReportConfigWithBLOBs>();
		TotalReportConfigExample e = new TotalReportConfigExample();
		e.createCriteria().andStateIn(BaseCommon.CONFIG_STATE_LIST);
		configList = reportConfigMapper.selectByExampleWithBLOBs(e);
		
		logger.info("加载配置完成，数量{}",configList.size());
		return configList;
	}

	public List<TotalReportConfigWithBLOBs> getConfigListByState(int state){
		List<TotalReportConfigWithBLOBs> configList=new ArrayList<TotalReportConfigWithBLOBs>();
		TotalReportConfigExample e = new TotalReportConfigExample();
		e.createCriteria().andStateEqualTo(state);
		configList=reportConfigMapper.selectByExampleWithBLOBs(e);
		return configList;
	}
	
}
