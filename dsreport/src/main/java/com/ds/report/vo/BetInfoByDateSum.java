package com.ds.report.vo;

import java.math.BigDecimal;

public class BetInfoByDateSum {
	private BigDecimal betamount;//下注金额
	private BigDecimal validamount;//有效下注金额；
	private BigDecimal winlose;//输赢金额;
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
	
}
