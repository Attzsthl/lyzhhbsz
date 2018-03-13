package com.szht.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import com.szht.model.User;

@Component
public class Log {
	@Resource
	Parmeters parmeters;
	public void writelog(String type,String aim,String dis) throws IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date datename=new java.util.Date();  
		String str=sdf.format(datename);  
		String filepathString=parmeters.getUrl()+"\\BlogLog\\"+str+"log.txt";
		System.out.println(filepathString);
		File dir=new File(filepathString);
		
        //判断目标文件所在的目录是否存在  
        if(!dir.getParentFile().exists()) {  
            //如果目标文件所在的目录不存在，则创建父目录  
            System.out.println("目标文件所在目录不存在，准备创建它！");  
            if(!dir.getParentFile().mkdirs()) {  
                System.out.println("创建目标文件所在目录失败！");  
            }  
        }  
        if(!dir.exists()){  
            if (dir.createNewFile()) {  
                System.out.println("创建单个文件" + dir + "成功！");  
            } else {  
                System.out.println("创建单个文件" + dir + "失败！");  
            }
        }

        FileWriter fileWriter=new FileWriter(dir,true);
        
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		User user = (User) subject.getPrincipal();
        
		Date date=new Date();
		fileWriter.write("[Time："+DateToString.dateToString(date)+"]\t[Type："+type+"]\t[受操作目标："+aim+"]\t[操作者："+(null!=user?user.getUsercode():"未登录")+"]\t[描述："+dis+"]\r\n");
		fileWriter.flush();
	}
	
	public void writelog(String type,String aim,String dis,String filepath) throws IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date datename=new java.util.Date();  
		String str=sdf.format(datename);  
		String filepathString=parmeters.getUrl()+"\\BlogLog\\"+str+filepath;
		File dir=new File(filepathString);
		
        //判断目标文件所在的目录是否存在  
        if(!dir.getParentFile().exists()) {  
            //如果目标文件所在的目录不存在，则创建父目录  
            System.out.println("目标文件所在目录不存在，准备创建它！");  
            if(!dir.getParentFile().mkdirs()) {  
                System.out.println("创建目标文件所在目录失败！");  
            }  
        }  
        if(!dir.exists()){  
            if (dir.createNewFile()) {  
                System.out.println("创建单个文件" + dir + "成功！");  
            } else {  
                System.out.println("创建单个文件" + dir + "失败！");  
            }
        }

        FileWriter fileWriter=new FileWriter(dir,true);
        
//		//从shiro的session中取activeUser
//		Subject subject = SecurityUtils.getSubject();
//		//取身份信息
//		User user = (User) subject.getPrincipal();
        
		Date date=new Date();
		fileWriter.write("[Time："+DateToString.dateToString(date)+"]\t[Type："+type+"]\t["+aim+"]\r\n");
		fileWriter.flush();
	}
}
