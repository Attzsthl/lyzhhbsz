package com.szht.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.szht.dao.UserMapper;
import com.szht.model.User;
import com.szht.model.custom.BcCustom;
import com.szht.service.Toexampleservice;

@Controller
public class MenuController {	
    @RequestMapping("jump.action")//跳板
    public String jump(Model model)
    {    	
        return "WEB-INF/jsp/jump.jsp";
    }
    @RequestMapping("bcfenxi.action")//区域补偿相关指标分析
    public String bcfenxi()
    {    	
        return "WEB-INF/html/bcfenxi.html";
    }

    @RequestMapping("testpermission.action")//权限测试action
    public void testpermission(HttpServletRequest request,HttpServletResponse response,String permission,String timecheck)
    { 
    	System.out.println(permission+","+timecheck);
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		
		String result="";
		if(!subject.isAuthenticated()){
			result="null";
		}else if(subject.isPermitted(permission)){
			result="true";
		}else{
			result="false";
		}

		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().write(result);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    @RequestMapping("index.action")//总页面
    public String index(Model model)
    {    	
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		//User user = (User) subject.getPrincipal();
		//通过model传到页面
		//model.addAttribute("time", new Date());
    	//System.out.println("index.action");
		if(!subject.isAuthenticated()){
    		model.addAttribute("result", "请登录");
    		subject.logout();
            return "WEB-INF/jsp/login.jsp";
		}
		else if(!subject.isPermitted("user")){
    		model.addAttribute("result", "账户未启用，请联系管理员");
    		subject.logout();
            return "WEB-INF/jsp/login.jsp";
    	}else {
    		return "WEB-INF/html/index.html";
		}

    	
    	
        
    }

    @RequiresPermissions("super")
    @RequestMapping("houtai.action")//后台管理
    public String houtai(Model model)
    {    	
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		User user = (User) subject.getPrincipal();
		//通过model传到页面
		model.addAttribute("user", user);
        return "WEB-INF/jsp/index.jsp";
    }
    
    @RequestMapping("getusername.action")//获取用户
    public void getusername(HttpServletRequest request,HttpServletResponse response)
    {    
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		User user = (User) subject.getPrincipal();

		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().write(user.getUsername());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

    }

	@Resource
	UserMapper userMapper;
	@Resource
	Toexampleservice toexampleservice;
    @RequestMapping("login.action")//登录
    public String login(HttpServletRequest request,Model model,String locateurl) throws Exception
    { 

/*    	UserCustom user=new UserCustom();
    	user.setUsercode("admin");
    	List<User> userList=userMapper.selectByExample(toexampleservice.usertoexample(user));
    	System.out.println(userList);*/
    	System.out.println("进入登录action!");
    	Subject subject=SecurityUtils.getSubject();
    	subject.logout();
		String result="";
		
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				result="账号不存在";
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				result="密码错误";
			} else if("randomCodeError".equals(exceptionClassName)){
				result="验证码错误 ";
			}else {
				result="请重试";//最终在异常处理器生成未知错误
			}
		}
		System.out.println("登录页面获取locateurl"+locateurl);
		model.addAttribute("result", result);
		model.addAttribute("locateurl", locateurl);
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面
        return "WEB-INF/jsp/login.jsp";
    }
    @RequiresPermissions("super")
    @RequestMapping("UserList.action")//UserList
    public String UserList()
    {
        return "WEB-INF/jsp/UserList.jsp";
    }
    @RequiresPermissions("super")
    @RequestMapping("UserPermissionList.action")//UserPermissionList
    public String UserPermissionList()
    {
        return "WEB-INF/jsp/UserPermissionList.jsp";
    }
    
    @RequiresPermissions("super")
    @RequestMapping("ProblemsList.action")//UserPermissionList
    public String ProblemsList()
    {
        return "WEB-INF/jsp/ProblemsList.jsp";
    }
    

    @RequestMapping("article.action")//UserPermissionList
    public String article()
    {
        return "WEB-INF/html/article.html";
    }
    
    @RequestMapping("article2.action")//UserPermissionList
    public String article2()
    {
        return "WEB-INF/html/article2.html";
    }
    
    @RequestMapping("dibiaoshui.action")//UserPermissionList
    public String dibiaoshui()
    {
        return "WEB-INF/html/dibiaoshui.html";
    }
    
    @RequestMapping("kongqi.action")//UserPermissionList
    public String kongqi()
    {
        return "WEB-INF/html/kongqi.html";
    }
    
    @RequestMapping("bcList.action")//UserPermissionList
    public String bcList()
    {
        return "WEB-INF/jsp/BcList.jsp";
    }
    @RequestMapping("JcdmList.action")
    public String JcdmList()
    {
        return "WEB-INF/jsp/JcdmList.jsp";
    }

    @RequestMapping("XzdmList.action")
    public String XzdmList()
    {
        return "WEB-INF/jsp/XzdmList.jsp";
    }
    
    @RequestMapping("log.action")
    public String log()
    {
        return "WEB-INF/html/log.html";
    }
    
    @RequestMapping("404.action")//404
    public String notfond()
    {
        return "WEB-INF/jsp/404.jsp";
    }
    
    @RequestMapping("500.action")//500
    public String errorpage()
    {
        return "WEB-INF/jsp/500.jsp";
    }
    @RequestMapping("logshow.action")//500
    public String logshow(Model model,String uninput)
    {
    	model.addAttribute("uninput",uninput);
        return "WEB-INF/jsp/logshow.jsp";
    }
}
