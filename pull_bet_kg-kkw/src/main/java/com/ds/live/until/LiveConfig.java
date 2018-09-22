package com.ds.live.until;

/**
 * 
*    
* 项目名称：kg-ds-live   
* 类名称：LiveConfig   
* 类描述：  视讯配置信息 
* 创建人：光光   
* 创建时间：2015年5月10日 下午8:34:33   
* 修改人：光光   
* 修改时间：2015年5月10日 下午8:34:33   
* 修改备注：   
* @version    
*
 */
public class LiveConfig {
	
	/**************************************/
	
	
	
	/**************************************/
	
	//状态定义 -50：删除  0： 未启用  50：正常  
	public final static Short DELETE_STATE = -50;
	public final static Short NOT_ENABLE_STATE = 0;//未启用
	public final static Short NORMAL_STATE = 50;
	
	
	/*******************************************/
	public final static Integer DS_KKW_LIVE_ID = 30;
	
	/*********************************************/
	//ds视讯厅 游戏类型定义
	public final static Integer DS_LIVE_GAME_TYPE_BACCARAT = 1;//百家乐
	public final static Integer DS_LIVE_GAME_TYPE_DRAGON_TIGER = 2;//龙虎
	public final static Integer DS_LIVE_GAME_TYPE_ROULETTE = 3;//轮盘
	public final static Integer DS_LIVE_GAME_TYPE_BACCARAT_INSURANCE = 4;//保险百家乐
	public final static Integer DS_LIVE_GAME_TYPE_SICBO = 5;//赛宝 
	public final static Integer DS_LIVE_GAME_TYPE_XOC_DIA = 6;//色碟
	
	/************************************************/
	//视讯输赢定义
	public final static Byte LIVE_RESULT_TYPE_LOSE = 1;//输
	public final static Byte LIVE_RESULT_TYPE_WIN = 2;//赢
	public final static Byte LIVE_RESULT_TYPE_HE = 3;//和
	public final static Byte LIVE_RESULT_TYPE_CANCEL = 4;//注单取消
	
	/** telegram消息通知相关  */
	public static final String BOT_A = "604355646:AAG1mCGGvj_nv6BbgHYrM0E0-3_SzpthPRg";
	public static final String GROUP_JAVA = "-286022000";
	
	/** 小飞机消息通知类型  */
	public final static String TELEGRAM_HTTP_ERROR = "pull_bet_kg-kkw_httpError";
	public final static String TELEGRAM_RESULT_ERROR = "pull_bet_kg-kkw_dataError";
	public final static String TELEGRAM_DATA_ERROR = "pull_bet_kg-kkw_dataError";
}
