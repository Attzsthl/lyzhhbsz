package com.szht.model;

public class Bctbhb {
    private Integer id;

    private String dmmc;

    private Integer year;

    private Integer month;

    private Double gmsytb;

    private Double adtb;

    private Double zltb;

    private Double gmsyhb;

    private Double adhb;

    private Double zlhb;

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

    public Double getGmsytb() {
        return gmsytb;
    }

    public void setGmsytb(Double gmsytb) {
        this.gmsytb = gmsytb;
    }

    public Double getAdtb() {
        return adtb;
    }

    public void setAdtb(Double adtb) {
        this.adtb = adtb;
    }

    public Double getZltb() {
        return zltb;
    }

    public void setZltb(Double zltb) {
        this.zltb = zltb;
    }

    public Double getGmsyhb() {
        return gmsyhb;
    }

    public void setGmsyhb(Double gmsyhb) {
        this.gmsyhb = gmsyhb;
    }

    public Double getAdhb() {
        return adhb;
    }

    public void setAdhb(Double adhb) {
        this.adhb = adhb;
    }

    public Double getZlhb() {
        return zlhb;
    }

    public void setZlhb(Double zlhb) {
        this.zlhb = zlhb;
    }
}