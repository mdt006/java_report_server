package com.ds.live.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ds.live.until.BBINCommon;
import com.ds.live.until.EncryptUtils;
import com.ds.live.until.PlatformUtil;

public class BaseCommon {
	public final static int PAGE_LIMIT=500;
	public final static List<String> TIME_LIST=Arrays.asList(
			"00:00:00_00:59:59",
			"01:00:00_01:59:59",
			"02:00:00_02:59:59",
			"03:00:00_03:59:59",
			"04:00:00_04:59:59",
			"05:00:00_05:59:59",
			"06:00:00_06:59:59",
			"07:00:00_07:59:59",
			"08:00:00_08:59:59",
			"09:00:00_09:59:59",
			"10:00:00_10:59:59",
			"11:00:00_11:59:59",
			"12:00:00_12:59:59",
			"13:00:00_13:59:59",
			"14:00:00_14:59:59",
			"15:00:00_15:59:59",
			"16:00:00_16:59:59",
			"17:00:00_17:59:59",
			"18:00:00_18:59:59",
			"19:00:00_19:59:59",
			"20:00:00_20:59:59",
			"21:00:00_21:59:59",
			"22:00:00_22:59:59",
			"23:00:00_23:59:59"
			);
	
	
	public static String getSendParam(String uppername,String date,String start_time,String end_time,
			int gamekind,int subgamekind, int page,int pageLimit,String key_b) {
		/*String key = getKey(key_b);
		StringBuffer sb = new StringBuffer();
		sb.append("website=").append(Platform.Constans.kkw_WEBSITE);
		sb.append("&uppername=").append(uppername);
		sb.append("&rounddate=").append(date);
		sb.append("&starttime=").append(start_time);
		sb.append("&endtime=").append(end_time);
		sb.append("&gamekind=").append(gamekind);
		sb.append("&subgamekind=").append(subgamekind);
		sb.append("&page=").append(page);
		sb.append("&pagelimit=").append(pageLimit);
		sb.append("&key=").append(key);
		return sb.toString();*/
		Map<String,String> paramMap = new TreeMap<String,String>(){{
			put("uppername",uppername);
			put("rounddate",date);
			put("starttime",start_time);
			put("endtime",end_time);
			put("gamekind",String.valueOf(gamekind));
			put("page",String.valueOf(page));
			put("pagelimit", String.valueOf(pageLimit));
		}};

		String param =  BBINCommon.mapToString(paramMap);
		String key = EncryptUtils.encrypt(param, BBINCommon.USERKEY);
		param+="&key="+key;
		return param;
	}
	
	public static String getKey(String key_b) {
		String key = PlatformUtil.randomString(7)+
				PlatformUtil.toMD5(Platform.Constans.kkw_WEBSITE+key_b+PlatformUtil.getTime())+
				PlatformUtil.randomString(2);
		return key;
	}
	
	public static String getCountSql(int siteId,String start_time,String end_time,int gameType){
		String sql="select count(1) from ds_bbin_jilv a where "
				+ "a.wagers_date >= '"+start_time+"' AND a.wagers_date <= '"+end_time+"'"
				+ " and a.site_id="+siteId;
		if(gameType==1){
			sql+=" and a.game_type not in(5901,5902,5908)";
		}else{
			sql+=" and a.game_type="+gameType;
		}
//		System.out.println(sql);
		return sql;
	}

	public static String mapToString(Map<String, String> params) {
		if(null == params || params.isEmpty()){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		params.forEach((k,v)-> sb.append(k+"="+v+"&"));
		if(sb.length() > 0){
			return sb.substring(0,sb.length()-1);
		}
		return null;
	}
}
