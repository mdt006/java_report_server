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

import com.ds.report.dao.mapper.DsGameTypeMapper;
import com.ds.report.entity.DsGFLotteryEntityExample;
import com.ds.report.entity.DsGFLotteryEntityExample.Criteria;
import com.ds.report.entity.DsGameType;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.entity.mapper.DsGFLotteryEntityMapper;
import com.ds.report.entity.mapper.DsJingdianEntityMapper;
import com.ds.report.utils.CommonUtils;
/**
 * 新官方彩
 * @author 光光
 *
 */
@Service
public class DsGFLottoServiceImpl {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private DsGFLotteryEntityMapper gfMapper;

	@Resource
	private DsGameTypeMapper dsGameTypeMapper;

	public DsReportDetail queryTotal(Map<String, Object> paramMap) throws Exception {
		DsReportDetail dsReportTotal = null;
		try {
			logger.info("GFLotto::queryTotal start");
			DsGFLotteryEntityExample m_example = this.generateSearchParamWithGameKind(paramMap);
			dsReportTotal = this.gfMapper.queryTotal(m_example);
			logger.info("GFLotto::queryTotal end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;

	}

	public List<DsReportDetail> queryDetail(Map<String, Object> paramMap) throws Exception {
		List<DsReportDetail> dsReportDetail = null;
		try {
			logger.info("GFLotto::queryDetail start");
			Map<String, String> map = this.generateParamsMap(paramMap);
			dsReportDetail = this.gfMapper.queryDetailByMap(map);
			logger.info("GFLotto::queryDetail end");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}

	private DsGFLotteryEntityExample generateSearchParam(Map<String, Object> paramMap) throws Exception {
		try {

			DsGFLotteryEntityExample e = new DsGFLotteryEntityExample();
			Criteria m_criteria = e.createCriteria();

			m_criteria.andSiteidEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			} else {
				startTime = "00:00:00";
			}
			m_criteria.andBetTimeGreaterThanOrEqualTo(
					format.parse(paramMap.get("betTimeBegin").toString() + " " + startTime));

			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			} else {
				endTime = "23:59:59";
			}
			m_criteria.andBetTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString() + " " + endTime));

			if (paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())) {
				m_criteria.andUserNameEqualTo(paramMap.get("username").toString());
			}

			if (paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))) {
				m_criteria.andNidEqualTo(paramMap.get("billNo") + "");
			}
			
			
			if (paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())) {
				DsGameType dsGameType = this.dsGameTypeMapper
						.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
				if (dsGameType != null && dsGameType.getOutGameCode() != null
						&& StringUtils.isNotBlank(dsGameType.getOutGameCode()))
					m_criteria.andLidEqualTo(Integer.valueOf(dsGameType.getOutGameCode()));
			}

			Integer page = 1;
			Integer pageLimit = CommonUtils.pageLimit;
			if (paramMap.containsKey("page") && StringUtils.isNotBlank(paramMap.get("page").toString())) {
				page = Integer.valueOf(paramMap.get("page").toString());
			}
			if (paramMap.containsKey("pageLimit") && StringUtils.isNotBlank(paramMap.get("pageLimit").toString())) {
				pageLimit = Integer.valueOf(paramMap.get("pageLimit").toString());
			}
			e.setPage((page - 1) * pageLimit);
			e.setPageLimit(pageLimit);
			e.setOrderByClause("bet_time desc,id desc");
			return e;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	private DsGFLotteryEntityExample generateSearchParamWithGameKind(Map<String, Object> paramMap) throws Exception {
		try {

			DsGFLotteryEntityExample e = new DsGFLotteryEntityExample();
			Criteria m_criteria = e.createCriteria();

			m_criteria.andSiteidEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			} else {
				startTime = "00:00:00";
			}
			m_criteria.andBetTimeGreaterThanOrEqualTo(
					format.parse(paramMap.get("betTimeBegin").toString() + " " + startTime));

			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			} else {
				endTime = "23:59:59";
			}
			m_criteria.andBetTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString() + " " + endTime));
			if (paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())) {
				m_criteria.andUserNameEqualTo(paramMap.get("username").toString());
			}

			if (paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))) {
				m_criteria.andNidEqualTo(paramMap.get("billNo") + "");
			}
			//增加期数查询条件
			if (paramMap.containsKey("term") && StringUtils.isNotBlank((paramMap.get("term") + ""))) {
				m_criteria.andIssueEqualTo(Long.parseLong(paramMap.get("term") + ""));
			}
			if (paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())) {
				DsGameType dsGameType = this.dsGameTypeMapper
						.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
				if (dsGameType != null && dsGameType.getOutGameCode() != null
						&& StringUtils.isNotBlank(dsGameType.getOutGameCode()))
					m_criteria.andLidEqualTo(Integer.valueOf(dsGameType.getOutGameCode()));
			}

			/**
			 * 由于经典彩的注单都在一张表中,需要根据lid区分各个gameKind 当只传入gameType时,只需要查看相应的Lid游戏
			 * 当只传入gameKind时,则查询相应的lid数组游戏 两个参数都传入时,则查看gameType对应的lid游戏
			 */
			else if (paramMap.containsKey("gameKind") && StringUtils.isNotBlank(paramMap.get("gameKind").toString())) {
				List<DsGameType> gameTypeList = this.dsGameTypeMapper
						.selectByParentId(Integer.valueOf(paramMap.get("gameKind").toString()));
				if (gameTypeList != null) {
					List<Integer> temp = new ArrayList<Integer>();
					for (DsGameType dsGameType : gameTypeList) {
						temp.add(Integer.valueOf(dsGameType.getOutGameCode()));
					}
					m_criteria.andLidIn(temp);
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
			e.setPage((page - 1) * pageLimit);
			e.setPageLimit(pageLimit);
			e.setOrderByClause("bet_time desc,id desc");
			return e;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportTotal = null;
		try {
			DsGFLotteryEntityExample e = this.generateSearchParamWithGameKind(paramMap);
			dsReportTotal = this.gfMapper.queryBetTotalByDayNew(e);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}

	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportTotal = null;
		try {
			Map<String, String> map = this.generateParamsMap(paramMap);
			dsReportTotal = this.gfMapper.queryTotalGroupGameTypeByMap(map);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}

	private Map<String, String> generateParamsMap(Map<String, Object> paramMap) {
		Map<String, String> hashMap = new HashMap<String, String>();
		StringBuilder strWhere = new StringBuilder("");
		StringBuilder strLimit = new StringBuilder("");
		StringBuilder strOrderBy = new StringBuilder("");
		strWhere.append(" and siteid=\'" + paramMap.get("siteId").toString() + "\'");
		String startTime = "";
		if (paramMap.containsKey("startTime")) {
			startTime = paramMap.get("startTime").toString();
		} else {
			startTime = "00:00:00";
		}
		String endTime = "";
		if (paramMap.containsKey("endTime")) {
			endTime = paramMap.get("endTime").toString();
		} else {
			endTime = "23:59:59";
		}
		strWhere.append(" and bet_time >=\'" + paramMap.get("betTimeBegin").toString() + " " + startTime + "\'");
		strWhere.append(" and bet_time <=\'" + paramMap.get("betTimeEnd").toString() + " " + endTime + "\'");
		if (paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())) {
			strWhere.append(" and user_name =\'" + paramMap.get("username").toString() + "\'");
		}
		if (paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo").toString()))) {
			strWhere.append(" and nid =\'" + paramMap.get("billNo") + "\'");
		}
		//期数
		if (paramMap.containsKey("term") && StringUtils.isNotBlank((paramMap.get("term").toString()))) {
			strWhere.append(" and issue =\'" + paramMap.get("term").toString() + "\'");
		}
		if (paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())) {
			DsGameType dsGameType = this.dsGameTypeMapper
					.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
			if (dsGameType != null && dsGameType.getOutGameCode() != null
					&& StringUtils.isNotBlank(dsGameType.getOutGameCode()))
				strWhere.append(" and lid =\'" + dsGameType.getOutGameCode() + "\'");
		}else{
			List<DsGameType> gameTypeList = this.dsGameTypeMapper.selectByParentId(Integer.valueOf(paramMap.get("gameKind").toString()));
			if (gameTypeList != null) {
				StringBuilder strIn=new StringBuilder(" and lid in(");
				strIn.append(gameTypeList.get(0).getOutGameCode());
				for(int i=1;i<gameTypeList.size();i++){
					strIn.append(","+gameTypeList.get(i).getOutGameCode());
				}
				strIn.append(")");
				strWhere.append(strIn.toString());
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
		strLimit.append(" " + (page - 1) * pageLimit);
		strLimit.append("," + pageLimit);
		strOrderBy.append(" bet_time desc,id desc");
		hashMap.put("where", strWhere.toString());
		hashMap.put("order", strOrderBy.toString());
		hashMap.put("limit", strLimit.toString());
		hashMap.put("gameKind", paramMap.get("gameKind").toString());
		return hashMap;
	}
}
