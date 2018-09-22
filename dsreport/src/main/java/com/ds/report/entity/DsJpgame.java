package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsJpgame {
    private Long id;

    private Integer siteId;

    private String wagersid;

    private String jptypeid;

    private String username;

    private Date wagersdate;

    private BigDecimal jpamount;

    private String agents;

    private String world;

    private String corprator;

    private String superior;

    private String admin;

    private Integer liveId;

    private String liveName;

    private Date createTime;

    private Date updateTime;
    
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

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getWagersid() {
        return wagersid;
    }

    public void setWagersid(String wagersid) {
        this.wagersid = wagersid == null ? null : wagersid.trim();
    }

    public String getJptypeid() {
        return jptypeid;
    }

    public void setJptypeid(String jptypeid) {
        this.jptypeid = jptypeid == null ? null : jptypeid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getWagersdate() {
        return wagersdate;
    }

    public void setWagersdate(Date wagersdate) {
        this.wagersdate = wagersdate;
    }

    public BigDecimal getJpamount() {
        return jpamount;
    }

    public void setJpamount(BigDecimal jpamount) {
        this.jpamount = jpamount;
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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin == null ? null : admin.trim();
    }

    public Integer getLiveId() {
        return liveId;
    }

    public void setLiveId(Integer liveId) {
        this.liveId = liveId;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName == null ? null : liveName.trim();
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