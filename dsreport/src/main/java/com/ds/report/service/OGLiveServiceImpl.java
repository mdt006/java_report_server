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
import com.ds.report.entity.OGLiveEntityExample;
import com.ds.report.entity.OGLiveEntityExample.Criteria;
import com.ds.report.entity.mapper.OGLiveEntityMapper;
import com.ds.report.utils.CommonUtils;

@Service
public class OGLiveServiceImpl {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	private OGLiveEntityMapper oGLiveEntityMapper;
	@Resource 
	private DsGameTypeMapper dsGameTypeMapper;
	
	
	public DsReportDetail queryTotal(Map<String, Object> paramMap) throws Exception {
		DsReportDetail dsReportTotal = null;
		try {
			log.info("OGLive::queryTotal start");
			OGLiveEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.oGLiveEntityMapper.queryTotal(m_example);
			log.info("OGLive::queryTotal end");
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;

	}
	
	public List<DsReportDetail> queryDetail(Map<String, Object> paramMap) throws Exception {
		List<DsReportDetail> dsReportDetail = null;
		try {
			log.info("OGLive::queryDetail start");
			OGLiveEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.oGLiveEntityMapper.queryDetail(m_example);
			log.info("OGLive::queryDetail end");
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}
	

	private OGLiveEntityExample generateSearchParam(Map<String, Object> paramMap) throws Exception {
		try {
			OGLiveEntityExample example = new OGLiveEntityExample();
			Criteria criteria = example.createCriteria();
			criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
			String startTime = "";
			if (paramMap.containsKey("startTime")) {
				startTime = paramMap.get("startTime").toString();
			} else {
				startTime = "00:00:00";
			}
			//criteria.andAddTimeGreaterThanOrEqualTo(value)
			criteria.andAddTimeGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString() + " " + startTime));
			String endTime = "";
			if (paramMap.containsKey("endTime")) {
				endTime = paramMap.get("endTime").toString();
			} else {
				endTime = "23:59:59";
			}
			//criteria.andAddTimeLessThanOrEqualTo(value)
			criteria.andAddTimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString() + " " + endTime));

			if (paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())) {
				criteria.andUsernameEqualTo(paramMap.get("username").toString());
			}
			if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
				//criteria.andBillnoEqualTo((paramMap.get("billNo") + ""));
				criteria.andProductIdEqualTo(Long.valueOf(paramMap.get("billNo").toString()));
			}
			
			if(paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())){
				DsGameType dsGameType = this.dsGameTypeMapper.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
				if(dsGameType != null && dsGameType.getOutGameCode() != null && StringUtils.isNotBlank(dsGameType.getOutGameCode())
						&& dsGameType.getId()!=70000){
					//criteria.andLottoTypeEqualTo(dsGameType.getOutGameCode());
					criteria.andGameNameIdEqualTo(dsGameType.getOutGameCode());
				}else{
					//新添加的游戏都
					//m_criteria.andGameTypeNotIn(getLotteryGameTypeList(Integer.valueOf(paramMap.get("gameType").toString())));
					//criteria.andLottoTypeNotIn(getLotteryGameTypeList(paramMap.get("gameType").toString()));
					criteria.andGameNameIdNotIn(getLotteryGameTypeList(paramMap.get("gameType").toString()));
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
			example.setOrderByClause("add_time desc");
			return example;

		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	private List<String> getLotteryGameTypeList(String gameType) {
		List<String> gameTypes = new ArrayList<String>();
    	DsGameTypeExample e = new DsGameTypeExample();
    	e.createCriteria().andFkLiveIdEqualTo((byte)3).andParentIdEqualTo(70).andIdNotEqualTo(Integer.valueOf(gameType));
    	List<DsGameType> dsGameTypeList = this.dsGameTypeMapper.selectByExample(e);
    	for (DsGameType dsGameType : dsGameTypeList) {
    		gameTypes.add(dsGameType.getOutGameCode());
		}
    	return gameTypes;
	}
	

	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportTotal = null;
		try{
			OGLiveEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.oGLiveEntityMapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			log.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}
	
	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportTotal = null;
		try{
			OGLiveEntityExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.oGLiveEntityMapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			log.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}

}