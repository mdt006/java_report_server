package com.ds.report.entity;

import java.math.BigDecimal;

public class DsWaterTotal {
	private String world;
	private String corprator;
	private String superior;
	private String agents;//代理
	private String username;//用户名
	private BigDecimal totalValidamount;//总投注额
	private BigDecimal totalWater;//总返水
	private BigDecimal returnWater;//实际返水金额
	private BigDecimal ballValidamount;//球类有效投注额
	private BigDecimal ballWater;//球类返水
	private BigDecimal liveValidamount;//视讯有效投注金额
	private BigDecimal liveWater;//视讯返水
	private BigDecimal liveBbValidamount;//BBIN视讯有效投注金额
	private BigDecimal liveBbWater;//视讯返水
	private BigDecimal liveDsValidamount;//DS视讯有效投注金额
	private BigDecimal liveDsWater;//视讯返水
	private BigDecimal liveOtherValidamount;//AG视讯有效投注金额
	private BigDecimal liveOtherWater;//视讯返水
	private BigDecimal gameValidamount;//机率有效投注金额
	private BigDecimal gameWater;//机率返水
	private BigDecimal lottoValidamount;//彩票有效投注额
	private BigDecimal lottoWater;//彩票返水
	private BigDecimal hongkongValidamount;//香港彩有效投注额
	private BigDecimal hongkongWater;//香港彩返水
	private BigDecimal bbSportValidamount;//BBIN体育有效投注额
	private BigDecimal bbSportWater;//BBIN体育返水
	private BigDecimal bb3dValidamount;//3D有效投注金额
	private BigDecimal bb3dWater;//3D返水
	
	private BigDecimal totalCalcValidamount;
	private BigDecimal totalUncalcValidamount;
	private BigDecimal ballCalcValidamount;
	private BigDecimal ballUncalcValidamount;
	private BigDecimal liveBbCalcValidamount;
	private BigDecimal liveBbUncalcValidamount;
	private BigDecimal liveDsCalcValidamount;
	private BigDecimal liveDsUncalcValidamount;
	private BigDecimal liveOtherCalcValidamount;
	private BigDecimal liveOtherUncalcValidamount;
	private BigDecimal gameCalcValidamount;
	private BigDecimal gameUncalcValidamount;
	private BigDecimal lottoCalcValidamount;
	private BigDecimal lottoUncalcValidamount;
	private BigDecimal hongkongCalcValidamount;
	private BigDecimal hongkongUncalcValidamount;
	private BigDecimal bbSportCalcValidamount;
	private BigDecimal bbSportUncalcValidamount;
	private BigDecimal bb3dCalcValidamount;
	private BigDecimal bb3dUncalcValidamount;

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
	public BigDecimal getBallValidamount() {
		return ballValidamount;
	}
	public void setBallValidamount(BigDecimal ballValidamount) {
		this.ballValidamount = ballValidamount;
	}
	public BigDecimal getBallWater() {
		return ballWater;
	}
	public void setBallWater(BigDecimal ballWater) {
		this.ballWater = ballWater;
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
	public BigDecimal getLiveOtherValidamount() {
		return liveOtherValidamount;
	}
	public void setLiveOtherValidamount(BigDecimal liveOtherValidamount) {
		this.liveOtherValidamount = liveOtherValidamount;
	}
	public BigDecimal getLiveOtherWater() {
		return liveOtherWater;
	}
	public void setLiveOtherWater(BigDecimal liveOtherWater) {
		this.liveOtherWater = liveOtherWater;
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
	public BigDecimal getBb3dValidamount() {
		return bb3dValidamount;
	}
	public void setBb3dValidamount(BigDecimal bb3dValidamount) {
		this.bb3dValidamount = bb3dValidamount;
	}
	public BigDecimal getBb3dWater() {
		return bb3dWater;
	}
	public void setBb3dWater(BigDecimal bb3dWater) {
		this.bb3dWater = bb3dWater;
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
	public BigDecimal getBallCalcValidamount() {
		return ballCalcValidamount;
	}
	public void setBallCalcValidamount(BigDecimal ballCalcValidamount) {
		this.ballCalcValidamount = ballCalcValidamount;
	}
	public BigDecimal getBallUncalcValidamount() {
		return ballUncalcValidamount;
	}
	public void setBallUncalcValidamount(BigDecimal ballUncalcValidamount) {
		this.ballUncalcValidamount = ballUncalcValidamount;
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
	public BigDecimal getLiveOtherCalcValidamount() {
		return liveOtherCalcValidamount;
	}
	public void setLiveOtherCalcValidamount(BigDecimal liveOtherCalcValidamount) {
		this.liveOtherCalcValidamount = liveOtherCalcValidamount;
	}
	public BigDecimal getLiveOtherUncalcValidamount() {
		return liveOtherUncalcValidamount;
	}
	public void setLiveOtherUncalcValidamount(BigDecimal liveOtherUncalcValidamount) {
		this.liveOtherUncalcValidamount = liveOtherUncalcValidamount;
	}
	public BigDecimal getGameCalcValidamount() {
		return gameCalcValidamount;
	}
	public void setGameCalcValidamount(BigDecimal gameCalcValidamount) {
		this.gameCalcValidamount = gameCalcValidamount;
	}
	public BigDecimal getGameUncalcValidamount() {
		return gameUncalcValidamount;
	}
	public void setGameUncalcValidamount(BigDecimal gameUncalcValidamount) {
		this.gameUncalcValidamount = gameUncalcValidamount;
	}
	public BigDecimal getLottoCalcValidamount() {
		return lottoCalcValidamount;
	}
	public void setLottoCalcValidamount(BigDecimal lottoCalcValidamount) {
		this.lottoCalcValidamount = lottoCalcValidamount;
	}
	public BigDecimal getLottoUncalcValidamount() {
		return lottoUncalcValidamount;
	}
	public void setLottoUncalcValidamount(BigDecimal lottoUncalcValidamount) {
		this.lottoUncalcValidamount = lottoUncalcValidamount;
	}
	public BigDecimal getHongkongCalcValidamount() {
		return hongkongCalcValidamount;
	}
	public void setHongkongCalcValidamount(BigDecimal hongkongCalcValidamount) {
		this.hongkongCalcValidamount = hongkongCalcValidamount;
	}
	public BigDecimal getHongkongUncalcValidamount() {
		return hongkongUncalcValidamount;
	}
	public void setHongkongUncalcValidamount(BigDecimal hongkongUncalcValidamount) {
		this.hongkongUncalcValidamount = hongkongUncalcValidamount;
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
	public BigDecimal getBb3dCalcValidamount() {
		return bb3dCalcValidamount;
	}
	public void setBb3dCalcValidamount(BigDecimal bb3dCalcValidamount) {
		this.bb3dCalcValidamount = bb3dCalcValidamount;
	}
	public BigDecimal getBb3dUncalcValidamount() {
		return bb3dUncalcValidamount;
	}
	public void setBb3dUncalcValidamount(BigDecimal bb3dUncalcValidamount) {
		this.bb3dUncalcValidamount = bb3dUncalcValidamount;
	}

}
