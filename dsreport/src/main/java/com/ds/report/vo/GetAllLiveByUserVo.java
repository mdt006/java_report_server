package com.ds.report.vo;

import java.math.BigDecimal;

public class GetAllLiveByUserVo {
	private String username;
	private Integer liveId;
	private BigDecimal vilidateMoney;
	private BigDecimal winLoseMoney;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getLiveId() {
		return liveId;
	}
	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
	}
	public BigDecimal getVilidateMoney() {
		return vilidateMoney;
	}
	public void setVilidateMoney(BigDecimal vilidateMoney) {
		this.vilidateMoney = vilidateMoney;
	}
	public BigDecimal getWinLoseMoney() {
		return winLoseMoney;
	}
	public void setWinLoseMoney(BigDecimal winLoseMoney) {
		this.winLoseMoney = winLoseMoney;
	}
	
}
