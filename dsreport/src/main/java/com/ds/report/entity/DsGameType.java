package com.ds.report.entity;

public class DsGameType {
    private Integer id;

    private String gameName;

    private String outGameCode;

    private Integer parentId;

    private Byte fkLiveId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public String getOutGameCode() {
        return outGameCode;
    }

    public void setOutGameCode(String outGameCode) {
        this.outGameCode = outGameCode == null ? null : outGameCode.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getFkLiveId() {
        return fkLiveId;
    }

    public void setFkLiveId(Byte fkLiveId) {
        this.fkLiveId = fkLiveId;
    }
}