package com.kg.live.contants;

/**
 * 
 * 定义稽核的gamename,防止各个平台的游戏由于注单号重复和定义此字段
 * 1.比如bbin平台的注单号和ag的注单号重复，如果不定义此字段会覆盖
 * 2.再比如bbin电子和bbin捕鱼的注单号有可能重复，故同一平台也要细分
 *
 */
public enum AuditGameNameEnum {
	BBIN("bbin"),//当一条记录没法划分清楚的时候 
	BBIN_LIVE("bbin_live"), 
	BBIN_GAME("bbin_game"),
	BBIN_HUNTER("bbin_hunter"),
	BBIN_SPORT("bbin_sport"),
	DS_LIVE("ds_live"), 
	AG("ag"),//当一条记录没法划分清楚的时候
	AG_LIVE("ag_live"),
	AG_GAME("ag_game"),
	AG_HUNTER("ag_hunter"),
	AG_SPORT("ag_sport"),
	OG("og"),
	OG_LIVE("og_live"),
	MG("mg"),
	MG_GAME("mg_game"),
	PT("pt"),
	PT_GAME("pt_game"),
	P_MG("p_mg"),
	P_MG_GMAE("p_mg"),
	H8_SPORT("sport"),
	KG_GAME("kg_game"),
	KG_JINGDIAN("kg_jingdian"),
	KG_GUANFANG("kg_guanfang"),
	LMG_LIVE("lmg_live"),
	KY_CHESS("ky_chess");
    private String nCode;
    
    private AuditGameNameEnum(String nCode) {
        this.nCode = nCode;
    }
    @Override
    public String toString() {
    	return String.valueOf(nCode);
    }
}
