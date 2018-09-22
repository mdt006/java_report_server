package com.ds.sgs.entity;

import java.util.Date;

public class DsSgsRecordTime {
    private Integer id;

    private String clientSecret;

    private Date lastGetRecordTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret == null ? null : clientSecret.trim();
    }

    public Date getLastGetRecordTime() {
        return lastGetRecordTime;
    }

    public void setLastGetRecordTime(Date lastGetRecordTime) {
        this.lastGetRecordTime = lastGetRecordTime;
    }
}