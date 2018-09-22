package com.ds.report.common;

import com.ds.msg.TelegramMessage;

public class BaseCommon {
	
	public static final String BOT_A = "604355646:AAG1mCGGvj_nv6BbgHYrM0E0-3_SzpthPRg";
	public static final String GROUP_JAVA = "-286022000";
	
	/**
	 * 小飞机通知
	 * @param message
	 */
	public static void sendTelegramMessage(String message){
		TelegramMessage t = TelegramMessage.getInstance();
		t.sendMessage(BaseCommon.BOT_A, BaseCommon.GROUP_JAVA, "total_report_delay_task", 
				"统计异常："+message);
	}
	
	
}