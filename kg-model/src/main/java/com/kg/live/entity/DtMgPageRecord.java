package com.kg.live.entity;

import java.util.Date;

public class DtMgPageRecord {
    private Long id;

    private Integer page;

    private Integer pageSize;

    private Integer lastPageCheckTimes;

    private Integer yesterdayCheckStatus;

    private String rounddate;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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