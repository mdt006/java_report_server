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
import com.ds.report.dao.mapper.DsKyChessMapper;
import com.ds.report.entity.DsGameType;
import com.ds.report.entity.DsKyChessExample;
import com.ds.report.entity.DsKyChessExample.Criteria;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.utils.CommonUtils;

@Service
public class KyChessServiceImpl {
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private DsKyChessMapper dsKyChessMapper;
	@Resource 
	private DsGameTypeMapper dsGameTypeMapper;
	
	
	public DsReportDetail queryTotal(Map<String,Object> paramMap)throws Exception{
		DsReportDetail dsReportTotal = null;
		try{
			logger.info("DsLive::queryTotal start");
			DsKyChessExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.dsKyChessMapper.queryTotal(m_example);
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
			DsKyChessExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsKyChessMapper.queryDetail(m_example);
			logger.info("DsLive::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
    }
   
    private DsKyChessExample generateSearchParam(Map<String,Object> paramMap)throws Exception{
    	try{
    		DsKyChessExample m_example = new DsKyChessExample();
			Criteria m_criteria = m_example.createCriteria();
	
			m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
			String startTime = "";
			if(paramMap.containsKey("startTime")){
				startTime = paramMap.get("startTime").toString();
			}else{
				startTime = "00:00:00";
			}
			m_criteria.andGameEndTimeGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
	
			String endTime = "";
			if(paramMap.containsKey("endTime")){
				endTime = paramMap.get("endTime").toString();
			}else{
				endTime = "23:59:59";
			}
	        m_criteria.andGameEndTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
	
	        if(paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())){
				m_criteria.andAccountEqualTo(paramMap.get("username").toString());
			}
	        
	        if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
	        	m_criteria.andGameIdEqualTo((paramMap.get("billNo")+""));
	        }
	        
	        if(paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())){
	        	List<DsGameType> dsGameTypes = this.dsGameTypeMapper.selectByParentId(Integer.valueOf(paramMap.get("gameType").toString()));
//				DsGameType dsGameType = this.dsGameTypeMapper.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
//				if(dsGameType != null && dsGameType.getOutGameCode() != null && StringUtils.isNotBlank(dsGameType.getOutGameCode()))
//					m_criteria.andKindIdEqualTo(Integer.parseInt(dsGameType.getOutGameCode()));
	        	if(dsGameTypes != null && dsGameTypes.size() >0){
	        		List<Integer> values = new ArrayList<Integer>();
	        		for (DsGameType dg : dsGameTypes) {
	        			if(StringUtils.isNotBlank(dg.getOutGameCode())){
	        				values.add(Integer.parseInt(dg.getOutGameCode()));
	        			}
					}
	        		if(values.size() > 0){
	        			m_criteria.andKindIdIn(values);
	        		}
	        	}
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
			m_example.setOrderByClause("game_end_time desc");
			return m_example;
    
    	}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
    }

	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			DsKyChessExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsKyChessMapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			DsKyChessExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsKyChessMapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
}
