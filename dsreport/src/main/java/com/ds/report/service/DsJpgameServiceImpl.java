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

import com.ds.report.dao.mapper.DsJpgameMapper;
import com.ds.report.entity.DsJpgame;
import com.ds.report.entity.DsJpgameExample;
import com.ds.report.entity.DsJpgameExample.Criteria;
import com.ds.report.utils.CommonUtils;

@Service
public class DsJpgameServiceImpl {
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource 
	private DsJpgameMapper dsJpgameMapper;
	
	public DsJpgame queryTotal(Map<String,Object> paramMap)throws Exception{
		DsJpgame dsJpgameTotal = null;
		try{
			logger.info("DsJpgame::queryTotal start");
			DsJpgameExample m_example = this.generateSearchParam(paramMap);
			dsJpgameTotal = this.dsJpgameMapper.queryTotal(m_example);
			logger.info("DsJpgame::queryTotal end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsJpgameTotal;
    }
	
	public List<DsJpgame> queryDetail(Map<String,Object> paramMap)throws Exception{
    	List<DsJpgame> dsJpgameDetail = null;
		try{
			logger.info("DsJpgame::queryDetail start");
			DsJpgameExample m_example = this.generateSearchParam(paramMap);
			dsJpgameDetail = this.dsJpgameMapper.queryDetail(m_example);
			logger.info("DsJpgame::queryDetail end");
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
		return dsJpgameDetail;
    }
	
    private DsJpgameExample generateSearchParam(Map<String,Object> paramMap)throws Exception{
    	try{
    		DsJpgameExample m_example = new DsJpgameExample();
			Criteria m_criteria = m_example.createCriteria();
	
			m_criteria.andSiteIdEqualTo(Integer.valueOf(paramMap.get("siteId").toString()));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
			String startTime = "";
			if(paramMap.containsKey("startTime")){
				startTime = paramMap.get("startTime").toString();
			}else{
				startTime = "00:00:00";
			}
			m_criteria.andWagersdateGreaterThanOrEqualTo(format.parse(paramMap.get("betTimeBegin").toString()+" "+startTime));
	
			String endTime = "";
			if(paramMap.containsKey("endTime")){
				endTime = paramMap.get("endTime").toString();
			}else{
				endTime = "23:59:59";
			}
	        m_criteria.andWagersdateLessThanOrEqualTo(format.parse(paramMap.get("betTimeEnd").toString()+" "+endTime));
	
	        if(paramMap.containsKey("username") && StringUtils.isNotBlank(paramMap.get("username").toString())){
				m_criteria.andUsernameEqualTo(paramMap.get("username").toString());
			}
	        
	        if(paramMap.containsKey("liveId") && StringUtils.isNotBlank(paramMap.get("liveId").toString())){
				m_criteria.andLiveIdEqualTo(Integer.valueOf(paramMap.get("liveId").toString()));
			}
	        
	        if(paramMap.containsKey("jptype") && StringUtils.isNotBlank(paramMap.get("jptype").toString())){
				m_criteria.andJptypeidEqualTo(paramMap.get("jptype").toString());
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
			return m_example;
    
    	}catch(Exception ex){
			logger.error(ex.getMessage());
			throw ex;
		}
    }
}
