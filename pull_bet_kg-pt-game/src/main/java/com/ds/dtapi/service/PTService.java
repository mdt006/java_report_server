package com.ds.dtapi.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.dtapi.common.BaseCommon;
import com.ds.temp.entity.AuditTotalVO;
import com.ds.temp.mapper.TempAuditTotalMapper;
import com.kg.live.entity.ApiInfoEntity;
import com.kg.live.entity.ApiInfoEntityExample;
import com.kg.live.entity.DtPtGame;
import com.kg.live.entity.DtPtGameExample;
import com.kg.live.entity.DtPtPageRecord;
import com.kg.live.entity.DtPtPageRecordExample;
import com.kg.live.mapper.ApiInfoEntityMapper;
import com.kg.live.mapper.DtPtGameMapper;
import com.kg.live.mapper.DtPtPageRecordMapper;
@Service
public class PTService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ApiInfoEntityMapper  apiInfoMapper;
	@Autowired
	private DtPtGameMapper dtPtGameMapper;
	@Autowired
	private DtPtPageRecordMapper dtPtPageRecordMapper;
	@Autowired
	private TempAuditTotalMapper tempAuditTotalMapper;
	
	//批量插入或更新到数据库
	public void insertOrUpdate(List<DtPtGame> list,ApiInfoEntity apiInfo,boolean isUpdate)throws Exception{
		saveData(list,apiInfo,isUpdate);
	}
	/**
	 * @param list
	 * @param isUpdate false:无需更新，true：需要更新数据
	 * @return
	 */
	public Map<String,Integer> saveData(List<DtPtGame> list,ApiInfoEntity apiInfo,boolean isUpdate) throws Exception{
		Map<String,Integer> map=new HashMap<String,Integer>();//用于手动拉取获取拉取结果
		int insert_count=0;
		int update_count=0;
		List<DtPtGame> insert_list=new ArrayList<DtPtGame>();
		List<AuditTotalVO> audit_list=new ArrayList<AuditTotalVO>();
			long start=System.currentTimeMillis();
			for(DtPtGame entity : list){
				if(StringUtils.isBlank(entity.getInfo())){//不是登入或者登出，没有这个属性，不入库
					String gamename=entity.getGamename().substring(0, entity.getGamename().indexOf("(", 1)).trim();
					entity.setGamename(gamename);
					//把北京时间变为美东时间
					entity.setGamedate(new Date(entity.getGamedate().getTime()-1000*60*60*12));
					DtPtGame record=null;
					String username= StringUtils.substringAfter(entity.getPlayername(),"_");
					String flagId = BaseCommon.record_map.getIfPresent(entity.getGamecode());
					if(StringUtils.isBlank(flagId)){
						record=dtPtGameMapper.selectByGameCode(entity.getGamecode());
					}
				    if(null!=record || StringUtils.isNotBlank(flagId)){
						if(isUpdate){
							entity.setSiteId(apiInfo.getSiteId());
							entity.setUsername(username.toLowerCase());
							entity.setUpdateTime(new Date());
							setExt(entity);
							dtPtGameMapper.updateByGameCode(entity);
							update_count++;
						}
						BaseCommon.record_map.put(entity.getGamecode(), entity.getGamecode());
					}else{
						entity.setSiteId(apiInfo.getSiteId());
						entity.setUsername(username.toLowerCase());
						entity.setCreateTime(new Date());
						setExt(entity);
//						dtPtGameMapper.insert(entity);
//						saveTempAuditTotal(entity,0);
						insert_count++;
						insert_list.add(entity);
						AuditTotalVO vo=convertTempAuditTotal(entity);
						audit_list.add(vo);
					}
				}else{
					logger.info("login data :"+entity.getGamecode()+",info:"+entity.getInfo());
				}
				
			}
			if(insert_list.size()>0){
				dtPtGameMapper.insertByBatch(insert_list);
				tempAuditTotalMapper.batInsertOrupdate(audit_list,apiInfo.getSiteId());
			}
			for(DtPtGame o :insert_list){
				BaseCommon.record_map.put(o.getGamecode(), o.getGamecode());//加入缓存
			}
			long end=System.currentTimeMillis();
			logger.info("耗时{}ms",end-start);
			map.put("insert_count", insert_count);
			map.put("update_count", update_count);
			logger.info("site_id："+apiInfo.getSiteId()+"本次执行结果：插入数据 "+insert_count+" 条，更新{ "+update_count+" }条");
		
		return map;
	}
	
	/**
	 * 稽核数据处理
	 */
	private AuditTotalVO convertTempAuditTotal(DtPtGame pt){
		AuditTotalVO audit = new AuditTotalVO();
		audit.setBetTime(pt.getGamedate());
		audit.setUsername(pt.getUsername());
		audit.setLiveId(16);
		audit.setOrderNo(pt.getGamecode());
		audit.setPayAmount(pt.getWin());
		audit.setBetAmount(pt.getBet());
		audit.setValidAmount(pt.getBet());
		audit.setGameName(pt.getGamename());
		audit.setType(4);
		return audit;
		
		
	}
	
	/**
	 * 把输赢变为绝对输赢
	 * @param record
	 */
	private void setExt(DtPtGame entity) {
		entity.setWin(entity.getWin().subtract(entity.getBet()));
	}
	/**
	 * 获取api配置列表
	 * @return
	 */
	public List<ApiInfoEntity> getConfigApiInfo(){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andStateEqualTo((short) 50).andLiveIdEqualTo(16);
		return apiInfoMapper.selectByExample(e);
	}
	/**
	 * 获取拉取页记录信息
	 * @param agent
	 * @param rounddate
	 * @return
	 */
	public DtPtPageRecord getPageRecord(String agent,String rounddate){
		DtPtPageRecordExample e = new DtPtPageRecordExample();
		e.createCriteria().andAgentEqualTo(agent).andRounddateEqualTo(rounddate);
		List<DtPtPageRecord> list = dtPtPageRecordMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public ApiInfoEntity getApiInfoBySiteId(Integer siteId){
		ApiInfoEntityExample e = new ApiInfoEntityExample();
		e.createCriteria().andStateEqualTo((short) 50).andLiveIdEqualTo(16).andSiteIdEqualTo(siteId);
		List<ApiInfoEntity> list = apiInfoMapper.selectByExample(e);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	
	//查询某网站某时间段内的数量
	public long getCountBySiteAndTime(int site_id,String starttime,String endtime) throws Exception{
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DtPtGameExample example =new DtPtGameExample();
		com.kg.live.entity.DtPtGameExample.Criteria c=example.createCriteria();
		c.andSiteIdEqualTo(site_id);
		c.andGamedateGreaterThanOrEqualTo(sdf.parse(starttime));
		c.andGamedateLessThan(sdf.parse(endtime));
		
		return dtPtGameMapper.countByExample(example);
	}
	
	//查询某网站某时间段内数据
	public List<DtPtGame> getListBySiteAndTime(int site_id,String starttime,String endtime) throws Exception{
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DtPtGameExample example =new DtPtGameExample();
		com.kg.live.entity.DtPtGameExample.Criteria c=example.createCriteria();
		c.andSiteIdEqualTo(site_id);
		c.andGamedateGreaterThan(sdf.parse(starttime));
		c.andGamedateLessThan(sdf.parse(endtime));
		
		return dtPtGameMapper.selectByExample(example);
	}
	
	//手动拉取单独处理
	public Map<String,Integer> manualSaveData(Map<String,String> cache_map,List<DtPtGame> list,ApiInfoEntity apiInfo,boolean isUpdate) throws Exception{
		Map<String,Integer> map=new HashMap<String,Integer>();//用于手动拉取获取拉取结果
		int insert_count=0;
		int update_count=0;
		List<DtPtGame> insert_list=new ArrayList<DtPtGame>();
		List<AuditTotalVO> audit_list=new ArrayList<AuditTotalVO>();
			long start=System.currentTimeMillis();
			for(DtPtGame entity : list){
				if(StringUtils.isBlank(entity.getInfo())){//不是登入或者登出，没有这个属性，不入库
					String gamename=entity.getGamename().substring(0, entity.getGamename().indexOf("(", 1)).trim();
					entity.setGamename(gamename);
					//把北京时间变为美东时间
					entity.setGamedate(new Date(entity.getGamedate().getTime()-1000*60*60*12));
					String username= StringUtils.substringAfter(entity.getPlayername(),"_");
					String flagId = cache_map.get(entity.getGamecode());
				    if(StringUtils.isNotBlank(flagId)){
						if(isUpdate){
							entity.setSiteId(apiInfo.getSiteId());
							entity.setUsername(username.toLowerCase());
							entity.setUpdateTime(new Date());
							setExt(entity);
							dtPtGameMapper.updateByGameCode(entity);
							update_count++;
						}
						BaseCommon.record_map.put(entity.getGamecode(), entity.getGamecode());
					}else{
						entity.setSiteId(apiInfo.getSiteId());
						entity.setUsername(username.toLowerCase());
						entity.setCreateTime(new Date());
						setExt(entity);
//						dtPtGameMapper.insert(entity);
//						saveTempAuditTotal(entity,0);
						insert_count++;
						insert_list.add(entity);
						AuditTotalVO vo=convertTempAuditTotal(entity);
						audit_list.add(vo);
					}
				}else{
					logger.info("login data :"+entity.getGamecode()+",info:"+entity.getInfo());
				}
				
			}
			if(insert_list.size()>0){
				dtPtGameMapper.insertByBatch(insert_list);
				tempAuditTotalMapper.batInsertOrupdate(audit_list,apiInfo.getSiteId());
			}
			long end=System.currentTimeMillis();
			logger.info("耗时{}ms",end-start);
			map.put("insert_count", insert_count);
			map.put("update_count", update_count);
			logger.info("site_id："+apiInfo.getSiteId()+"本次执行结果：插入数据 "+insert_count+" 条，更新{ "+update_count+" }条");
		
		return map;
	}
}
