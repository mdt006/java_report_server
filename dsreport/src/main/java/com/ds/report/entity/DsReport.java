package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsReport {
    private Long id;

    private String username;

    private Integer betCount;

    private BigDecimal betamount;

    private BigDecimal winlose;

    private BigDecimal validamount;

    private Integer siteId;

    private Byte liveId;

    private String liveName;

    private Integer gameKind;

    private String gameKindName;

    private Integer gameType;

    private String gameName;

    private Date betTime;

    private String agents;

    private String world;

    private String corprator;

    private String superior;

    private String company;

    private BigDecimal commAgent;

    private BigDecimal commWorld;

    private BigDecimal commCorprator;

    private BigDecimal commSuperior;

    private BigDecimal commBranch;
    
    private Integer recordCount;

    public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents == null ? null : agents.trim();
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world == null ? null : world.trim();
    }

    public String getCorprator() {
        return corprator;
    }

    public void setCorprator(String corprator) {
        this.corprator = corprator == null ? null : corprator.trim();
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior == null ? null : superior.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public BigDecimal getCommAgent() {
        return commAgent;
    }

    public void setCommAgent(BigDecimal commAgent) {
        this.commAgent = commAgent;
    }

    public BigDecimal getCommWorld() {
        return commWorld;
    }

    public void setCommWorld(BigDecimal commWorld) {
        this.commWorld = commWorld;
    }

    public BigDecimal getCommCorprator() {
        return commCorprator;
    }

    public void setCommCorprator(BigDecimal commCorprator) {
        this.commCorprator = commCorprator;
    }

    public BigDecimal getCommSuperior() {
        return commSuperior;
    }

    public void setCommSuperior(BigDecimal commSuperior) {
        this.commSuperior = commSuperior;
    }

    public BigDecimal getCommBranch() {
        return commBranch;
    }

    public void setCommBranch(BigDecimal commBranch) {
        this.commBranch = commBranch;
    }
}