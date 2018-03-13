package com.szht.model.custom;
import com.szht.model.Bc;
import com.szht.model.Bcinfo;
import com.szht.model.Bctbhb;
public class BcinfoCustom extends com.szht.model.Bcinfo{
	String shuizhi;
	String mubiaoshuizhi;

	String dabiao;
	Bctbhb bctbhb;
	
	Integer muqianshuizhiInteger;
	Bc bc;
	
	public Integer getMuqianshuizhiInteger() {
		return muqianshuizhiInteger;
	}
	public void setMuqianshuizhiInteger(Integer muqianshuizhiInteger) {
		this.muqianshuizhiInteger = muqianshuizhiInteger;
	}
	public Bc getBc() {
		return bc;
	}
	public void setBc(Bc bc) {
		this.bc = bc;
	}
	public Bctbhb getBctbhb() {
		return bctbhb;
	}
	public void setBctbhb(Bctbhb bctbhb) {
		this.bctbhb = bctbhb;
	}
	Bcinfo bcinfo;
	public Bcinfo getBcinfo() {
	return bcinfo;}
	public String getShuizhi() {
		return shuizhi;
	}
	public void setShuizhi(String shuizhi) {
		this.shuizhi = shuizhi;
	}
	public String getDabiao() {
		return dabiao;
	}
	public void setDabiao(String dabiao) {
		this.dabiao = dabiao;
	}
	public void setBcinfo(Bcinfo bcinfo) {
	this.bcinfo = bcinfo;}
	public String getMubiaoshuizhi() {
		return mubiaoshuizhi;
	}
	public void setMubiaoshuizhi(String mubiaoshuizhi) {
		this.mubiaoshuizhi = mubiaoshuizhi;
	}
}
