package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsBbinLive {
    private Long id;

    private String userName;

    private String uppername;

    private String bbinWebsite;

    private Integer siteId;

    private String wagersId;

    private Date wagersDate;

    private String serialId;

    private String roundNo;

    private Integer gameType;

    private String gameCode;

    private String result;

    private String resultType;

    private String card;

    private BigDecimal betAmount;

    private BigDecimal payOff;

    private String currency;

    private String exchangeRate;

    private BigDecimal commissionable;

    private BigDecimal commission;

    private Byte winLossType;

    private Date createTime;

    private Date updateTime;

    private Date modifiedDate;

    private Byte flag;

    private String lastJson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUppername() {
        return uppername;
    }

    public void setUppername(String uppername) {
        this.uppername = uppername == null ? null : uppername.trim();
    }

    public String getBbinWebsite() {
        return bbinWebsite;
    }

    public void setBbinWebsite(String bbinWebsite) {
        this.bbinWebsite = bbinWebsite == null ? null : bbinWebsite.trim();
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getWagersId() {
        return wagersId;
    }

    public void setWagersId(String wagersId) {
        this.wagersId = wagersId == null ? null : wagersId.trim();
    }

    public Date getWagersDate() {
        return wagersDate;
    }

    public void setWagersDate(Date wagersDate) {
        this.wagersDate = wagersDate;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId == null ? null : serialId.trim();
    }

    public String getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(String roundNo) {
        this.roundNo = roundNo == null ? null : roundNo.trim();
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode == null ? null : gameCode.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType == null ? null : resultType.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public BigDecimal getPayOff() {
        return payOff;
    }

    public void setPayOff(BigDecimal payOff) {
        this.payOff = payOff;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate == null ? null : exchangeRate.trim();
    }

    public BigDecimal getCommissionable() {
        return commissionable;
    }

    public void setCommissionable(BigDecimal commissionable) {
        this.commissionable = commissionable;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Byte getWinLossType() {
        return winLossType;
    }

    public void setWinLossType(Byte winLossType) {
        this.winLossType = winLossType;
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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String getLastJson() {
        return lastJson;
    }

    public void setLastJson(String lastJson) {
        this.lastJson = lastJson == null ? null : lastJson.trim();
    }
}