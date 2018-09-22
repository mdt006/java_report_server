package com.ds.chess.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsKyChess {
    private Long id;

    private Integer siteId;

    private String gameId;

    private String account;

    private Integer serverId;

    private Integer kindId;

    private Integer tableId;

    private Integer chairId;

    private Integer userCount;

    private String cardValue;

    private BigDecimal cellScore;

    private BigDecimal allBet;

    private BigDecimal profit;

    private BigDecimal revenue;

    private Date gameStartTime;

    private Date gameEndTime;

    private Integer channelId;
    
    private Byte winLossType;
    
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

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getChairId() {
        return chairId;
    }

    public void setChairId(Integer chairId) {
        this.chairId = chairId;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue == null ? null : cardValue.trim();
    }

    public BigDecimal getCellScore() {
        return cellScore;
    }

    public void setCellScore(BigDecimal cellScore) {
        this.cellScore = cellScore;
    }

    public BigDecimal getAllBet() {
        return allBet;
    }

    public void setAllBet(BigDecimal allBet) {
        this.allBet = allBet;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public Date getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(Date gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public Date getGameEndTime() {
        return gameEndTime;
    }

    public void setGameEndTime(Date gameEndTime) {
        this.gameEndTime = gameEndTime;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

	public Byte getWinLossType() {
		return winLossType;
	}

	public void setWinLossType(Byte winLossType) {
		this.winLossType = winLossType;
	}

}