package com.szht.model;

public class Site {
    private Integer id;

    private String aqi;

    private String co;

    private String ct;

    private String no2;

    private String o3;

    private String o38h;

    private String pm10;

    private String pm25;

    private String primaryPollutant;

    private String quality;

    private String siteName;

    private String so2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi == null ? null : aqi.trim();
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co == null ? null : co.trim();
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct == null ? null : ct.trim();
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2 == null ? null : no2.trim();
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3 == null ? null : o3.trim();
    }

    public String getO38h() {
        return o38h;
    }

    public void setO38h(String o38h) {
        this.o38h = o38h == null ? null : o38h.trim();
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10 == null ? null : pm10.trim();
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25 == null ? null : pm25.trim();
    }

    public String getPrimaryPollutant() {
        return primaryPollutant;
    }

    public void setPrimaryPollutant(String primaryPollutant) {
        this.primaryPollutant = primaryPollutant == null ? null : primaryPollutant.trim();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2 == null ? null : so2.trim();
    }
}