package com.ds.report.vo;

import java.math.BigDecimal;

public class HunterDetailTotalVo {
	private Integer count; 
	private BigDecimal sumEarn;
	private BigDecimal sumWinlose;
	private BigDecimal sumDrawAwardAll;
	private BigDecimal sumHunterAwardAll;
	private BigDecimal sumBetAmount;

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getSumEarn() {
		return sumEarn;
	}
	public void setSumEarn(BigDecimal sumEarn) {
		this.sumEarn = sumEarn;
	}
	public BigDecimal getSumWinlose() {
		return sumWinlose;
	}
	public void setSumWinlose(BigDecimal sumWinlose) {
		this.sumWinlose = sumWinlose;
	}
	public BigDecimal getSumBetAmount() {
		return sumBetAmount;
	}
	public void setSumBetAmount(BigDecimal sumBetAmount) {
		this.sumBetAmount = sumBetAmount;
	}
	public BigDecimal getSumDrawAwardAll() {
		return sumDrawAwardAll;
	}
	public void setSumDrawAwardAll(BigDecimal sumDrawAwardAll) {
		this.sumDrawAwardAll = sumDrawAwardAll;
	}
	public BigDecimal getSumHunterAwardAll() {
		return sumHunterAwardAll;
	}
	public void setSumHunterAwardAll(BigDecimal sumHunterAwardAll) {
		this.sumHunterAwardAll = sumHunterAwardAll;
	}
	
	
	
	
}
