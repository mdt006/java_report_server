package com.ds.sgs.util;

/**
 * SGS配置
 * @author worf 
 * @date 2018年6月6日 下午1:48:47
 */
public class SgsConfig {

	
	/**************************************/

	/** 状态定义 -50：删除 0： 未启用 50：正常  */
	public final static Short DELETE_STATE = -50;
	public final static Short NOT_ENABLE_STATE = 0;
	public final static Short NORMAL_STATE = 50;

	/** 2:AG视讯厅 3:OG视讯厅 11:BBIN视讯厅 12:DS视讯厅 13:M8体育 90:棋牌 19:申博太阳城  */
	public final static Integer SGS_LIVE_ID = 19;
	
	/** 游戏类型定义 95：视讯  96：电子  */
	public final static Byte SGS_GAME_KIND_LIVE = 95;
	public final static Byte SGS_GAME_KIND_GAME = 96;

	/*********************************************/
	/** 输赢定义  */
	public final static Byte SGS_RESULT_TYPE_LOSE = 1;//输
	public final static Byte SGS_RESULT_TYPE_WIN = 2;//赢
	public final static Byte SGS_RESULT_TYPE_HE = 3;//和
	public final static Byte SGS_RESULT_TYPE_CANCEL = 4;//注单取消
	
	/** 截取前缀长度  */
	public final static int SGS_NAME_PRE_LENGTH = 2;
	
	/** 小飞机消息通知类型  */
	public final static String TELEGRAM_HTTP_ERROR = "pull_bet_kg-sgs_httpError";
	public final static String TELEGRAM_DATA_ERROR = "pull_bet_kg-sgs_dataError";

}
