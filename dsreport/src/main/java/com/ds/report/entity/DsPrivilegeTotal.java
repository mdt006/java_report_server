package com.ds.report.entity;

import java.math.BigDecimal;

public class DsPrivilegeTotal {
	
	private String username;//用户名
	private BigDecimal bbSportValidamount;//BBIN球类有效投注金额
	private BigDecimal bbLiveValidamount;//BBIN视讯有效投注金额
	private BigDecimal bbJilvValidamount;//BBIN机率有效投注金额
	private BigDecimal bb3dValidamount;//BBIN3D有效投注金额
	private BigDecimal agLiveValidamount;//AG视讯有效投注金额
	private BigDecimal agJilvValidamount;//AG机率有效投注金额
	private BigDecimal dsLiveValidamount;//DS视讯有效投注金额
	private BigDecimal lottoValidamount;//彩票有效投注金额
	private BigDecimal hongkongValidamount;//香港彩有效投注金额
	
	/**
	 * 新增幸运彩,将经典彩彩拆分成经典时时彩以及经典香港彩
	 */
	private BigDecimal xingyunValidamount;
	private BigDecimal jingdianshishicaiValidamount;
	private BigDecimal jingdianxianggangValidamount;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BigDecimal getBbSportValidamount() {
		return bbSportValidamount;
	}
	public void setBbSportValidamount(BigDecimal bbSportValidamount) {
		this.bbSportValidamount = bbSportValidamount;
	}
	public BigDecimal getBbLiveValidamount() {
		return bbLiveValidamount;
	}
	public void setBbLiveValidamount(BigDecimal bbLiveValidamount) {
		this.bbLiveValidamount = bbLiveValidamount;
	}
	public BigDecimal getBbJilvValidamount() {
		return bbJilvValidamount;
	}
	public void setBbJilvValidamount(BigDecimal bbJilvValidamount) {
		this.bbJilvValidamount = bbJilvValidamount;
	}
	public BigDecimal getBb3dValidamount() {
		return bb3dValidamount;
	}
	public void setBb3dValidamount(BigDecimal bb3dValidamount) {
		this.bb3dValidamount = bb3dValidamount;
	}
	public BigDecimal getAgLiveValidamount() {
		return agLiveValidamount;
	}
	public void setAgLiveValidamount(BigDecimal agLiveValidamount) {
		this.agLiveValidamount = agLiveValidamount;
	}
	public BigDecimal getAgJilvValidamount() {
		return agJilvValidamount;
	}
	public void setAgJilvValidamount(BigDecimal agJilvValidamount) {
		this.agJilvValidamount = agJilvValidamount;
	}
	public BigDecimal getDsLiveValidamount() {
		return dsLiveValidamount;
	}
	public void setDsLiveValidamount(BigDecimal dsLiveValidamount) {
		this.dsLiveValidamount = dsLiveValidamount;
	}
	public BigDecimal getLottoValidamount() {
		return lottoValidamount;
	}
	public void setLottoValidamount(BigDecimal lottoValidamount) {
		this.lottoValidamount = lottoValidamount;
	}
	public BigDecimal getHongkongValidamount() {
		return hongkongValidamount;
	}
	public void setHongkongValidamount(BigDecimal hongkongValidamount) {
		this.hongkongValidamount = hongkongValidamount;
	}
	public BigDecimal getXingyunValidamount() {
		return xingyunValidamount;
	}
	public void setXingyunValidamount(BigDecimal xingyunValidamount) {
		this.xingyunValidamount = xingyunValidamount;
	}
	public BigDecimal getJingdianshishicaiValidamount() {
		return jingdianshishicaiValidamount;
	}
	public void setJingdianshishicaiValidamount(BigDecimal jingdianshishicaiValidamount) {
		this.jingdianshishicaiValidamount = jingdianshishicaiValidamount;
	}
	public BigDecimal getJingdianxianggangValidamount() {
		return jingdianxianggangValidamount;
	}
	public void setJingdianxianggangValidamount(BigDecimal jingdianxianggangValidamount) {
		this.jingdianxianggangValidamount = jingdianxianggangValidamount;
	}
}