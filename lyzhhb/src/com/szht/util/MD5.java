package com.szht.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;
@Component
public class MD5 {
    public String md5(String password,String salt,Integer times)
    {
    	try {
    		SimpleHash simpleHash = new SimpleHash("md5", password, salt, times);
    		return simpleHash.toString(); 
		} catch (Exception e) {
			return null;
		}
 	
    	
    }
}
