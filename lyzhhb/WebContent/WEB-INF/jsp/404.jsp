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
<head>
	<title>404 Not Found</title>
	<link rel="shortcut icon" href="images/logo2.png" type="image/x-icon">
	<link href="app/css/style.css" rel='stylesheet' type='text/css'/>

		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Custom Error Page Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body style="font-family: 微软雅黑">
	<div class="top-bar-agile">
		<div class="logo-agileits">
			<img src="app/img/logo.png" alt=" " />
		</div>
		<div class="nav-agileinfo">
			<ul>
				<li><a href="index.action">首页</a></li><%--
				<li><a href="aboutjack.action">关于Jack</a></li>
				<li><a href="article.action">文章</a></li>
				<li><a href="message.action">留言</a></li>
			--%></ul>
		</div>
		<div class="clear"></div>
	</div>

	<div class="content-w3">
		<h1>404</h1>
		<h2>Not Found</h2>
		<p>The page you are looking for has been removed,had its name changed or temporarily unavailable</p>	
	</div><%--

	<iframe scrolling='no' frameborder='0' src='http://yibo.iyiyun.com/Home/Distribute/ad404/key/1326220' width='654' height='470' style='display:block;margin:auto;'></iframe>
	--%><div class="footer-w3ls">
		<div><%--
			<h5 align="center" style="margin-top: 50px;"><img src="app/img/jacksunglogo2.png" width="25px;" height="25px;" />&nbsp;&nbsp;&nbsp;
			Copyright2017 jacksung All Rights Reserved </br>
			</h5>

		--%></div>
	</div>
</body>
</html>
