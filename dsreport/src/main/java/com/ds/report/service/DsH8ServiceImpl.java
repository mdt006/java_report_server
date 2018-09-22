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

import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.M8SportEntityExample;
import com.ds.report.entity.M8SportEntityExample.Criteria;
import com.ds.report.entity.mapper.M8SportEntityMapper;
import com.ds.report.utils.CommonUtils;

@Service
public class DsH8ServiceImpl {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource 
	private M8SportEntityMapper h8Mapper;
	
	public DsReportDetail queryTotal(Map<String, Object> paramMap) throws Exception {
		DsReportDetail dsReportTotal = null;
		try{
			logger.info("H8::queryTotal start");
			M8SportEntityExample m_example = this.generateSearchParam(paramMap);
			
			dsReportTotal = this.h8Mapper.queryTotal(m_example);
			logger.info("H8::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}

	private M8SportEntityExample generateSearchParam(
			Map<String, Object> paramMap) throws Exception {
		try{
			M8SportEntityExample m_example = new M8SportEntityExample();
			Criteria m_criteria = m_example.createCriteria();
			m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
			String startTime = "";
			String endTime = "";
			if(paramMap.containsKey("startTime")){
				startTime = paramMap.get("startTime").toString();
			}else{
				startTime = "00:00:00";
			}
			if(paramMap.containsKey("endTime")){
				endTime = paramMap.get("endTime").toString();
			}else{
				endTime = "23:59:59";
			}
			if(paramMap.containsKey("is_js_time")){//按结算时间查询
				if("1".equals(paramMap.get("is_js_time"))){
					m_criteria.andWorkdateGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
					m_criteria.andWorkdateLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
				}else{//下注时间
					m_criteria.andTransactionDateGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
			        m_criteria.andTransactionDateLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
				}
			}else{//下注时间
				m_criteria.andTransactionDateGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
		        m_criteria.andTransactionDateLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
			}
			
			
			
	
	        if(paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())){
				m_criteria.andUsernameEqualTo(paramMap.get("username").toString());
			}
	        
	        if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
	        	m_criteria.andBetIdEqualTo(paramMap.get("billNo") + "");
	        }
	        
//			if(paramMap.containsKey("gameKind") && StringUtils.isNotBlank(paramMap.get("gameKind").toString())){
//				m_criteria.andGameKindEqualTo(Byte.valueOf(paramMap.get("gameKind").toString()));
//			}
			
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
			m_example.setOrderByClause("transaction_date desc");
			return m_example;
    	}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	public List<DsReportDetail> queryDetail(Map<String, Object> paramMap) throws Exception {
		List<DsReportDetail> dsReportDetail = null;
		try{
			logger.info("H8体育::queryDetail start");
			M8SportEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.h8Mapper.queryDetail(m_example);
			logger.info("H8体育::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}

	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			M8SportEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.h8Mapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}

	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap)throws Exception  {
		List<DsReport> dsReportDetail = null;
		try{
			M8SportEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.h8Mapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}

}
