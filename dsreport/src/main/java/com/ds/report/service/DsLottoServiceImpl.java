package com.ds.report.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ds.report.entity.DSLottoBetEntityExample;
import com.ds.report.entity.DSLottoBetEntityExample.Criteria;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.LottoBetDetail;
import com.ds.report.entity.LottoBetDetailExample;
import com.ds.report.entity.mapper.DSLottoBetEntityMapper;
import com.ds.report.entity.mapper.LottoBetDetailMapper;
import com.ds.report.utils.CommonUtils;

@Service
public class DsLottoServiceImpl {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource 
	private DSLottoBetEntityMapper dsLottoMapper;
	@Resource 
	private LottoBetDetailMapper detailMapper;
	
	public DsReportDetail queryTotal(Map<String, Object> paramMap) throws Exception {
		DsReportDetail dsReportTotal = null;
		try{
			logger.info("DSLotto::queryTotal start");
			DSLottoBetEntityExample m_example = this.generateSearchParam(paramMap);
			
			dsReportTotal = this.dsLottoMapper.queryTotal(m_example);
			logger.info("DSLotto::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}

	private DSLottoBetEntityExample generateSearchParam(
			Map<String, Object> paramMap) throws Exception {
		try{
			DSLottoBetEntityExample m_example = new DSLottoBetEntityExample();
			Criteria m_criteria = m_example.createCriteria();
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
	        
	        if(paramMap.containsKey("billNo") && StringUtils.isNotBlank(paramMap.get("billNo").toString())){
				//m_criteria.andBillnoEqualTo(Long.valueOf(paramMap.get("billNo").toString()));
	        	m_criteria.andBetIdEqualTo(paramMap.get("billNo").toString());
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
			m_example.setOrderByClause("bet_time desc,id desc");
			return m_example;
    	}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	public List<DsReportDetail> queryDetail(Map<String, Object> paramMap) throws Exception {
		List<DsReportDetail> dsReportDetail = null;
		try{
			logger.info("DSLotto::queryDetail start");
			DSLottoBetEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsLottoMapper.queryDetail(m_example);
			logger.info("DSLotto::queryDetail end");
			formatLottoBetList(dsReportDetail);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
	/**
	 * 对结果牌进行分析bet_detail
	 * @param dsReportDetail
	 */
	private void formatLottoBetList(List<DsReportDetail> dsReportDetail) {
		Map<String,String> detailMap =  getBetDetailList();
		for (DsReportDetail report : dsReportDetail) {
			List<String> detailList = new ArrayList<String>();
			String betDetails = report.getBetDetailsId();//["NO_1"]
			if(StringUtils.isBlank(betDetails) || 
					betDetails.equals("[]")){
				continue;
			}
			String subBet = StringUtils.substringBetween(betDetails, "[", "]");//"NO_1"
			String subBet2 = StringUtils.replace(subBet, "\"", "");//NO_1,NO_2
			String[] betDetailArr = subBet2.split(",");
			for (String betsubDetail : betDetailArr) {
				detailList.add(detailMap.get(betsubDetail));
			}
			report.setBetDetailList(detailList);
			report.setBetDetailsId(null);
		}
	}
	private Map<String,String> getBetDetailList(){
		Map<String,String> map = new HashMap<String, String>();
		LottoBetDetailExample e = new LottoBetDetailExample();
		List<LottoBetDetail> list = detailMapper.selectByExample(e);
		for (LottoBetDetail lottoBetDetail : list) {
			map.put(lottoBetDetail.getBetDetailId(), lottoBetDetail.getBetDetailIdExpain());
		}
		return map;
	}

	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportTotal = null;
		try{
			logger.info("DSLotto::queryTotal start");
			DSLottoBetEntityExample m_example = this.generateSearchParam(paramMap);
			
			dsReportTotal = this.dsLottoMapper.queryTotalGroupGameType(m_example);
			logger.info("DSLotto::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}

	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportTotal = null;
		try{
			logger.info("DSLotto::queryBetTotalByDayNew start");
			DSLottoBetEntityExample m_example = this.generateSearchParam(paramMap);
			
			dsReportTotal = this.dsLottoMapper.queryBetTotalByDayNew(m_example);
			logger.info("DSLotto::queryBetTotalByDayNew end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}
	

}
