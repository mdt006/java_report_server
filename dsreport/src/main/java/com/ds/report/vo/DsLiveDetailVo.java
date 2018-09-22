package com.ds.report.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DsLiveDetailVo {
	private String betType;
	private BigDecimal betAmount;
	private BigDecimal winLossAmount;
	private Date betTime;
	public String getBetType() {
		return betType;
	}
	public void setBetType(String betType) {
		this.betType = betType;
	}
	public BigDecimal getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}
	public BigDecimal getWinLossAmount() {
		return winLossAmount;
	}
	public void setWinLossAmount(BigDecimal winLossAmount) {
		this.winLossAmount = winLossAmount;
	}
	public Date getBetTime() {
		return betTime;
	}
	public void setBetTime(Date betTime) {
		this.betTime = betTime;
	}
	
}
