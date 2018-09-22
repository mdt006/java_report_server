package com.ds.live.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ds.msg.TelegramMessage;
import com.kg.live.entity.TotalReportConfigWithBLOBs;

public class BaseCommon {
	public static Map<String,TotalReportConfigWithBLOBs> CONFIG_MAP=new ConcurrentHashMap<String,TotalReportConfigWithBLOBs>();
	
	public final static List<Integer> CONFIG_STATE_LIST=Arrays.asList(50,60,100);
	
	public final static Long LOAD_CACHE_CONFIG_TIME=5*60*1000L;//配置刷新比对时间
	
	public final static Long ONE_SLEEP_TIME=3*60*1000L;//统计一次间隔时间
	
	public static final String BOT_A = "604355646:AAG1mCGGvj_nv6BbgHYrM0E0-3_SzpthPRg";
	public static final String GROUP_JAVA = "-286022000";
	
	public static void sendTelegramMessage(String message){
		TelegramMessage t = TelegramMessage.getInstance();
		t.sendMessage(BaseCommon.BOT_A, BaseCommon.GROUP_JAVA, "total_report_delay_task", 
				"统计异常："+message);
	}
	
	
}