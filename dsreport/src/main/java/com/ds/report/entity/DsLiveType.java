package com.ds.report.entity;

public class DsLiveType {
    private Byte id;

    private String liveName;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName == null ? null : liveName.trim();
    }
}