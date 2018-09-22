package com.ds.report.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ds.report.dao.mapper.DsReportMapper;
import com.ds.report.vo.GameWaterVo;

@Service
public class ReporWaterService {
	@Autowired
	private DsReportMapper dsReportMapper;
	public Map<String,Object> getWaterInfo(Integer siteId,String starttime,String endtime,String waterJson){
		Map<String,Object> all_map= new HashMap<String, Object>();
		List<GameWaterVo> list=new ArrayList<GameWaterVo>();//包含的分类
		Map<String,String> map=new HashMap<String,String>();//不包含的分类
		JSONArray array=JSONArray.parseArray(waterJson);
		for(int i=0;i<array.size();i++){
			JSONObject json=array.getJSONObject(i);
			List<GameWaterVo> voList=convertGameWaterVo(map,json);
			list.addAll(voList);
		}
		Map<String,GameWaterVo> water_map=new HashMap<String, GameWaterVo>();//用户返水信息
		Map<String,JSONArray> jsonMap=new HashMap<String, JSONArray>();
		for(GameWaterVo waterVo : list){
			int gamekind=waterVo.getGamekind();
			String water=waterVo.getWater();
			String select_sql=this.game_water_sql(siteId, gamekind, starttime, endtime, waterVo.getGametypes(), " in ");
			List<Map<String,Object>> list_map=dsReportMapper.getGameWaterDataBySql(select_sql);
			
			if(null==list_map || list_map.size()<1){
				continue;
			}
			
			String username="";
			for(Map<String,Object> m : list_map){
				GameWaterVo vo=new GameWaterVo();
				BigDecimal validamount=null;
				BigDecimal water_money=null;
				validamount=new BigDecimal(m.get("validamount").toString());
				username=m.get("username").toString();
				water_money=validamount.multiply(new BigDecimal(water)).divide(new BigDecimal(100));
			
				
				
				JSONObject jsonObj=new JSONObject();//用户打码量
				if(jsonMap.containsKey(gamekind+"_"+username)){
					JSONArray jsonArr=jsonMap.get(gamekind+"_"+username);
					jsonObj.put(m.get("game_type").toString(), validamount);
					jsonArr.add(jsonObj);
					jsonMap.put(gamekind+"_"+username, jsonArr);
				}else{
					JSONArray jsonArr=new JSONArray();
					jsonObj.put(m.get("game_type").toString(), validamount);
					jsonArr.add(jsonObj);
					jsonMap.put(gamekind+"_"+username, jsonArr);

				}
				
				//总返水计算
				if(water_map.containsKey(gamekind+"_"+username)){//相同的gamekind金额相加
					vo=water_map.get(gamekind+"_"+username);
					validamount=validamount.add(vo.getValidamount());
					water_money=water_money.add(vo.getWater_money());
				}
				vo.setValidamount(validamount);
				vo.setWater_money(water_money);
				water_map.put(gamekind+"_"+username, vo);
			}
			
			
		}
		all_map.put("water_map", water_map);
		all_map.put("jsonMap", jsonMap);

		return all_map;
	}
	
	
	public List<GameWaterVo> convertGameWaterVo(Map<String,String> map,JSONObject json){
		List<GameWaterVo> list = new ArrayList<GameWaterVo>();
		
		String pt_gametypes=map.get("16");//16
		String ag_gametypes=map.get("22");//22
		String bbin_gametypes=map.get("5");//5
		String pmg_gametypes=map.get("65");//65
		String mg_gametypes=map.get("60");//60
		
		
		JSONObject gameJson=JSONObject.parseObject(json.getString("gamelist"));
		String water=json.getString("gamewater");
		
		if(gameJson.containsKey("16")){
			GameWaterVo vo=new GameWaterVo();
			vo.setWater(water);
			vo.setGamekind(16);
			vo.setGametypes(gameJson.getString("16"));
			list.add(vo);
			pt_gametypes=this.appendGameTypes(pt_gametypes, gameJson.getString("16"));
			map.put("16", pt_gametypes);
		}
		if(gameJson.containsKey("22")){
			GameWaterVo vo=new GameWaterVo();
			vo.setWater(water);
			vo.setGamekind(22);
			vo.setGametypes(gameJson.getString("22"));
			list.add(vo);
			this.appendGameTypes(ag_gametypes, gameJson.getString("22"));
			map.put("22", ag_gametypes);

		}
		if(gameJson.containsKey("5")){
			GameWaterVo vo=new GameWaterVo();
			vo.setWater(water);
			vo.setGamekind(5);
			vo.setGametypes(gameJson.getString("5"));
			list.add(vo);
			this.appendGameTypes(bbin_gametypes, gameJson.getString("5"));
			map.put("5", bbin_gametypes);

		}
		if(gameJson.containsKey("65")){
			GameWaterVo vo=new GameWaterVo();
			vo.setWater(water);
			vo.setGamekind(65);
			vo.setGametypes(gameJson.getString("65"));
			list.add(vo);
			this.appendGameTypes(pmg_gametypes, gameJson.getString("65"));
			map.put("65", pmg_gametypes);

		}
		if(gameJson.containsKey("60")){
			GameWaterVo vo=new GameWaterVo();
			vo.setWater(water);
			vo.setGamekind(60);
			vo.setGametypes(gameJson.getString("60"));
			list.add(vo);
			this.appendGameTypes(mg_gametypes, gameJson.getString("60"));
			map.put("60", mg_gametypes);

		}
		return list;
	}
	public String game_water_sql(Integer siteId,Integer gameKind ,String starttime,String endtime,String gametypes,String is_not_in){
		StringBuffer sql=new StringBuffer("select a.username as username,a.game_kind as game_kind,a.game_type as game_type,sum(a.validamount) as validamount from ds_report a ");
		sql.append(" where 1=1 ");
		sql.append(" and a.site_id="+siteId);
		sql.append(" and a.bet_time>= '"+starttime+"'");
		sql.append(" and a.bet_time<= '"+endtime+"'");
		sql.append(" and a.game_kind="+gameKind);
		if(StringUtils.isNotBlank(is_not_in)){
			sql.append(" and a.game_type "+is_not_in).append("("+gametypes+")");
		}
		sql.append(" group by a.username,a.game_type");
		
		return sql.toString();
	}
	public String appendGameTypes(String base,String gametypes){
		String val="";
		if(StringUtils.isBlank(gametypes)){
			return base;
		}
		if("".equals(base)){
			val=gametypes;
		}else{
			val=base+","+gametypes;
		}
		return val;
	}
}

