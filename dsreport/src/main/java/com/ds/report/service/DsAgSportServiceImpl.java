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

import com.ds.report.dao.mapper.DsAgSportMapper;
import com.ds.report.dao.mapper.DsGameTypeMapper;
import com.ds.report.entity.DsAgSportExample;
import com.ds.report.entity.DsAgSportExample.Criteria;
import com.ds.report.entity.DsGameType;
import com.ds.report.entity.DsGameTypeExample;
import com.ds.report.entity.DsReport;
import com.ds.report.entity.DsReportDetail;
import com.ds.report.utils.CommonUtils;

@Service
public class DsAgSportServiceImpl {
	
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource 
	private DsAgSportMapper dsAgSportMapper;
	
	@Resource 
	private DsGameTypeMapper dsGameTypeMapper;
	
	public DsReportDetail queryTotal(Map<String,Object> paramMap)throws Exception{
		DsReportDetail dsReportTotal = null;
		try{
			logger.info("AgSport::queryTotal start");
			DsAgSportExample m_example = this.generateSearchParam(paramMap);
			dsReportTotal = this.dsAgSportMapper.queryTotal(m_example);
			logger.info("AgSport::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportTotal;
		
	}
	
    public List<DsReportDetail> queryDetail(Map<String,Object> paramMap)throws Exception{
    	List<DsReportDetail> dsReportDetail = null;
		try{
			logger.info("AgSport::queryDetail start");
			DsAgSportExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsAgSportMapper.queryDetail(m_example);
			logger.info("AgSport::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
    }
	

    private DsAgSportExample generateSearchParam(Map<String,Object> paramMap)throws Exception{
    	try{
    		DsAgSportExample m_example = new DsAgSportExample();
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
	        if(paramMap.containsKey("billNo") && StringUtils.isNotBlank((paramMap.get("billNo") + ""))){
	        	m_criteria.andBillNoEqualTo(paramMap.get("billNo") + "");
	        }
	        
			if(paramMap.containsKey("gameKind") && StringUtils.isNotBlank(paramMap.get("gameKind").toString())){
				/*List<DsGameType> listGameType = this.dsGameTypeMapper.selectByParentId(Integer.valueOf(paramMap.get("gameKind").toString()));
				if(!listGameType.isEmpty()){
					List<String> lGameType = new ArrayList<String>();
					for(int i = 0 ; i< listGameType.size();i++){   
						String iGameType = listGameType.get(i).getOutGameCode();
						lGameType.add(iGameType);
			        }
					if(paramMap.get("gameKind").toString().endsWith("21")){ //AG视讯
						m_criteria.andGameTypeIn(lGameType);
					}else{
						m_criteria.andGameTypeNotIn(lGameType);
					}
				}*/
				m_criteria.andGameKindEqualTo(Byte.valueOf(paramMap.get("gameKind").toString()));
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
    private List<String> getAGGameTypeList(int gameType){
    	List<String> gameTypes = new ArrayList<String>();
    	DsGameTypeExample e = new DsGameTypeExample();
    	e.createCriteria().andFkLiveIdEqualTo((byte)2).andParentIdEqualTo(22).andIdNotEqualTo(gameType);
    	List<DsGameType> dsGameTypeList = this.dsGameTypeMapper.selectByExample(e);
    	for (DsGameType dsGameType : dsGameTypeList) {
    		gameTypes.add(dsGameType.getOutGameCode());
		}
    	return gameTypes;
    }

	public List<DsReport> queryTotalGroupGameType(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			DsAgSportExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsAgSportMapper.queryTotalGroupGameType(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}

	public List<DsReport> queryBetTotalByDayNew(Map<String, Object> paramMap)throws Exception {
		List<DsReport> dsReportDetail = null;
		try{
			DsAgSportExample m_example = this.generateSearchParam(paramMap);
			dsReportDetail = this.dsAgSportMapper.queryBetTotalByDayNew(m_example);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsReportDetail;
	}

}
