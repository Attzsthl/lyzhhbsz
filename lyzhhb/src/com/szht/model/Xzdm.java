package com.szht.model;

public class Xzdm {
    private Integer id;

    private String dmmc;

    private String hlmc;

    private Integer year;

    private Integer season;

    private String zhenqu;

    private Double ad;

    private Double zl;

    private Double gmsy;

    private Double rjy;

    private String dabiao;

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

    public String getHlmc() {
        return hlmc;
    }

    public void setHlmc(String hlmc) {
        this.hlmc = hlmc == null ? null : hlmc.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getZhenqu() {
        return zhenqu;
    }

    public void setZhenqu(String zhenqu) {
        this.zhenqu = zhenqu == null ? null : zhenqu.trim();
    }

    public Double getAd() {
        return ad;
    }

    public void setAd(Double ad) {
        this.ad = ad;
    }

    public Double getZl() {
        return zl;
    }

    public void setZl(Double zl) {
        this.zl = zl;
    }

    public Double getGmsy() {
        return gmsy;
    }

    public void setGmsy(Double gmsy) {
        this.gmsy = gmsy;
    }

    public Double getRjy() {
        return rjy;
    }

    public void setRjy(Double rjy) {
        this.rjy = rjy;
    }

    public String getDabiao() {
        return dabiao;
    }

    public void setDabiao(String dabiao) {
        this.dabiao = dabiao == null ? null : dabiao.trim();
    }
}