package com.ds.report.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ds.report.dao.mapper.DsGameTypeMapper;
import com.ds.report.entity.DsGameType;
import com.ds.report.entity.DsGameTypeExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.LMGLiveEntityExample;
import com.ds.report.entity.LMGLiveEntityExample.Criteria;
import com.ds.report.entity.mapper.LMGLiveEntityMapper;
import com.ds.report.utils.CommonUtils;

@Service
public class LMGServiceImpl {
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private LMGLiveEntityMapper lmgLiveEntityMapper;
	@Resource 
	private DsGameTypeMapper dsGameTypeMapper;
	
	
	public DsReportDetail queryTotal(Map<String,Object> paramMap)throws Exception{
		DsReportDetail dsReportTotal = null;
		try{
			logger.info("DsLive::queryTotal start");
			LMGLiveEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.lmgLiveEntityMapper.queryTotal(m_example);
			logger.info("DsLive::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
		
	}
	
    public List<DsReportDetail> queryDetail(Map<String,Object> paramMap)throws Exception{
    	List<DsReportDetail> dsReportDetail = null;
		try{
			logger.info("DsLive::queryDetail start");
			LMGLiveEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.lmgLiveEntityMapper.queryDetail(m_example);
			logger.info("DsLive::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
    }
   
    private LMGLiveEntityExample generateSearchParam(Map<String,Object> paramMap)throws Exception{
    	try{
    		LMGLiveEntityExample m_example = new LMGLiveEntityExample();
			Criteria m_criteria = m_example.createCriteria();
	
			m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
			String startTime = "";
			if(paramMap.containsKey("startTime")){
				startTime = paramMap.get("startTime").toString();
			}else{
				startTime = "00:00:00";
			}
			m_criteria.andEndTimeGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
	
			String endTime = "";
			if(paramMap.containsKey("endTime")){
				endTime = paramMap.get("endTime").toString();
			}else{
				endTime = "23:59:59";
			}
	        m_criteria.andEndTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
	
	        if(paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())){
				m_criteria.andUsernameEqualTo(paramMap.get("username").toString());
			}
	        
	        if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
	        	m_criteria.andBillnoEqualTo(Long.valueOf(paramMap.get("billNo") + ""));
	        }
	        
	        if(paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())){
				DsGameType dsGameType = this.dsGameTypeMapper.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
				if(dsGameType != null && dsGameType.getOutGameCode() != null && StringUtils.isNotBlank(dsGameType.getOutGameCode()))
					m_criteria.andGameTypeEqualTo(dsGameType.getOutGameCode());
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
			m_example.setOrderByClause("end_time desc");
			return m_example;
    
    	}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
    }

	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			LMGLiveEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.lmgLiveEntityMapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			LMGLiveEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.lmgLiveEntityMapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
}
