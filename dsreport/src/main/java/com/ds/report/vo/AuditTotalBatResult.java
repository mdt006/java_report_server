package com.ds.report.vo;

import java.math.BigDecimal;

public class AuditTotalBatResult {
	private String startTime;
	private String endTime;
  	private BigDecimal sportValidamount;
  	private BigDecimal liveValidamount;
  	private BigDecimal jilvValidamount;
  	private BigDecimal lottoValidamount;
  	private BigDecimal totalValidamount;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getSportValidamount() {
		return sportValidamount;
	}
	public void setSportValidamount(BigDecimal sportValidamount) {
		this.sportValidamount = sportValidamount;
	}
	public BigDecimal getLiveValidamount() {
		return liveValidamount;
	}
	public void setLiveValidamount(BigDecimal liveValidamount) {
		this.liveValidamount = liveValidamount;
	}
	public BigDecimal getJilvValidamount() {
		return jilvValidamount;
	}
	public void setJilvValidamount(BigDecimal jilvValidamount) {
		this.jilvValidamount = jilvValidamount;
	}
	public BigDecimal getLottoValidamount() {
		return lottoValidamount;
	}
	public void setLottoValidamount(BigDecimal lottoValidamount) {
		this.lottoValidamount = lottoValidamount;
	}
	public BigDecimal getTotalValidamount() {
		return totalValidamount;
	}
	public void setTotalValidamount(BigDecimal totalValidamount) {
		this.totalValidamount = totalValidamount;
	}
  	
  	
}
