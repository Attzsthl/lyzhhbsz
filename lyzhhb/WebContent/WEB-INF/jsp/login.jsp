<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>溧阳智慧环保</title>
<link rel="shortcut icon" href="images/logo2.png" type="image/x-icon">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	opacity: .10;
}

.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 40%;
	width: 300px;
	height: 250px;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>
<link href="app/css/bootstrap.min.css" rel="stylesheet">
<script src="app/js/jquery-3.1.1.min.js"></script>
<script src="app/js/bootstrap.min.js"></script>
<script type="text/javascript" src="app/js/customjjs.js"></script>
<script type="text/javascript">
	$(function() {

		if (top != self) {
			if (top.location != self.location)
				top.location = self.location;
		}
		ShowDiv('MyDiv', 'fade');
	});
</script>


<style type="text/css">
* {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}
</style>
</head>

<body style="background-image: url('app/img/bgt.png');background-size:cover">
	<div id="main">
	<p style="width:100%;margin-top:80px;font-size: 50px;font-family: SimHei;text-align: center;color: white;">溧阳市智慧环保信息化管理平台</p>
	<p style="width:100%;margin-top:400px;font-size: 25px;font-family: KaiTi;text-align: center;color: white;">溧阳市环境保护局</p>
		<div id="MyDiv" class="white_content">
			<div style="margin-top: 30px; margin-left: 25px; width: 250px;">
				<form method="post" action="login.action">
					<h5>登录</h5>
					<div class="input-group" style="margin-top: 30px">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-user"> </span>
						</span> <input type="text" class="form-control" name="username"
							placeholder="用户名" aria-describedby="sizing-addon2">
					</div>

					<div class="input-group" style="margin-top: 10px">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-lock"> </span>
						</span> <input type="password" class="form-control" name="password"
							placeholder="密码" aria-describedby="sizing-addon2">
					</div>

					<div style="margin-top: 10px; float: right;">
						<span id="result">${result}</span>
						<button type="submit" class="btn btn-info">登录</button>
						<!-- 							<button id="register" type="button" class="btn btn-success" onclick="ShowDiv('regieterdiv','fade2')">注册</button> -->
					</div>
				</form>
			</div>
		</div>



		<div id="fade" class="black_overlay"></div>



	</div>
</body>
</html>
