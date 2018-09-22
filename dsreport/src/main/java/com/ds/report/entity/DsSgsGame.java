package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsSgsGame {
    private Long id;

    private Integer siteId;

    private String ugsBetId;

    private String txid;

    private String betId;

    private Date betOn;

    private Date betClosedOn;

    private Date betUpdatedOn;

    private Date timestamp;

    private String roundid;

    private String roundStatus;

    private String userid;

    private String username;

    private BigDecimal riskamt;

    private BigDecimal winamt;

    private BigDecimal winloss;

    private BigDecimal beforebal;

    private BigDecimal postbal;

    private Byte winLossType;

    private String currency;

    private String gameProvider;

    private String gameProviderCode;

    private String gameName;

    private String gameId;

    private String platformType;

    private String ipAddress;

    private String betType;

    private String playType;

    private Byte playerType;

    private BigDecimal turnover;

    private BigDecimal validbet;

    private Date createTime;

    private Date updateTime;

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

    public String getUgsBetId() {
        return ugsBetId;
    }

    public void setUgsBetId(String ugsBetId) {
        this.ugsBetId = ugsBetId == null ? null : ugsBetId.trim();
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid == null ? null : txid.trim();
    }

    public String getBetId() {
        return betId;
    }

    public void setBetId(String betId) {
        this.betId = betId == null ? null : betId.trim();
    }

    public Date getBetOn() {
        return betOn;
    }

    public void setBetOn(Date betOn) {
        this.betOn = betOn;
    }

    public Date getBetClosedOn() {
        return betClosedOn;
    }

    public void setBetClosedOn(Date betClosedOn) {
        this.betClosedOn = betClosedOn;
    }

    public Date getBetUpdatedOn() {
        return betUpdatedOn;
    }

    public void setBetUpdatedOn(Date betUpdatedOn) {
        this.betUpdatedOn = betUpdatedOn;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getRoundid() {
        return roundid;
    }

    public void setRoundid(String roundid) {
        this.roundid = roundid == null ? null : roundid.trim();
    }

    public String getRoundStatus() {
        return roundStatus;
    }

    public void setRoundStatus(String roundStatus) {
        this.roundStatus = roundStatus == null ? null : roundStatus.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public BigDecimal getRiskamt() {
        return riskamt;
    }

    public void setRiskamt(BigDecimal riskamt) {
        this.riskamt = riskamt;
    }

    public BigDecimal getWinamt() {
        return winamt;
    }

    public void setWinamt(BigDecimal winamt) {
        this.winamt = winamt;
    }

    public BigDecimal getWinloss() {
        return winloss;
    }

    public void setWinloss(BigDecimal winloss) {
        this.winloss = winloss;
    }

    public BigDecimal getBeforebal() {
        return beforebal;
    }

    public void setBeforebal(BigDecimal beforebal) {
        this.beforebal = beforebal;
    }

    public BigDecimal getPostbal() {
        return postbal;
    }

    public void setPostbal(BigDecimal postbal) {
        this.postbal = postbal;
    }

    public Byte getWinLossType() {
        return winLossType;
    }

    public void setWinLossType(Byte winLossType) {
        this.winLossType = winLossType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getGameProvider() {
        return gameProvider;
    }

    public void setGameProvider(String gameProvider) {
        this.gameProvider = gameProvider == null ? null : gameProvider.trim();
    }

    public String getGameProviderCode() {
        return gameProviderCode;
    }

    public void setGameProviderCode(String gameProviderCode) {
        this.gameProviderCode = gameProviderCode == null ? null : gameProviderCode.trim();
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType == null ? null : platformType.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType == null ? null : betType.trim();
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType == null ? null : playType.trim();
    }

    public Byte getPlayerType() {
        return playerType;
    }

    public void setPlayerType(Byte playerType) {
        this.playerType = playerType;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigDecimal getValidbet() {
        return validbet;
    }

    public void setValidbet(BigDecimal validbet) {
        this.validbet = validbet;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}