package com.szht.util;

import org.springframework.stereotype.Component;

@Component
public class Parmeters {
private String url="C:\\Program Files\\Apache Software Foundation\\zhhbtemp";
//private String url="C:\\Users\\宋子江\\Desktop\\智慧环保temp";
public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

}
