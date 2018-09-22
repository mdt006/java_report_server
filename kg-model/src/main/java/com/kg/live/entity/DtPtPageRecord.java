package com.kg.live.entity;

import java.util.Date;

public class DtPtPageRecord {
    private Long id;

    private Integer siteId;

    private String agent;

    private Integer page;

    private Integer pageSize;

    private Integer lastPageCheckTimes;

    private Integer yesterdayCheckStatus;

    private String rounddate;

    private String beginTime;

    private String endTime;

    private Integer timeIndex;

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

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLastPageCheckTimes() {
        return lastPageCheckTimes;
    }

    public void setLastPageCheckTimes(Integer lastPageCheckTimes) {
        this.lastPageCheckTimes = lastPageCheckTimes;
    }

    public Integer getYesterdayCheckStatus() {
        return yesterdayCheckStatus;
    }

    public void setYesterdayCheckStatus(Integer yesterdayCheckStatus) {
        this.yesterdayCheckStatus = yesterdayCheckStatus;
    }

    public String getRounddate() {
        return rounddate;
    }

    public void setRounddate(String rounddate) {
        this.rounddate = rounddate == null ? null : rounddate.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getTimeIndex() {
        return timeIndex;
    }

    public void setTimeIndex(Integer timeIndex) {
        this.timeIndex = timeIndex;
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