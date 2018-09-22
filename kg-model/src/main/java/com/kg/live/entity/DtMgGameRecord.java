package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DtMgGameRecord {
    private Long id;

    private Integer siteId;

    private String mgId;

    private String username;

    private String playername;

    private BigDecimal amount;

    private BigDecimal validateAmount;

    private BigDecimal payoff;

    private Integer winLoseType;

    private BigDecimal sumOfRefund;

    private String mgStatus;

    private String applicationId;

    private String gameCode;

    private String accountId;

    private String walletCode;

    private String currencyUnit;

    private String externalRef;

    private Date betTime;

    private Date closeTime;

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

    public String getMgId() {
        return mgId;
    }

    public void setMgId(String mgId) {
        this.mgId = mgId == null ? null : mgId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername == null ? null : playername.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getValidateAmount() {
        return validateAmount;
    }

    public void setValidateAmount(BigDecimal validateAmount) {
        this.validateAmount = validateAmount;
    }

    public BigDecimal getPayoff() {
        return payoff;
    }

    public void setPayoff(BigDecimal payoff) {
        this.payoff = payoff;
    }

    public Integer getWinLoseType() {
        return winLoseType;
    }

    public void setWinLoseType(Integer winLoseType) {
        this.winLoseType = winLoseType;
    }

    public BigDecimal getSumOfRefund() {
        return sumOfRefund;
    }

    public void setSumOfRefund(BigDecimal sumOfRefund) {
        this.sumOfRefund = sumOfRefund;
    }

    public String getMgStatus() {
        return mgStatus;
    }

    public void setMgStatus(String mgStatus) {
        this.mgStatus = mgStatus == null ? null : mgStatus.trim();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId == null ? null : applicationId.trim();
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode == null ? null : gameCode.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getWalletCode() {
        return walletCode;
    }

    public void setWalletCode(String walletCode) {
        this.walletCode = walletCode == null ? null : walletCode.trim();
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
    }

    public String getExternalRef() {
        return externalRef;
    }

    public void setExternalRef(String externalRef) {
        this.externalRef = externalRef == null ? null : externalRef.trim();
    }

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
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