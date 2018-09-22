package com.ds.report.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ds.report.dao.mapper.DsGameTypeMapper;
import com.ds.report.dao.mapper.DsLiveMapper;
import com.ds.report.entity.DsGameType;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.DsLiveExample;
import com.ds.report.entity.DsLiveExample.Criteria;
import com.ds.report.utils.CommonUtils;
import com.ds.report.vo.DsLiveDetailVo;

@Service
public class DsLiveServiceImpl {
	
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource 
	private DsLiveMapper dsLiveMapper;
	
	@Resource 
	private DsGameTypeMapper dsGameTypeMapper;
	
	@Resource 
	protected RedisTemplate redisTemplate;
	
	
	public DsReportDetail queryTotal(Map<String,Object> paramMap)throws Exception{
		DsReportDetail dsReportTotal = null;
		try{
			logger.info("DsLive::queryTotal start");
			DsLiveExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.dsLiveMapper.queryTotal(m_example);
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
			DsLiveExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsLiveMapper.queryDetail(m_example);
			formatDsLiveDetail(dsReportDetail);
			logger.info("DsLive::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
    }
    /**
     * 为了处理牌型分解，处理
     * @param dsReportDetail
     */
	public void formatDsLiveDetail(List<DsReportDetail> dsReportDetail){
		if(dsReportDetail == null || dsReportDetail.size()==0){
			return;
		}
		for (DsReportDetail detail : dsReportDetail) {
		//	List<DsLiveDetailVo> detailMemberVo = new ArrayList<DsLiveDetailVo>();
			String liveMemberReportDetails = detail.getLiveMemberReportDetails();
			if(StringUtils.isNotBlank(liveMemberReportDetails)){
				List<DsLiveDetailVo> liveMemberDetails = JSON.parseArray(liveMemberReportDetails, DsLiveDetailVo.class);
				detail.setLiveMemberDetails(liveMemberDetails);
				try {
					detail.setBankResultArr(JSON.parseArray(detail.getBankResult()));
				} catch (Exception e) {
					detail.setBankResultArr(null);
				}
				try {
					detail.setPokerListArr(JSON.parseArray(detail.getPokerList()));
				} catch (Exception e) {
					detail.setPokerListArr(null);
				}
				
			}
		}
	}
	
    private DsLiveExample generateSearchParam(Map<String,Object> paramMap)throws Exception{
    	try{
	    	DsLiveExample m_example = new DsLiveExample();
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
			DsLiveExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsLiveMapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			DsLiveExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsLiveMapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
}
