package com.szht.model;

public class Bc {
    private Integer id;

    private Integer year;

    private Integer month;

    private Double gmsy;

    private Double ad;

    private Double zl;

    private String dm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getGmsy() {
        return gmsy;
    }

    public void setGmsy(Double gmsy) {
        this.gmsy = gmsy;
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

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm == null ? null : dm.trim();
    }
}