package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsLive {
    private Long id;

    private Long billno;

    private Long billnoModifyId;

    private String username;

    private Integer siteId;

    private String currency;

    private String gameType;

    private Integer tableInfoId;

    private Integer showInfoId;

    private String tableName;

    private Integer gameInfoId;

    private String bankerResult;

    private String resultList;

    private String pokerList;

    private BigDecimal stakeAmount;

    private BigDecimal validStake;

    private BigDecimal winLoss;

    private Byte winLossType;

    private BigDecimal comm;

    private BigDecimal balanceAfter;

    private Date endTime;

    private Date adjustmentTime;

    private String ip;

    private String liveMemberReportDetails;

    private String resultImgName;

    private Byte flag;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillno() {
        return billno;
    }

    public void setBillno(Long billno) {
        this.billno = billno;
    }

    public Long getBillnoModifyId() {
        return billnoModifyId;
    }

    public void setBillnoModifyId(Long billnoModifyId) {
        this.billnoModifyId = billnoModifyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType == null ? null : gameType.trim();
    }

    public Integer getTableInfoId() {
        return tableInfoId;
    }

    public void setTableInfoId(Integer tableInfoId) {
        this.tableInfoId = tableInfoId;
    }

    public Integer getShowInfoId() {
        return showInfoId;
    }

    public void setShowInfoId(Integer showInfoId) {
        this.showInfoId = showInfoId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getGameInfoId() {
        return gameInfoId;
    }

    public void setGameInfoId(Integer gameInfoId) {
        this.gameInfoId = gameInfoId;
    }

    public String getBankerResult() {
        return bankerResult;
    }

    public void setBankerResult(String bankerResult) {
        this.bankerResult = bankerResult == null ? null : bankerResult.trim();
    }

    public String getResultList() {
        return resultList;
    }

    public void setResultList(String resultList) {
        this.resultList = resultList == null ? null : resultList.trim();
    }

    public String getPokerList() {
        return pokerList;
    }

    public void setPokerList(String pokerList) {
        this.pokerList = pokerList == null ? null : pokerList.trim();
    }

    public BigDecimal getStakeAmount() {
        return stakeAmount;
    }

    public void setStakeAmount(BigDecimal stakeAmount) {
        this.stakeAmount = stakeAmount;
    }

    public BigDecimal getValidStake() {
        return validStake;
    }

    public void setValidStake(BigDecimal validStake) {
        this.validStake = validStake;
    }

    public BigDecimal getWinLoss() {
        return winLoss;
    }

    public void setWinLoss(BigDecimal winLoss) {
        this.winLoss = winLoss;
    }

    public Byte getWinLossType() {
        return winLossType;
    }

    public void setWinLossType(Byte winLossType) {
        this.winLossType = winLossType;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public BigDecimal getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(BigDecimal balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getAdjustmentTime() {
        return adjustmentTime;
    }

    public void setAdjustmentTime(Date adjustmentTime) {
        this.adjustmentTime = adjustmentTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getLiveMemberReportDetails() {
        return liveMemberReportDetails;
    }

    public void setLiveMemberReportDetails(String liveMemberReportDetails) {
        this.liveMemberReportDetails = liveMemberReportDetails == null ? null : liveMemberReportDetails.trim();
    }

    public String getResultImgName() {
        return resultImgName;
    }

    public void setResultImgName(String resultImgName) {
        this.resultImgName = resultImgName == null ? null : resultImgName.trim();
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
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