package com.ds.chess.entity;

import java.util.Date;

public class DsKyRecordTime {
    private String agent;

    private Date lastGetRecordTime;

    private Date lastUpdateTime;

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public Date getLastGetRecordTime() {
        return lastGetRecordTime;
    }

    public void setLastGetRecordTime(Date lastGetRecordTime) {
        this.lastGetRecordTime = lastGetRecordTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}