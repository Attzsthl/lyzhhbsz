package com.szht.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {
	/** 
	   * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br> 
	   * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br> 
	   * @param time Date 日期<br> 
	   * @return String   字符串<br> 
	   */ 
	  

	public static String dateToString(Date time){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
	    String ctime = formatter.format(time); 

	    return ctime; 
	} 
}
