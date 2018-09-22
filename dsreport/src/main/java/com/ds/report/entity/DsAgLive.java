package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsAgLive {
    private Long id;

    private Integer siteId;

    private String userPre;

    private String username;

    private String playerName;

    private String billNo;

    private String agentCode;

    private String gameCode;

    private BigDecimal netAmount;

    private Byte winLossType;

    private Byte gameKind;

    private String gameKindName;

    private String gameType;

    private String gameTypeName;

    private BigDecimal betAmount;

    private Date betTime;

    private BigDecimal validBetAmount;

    private String flag;

    private String playType;

    private String currency;

    private String tableCode;

    private String loginIp;

    private Date recalcuTime;

    private String platformId;

    private String platformType;

    private String remark;

    private String round;

    private String result;

    private BigDecimal beforeCredit;

    private String deviceType;

    private Date createTime;

    private Date updateTime;

    private Byte agFlag;

    private String lastJson;

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

    public String getUserPre() {
        return userPre;
    }

    public void setUserPre(String userPre) {
        this.userPre = userPre == null ? null : userPre.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName == null ? null : playerName.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode == null ? null : gameCode.trim();
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public Byte getWinLossType() {
        return winLossType;
    }

    public void setWinLossType(Byte winLossType) {
        this.winLossType = winLossType;
    }

    public Byte getGameKind() {
        return gameKind;
    }

    public void setGameKind(Byte gameKind) {
        this.gameKind = gameKind;
    }

    public String getGameKindName() {
        return gameKindName;
    }

    public void setGameKindName(String gameKindName) {
        this.gameKindName = gameKindName == null ? null : gameKindName.trim();
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType == null ? null : gameType.trim();
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public void setGameTypeName(String gameTypeName) {
        this.gameTypeName = gameTypeName == null ? null : gameTypeName.trim();
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
    }

    public BigDecimal getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(BigDecimal validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType == null ? null : playType.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode == null ? null : tableCode.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getRecalcuTime() {
        return recalcuTime;
    }

    public void setRecalcuTime(Date recalcuTime) {
        this.recalcuTime = recalcuTime;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType == null ? null : platformType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round == null ? null : round.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public BigDecimal getBeforeCredit() {
        return beforeCredit;
    }

    public void setBeforeCredit(BigDecimal beforeCredit) {
        this.beforeCredit = beforeCredit;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
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

    public Byte getAgFlag() {
        return agFlag;
    }

    public void setAgFlag(Byte agFlag) {
        this.agFlag = agFlag;
    }

    public String getLastJson() {
        return lastJson;
    }

    public void setLastJson(String lastJson) {
        this.lastJson = lastJson == null ? null : lastJson.trim();
    }
}