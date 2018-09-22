package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsReportSiteDay {
    private Integer id;

    private Integer betCount;

    private BigDecimal betamount;

    private BigDecimal winlose;

    private BigDecimal validamount;

    private Integer siteId;

    private Byte liveId;

    private String liveName;

    private Integer gameKind;

    private String gameKindName;

    private Date betTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBetCount() {
        return betCount;
    }

    public void setBetCount(Integer betCount) {
        this.betCount = betCount;
    }

    public BigDecimal getBetamount() {
        return betamount;
    }

    public void setBetamount(BigDecimal betamount) {
        this.betamount = betamount;
    }

    public BigDecimal getWinlose() {
        return winlose;
    }

    public void setWinlose(BigDecimal winlose) {
        this.winlose = winlose;
    }

    public BigDecimal getValidamount() {
        return validamount;
    }

    public void setValidamount(BigDecimal validamount) {
        this.validamount = validamount;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Byte getLiveId() {
        return liveId;
    }

    public void setLiveId(Byte liveId) {
        this.liveId = liveId;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName == null ? null : liveName.trim();
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
        this.gameKindName = gameKindName == null ? null : gameKindName.trim();
    }

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
    }
}