package com.ds.report.entity;

import java.math.BigDecimal;

public class DsAuditTotal {
	private String username;//用户名
	private BigDecimal totalValidamount;
	private BigDecimal liveValidamount;//视讯有效投注金额
	private BigDecimal lottoValidamount;//彩票有效投注金额
	private BigDecimal jilvValidamount;//机率有效投注金额
	private BigDecimal sportValidamount;//体育有效投注金额
	
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
	public BigDecimal getLiveValidamount() {
		return liveValidamount;
	}
	public void setLiveValidamount(BigDecimal liveValidamount) {
		this.liveValidamount = liveValidamount;
	}
	public BigDecimal getLottoValidamount() {
		return lottoValidamount;
	}
	public void setLottoValidamount(BigDecimal lottoValidamount) {
		this.lottoValidamount = lottoValidamount;
	}
	public BigDecimal getJilvValidamount() {
		return jilvValidamount;
	}
	public void setJilvValidamount(BigDecimal jilvValidamount) {
		this.jilvValidamount = jilvValidamount;
	}
	public BigDecimal getSportValidamount() {
		return sportValidamount;
	}
	public void setSportValidamount(BigDecimal sportValidamount) {
		this.sportValidamount = sportValidamount;
	}
	

}
