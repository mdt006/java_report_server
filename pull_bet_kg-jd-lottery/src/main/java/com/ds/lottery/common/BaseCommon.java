package com.ds.lottery.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ds.lottery.until.PropsUtil;
import com.ds.lottery.vo.GameTypeVo;
import com.kg.live.entity.LotteryInfoEntity;

public class BaseCommon {
	public static Map<Integer,LotteryInfoEntity> LOT_INFO_MAP = new ConcurrentHashMap<Integer, LotteryInfoEntity>();
	
	public static Map<String, GameTypeVo> OUTCODE_GAME_MAP =new ConcurrentHashMap<String, GameTypeVo>();
	
	public final static List<Integer> GAME_KIND_LIST = Arrays.asList(57,58,59);
	
	public static String KIND_NAME_SSC;
	public static String KIND_NAME_HK;
	public static String KIND_NAME_PC28;
	public static String KIND_NAME_DSPT;

	public static void initGameName(){
		KIND_NAME_SSC=PropsUtil.getProperty("KIND_NAME_SSC");
		KIND_NAME_HK=PropsUtil.getProperty("KIND_NAME_HK");
		KIND_NAME_PC28=PropsUtil.getProperty("KIND_NAME_PC28");
		KIND_NAME_DSPT=PropsUtil.getProperty("KIND_NAME_DSPT");
	}
}
