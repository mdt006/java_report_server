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
import com.ds.report.entity.FenfenLottoEntityExample;
import com.ds.report.entity.VideoGameWagerExample;
import com.ds.report.entity.VideoGameWagerExample.Criteria;
import com.ds.report.entity.mapper.VideoGameWagerMapper;
import com.ds.report.utils.CommonUtils;
@Service
public class DsGameServiceImpl {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource 
	private VideoGameWagerMapper dsgameMapper;
	@Resource 
	private DsGameTypeMapper dsGameTypeMapper;
	
	
	public DsReportDetail queryTotal(Map<String, Object> paramMap) throws Exception {
		DsReportDetail dsReportTotal = null;
		try{
			logger.info("DSGAME::queryTotal start");
			VideoGameWagerExample m_example = this.generateSearchParam(paramMap);
			
			dsReportTotal = this.dsgameMapper.queryTotal(m_example);
			logger.info("DSGAME::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}

	private VideoGameWagerExample generateSearchParam(Map<String, Object> paramMap) throws Exception {
		try{
			VideoGameWagerExample m_example = new VideoGameWagerExample();
			Criteria m_criteria = m_example.createCriteria();
			m_criteria.andSiteidEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
			String startTime = "";
			if(paramMap.containsKey("startTime")){
				startTime = paramMap.get("startTime").toString();
			}else{
				startTime = "00:00:00";
			}
			m_criteria.andCreatetimeGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
			String endTime = "";
			if(paramMap.containsKey("endTime")){
				endTime = paramMap.get("endTime").toString();
			}else{
				endTime = "23:59:59";
			}
	        m_criteria.andCreatetimeLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
	
	        if(paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())){
				m_criteria.andUsernameEqualTo(paramMap.get("username").toString());
			}
	        
	        if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
	        	m_criteria.andIdEqualTo(Long.valueOf(paramMap.get("billNo").toString()));
	        }
	        
//			if(paramMap.containsKey("gameKind") && StringUtils.isNotBlank(paramMap.get("gameKind").toString())){
//				m_criteria.andGameKindEqualTo(Byte.valueOf(paramMap.get("gameKind").toString()));
//			}
	        if(paramMap.containsKey("gameType") && StringUtils.isNotBlank(paramMap.get("gameType").toString())){
				//	if(paramMap.get("gameKind").toString().equals("21")){//视讯有分小类，机率不分小类
						DsGameType dsGameType = this.dsGameTypeMapper.selectByPrimaryKey(Integer.valueOf(paramMap.get("gameType").toString()));
						if(dsGameType != null && dsGameType.getOutGameCode() != null && StringUtils.isNotBlank(dsGameType.getOutGameCode())
								&& dsGameType.getId()!=53000){
							m_criteria.andGamekeyEqualTo(dsGameType.getOutGameCode());
						}else{
							//新添加的游戏都叫DS最新电子游戏 gameType=53000
							m_criteria.andGamekeyNotIn(getDSGameTypeList(Integer.valueOf(paramMap.get("gameType").toString())));
						}
				//	}
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
			m_example.setOrderByClause("createTime desc");
			return m_example;
    	}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		
	}
	private List<String> getDSGameTypeList(Integer gameType) {
		List<String> gameTypes = new ArrayList<String>();
    	DsGameTypeExample e = new DsGameTypeExample();
    	e.createCriteria().andFkLiveIdEqualTo((byte)12).andParentIdEqualTo(53).andIdNotEqualTo(gameType);
    	List<DsGameType> dsGameTypeList = this.dsGameTypeMapper.selectByExample(e);
    	for (DsGameType dsGameType : dsGameTypeList) {
    		gameTypes.add(dsGameType.getOutGameCode());
		}
    	return gameTypes;
	}

	public List<DsReportDetail> queryDetail(Map<String, Object> paramMap) throws Exception {
		List<DsReportDetail> dsReportDetail = null;
		try{
			logger.info("DSGAME::queryDetail start");
			VideoGameWagerExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsgameMapper.queryDetail(m_example);
			logger.info("DSGAME::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}

	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			VideoGameWagerExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsgameMapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}

	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap) throws Exception {
		List<DsReport> dsReportTotal = null;
		try{
			VideoGameWagerExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.dsgameMapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
	}

}
