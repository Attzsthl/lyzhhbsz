package com.szht.model;

public class Bcinfo {
    private Integer id;

    private String dmmc;

    private Integer mubiao;

    private String hlmc;

    private String dmlb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDmmc() {
        return dmmc;
    }

    public void setDmmc(String dmmc) {
        this.dmmc = dmmc == null ? null : dmmc.trim();
    }

    public Integer getMubiao() {
        return mubiao;
    }

    public void setMubiao(Integer mubiao) {
        this.mubiao = mubiao;
    }

    public String getHlmc() {
        return hlmc;
    }

    public void setHlmc(String hlmc) {
        this.hlmc = hlmc == null ? null : hlmc.trim();
    }

    public String getDmlb() {
        return dmlb;
    }

    public void setDmlb(String dmlb) {
        this.dmlb = dmlb == null ? null : dmlb.trim();
    }
}