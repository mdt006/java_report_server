package com.ds.chess.util;

/**
 * 棋牌配置
 * 
 * @author worf
 * @date 2018年4月26日 下午1:07:34
 */
public class ChessConfig {

	/**************************************/
	public static String kyChessDeskey;
	public static String kyChessMd5key;
	
	/**************************************/

	// 状态定义 -50：删除 0： 未启用 50：正常
	public final static Short DELETE_STATE = -50;
	public final static Short NOT_ENABLE_STATE = 0;// 未启用
	public final static Short NORMAL_STATE = 50;

	/*******************************************/
	// 2:AG视讯厅 3:OG视讯厅 11:BBIN视讯厅 12:DS视讯厅 13:M8体育 90:棋牌

	public final static Integer AG_LIVE_ID = 2;
	public final static Integer OG_LIVE_ID = 3;
	public final static Integer BBIN_LIVE_ID = 11;
	public final static Integer DS_LIVE_ID = 12;
	public final static Integer M8_LIVE_ID = 13;
	public final static Integer CHESS_LIVE_ID = 90;

	/*********************************************/
	//开元棋牌输赢定义
	public final static Byte CHESS_RESULT_TYPE_LOSE = 1;//输
	public final static Byte CHESS_RESULT_TYPE_WIN = 2;//赢
	public final static Byte CHESS_RESULT_TYPE_HE = 3;//和
	public final static Byte CHESS_RESULT_TYPE_CANCEL = 4;//注单取消
	
	public final static int CHESS_NAME_PRE_LENGTH = 2;

	public String getKyChessDeskey() {
		return kyChessDeskey;
	}

	public void setKyChessDeskey(String kyChessDeskey) {
		ChessConfig.kyChessDeskey = kyChessDeskey;
	}

	public String getKyChessMd5key() {
		return kyChessMd5key;
	}

	public void setKyChessMd5key(String kyChessMd5key) {
		ChessConfig.kyChessMd5key = kyChessMd5key;
	}
	
}
