package com.ds.report.entity;

import java.math.BigDecimal;

public class DsWaterTotalNew {
	private String world;
	private String corprator;
	private String superior;
	private String agents;// 代理
	private String username;// 用户名
	private BigDecimal totalValidamount;// 总投注额
	private BigDecimal totalWater;// 总返水
	private BigDecimal returnWater;// 实际返水金额

	private BigDecimal sportValidamount;// 球类有效投注额
	private BigDecimal sportWater;// 球类返水
	private BigDecimal liveValidamount;// 视讯有效投注金额
	private BigDecimal liveWater;// 视讯返水
	private BigDecimal hongkongValidamount;// 香港彩有效投注额
	private BigDecimal hongkongWater;// 香港彩返水
	private BigDecimal lottoValidamount;// 彩票有效投注额
	private BigDecimal lottoWater;// 彩票返水
	private BigDecimal gameValidamount;// 机率有效投注金额
	private BigDecimal gameWater;// 机率返水
	private BigDecimal chessValidamount;//棋牌有效投注金额
	private BigDecimal chessWater;//棋牌返水


	private BigDecimal liveBbValidamount;// BBIN视讯有效投注金额
	private BigDecimal liveBbWater;// 视讯返水
	private BigDecimal liveDsValidamount;// DS视讯有效投注金额
	private BigDecimal liveDsWater;// 视讯返水
	private BigDecimal liveLmgValidamount;// Lmg视讯有效投注金额
	private BigDecimal liveLmgWater;// 视讯返水
	private BigDecimal liveAGValidamount;// AG视讯有效投注金额
	private BigDecimal liveAGWater;// 视讯返水
	private BigDecimal liveOGValidamount;// AG视讯有效投注金额
	private BigDecimal liveOGWater;// 视讯返水

	private BigDecimal bbSportValidamount;// BBIN体育有效投注额
	private BigDecimal bbSportWater;// BBIN体育返水
	private BigDecimal h8Validamount;// h8有效投注金额
	private BigDecimal h8Water;// h8返水
	private BigDecimal agSportValidamount;// BBIN体育有效投注额
	private BigDecimal agSportWater;// BBIN体育返水

	private BigDecimal xiaoyuLottoValidamount;// xiaoyuLotto有效投注额
	private BigDecimal xiaoyuLottoWater;// xiaoyuLotto返水
	private BigDecimal xingyunLottoValidamount;// xingyunLotto有效投注额
	private BigDecimal xingyunLottoWater;// xingyunLotto返水
	private BigDecimal fenfenLottoValidamount;// fenfenLotto有效投注金额
	private BigDecimal fenfenLottoWater;// fenfenLotto返水
	private BigDecimal chuantongLottoValidamount;// ds传统彩
	private BigDecimal chuantongLottoWater;

	private BigDecimal xiaoyuHongkongValidamount;// xiaoyuHongkong有效投注额
	private BigDecimal xiaoyuHongkongWater;// xiaoyuHongkong返水
	private BigDecimal dsHongkongValidamount;// dsHongkong有效投注金额
	private BigDecimal dsHongkongWater;// dsHongkong返水

	private BigDecimal dsGameValidamount;
	private BigDecimal dsGameWater;
	private BigDecimal bbGameValidamount;
	private BigDecimal bbGameWater;
	private String bbGame_type_list;
	private BigDecimal agGameValidamount;
	private BigDecimal agGameWater;
	private String agGame_type_list;
	private BigDecimal mgGameValidamount;
	private BigDecimal mgGameWater;
	private String mgGame_type_list;
	private BigDecimal ptGameValidamount;
	private BigDecimal ptGameWater;
	private String ptGame_type_list;
	private BigDecimal pmgGameValidamount;
	private BigDecimal pmgGameWater;
	private String pmgGame_type_list;

	private BigDecimal totalCalcValidamount;
	private BigDecimal totalUncalcValidamount;

	private BigDecimal liveBbCalcValidamount;
	private BigDecimal liveBbUncalcValidamount;
	private BigDecimal liveDsCalcValidamount;
	private BigDecimal liveDsUncalcValidamount;
	private BigDecimal liveLmgCalcValidamount;
	private BigDecimal liveLmgUncalcValidamount;
	private BigDecimal liveAgCalcValidamount;
	private BigDecimal liveAgUncalcValidamount;
	private BigDecimal liveOgCalcValidamount;
	private BigDecimal liveOgUncalcValidamount;

	private BigDecimal h8CalcValidamount;
	private BigDecimal h8UncalcValidamount;
	private BigDecimal bbSportCalcValidamount;
	private BigDecimal bbSportUncalcValidamount;
	private BigDecimal agSportCalcValidamount;
	private BigDecimal agSportUncalcValidamount;

	private BigDecimal dsGameCalcValidamount;
	private BigDecimal dsgameUncalcValidamount;
	private BigDecimal bbGameCalcValidamount;
	private BigDecimal bbgameUncalcValidamount;
	private BigDecimal agGameCalcValidamount;
	private BigDecimal aggameUncalcValidamount;
	private BigDecimal mgGameCalcValidamount;
	private BigDecimal mggameUncalcValidamount;
	private BigDecimal ptGameCalcValidamount;
	private BigDecimal ptgameUncalcValidamount;
	private BigDecimal pmgGameCalcValidamount;
	private BigDecimal pmggameUncalcValidamount;
	
	private BigDecimal xiaoyuLottoCalcValidamount;
	private BigDecimal xiaoyuLottoUncalcValidamount;
	private BigDecimal xingyunLottoCalcValidamount;
	private BigDecimal xingyunLottoUncalcValidamount;
	private BigDecimal fenfenLottoCalcValidamount;
	private BigDecimal fenfenLottoUncalcValidamount;
	private BigDecimal chuantongLottoCalcValidamount;
	private BigDecimal chuantongLottoUncalcValidamount;
	
	
	private BigDecimal xiaoyuHongkongCalcValidamount;
	private BigDecimal xiaoyuHongkongUncalcValidamount;
	private BigDecimal dsHongkongCalcValidamount;
	private BigDecimal dsHongkongUncalcValidamount;
	
	private BigDecimal kyChessValidamount;// kyChess有效投注金额
	private BigDecimal kyChessWater;// kyChess返水
	private BigDecimal kyChessCalcValidamount;
	private BigDecimal kyChessUncalcValidamount;
	
	//SGS视讯返水
	private BigDecimal liveSgsValidamount;
	private BigDecimal liveSgsCalcValidamount;
	private BigDecimal liveSgsUncalcValidamount;
	private BigDecimal liveSgsWater;
	
	//SGS电子返水
	private BigDecimal sgsGameValidamount;
	private BigDecimal sgsGameCalcValidamount;
	private BigDecimal sgsGameUncalcValidamount;
	private BigDecimal sgsGameWater;
	private String SgsGame_type_list;
	
	//kkw视讯
	private BigDecimal liveKKWValidamount;// KKW视讯有效投注金额
	private BigDecimal liveKKWWater;// 视讯返水
	private BigDecimal liveKKWCalcValidamount;
	private BigDecimal liveKKWUncalcValidamount;
	
	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
	}

	public String getCorprator() {
		return corprator;
	}

	public void setCorprator(String corprator) {
		this.corprator = corprator;
	}

	public String getSuperior() {
		return superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public String getAgents() {
		return agents;
	}

	public void setAgents(String agents) {
		this.agents = agents;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getTotalValidamount() {
		return totalValidamount;
	}

	public void setTotalValidamount(BigDecimal totalValidamount) {
		this.totalValidamount = totalValidamount;
	}

	public BigDecimal getTotalWater() {
		return totalWater;
	}

	public void setTotalWater(BigDecimal totalWater) {
		this.totalWater = totalWater;
	}

	public BigDecimal getReturnWater() {
		return returnWater;
	}

	public void setReturnWater(BigDecimal returnWater) {
		this.returnWater = returnWater;
	}

	public BigDecimal getLiveValidamount() {
		return liveValidamount;
	}

	public void setLiveValidamount(BigDecimal liveValidamount) {
		this.liveValidamount = liveValidamount;
	}

	public BigDecimal getLiveWater() {
		return liveWater;
	}

	public void setLiveWater(BigDecimal liveWater) {
		this.liveWater = liveWater;
	}

	public BigDecimal getLiveBbValidamount() {
		return liveBbValidamount;
	}

	public void setLiveBbValidamount(BigDecimal liveBbValidamount) {
		this.liveBbValidamount = liveBbValidamount;
	}

	public BigDecimal getLiveBbWater() {
		return liveBbWater;
	}

	public void setLiveBbWater(BigDecimal liveBbWater) {
		this.liveBbWater = liveBbWater;
	}

	public BigDecimal getLiveDsValidamount() {
		return liveDsValidamount;
	}

	public void setLiveDsValidamount(BigDecimal liveDsValidamount) {
		this.liveDsValidamount = liveDsValidamount;
	}

	public BigDecimal getLiveDsWater() {
		return liveDsWater;
	}

	public void setLiveDsWater(BigDecimal liveDsWater) {
		this.liveDsWater = liveDsWater;
	}

	public BigDecimal getGameValidamount() {
		return gameValidamount;
	}

	public void setGameValidamount(BigDecimal gameValidamount) {
		this.gameValidamount = gameValidamount;
	}

	public BigDecimal getGameWater() {
		return gameWater;
	}

	public void setGameWater(BigDecimal gameWater) {
		this.gameWater = gameWater;
	}

	public BigDecimal getLottoValidamount() {
		return lottoValidamount;
	}

	public void setLottoValidamount(BigDecimal lottoValidamount) {
		this.lottoValidamount = lottoValidamount;
	}

	public BigDecimal getLottoWater() {
		return lottoWater;
	}

	public void setLottoWater(BigDecimal lottoWater) {
		this.lottoWater = lottoWater;
	}

	public BigDecimal getHongkongValidamount() {
		return hongkongValidamount;
	}

	public void setHongkongValidamount(BigDecimal hongkongValidamount) {
		this.hongkongValidamount = hongkongValidamount;
	}

	public BigDecimal getHongkongWater() {
		return hongkongWater;
	}

	public void setHongkongWater(BigDecimal hongkongWater) {
		this.hongkongWater = hongkongWater;
	}

	public BigDecimal getBbSportValidamount() {
		return bbSportValidamount;
	}

	public void setBbSportValidamount(BigDecimal bbSportValidamount) {
		this.bbSportValidamount = bbSportValidamount;
	}

	public BigDecimal getBbSportWater() {
		return bbSportWater;
	}

	public void setBbSportWater(BigDecimal bbSportWater) {
		this.bbSportWater = bbSportWater;
	}

	public BigDecimal getSportValidamount() {
		return sportValidamount;
	}

	public void setSportValidamount(BigDecimal sportValidamount) {
		this.sportValidamount = sportValidamount;
	}

	public BigDecimal getSportWater() {
		return sportWater;
	}

	public void setSportWater(BigDecimal sportWater) {
		this.sportWater = sportWater;
	}

	public BigDecimal getLiveAGValidamount() {
		return liveAGValidamount;
	}

	public void setLiveAGValidamount(BigDecimal liveAGValidamount) {
		this.liveAGValidamount = liveAGValidamount;
	}

	public BigDecimal getLiveAGWater() {
		return liveAGWater;
	}

	public void setLiveAGWater(BigDecimal liveAGWater) {
		this.liveAGWater = liveAGWater;
	}

	public BigDecimal getH8Validamount() {
		return h8Validamount;
	}

	public void setH8Validamount(BigDecimal h8Validamount) {
		this.h8Validamount = h8Validamount;
	}

	public BigDecimal getH8Water() {
		return h8Water;
	}

	public void setH8Water(BigDecimal h8Water) {
		this.h8Water = h8Water;
	}

	public BigDecimal getXiaoyuLottoValidamount() {
		return xiaoyuLottoValidamount;
	}

	public void setXiaoyuLottoValidamount(BigDecimal xiaoyuLottoValidamount) {
		this.xiaoyuLottoValidamount = xiaoyuLottoValidamount;
	}

	public BigDecimal getXiaoyuLottoWater() {
		return xiaoyuLottoWater;
	}

	public void setXiaoyuLottoWater(BigDecimal xiaoyuLottoWater) {
		this.xiaoyuLottoWater = xiaoyuLottoWater;
	}

	public BigDecimal getFenfenLottoValidamount() {
		return fenfenLottoValidamount;
	}

	public void setFenfenLottoValidamount(BigDecimal fenfenLottoValidamount) {
		this.fenfenLottoValidamount = fenfenLottoValidamount;
	}

	public BigDecimal getFenfenLottoWater() {
		return fenfenLottoWater;
	}

	public void setFenfenLottoWater(BigDecimal fenfenLottoWater) {
		this.fenfenLottoWater = fenfenLottoWater;
	}

	public BigDecimal getXiaoyuHongkongValidamount() {
		return xiaoyuHongkongValidamount;
	}

	public void setXiaoyuHongkongValidamount(BigDecimal xiaoyuHongkongValidamount) {
		this.xiaoyuHongkongValidamount = xiaoyuHongkongValidamount;
	}

	public BigDecimal getXiaoyuHongkongWater() {
		return xiaoyuHongkongWater;
	}

	public void setXiaoyuHongkongWater(BigDecimal xiaoyuHongkongWater) {
		this.xiaoyuHongkongWater = xiaoyuHongkongWater;
	}

	public BigDecimal getDsHongkongValidamount() {
		return dsHongkongValidamount;
	}

	public void setDsHongkongValidamount(BigDecimal dsHongkongValidamount) {
		this.dsHongkongValidamount = dsHongkongValidamount;
	}

	public BigDecimal getDsHongkongWater() {
		return dsHongkongWater;
	}

	public void setDsHongkongWater(BigDecimal dsHongkongWater) {
		this.dsHongkongWater = dsHongkongWater;
	}

	public BigDecimal getDsGameValidamount() {
		return dsGameValidamount;
	}

	public void setDsGameValidamount(BigDecimal dsGameValidamount) {
		this.dsGameValidamount = dsGameValidamount;
	}

	public BigDecimal getDsGameWater() {
		return dsGameWater;
	}

	public void setDsGameWater(BigDecimal dsGameWater) {
		this.dsGameWater = dsGameWater;
	}

	public BigDecimal getBbGameValidamount() {
		return bbGameValidamount;
	}

	public void setBbGameValidamount(BigDecimal bbGameValidamount) {
		this.bbGameValidamount = bbGameValidamount;
	}

	public BigDecimal getBbGameWater() {
		return bbGameWater;
	}

	public void setBbGameWater(BigDecimal bbGameWater) {
		this.bbGameWater = bbGameWater;
	}

	public BigDecimal getAgGameValidamount() {
		return agGameValidamount;
	}

	public void setAgGameValidamount(BigDecimal agGameValidamount) {
		this.agGameValidamount = agGameValidamount;
	}

	public BigDecimal getAgGameWater() {
		return agGameWater;
	}

	public void setAgGameWater(BigDecimal agGameWater) {
		this.agGameWater = agGameWater;
	}

	public BigDecimal getTotalCalcValidamount() {
		return totalCalcValidamount;
	}

	public void setTotalCalcValidamount(BigDecimal totalCalcValidamount) {
		this.totalCalcValidamount = totalCalcValidamount;
	}

	public BigDecimal getTotalUncalcValidamount() {
		return totalUncalcValidamount;
	}

	public void setTotalUncalcValidamount(BigDecimal totalUncalcValidamount) {
		this.totalUncalcValidamount = totalUncalcValidamount;
	}

	public BigDecimal getLiveBbCalcValidamount() {
		return liveBbCalcValidamount;
	}

	public void setLiveBbCalcValidamount(BigDecimal liveBbCalcValidamount) {
		this.liveBbCalcValidamount = liveBbCalcValidamount;
	}

	public BigDecimal getLiveBbUncalcValidamount() {
		return liveBbUncalcValidamount;
	}

	public void setLiveBbUncalcValidamount(BigDecimal liveBbUncalcValidamount) {
		this.liveBbUncalcValidamount = liveBbUncalcValidamount;
	}

	public BigDecimal getLiveDsCalcValidamount() {
		return liveDsCalcValidamount;
	}

	public void setLiveDsCalcValidamount(BigDecimal liveDsCalcValidamount) {
		this.liveDsCalcValidamount = liveDsCalcValidamount;
	}

	public BigDecimal getLiveDsUncalcValidamount() {
		return liveDsUncalcValidamount;
	}

	public void setLiveDsUncalcValidamount(BigDecimal liveDsUncalcValidamount) {
		this.liveDsUncalcValidamount = liveDsUncalcValidamount;
	}

	public BigDecimal getBbSportCalcValidamount() {
		return bbSportCalcValidamount;
	}

	public void setBbSportCalcValidamount(BigDecimal bbSportCalcValidamount) {
		this.bbSportCalcValidamount = bbSportCalcValidamount;
	}

	public BigDecimal getBbSportUncalcValidamount() {
		return bbSportUncalcValidamount;
	}

	public void setBbSportUncalcValidamount(BigDecimal bbSportUncalcValidamount) {
		this.bbSportUncalcValidamount = bbSportUncalcValidamount;
	}

	public BigDecimal getLiveAgCalcValidamount() {
		return liveAgCalcValidamount;
	}

	public void setLiveAgCalcValidamount(BigDecimal liveAgCalcValidamount) {
		this.liveAgCalcValidamount = liveAgCalcValidamount;
	}

	public BigDecimal getLiveAgUncalcValidamount() {
		return liveAgUncalcValidamount;
	}

	public void setLiveAgUncalcValidamount(BigDecimal liveAgUncalcValidamount) {
		this.liveAgUncalcValidamount = liveAgUncalcValidamount;
	}

	public BigDecimal getH8CalcValidamount() {
		return h8CalcValidamount;
	}

	public void setH8CalcValidamount(BigDecimal h8CalcValidamount) {
		this.h8CalcValidamount = h8CalcValidamount;
	}

	public BigDecimal getH8UncalcValidamount() {
		return h8UncalcValidamount;
	}

	public void setH8UncalcValidamount(BigDecimal h8UncalcValidamount) {
		this.h8UncalcValidamount = h8UncalcValidamount;
	}

	public BigDecimal getDsGameCalcValidamount() {
		return dsGameCalcValidamount;
	}

	public void setDsGameCalcValidamount(BigDecimal dsGameCalcValidamount) {
		this.dsGameCalcValidamount = dsGameCalcValidamount;
	}

	public BigDecimal getDsgameUncalcValidamount() {
		return dsgameUncalcValidamount;
	}

	public void setDsgameUncalcValidamount(BigDecimal dsgameUncalcValidamount) {
		this.dsgameUncalcValidamount = dsgameUncalcValidamount;
	}

	public BigDecimal getBbGameCalcValidamount() {
		return bbGameCalcValidamount;
	}

	public void setBbGameCalcValidamount(BigDecimal bbGameCalcValidamount) {
		this.bbGameCalcValidamount = bbGameCalcValidamount;
	}

	public BigDecimal getBbgameUncalcValidamount() {
		return bbgameUncalcValidamount;
	}

	public void setBbgameUncalcValidamount(BigDecimal bbgameUncalcValidamount) {
		this.bbgameUncalcValidamount = bbgameUncalcValidamount;
	}

	public BigDecimal getAgGameCalcValidamount() {
		return agGameCalcValidamount;
	}

	public void setAgGameCalcValidamount(BigDecimal agGameCalcValidamount) {
		this.agGameCalcValidamount = agGameCalcValidamount;
	}

	public BigDecimal getAggameUncalcValidamount() {
		return aggameUncalcValidamount;
	}

	public void setAggameUncalcValidamount(BigDecimal aggameUncalcValidamount) {
		this.aggameUncalcValidamount = aggameUncalcValidamount;
	}

	public BigDecimal getXiaoyuLottoCalcValidamount() {
		return xiaoyuLottoCalcValidamount;
	}

	public void setXiaoyuLottoCalcValidamount(BigDecimal xiaoyuLottoCalcValidamount) {
		this.xiaoyuLottoCalcValidamount = xiaoyuLottoCalcValidamount;
	}

	public BigDecimal getXiaoyuLottoUncalcValidamount() {
		return xiaoyuLottoUncalcValidamount;
	}

	public void setXiaoyuLottoUncalcValidamount(BigDecimal xiaoyuLottoUncalcValidamount) {
		this.xiaoyuLottoUncalcValidamount = xiaoyuLottoUncalcValidamount;
	}

	public BigDecimal getFenfenLottoCalcValidamount() {
		return fenfenLottoCalcValidamount;
	}

	public void setFenfenLottoCalcValidamount(BigDecimal fenfenLottoCalcValidamount) {
		this.fenfenLottoCalcValidamount = fenfenLottoCalcValidamount;
	}

	public BigDecimal getFenfenLottoUncalcValidamount() {
		return fenfenLottoUncalcValidamount;
	}

	public void setFenfenLottoUncalcValidamount(BigDecimal fenfenLottoUncalcValidamount) {
		this.fenfenLottoUncalcValidamount = fenfenLottoUncalcValidamount;
	}

	public BigDecimal getXiaoyuHongkongCalcValidamount() {
		return xiaoyuHongkongCalcValidamount;
	}

	public void setXiaoyuHongkongCalcValidamount(BigDecimal xiaoyuHongkongCalcValidamount) {
		this.xiaoyuHongkongCalcValidamount = xiaoyuHongkongCalcValidamount;
	}

	public BigDecimal getXiaoyuHongkongUncalcValidamount() {
		return xiaoyuHongkongUncalcValidamount;
	}

	public void setXiaoyuHongkongUncalcValidamount(BigDecimal xiaoyuHongkongUncalcValidamount) {
		this.xiaoyuHongkongUncalcValidamount = xiaoyuHongkongUncalcValidamount;
	}

	public BigDecimal getDsHongkongCalcValidamount() {
		return dsHongkongCalcValidamount;
	}

	public void setDsHongkongCalcValidamount(BigDecimal dsHongkongCalcValidamount) {
		this.dsHongkongCalcValidamount = dsHongkongCalcValidamount;
	}

	public BigDecimal getDsHongkongUncalcValidamount() {
		return dsHongkongUncalcValidamount;
	}

	public void setDsHongkongUncalcValidamount(BigDecimal dsHongkongUncalcValidamount) {
		this.dsHongkongUncalcValidamount = dsHongkongUncalcValidamount;
	}

	public BigDecimal getChuantongLottoValidamount() {
		return chuantongLottoValidamount;
	}

	public void setChuantongLottoValidamount(BigDecimal chuantongLottoValidamount) {
		this.chuantongLottoValidamount = chuantongLottoValidamount;
	}

	public BigDecimal getChuantongLottoWater() {
		return chuantongLottoWater;
	}

	public void setChuantongLottoWater(BigDecimal chuantongLottoWater) {
		this.chuantongLottoWater = chuantongLottoWater;
	}

	public BigDecimal getChuantongLottoCalcValidamount() {
		return chuantongLottoCalcValidamount;
	}

	public void setChuantongLottoCalcValidamount(BigDecimal chuantongLottoCalcValidamount) {
		this.chuantongLottoCalcValidamount = chuantongLottoCalcValidamount;
	}

	public BigDecimal getChuantongLottoUncalcValidamount() {
		return chuantongLottoUncalcValidamount;
	}

	public void setChuantongLottoUncalcValidamount(BigDecimal chuantongLottoUncalcValidamount) {
		this.chuantongLottoUncalcValidamount = chuantongLottoUncalcValidamount;
	}

	public BigDecimal getLiveOGValidamount() {
		return liveOGValidamount;
	}

	public void setLiveOGValidamount(BigDecimal liveOGValidamount) {
		this.liveOGValidamount = liveOGValidamount;
	}

	public BigDecimal getLiveOGWater() {
		return liveOGWater;
	}

	public void setLiveOGWater(BigDecimal liveOGWater) {
		this.liveOGWater = liveOGWater;
	}

	public BigDecimal getLiveOgCalcValidamount() {
		return liveOgCalcValidamount;
	}

	public void setLiveOgCalcValidamount(BigDecimal liveOgCalcValidamount) {
		this.liveOgCalcValidamount = liveOgCalcValidamount;
	}

	public BigDecimal getLiveOgUncalcValidamount() {
		return liveOgUncalcValidamount;
	}

	public void setLiveOgUncalcValidamount(BigDecimal liveOgUncalcValidamount) {
		this.liveOgUncalcValidamount = liveOgUncalcValidamount;
	}

	public BigDecimal getMgGameValidamount() {
		return mgGameValidamount;
	}

	public void setMgGameValidamount(BigDecimal mgGameValidamount) {
		this.mgGameValidamount = mgGameValidamount;
	}

	public BigDecimal getMgGameWater() {
		return mgGameWater;
	}

	public void setMgGameWater(BigDecimal mgGameWater) {
		this.mgGameWater = mgGameWater;
	}

	public BigDecimal getMgGameCalcValidamount() {
		return mgGameCalcValidamount;
	}

	public void setMgGameCalcValidamount(BigDecimal mgGameCalcValidamount) {
		this.mgGameCalcValidamount = mgGameCalcValidamount;
	}

	public BigDecimal getMggameUncalcValidamount() {
		return mggameUncalcValidamount;
	}

	public void setMggameUncalcValidamount(BigDecimal mggameUncalcValidamount) {
		this.mggameUncalcValidamount = mggameUncalcValidamount;
	}

	public BigDecimal getXingyunLottoValidamount() {
		return xingyunLottoValidamount;
	}

	public void setXingyunLottoValidamount(BigDecimal xingyunLottoValidamount) {
		this.xingyunLottoValidamount = xingyunLottoValidamount;
	}

	public BigDecimal getXingyunLottoWater() {
		return xingyunLottoWater;
	}

	public void setXingyunLottoWater(BigDecimal xingyunLottoWater) {
		this.xingyunLottoWater = xingyunLottoWater;
	}

	public BigDecimal getXingyunLottoCalcValidamount() {
		return xingyunLottoCalcValidamount;
	}

	public void setXingyunLottoCalcValidamount(BigDecimal xingyunLottoCalcValidamount) {
		this.xingyunLottoCalcValidamount = xingyunLottoCalcValidamount;
	}

	public BigDecimal getXingyunLottoUncalcValidamount() {
		return xingyunLottoUncalcValidamount;
	}

	public void setXingyunLottoUncalcValidamount(BigDecimal xingyunLottoUncalcValidamount) {
		this.xingyunLottoUncalcValidamount = xingyunLottoUncalcValidamount;
	}

	public BigDecimal getPtGameValidamount() {
		return ptGameValidamount;
	}

	public void setPtGameValidamount(BigDecimal ptGameValidamount) {
		this.ptGameValidamount = ptGameValidamount;
	}

	public BigDecimal getPtGameWater() {
		return ptGameWater;
	}

	public void setPtGameWater(BigDecimal ptGameWater) {
		this.ptGameWater = ptGameWater;
	}

	public BigDecimal getPtGameCalcValidamount() {
		return ptGameCalcValidamount;
	}

	public void setPtGameCalcValidamount(BigDecimal ptGameCalcValidamount) {
		this.ptGameCalcValidamount = ptGameCalcValidamount;
	}

	public BigDecimal getPtgameUncalcValidamount() {
		return ptgameUncalcValidamount;
	}

	public void setPtgameUncalcValidamount(BigDecimal ptgameUncalcValidamount) {
		this.ptgameUncalcValidamount = ptgameUncalcValidamount;
	}

	public BigDecimal getPmgGameCalcValidamount() {
		return pmgGameCalcValidamount;
	}

	public void setPmgGameCalcValidamount(BigDecimal pmgGameCalcValidamount) {
		this.pmgGameCalcValidamount = pmgGameCalcValidamount;
	}

	public BigDecimal getPmggameUncalcValidamount() {
		return pmggameUncalcValidamount;
	}

	public void setPmggameUncalcValidamount(BigDecimal pmggameUncalcValidamount) {
		this.pmggameUncalcValidamount = pmggameUncalcValidamount;
	}

	public BigDecimal getPmgGameValidamount() {
		return pmgGameValidamount;
	}

	public void setPmgGameValidamount(BigDecimal pmgGameValidamount) {
		this.pmgGameValidamount = pmgGameValidamount;
	}

	public BigDecimal getPmgGameWater() {
		return pmgGameWater;
	}

	public void setPmgGameWater(BigDecimal pmgGameWater) {
		this.pmgGameWater = pmgGameWater;
	}

	public String getBbGame_type_list() {
		return bbGame_type_list;
	}

	public void setBbGame_type_list(String bbGame_type_list) {
		this.bbGame_type_list = bbGame_type_list;
	}

	public String getAgGame_type_list() {
		return agGame_type_list;
	}

	public void setAgGame_type_list(String agGame_type_list) {
		this.agGame_type_list = agGame_type_list;
	}

	public String getMgGame_type_list() {
		return mgGame_type_list;
	}

	public void setMgGame_type_list(String mgGame_type_list) {
		this.mgGame_type_list = mgGame_type_list;
	}

	public String getPtGame_type_list() {
		return ptGame_type_list;
	}

	public void setPtGame_type_list(String ptGame_type_list) {
		this.ptGame_type_list = ptGame_type_list;
	}

	public String getPmgGame_type_list() {
		return pmgGame_type_list;
	}

	public void setPmgGame_type_list(String pmgGame_type_list) {
		this.pmgGame_type_list = pmgGame_type_list;
	}

	public BigDecimal getLiveLmgValidamount() {
		return liveLmgValidamount;
	}

	public void setLiveLmgValidamount(BigDecimal liveLmgValidamount) {
		this.liveLmgValidamount = liveLmgValidamount;
	}

	public BigDecimal getLiveLmgWater() {
		return liveLmgWater;
	}

	public void setLiveLmgWater(BigDecimal liveLmgWater) {
		this.liveLmgWater = liveLmgWater;
	}

	public BigDecimal getLiveLmgCalcValidamount() {
		return liveLmgCalcValidamount;
	}

	public void setLiveLmgCalcValidamount(BigDecimal liveLmgCalcValidamount) {
		this.liveLmgCalcValidamount = liveLmgCalcValidamount;
	}

	public BigDecimal getLiveLmgUncalcValidamount() {
		return liveLmgUncalcValidamount;
	}

	public void setLiveLmgUncalcValidamount(BigDecimal liveLmgUncalcValidamount) {
		this.liveLmgUncalcValidamount = liveLmgUncalcValidamount;
	}

	public BigDecimal getChessValidamount() {
		return chessValidamount;
	}

	public void setChessValidamount(BigDecimal chessValidamount) {
		this.chessValidamount = chessValidamount;
	}

	public BigDecimal getChessWater() {
		return chessWater;
	}

	public void setChessWater(BigDecimal chessWater) {
		this.chessWater = chessWater;
	}

	public BigDecimal getKyChessValidamount() {
		return kyChessValidamount;
	}

	public void setKyChessValidamount(BigDecimal kyChessValidamount) {
		this.kyChessValidamount = kyChessValidamount;
	}


	public BigDecimal getKyChessCalcValidamount() {
		return kyChessCalcValidamount;
	}

	public void setKyChessCalcValidamount(BigDecimal kyChessCalcValidamount) {
		this.kyChessCalcValidamount = kyChessCalcValidamount;
	}

	public BigDecimal getKyChessUncalcValidamount() {
		return kyChessUncalcValidamount;
	}

	public void setKyChessUncalcValidamount(BigDecimal kyChessUncalcValidamount) {
		this.kyChessUncalcValidamount = kyChessUncalcValidamount;
	}

	public BigDecimal getKyChessWater() {
		return kyChessWater;
	}

	public void setKyChessWater(BigDecimal kyChessWater) {
		this.kyChessWater = kyChessWater;
	}

	public BigDecimal getAgSportValidamount() {
		return agSportValidamount;
	}

	public void setAgSportValidamount(BigDecimal agSportValidamount) {
		this.agSportValidamount = agSportValidamount;
	}

	public BigDecimal getAgSportWater() {
		return agSportWater;
	}

	public void setAgSportWater(BigDecimal agSportWater) {
		this.agSportWater = agSportWater;
	}

	public BigDecimal getAgSportCalcValidamount() {
		return agSportCalcValidamount;
	}

	public void setAgSportCalcValidamount(BigDecimal agSportCalcValidamount) {
		this.agSportCalcValidamount = agSportCalcValidamount;
	}

	public BigDecimal getAgSportUncalcValidamount() {
		return agSportUncalcValidamount;
	}

	public void setAgSportUncalcValidamount(BigDecimal agSportUncalcValidamount) {
		this.agSportUncalcValidamount = agSportUncalcValidamount;
	}

	public BigDecimal getLiveSgsValidamount() {
		return liveSgsValidamount;
	}

	public void setLiveSgsValidamount(BigDecimal liveSgsValidamount) {
		this.liveSgsValidamount = liveSgsValidamount;
	}

	public BigDecimal getLiveSgsCalcValidamount() {
		return liveSgsCalcValidamount;
	}

	public void setLiveSgsCalcValidamount(BigDecimal liveSgsCalcValidamount) {
		this.liveSgsCalcValidamount = liveSgsCalcValidamount;
	}

	public BigDecimal getLiveSgsUncalcValidamount() {
		return liveSgsUncalcValidamount;
	}

	public void setLiveSgsUncalcValidamount(BigDecimal liveSgsUncalcValidamount) {
		this.liveSgsUncalcValidamount = liveSgsUncalcValidamount;
	}

	public BigDecimal getLiveSgsWater() {
		return liveSgsWater;
	}

	public void setLiveSgsWater(BigDecimal liveSgsWater) {
		this.liveSgsWater = liveSgsWater;
	}

	public BigDecimal getSgsGameValidamount() {
		return sgsGameValidamount;
	}

	public void setSgsGameValidamount(BigDecimal sgsGameValidamount) {
		this.sgsGameValidamount = sgsGameValidamount;
	}

	public BigDecimal getSgsGameCalcValidamount() {
		return sgsGameCalcValidamount;
	}

	public void setSgsGameCalcValidamount(BigDecimal sgsGameCalcValidamount) {
		this.sgsGameCalcValidamount = sgsGameCalcValidamount;
	}

	public BigDecimal getSgsGameUncalcValidamount() {
		return sgsGameUncalcValidamount;
	}

	public void setSgsGameUncalcValidamount(BigDecimal sgsGameUncalcValidamount) {
		this.sgsGameUncalcValidamount = sgsGameUncalcValidamount;
	}

	public BigDecimal getSgsGameWater() {
		return sgsGameWater;
	}

	public void setSgsGameWater(BigDecimal sgsGameWater) {
		this.sgsGameWater = sgsGameWater;
	}

	public String getSgsGame_type_list() {
		return SgsGame_type_list;
	}

	public void setSgsGame_type_list(String sgsGame_type_list) {
		SgsGame_type_list = sgsGame_type_list;
	}

	public BigDecimal getLiveKKWValidamount() {
		return liveKKWValidamount;
	}

	public void setLiveKKWValidamount(BigDecimal liveKKWValidamount) {
		this.liveKKWValidamount = liveKKWValidamount;
	}

	public BigDecimal getLiveKKWWater() {
		return liveKKWWater;
	}

	public void setLiveKKWWater(BigDecimal liveKKWWater) {
		this.liveKKWWater = liveKKWWater;
	}

	public BigDecimal getLiveKKWCalcValidamount() {
		return liveKKWCalcValidamount;
	}

	public void setLiveKKWCalcValidamount(BigDecimal liveKKWCalcValidamount) {
		this.liveKKWCalcValidamount = liveKKWCalcValidamount;
	}

	public BigDecimal getLiveKKWUncalcValidamount() {
		return liveKKWUncalcValidamount;
	}

	public void setLiveKKWUncalcValidamount(BigDecimal liveKKWUncalcValidamount) {
		this.liveKKWUncalcValidamount = liveKKWUncalcValidamount;
	}

}