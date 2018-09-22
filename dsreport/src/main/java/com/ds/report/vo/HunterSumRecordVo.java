package com.ds.report.vo;

import java.math.BigDecimal;


public class HunterSumRecordVo {
	
	/*SELECT site_id AS siteId, SUM(bet_count) as betCount,SUM(betamount) as betAmount,SUM(validamount) AS validAmount,
	SUM(winlose) as winlose,SUM(jackpot) as jackpot
	FROM ds_aghunter_report a WHERE a.bet_time >= '2017-07-25' AND a.bet_time <= '2017-08-09' GROUP BY site_id*/
	private Integer siteId;
	private Integer betCount;
	private BigDecimal betAmount;
	private BigDecimal validAmount;
	private BigDecimal winlose;
	private BigDecimal jackpot;
	
	public Integer getBetCount() {
		return betCount;
	}
	public void setBetCount(Integer betCount) {
		this.betCount = betCount;
	}
	public BigDecimal getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}
	public BigDecimal getValidAmount() {
		return validAmount;
	}
	public void setValidAmount(BigDecimal validAmount) {
		this.validAmount = validAmount;
	}
	public BigDecimal getWinlose() {
		return winlose;
	}
	public void setWinlose(BigDecimal winlose) {
		this.winlose = winlose;
	}
	public BigDecimal getJackpot() {
		return jackpot;
	}
	public void setJackpot(BigDecimal jackpot) {
		this.jackpot = jackpot;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	
}
