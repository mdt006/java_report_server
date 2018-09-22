package com.ds.report.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.onetwo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ds.report.dao.mapper.DsReportDao;
import com.ds.report.entity.DsAgHunterExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.mapper.DsAgHunterMapper;
import com.ds.report.entity.mapper.DsAgHunterReportMapper;
import com.ds.report.utils.CommonUtils;
import com.ds.report.vo.HunterDetailRecordParam;
import com.ds.report.vo.HunterDetailRecordVo;
import com.ds.report.vo.HunterDetailTotalVo;
import com.ds.report.vo.HunterSumRecordParam;


@Service
public class HunterJackpotServiceImpl {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource 
	private DsAgHunterReportMapper dsAgHunterReportMapper;
	@Resource 
	private DsAgHunterMapper dsAgHunterMapper;
	@Resource 
	private DsReportDao dsReportDao;
	
	//查询捕鱼王详细记录
	  public List<HunterDetailRecordVo> getDeatilRecord(Integer siteId,String username, Date startTime, Date endTime,int pageNum,int pageSize){
		  
		  	HunterDetailRecordParam hunterDetailRecordParam = new HunterDetailRecordParam();
		  	if(null!=siteId){
		  		hunterDetailRecordParam.setSiteId(siteId);
			}
			if(StringUtils.isNotBlank(username)){
				hunterDetailRecordParam.setUsername(username);
			}
			if(null!=startTime){
				hunterDetailRecordParam.setStartTime(startTime);
			}
			if(null!=endTime){
				hunterDetailRecordParam.setEndTime(endTime);
			}
	    	return dsReportDao.getDeatilRecord(hunterDetailRecordParam, pageNum, pageSize);
	    }
	//查询捕鱼王详细记录总数
	  public HunterDetailTotalVo getDeatilRecordCount(Integer siteId,String username, Date startTime, Date endTime){
		  
		  	HunterDetailRecordParam hunterDetailRecordParam = new HunterDetailRecordParam();
		  	if(null!=siteId){
		  		hunterDetailRecordParam.setSiteId(siteId);
			}
			if(StringUtils.isNotBlank(username)){
				hunterDetailRecordParam.setUsername(username);
			}
			if(null!=startTime){
				hunterDetailRecordParam.setStartTime(startTime);
			}
			if(null!=endTime){
				hunterDetailRecordParam.setEndTime(endTime);
			} 
	    	return dsReportDao.getDeatilRecordCount(hunterDetailRecordParam);
	    }
	//查询捕鱼王统计记录
	  public void getTotalRecord(Map<String, Object> paramMap, Map<String, Object> result){
		  
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
		  	HunterSumRecordParam hunterSumRecordParam = new HunterSumRecordParam();
		  	try {
		  		if(StringUtils.isNotBlank((String) paramMap.get("siteId"))){
			  		hunterSumRecordParam.setSiteId(Integer.valueOf((paramMap.get("siteId").toString())));
			  	}
		  		if(StringUtils.isNotBlank((String) paramMap.get("startTime"))){
			  		hunterSumRecordParam.setStartTime(sdf.parse(paramMap.get("startTime").toString()));
			  	}
		  		if(StringUtils.isNotBlank((String) paramMap.get("endTime"))){
			  		hunterSumRecordParam.setEndTime(sdf.parse(paramMap.get("endTime").toString()));
			  	}
		  		
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  	result.put("returnCode", 10000);
			result.put("returnMsg", "Success");
			result.put("dataList", dsReportDao.getTotalRecord(hunterSumRecordParam));
	    }
	  public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap)throws Exception {
			List<DsReport> dsReportDetail = null;
			try{
				DsAgHunterExample m_example = this.generateSearchParam(paramMap);
				dsReportDetail = this.dsAgHunterMapper.queryTotalGroupGameType(m_example);
			}catch(Exception ex){
				logger.error(ex.getMessage());
				throw ex;
			}
			return dsReportDetail;
		}
	  public DsReportDetail queryTotal(Map<String,Object> paramMap)throws Exception{
			DsReportDetail dsReportTotal = null;
			try{
				logger.info("AgHunter::queryTotal start");
				DsAgHunterExample m_example = this.generateSearchParam(paramMap);
				dsReportTotal = this.dsAgHunterMapper.queryTotal(m_example);
				logger.info("AgHunter::queryTotal end");
			}catch(Exception ex){
				logger.error(ex.getMessage());
				throw ex;
			}
			return dsReportTotal;
			
		}
		
	    public List<DsReportDetail> queryDetail(Map<String,Object> paramMap)throws Exception{
	    	List<DsReportDetail> dsReportDetail = null;
			try{
				logger.info("AgHunter::queryDetail start");
				DsAgHunterExample m_example = this.generateSearchParam(paramMap);
				dsReportDetail = this.dsAgHunterMapper.queryDetail(m_example);
				logger.info("AgHunter::queryDetail end");
			}catch(Exception ex){
				logger.error(ex.getMessage());
				throw ex;
			}
			return dsReportDetail;
	    }
	    public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap)throws Exception {
			List<DsReport> dsReportDetail = null;
			try{
				DsAgHunterExample m_example = this.generateSearchParam(paramMap);
				dsReportDetail = this.dsAgHunterMapper.queryBetTotalByDayNew(m_example);
			}catch(Exception ex){
				logger.error(ex.getMessage());
				throw ex;
			}
			return dsReportDetail;
		}
	    private DsAgHunterExample generateSearchParam(Map<String,Object> paramMap)throws Exception{
	    	try{
	    		DsAgHunterExample m_example = new DsAgHunterExample();
				com.ds.report.entity.DsAgHunterExample.Criteria m_criteria = m_example.createCriteria();
		
				m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
				String startTime = "";
				if(paramMap.containsKey("startTime")){
					startTime = paramMap.get("startTime").toString();
				}else{
					startTime = "00:00:00";
				}
				m_criteria.andBetTimeGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
		
				String endTime = "";
				if(paramMap.containsKey("endTime")){
					endTime = paramMap.get("endTime").toString();
				}else{
					endTime = "23:59:59";
				}
		        m_criteria.andBetTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
		
		        if(paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())){
					m_criteria.andUsernameEqualTo(paramMap.get("username").toString());
				}
		        if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
		        	m_criteria.andTradeNoEqualTo(paramMap.get("billNo") + "");
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
				m_example.setOrderByClause("bet_time desc");
				return m_example;
	    	}catch(Exception ex){
				logger.error(ex.getMessage());
				throw ex;
			}
	    	
	    }
	    
	}

