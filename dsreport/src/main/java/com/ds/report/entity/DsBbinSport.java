package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsBbinSport {
    private Long id;

    private String userName;

    private Integer siteId;

    private String uppername;

    private String bbinWebsite;

    private Byte bbinGameKind;

    private String wagersId;

    private Date wagersDate;

    private String serialId;

    private String roundNo;

    private String gameType;

    private String gameCode;

    private String result;

    private String resultType;

    private String card;

    private BigDecimal betAmount;

    private BigDecimal payOff;

    private BigDecimal commission;

    private String currency;

    private String exchangeRate;

    private BigDecimal commissionable;

    private Byte winLossType;

    private Date modifiedDate;

    private Date createTime;

    private Date updateTime;

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

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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

    public Byte getBbinGameKind() {
        return bbinGameKind;
    }

    public void setBbinGameKind(Byte bbinGameKind) {
        this.bbinGameKind = bbinGameKind;
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

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType == null ? null : gameType.trim();
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

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
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

    public Byte getWinLossType() {
        return winLossType;
    }

    public void setWinLossType(Byte winLossType) {
        this.winLossType = winLossType;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
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