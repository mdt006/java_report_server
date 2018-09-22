package com.ds.lottery.vo;

import java.math.BigDecimal;
import java.sql.Date;

public class TotalReportVo {
	private Long id;
	private Integer siteId;
	private String username;
	private BigDecimal betAmount;
	private BigDecimal validAmount;
	private BigDecimal winLossAmount;
//	private Integer betType;
	private Date betTime;
	private Integer liveId;
	private String liveName;
	private Integer gameKind;
	private String gameKindName;
	private Integer gameType;
	private String gameName;
	private Integer count;//下注次数
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Integer getLiveId() {
		return liveId;
	}
	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
	}
	public String getLiveName() {
		return liveName;
	}
	public void setLiveName(String liveName) {
		this.liveName = liveName;
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
	public Integer getGameType() {
		return gameType;
	}
	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
