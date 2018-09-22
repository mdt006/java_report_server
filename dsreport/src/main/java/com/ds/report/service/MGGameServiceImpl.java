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
import com.ds.report.entity.DSLotteryBetEntityExample;
import com.ds.report.entity.DsGameType;
import com.ds.report.entity.DsGameTypeExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.FenfenLottoEntityExample;
import com.ds.report.entity.MGGameEntityExample;
import com.ds.report.entity.MGGameEntityExample.Criteria;
import com.ds.report.entity.mapper.MGGameEntityMapper;
import com.ds.report.utils.CommonUtils;

@Service
public class MGGameServiceImpl {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private MGGameEntityMapper mgGameEntityMapper;
	@Resource 
	private DsGameTypeMapper dsGameTypeMapper;
	public List<DsReportDetail> queryDetail(Map<String, Object> paramMap) throws Exception {
		List<DsReportDetail> dsReportDetail = null;
		try{
			log.info("MG::queryDetail start");
			MGGameEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.mgGameEntityMapper.queryDetail(m_example);
			log.info("MG::queryDetail end");
		}catch(Exception ex){
			log.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
	public DsReportDetail queryTotal(Map<String, Object> paramMap) throws Exception {
		DsReportDetail detail = null;
		try {
			log.info("MG::queryTotal start");
			MGGameEntityExample example = this.generateSearchParam(paramMap);
			detail = this.mgGameEntityMapper.queryTotal(example);
			log.info("MG::queryTotal end");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return detail;
	}
	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap) throws Exception{
		List<DsReport> dsReportTotal = null;
		try{
			MGGameEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.mgGameEntityMapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			log.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}
	private MGGameEntityExample generateSearchParam(Map<String, Object> paramMap) throws Exception {
		try {
			MGGameEntityExample example = new MGGameEntityExample();
			Criteria criteria = example.createCriteria();
			criteria.andSiteidEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			} else {
				startTime = "00:00:00";
			}
			criteria.andTransactionTimestampDateGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString() + " " + startTime));
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			} else {
				endTime = "23:59:59";
			}
			criteria.andTransactionTimestampDateLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString() + " " + endTime));

			if (paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())) {
				criteria.andUsernameEqualTo(paramMap.get("username").toString());
			}
			if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
				criteria.andBetColIdEqualTo((paramMap.get("billNo") + ""));
			}
			
			if(paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())){
				DsGameType dsGameType = this.dsGameTypeMapper.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
				if(dsGameType != null && dsGameType.getOutGameCode() != null && StringUtils.isNotBlank(dsGameType.getOutGameCode())
						&& dsGameType.getId()!=52000){
					criteria.andGameCodeEqualTo(dsGameType.getOutGameCode());
					
				}else{
					//m_criteria.andGameTypeNotIn(getLotteryGameTypeList(Integer.valueOf(paramMap.get("gameType").toString())));
					criteria.andGameCodeNotIn(getMGGameTypeList(paramMap.get("gameType").toString()));
				}
			}
			
			
			Integer page = 1;
			Integer pageLimit = CommonUtils.pageLimit;
			if (paramMap.containsKey("page") && StringUtils.isNotBlank(paramMap.get("page").toString())) {
				page = Integer.valueOf(paramMap.get("page").toString());
			}
			if (paramMap.containsKey("pageLimit") && StringUtils.isNotBlank(paramMap.get("pageLimit").toString())) {
				pageLimit = Integer.valueOf(paramMap.get("pageLimit").toString());
			}
			example.setPage((page - 1) * pageLimit);
			example.setPageLimit(pageLimit);
			example.setOrderByClause("transaction_timestamp_date desc");
			return example;

		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	private List<String> getMGGameTypeList(String gameType) {
		List<String> gameTypes = new ArrayList<String>();
    	DsGameTypeExample e = new DsGameTypeExample();
    	e.createCriteria().andFkLiveIdEqualTo((byte)15).andParentIdEqualTo(60).andIdNotEqualTo(Integer.valueOf(gameType));
    	List<DsGameType> dsGameTypeList = this.dsGameTypeMapper.selectByExample(e);
    	for (DsGameType dsGameType : dsGameTypeList) {
    		gameTypes.add(dsGameType.getOutGameCode());
		}
    	return gameTypes;
	}
	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportTotal = null;
		try{
			MGGameEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.mgGameEntityMapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			log.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}
	

}
