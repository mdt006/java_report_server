package com.ds.report.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ds.report.dao.mapper.DsGameTypeMapper;
import com.ds.report.entity.DsGameType;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.FenfenLottoEntityExample;
import com.ds.report.entity.ManniuBetEntityExample;
import com.ds.report.entity.mapper.ManniuBetEntityMapper;
import com.ds.report.utils.CommonUtils;

@Service
public class ManniuServiceImpl {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ManniuBetEntityMapper manniuBetMapper;

	@Resource
	private DsGameTypeMapper dsGameTypeMapper;
	
	public DsReportDetail queryTotal(Map<String, Object> paramMap) throws Exception {
		DsReportDetail dsReportTotal = null;
		try {
			logger.info("manniu::queryTotal start");
			ManniuBetEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.manniuBetMapper.queryTotal(m_example);
			logger.info("manniu::queryTotal end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;

	}
	private ManniuBetEntityExample generateSearchParam(Map<String, Object> paramMap) throws Exception {
		try {
			ManniuBetEntityExample m_example = new ManniuBetEntityExample();
			com.ds.report.entity.ManniuBetEntityExample.Criteria m_criteria = m_example.createCriteria();

			m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//format.setTimeZone(TimeZone.getTimeZone("GMT-4"));
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			} else {
				startTime = "00:00:00";
			}
			m_criteria.andCreateTimeGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString() + " " + startTime));

			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			} else {
				endTime = "23:59:59";
			}
			m_criteria.andCreateTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString() + " " + endTime));

			if (paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())) {
				m_criteria.andUsernameEqualTo(paramMap.get("username").toString());
			}
			if (paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))) {
				m_criteria.andBetBillnoEqualTo(paramMap.get("billNo") + "");
			}
			if (paramMap.containsKey("tableId") && StringUtils.isNotBlank((paramMap.get("tableId") + ""))) {
				m_criteria.andTableIdEqualTo(Integer.parseInt(paramMap.get("tableId").toString()));
			}
			if (paramMap.containsKey("term") && StringUtils.isNotBlank((paramMap.get("term") + ""))) {
				m_criteria.andTermEqualTo(Long.parseLong(paramMap.get("term").toString()));
				//m_criteria.andTableIdEqualTo(Integer.parseInt(paramMap.get("tableId").toString()));
			}
			if (paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())) {
				DsGameType dsGameType = this.dsGameTypeMapper.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
				if (dsGameType != null && dsGameType.getOutGameCode() != null && StringUtils.isNotBlank(dsGameType.getOutGameCode()))
					m_criteria.andGameTypeEqualTo(dsGameType.getOutGameCode());
			}
			Integer page = 1;
			Integer pageLimit = CommonUtils.pageLimit;
			if (paramMap.containsKey("page") && StringUtils.isNotBlank(paramMap.get("page").toString())) {
				page = Integer.valueOf(paramMap.get("page").toString());
			}
			if (paramMap.containsKey("pageLimit") && StringUtils.isNotBlank(paramMap.get("pageLimit").toString())) {
				pageLimit = Integer.valueOf(paramMap.get("pageLimit").toString());
			}
			m_example.setPage((page - 1) * pageLimit);
			m_example.setPageLimit(pageLimit);
			m_example.setOrderByClause("create_time desc,id desc");
			return m_example;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}

	}
	public List<DsReportDetail> queryDetail(Map<String, Object> paramMap) throws Exception {
		List<DsReportDetail> dsReportDetail = null;
		try {
			logger.info("manniu::queryDetail start");
			ManniuBetEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.manniuBetMapper.queryDetail(m_example);
			logger.info("manniu::queryDetail end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportTotal = null;
		try{
			ManniuBetEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.manniuBetMapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}
	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportTotal = null;
		try{
			ManniuBetEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.manniuBetMapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}
}
