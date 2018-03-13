package com.szht.model;

import java.util.ArrayList;

 class SeriesCustom
{
    private String name;
    private ArrayList<String> keys;
    private ArrayList<String> data;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getKeys() {
		return keys;
	}
	public void setKeys(ArrayList<String> keys) {
		this.keys = keys;
	}
	public ArrayList<String> getData() {
		return data;
	}
	public void setData(ArrayList<String> data) {
		this.data = data;
	}

}
