package com.ds.lottery.common;

import com.ds.lottery.until.PropsUtil;

public class BaseCommon {
	
	public static String KIND_NAME_GF;
	public static String KIND_NAME_DSPT;

	public static void initGameName(){
		KIND_NAME_GF=PropsUtil.getProperty("KIND_NAME_GF");
		KIND_NAME_DSPT=PropsUtil.getProperty("KIND_NAME_DSPT");
	}
}
