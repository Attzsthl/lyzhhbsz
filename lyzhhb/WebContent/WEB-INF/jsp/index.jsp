<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>溧阳智慧环保后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>

	</style>
	
    <link href="app/css/bootstrap.min.css" rel="stylesheet">
    <link href="app/css/custom.css" rel="stylesheet">
    <link rel="shortcut icon" href="app/img/favicon.ico" type="image/x-icon" />
    <script src="app/js/jquery-3.1.1.min.js"></script>
	<script src="app/js/bootstrap.min.js"></script>
	<script src="app/js/customjs.js"></script> 
	<script type="text/javascript">
	$(function(){
		$("#meunlist li").each(function(){
			$(this).click(function(){
				
				$(this).addClass("active");
				$(this).siblings().removeClass("active");
			});
		});
	});
	function changeiframe(url){
		$("#content").attr("src",url); 
	}
	
	
	</script>


  </head>
  
  <body style="width:1510px">

	
     <div id="meun">  
      
      	<div id="title" style="margin-bottom: 10px;background: url(images/pexels-photo-192136.jpg);-webkit-background-size: 100%; background-size: 100%; background-position: 0 70%;">
      		<img style="margin-top: 5px;height: 80px;margin-left: 30px" src="images/logo2.png" draggable="false">
      		<font style="margin-left:10px;font-size: 40px;font-family: '隶书';">溧阳智慧环保后台管理系统</font>
      		<span style="float: right;margin-right: 10px;margin-top: 20px;color: white;">欢迎你，${user.username}&nbsp;&nbsp;&nbsp;
      		<a href="login.action" style="color: white;">退出系统</a></span>

    	</div><%--
    	<div style="margin-top: 10px;">
			<ul class="nav nav-tabs" id="meunlist" style="margin-left: 10px;">
			  <li role="presentation" class="active" style="margin-left: 250px"><a href="javascript:changeiframe('UserList.action')">用户管理</a></li>
			  
			  <li role="presentation"><a href="javascript:changeiframe('bcList.action')">区域补偿断面数据管理</a></li>
			  <li role="presentation"><a href="javascript:changeiframe('XzdmList.action')">镇区考核断面测数据管理</a></li>
			  <li role="presentation"><a href="javascript:changeiframe('JcdmList.action')">例行监测数据管理</a></li>
			  <li role="presentation"><a href="javascript:changeiframe('ProblemsList.action')">问题反馈</a></li>
			  <li role="presentation"><a href="javascript:changeiframe('log.action')">日志管理</a></li>
			</ul>
		</div>
	     <iframe id="content" src="UserList.action" style="width: 1300px;height: 550px" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes">
	     </iframe>
		--%><div style="width: 170px;height:640px;float: left;margin-left: 30px;margin-top: 0px;border-color:#0000FF;border: 2px solid ;">
			<div>
			<a href="javascript:changeiframe('UserList.action')">用户管理</a>	
			</div>
			<div>
			 <a href="javascript:changeiframe('bcList.action')">区域补偿断面数据管理</a>
			</div>
			<div>
			 <a href="javascript:changeiframe('XzdmList.action')">镇区考核断面测数据管理</a>
			</div>
			<div>
			 <a href="javascript:changeiframe('JcdmList.action')">例行监测数据管理</a>
			</div>
			<div>
			<a href="javascript:changeiframe('ProblemsList.action')">问题反馈</a>
			</div>
			<div>
			<a href="javascript:changeiframe('log.action')">日志管理</a>
			</div>
	  
		</div>
	     <iframe id="content" src="UserList.action" style="margin-left:5px;border-color:#0000FF;border: 2px solid ;width: 1300px;height: 640px" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes">
	     </iframe>
     </div>
  </body>
</html>
