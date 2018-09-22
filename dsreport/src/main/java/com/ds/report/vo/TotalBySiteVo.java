package com.ds.report.vo;

import java.math.BigDecimal;

public class TotalBySiteVo {
	private String username;
	private BigDecimal betamount;//下注金额
	private BigDecimal validamount;//有效下注金额；
	private BigDecimal winlose;//输赢金额;
	private Integer betCount;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BigDecimal getBetamount() {
		return betamount;
	}
	public void setBetamount(BigDecimal betamount) {
		this.betamount = betamount;
	}
	public BigDecimal getValidamount() {
		return validamount;
	}
	public void setValidamount(BigDecimal validamount) {
		this.validamount = validamount;
	}
	public BigDecimal getWinlose() {
		return winlose;
	}
	public void setWinlose(BigDecimal winlose) {
		this.winlose = winlose;
	}
	public Integer getBetCount() {
		return betCount;
	}
	public void setBetCount(Integer betCount) {
		this.betCount = betCount;
	}
	
}
