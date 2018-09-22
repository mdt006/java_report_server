package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsAgHunterInfo {
    private Long id;

    private Integer siteId;

    private String agentCode;

    private String namepre;

    private String username;

    private String billId;

    private Byte winLossType;

    private String platformType;

    private String sceneId;

    private String playerName;

    private String platformId;

    private Byte deviceType;

    private Byte billType;

    private Date sceneStartTime;

    private Date sceneEndTime;

    private String roomid;

    private BigDecimal roombet;

    private BigDecimal jpDraw;

    private BigDecimal sceneEx;

    private Byte bombDraw;

    private Integer bulletOutNum;

    private Integer billHitNum;

    private BigDecimal earn;

    private BigDecimal netAmount;

    private BigDecimal jackpotcomm;

    private BigDecimal validBetAmount;

    private BigDecimal betAmount;

    private String remark;

    private Date betTime;

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

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getNamepre() {
        return namepre;
    }

    public void setNamepre(String namepre) {
        this.namepre = namepre == null ? null : namepre.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public Byte getWinLossType() {
        return winLossType;
    }

    public void setWinLossType(Byte winLossType) {
        this.winLossType = winLossType;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType == null ? null : platformType.trim();
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId == null ? null : sceneId.trim();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName == null ? null : playerName.trim();
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }

    public Byte getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Byte deviceType) {
        this.deviceType = deviceType;
    }

    public Byte getBillType() {
        return billType;
    }

    public void setBillType(Byte billType) {
        this.billType = billType;
    }

    public Date getSceneStartTime() {
        return sceneStartTime;
    }

    public void setSceneStartTime(Date sceneStartTime) {
        this.sceneStartTime = sceneStartTime;
    }

    public Date getSceneEndTime() {
        return sceneEndTime;
    }

    public void setSceneEndTime(Date sceneEndTime) {
        this.sceneEndTime = sceneEndTime;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public BigDecimal getRoombet() {
        return roombet;
    }

    public void setRoombet(BigDecimal roombet) {
        this.roombet = roombet;
    }

    public BigDecimal getJpDraw() {
        return jpDraw;
    }

    public void setJpDraw(BigDecimal jpDraw) {
        this.jpDraw = jpDraw;
    }

    public BigDecimal getSceneEx() {
        return sceneEx;
    }

    public void setSceneEx(BigDecimal sceneEx) {
        this.sceneEx = sceneEx;
    }

    public Byte getBombDraw() {
        return bombDraw;
    }

    public void setBombDraw(Byte bombDraw) {
        this.bombDraw = bombDraw;
    }

    public Integer getBulletOutNum() {
        return bulletOutNum;
    }

    public void setBulletOutNum(Integer bulletOutNum) {
        this.bulletOutNum = bulletOutNum;
    }

    public Integer getBillHitNum() {
        return billHitNum;
    }

    public void setBillHitNum(Integer billHitNum) {
        this.billHitNum = billHitNum;
    }

    public BigDecimal getEarn() {
        return earn;
    }

    public void setEarn(BigDecimal earn) {
        this.earn = earn;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getJackpotcomm() {
        return jackpotcomm;
    }

    public void setJackpotcomm(BigDecimal jackpotcomm) {
        this.jackpotcomm = jackpotcomm;
    }

    public BigDecimal getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(BigDecimal validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
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