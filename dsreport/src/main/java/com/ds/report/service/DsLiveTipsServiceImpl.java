package com.ds.report.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ds.report.dao.mapper.DsLiveTipsMapper;
import com.ds.report.entity.DsLiveTips;
import com.ds.report.entity.DsLiveTipsExample;
import com.ds.report.entity.DsLiveTipsExample.Criteria;
import com.ds.report.utils.CommonUtils;

@Service
public class DsLiveTipsServiceImpl {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource 
	private DsLiveTipsMapper dsLiveTipsMapper;
	
	public DsLiveTips queryTotal(Map<String,Object> paramMap)throws Exception{
    	DsLiveTips dsLiveTips = null;
		try{
			logger.info("DsLiveTips::queryTotal start");
			DsLiveTipsExample m_example = this.generateSearchParam(paramMap);
			dsLiveTips = this.dsLiveTipsMapper.queryTotal(m_example);
			logger.info("DsLiveTips::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsLiveTips;
    }
	
	public List<DsLiveTips> queryDetail(Map<String,Object> paramMap)throws Exception{
    	List<DsLiveTips> dsLiveTips = null;
		try{
			logger.info("DsLiveTips::queryDetail start");
			DsLiveTipsExample m_example = this.generateSearchParam(paramMap);
			dsLiveTips = this.dsLiveTipsMapper.queryDetail(m_example);
			logger.info("DsLiveTips::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsLiveTips;
    }
	
    private DsLiveTipsExample generateSearchParam(Map<String,Object> paramMap)throws Exception{
    	try{
    		DsLiveTipsExample m_example = new DsLiveTipsExample();
			Criteria m_criteria = m_example.createCriteria();
	
			m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
			String startTime = "";
			if(paramMap.containsKey("startTime")){
				startTime = paramMap.get("startTime").toString();
			}else{
				startTime = "00:00:00";
			}
			m_criteria.andCreationTimeGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
	
			String endTime = "";
			if(paramMap.containsKey("endTime")){
				endTime = paramMap.get("endTime").toString();
			}else{
				endTime = "23:59:59";
			}
	        m_criteria.andCreationTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
	
	        if(paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())){
				m_criteria.andUsernameEqualTo(paramMap.get("username").toString());
			}
	        
	        if(paramMap.containsKey("liveId") && StringUtils.isNotBlank(paramMap.get("liveId").toString())){
				m_criteria.andDsLiveTypeEqualTo(Integer.valueOf(paramMap.get("liveId").toString()));
			}
	        if(paramMap.containsKey("transferType") && StringUtils.isNotBlank(paramMap.get("transferType").toString())){
				m_criteria.andTransferTypeEqualTo(paramMap.get("transferType").toString());
			}
	        
	        
			Integer page = 1;
			Integer pageLimit = CommonUtils.pageLimit;
			if(paramMap.containsKey("page") && StringUtils.isNotBlank(paramMap.get("page").toString())){
				page = Integer.valueOf(paramMap.get("page").toString());
			}
			if(paramMap.containsKey("pageLimit") && StringUtils.isNotBlank(paramMap.get("pageLimit").toString())){
				pageLimit = Integer.valueOf(paramMap.get("pageLimit").toString());
			}
			m_example.setPage((page - 1)*pageLimit);
			m_example.setPageLimit(pageLimit);
			return m_example;
    
    	}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
    }
    
}
