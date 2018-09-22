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

import com.ds.report.dao.mapper.DsBbinSportMapper;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DsBbinSportExample;
import com.ds.report.utils.CommonUtils;


@Service
public class DsBbinSportServiceImpl {
	
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource 
	private DsBbinSportMapper dsBbinSportMapper;
	
	public DsReportDetail queryTotal(Map<String,Object> paramMap)throws Exception{
		DsReportDetail dsReportTotal = null;
		try{
			logger.info("BbinSport::queryTotal start");
			DsBbinSportExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.dsBbinSportMapper.queryTotal(m_example);
			logger.info("BbinSport::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
		
	}
	
    public List<DsReportDetail> queryDetail(Map<String,Object> paramMap)throws Exception{
    	List<DsReportDetail> dsReportDetail = null;
		try{
			logger.info("BbinSport::queryDetail start");
			DsBbinSportExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsBbinSportMapper.queryDetail(m_example);
			logger.info("BbinSport::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
    }
    
    public List<DsReport> queryTotalGroupGameType(Map<String,Object> paramMap) throws Exception{
    	List<DsReport> dsReportDetail = null;
		try{
			logger.info("BbinSport::queryTotalGroupGameType start");
			DsBbinSportExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsBbinSportMapper.queryTotalGroupGameType(m_example);
			logger.info("BbinSport::queryTotalGroupGameType end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
    }
	

    private DsBbinSportExample generateSearchParam(Map<String,Object> paramMap)throws Exception{
    	try{
	    	DsBbinSportExample m_example = new DsBbinSportExample();
	    	com.ds.report.entity.DsBbinSportExample.Criteria m_criteria = m_example.createCriteria();
	
			m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
			String startTime = "";
			if(paramMap.containsKey("startTime")){
				startTime = paramMap.get("startTime").toString();
			}else{
				startTime = "00:00:00";
			}
			m_criteria.andWagersDateGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
	
			String endTime = "";
			if(paramMap.containsKey("endTime")){
				endTime = paramMap.get("endTime").toString();
			}else{
				endTime = "23:59:59";
			}
	        m_criteria.andWagersDateLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
	
	        if(paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())){
				m_criteria.andUserNameEqualTo(paramMap.get("username").toString());
			}
	        
	        if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
	        	m_criteria.andWagersIdEqualTo(paramMap.get("billNo") + "");
	        }
	        
	        //不分小类，直接查所有
			/*if(paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())){
				DsGameType dsGameType = this.dsGameTypeMapper.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameKind").toString()));
				if(dsGameType != null && dsGameType.getOutGameCode() != null && StringUtils.isNotBlank(dsGameType.getOutGameCode()))
					m_criteria.andGameTypeEqualTo(Integer.valueOf(dsGameType.getOutGameCode()));
			}*/
	
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
			m_example.setOrderByClause("wagers_date desc");
			return m_example;
    	}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
    	
    }

	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap) throws Exception{
    	List<DsReport> dsReportDetail = null;
		try{
			logger.info("BbinSport::queryBetTotalByDayNew start");
			DsBbinSportExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsBbinSportMapper.queryBetTotalByDayNew(m_example);
			logger.info("BbinSport::queryBetTotalByDayNew end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
    }

}
