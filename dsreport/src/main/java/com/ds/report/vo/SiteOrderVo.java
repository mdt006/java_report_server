package com.ds.report.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SiteOrderVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer siteId;//网站Id
	private String siteName;
	private Integer gameKind;
	private String gameKindName;
	private BigDecimal betamount;//下注金额
	private BigDecimal validamount;//有效下注金额；
	private BigDecimal winlose;//输赢金额;
	private Integer betCount;//注单数量
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
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
	public Integer getGameKind() {
		return gameKind;
	}
	public void setGameKind(Integer gameKind) {
		this.gameKind = gameKind;
	}
	public String getGameKindName() {
		return gameKindName;
	}
	public void setGameKindName(String gameKindName) {
		this.gameKindName = gameKindName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	
}
