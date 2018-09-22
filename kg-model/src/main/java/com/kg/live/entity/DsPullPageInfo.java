package com.kg.live.entity;

import java.util.Date;

public class DsPullPageInfo {
    private Integer pageNum;

    private Integer gameKind;

    private Date createTime;

    private Integer gameType;

    private Date pageDate;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getGameKind() {
        return gameKind;
    }

    public void setGameKind(Integer gameKind) {
        this.gameKind = gameKind;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public Date getPageDate() {
        return pageDate;
    }

    public void setPageDate(Date pageDate) {
        this.pageDate = pageDate;
    }
}