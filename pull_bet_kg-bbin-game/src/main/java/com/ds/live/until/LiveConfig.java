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
	//2:AG视讯厅  3:OG视讯厅 11:BBIN视讯厅 12:DS视讯厅
    
	public final static Integer AG_LIVE_ID = 2;
	public final static Integer OG_LIVE_ID = 3;
	public final static Integer BBIN_LIVE_ID = 11;
	public final static Integer DS_LIVE_ID = 12;
	
	/*********************************************/
	//bbin视讯编码
	public final static String BBIN_LIVE_WEBSITE = "kkw910";
	//bbin视讯注单拉取编码
	public final static String BBIN_BETRECORD_KEY = "Z9e9k82Y";
	//每页拉取数据数
	public final static Integer BBIN_PAGE_LIMIT = 500;
	//BBin视讯类型
	//体育
	public final static Integer BBIN_GAME_KIND_SPORT = 1;
	//视讯
	public final static Integer BBIN_GAME_KIND_LIVE = 3;
	//3d
	public final static Integer BBIN_GAME_KIND_3D = 15;
	//机率
	public final static Integer BBIN_GAME_KIND_JL = 5;
	//bbin用户名前缀长度
	
	//视讯输赢定义
	
	//bbin用户名前缀长度
	public final static int BBIN_NAME_PRE_LENGTH = 2;
	
	//视讯输赢定义
	public final static Byte LIVE_RESULT_TYPE_UNBET = 0;//未结算
	public final static Byte LIVE_RESULT_TYPE_LOSE = 1;//输
	public final static Byte LIVE_RESULT_TYPE_WIN = 2;//赢
	public final static Byte LIVE_RESULT_TYPE_HE = 3;//和
	public final static Byte LIVE_RESULT_TYPE_CANCEL = 4;//注单取消
}
