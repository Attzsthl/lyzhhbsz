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
    
    <title>登录用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>

	</style>
	
    <link href="app/css/bootstrap.min.css" rel="stylesheet">
    <link href="app/css/customstyle.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
    <link rel="shortcut icon" href="app/img/favicon.ico" type="image/x-icon" />
    <script src="app/js/jquery-3.1.1.min.js"></script>
	<script src="app/js/bootstrap.min.js"></script>
	<script src="app/js/customjjs.js"></script> 


<script type="text/javascript">
function newusercode2(){
	if($("#newpassword").val()!=$("#newpassword2").val())
		{
			alert("两次密码不同！");
		}
		else if(!checkusercode($("#newusercode").val()))
			{
			alert("账户允许是30位以内的字母和数字");
			}
		else
			{
			$.post("updateUser.action",getNewUserData(),function(data,textStatus){
				
				if(data=="操作成功")
					CloseDiv('MyDiv','fade');
				else
					alert(data);
				reload("",ad);
				}
				
		 		,"text");
			}
	}
	function getNewUserData() {
	    var jsonStr = "{"; // json格式开始
	    jsonStr+="\"usercode\":\""+$("#newusercode").val()+
	    		 "\",\"username\":\""+$("#newusername").val()+
	    		 "\",\"password\":\""+$("#newpassword").val()+
	    		 /* "\",\"generation\":\"" +$("#newrabbitkind").val() + */
	    		 "\"}"; 
	    var jsonObj = jQuery.parseJSON(jsonStr);
	    return jsonObj;
	}
	function checkusercode(usercode){
		
		if(usercode.match(/^(\w{1,30})$/)==null)
			return false;
		else
			return true;
	}

function check()
{
<%--	if($this.find("#identity input").val()=="")--%>
<%--		{--%>
<%--			alert("请输入编号，如果出现两只相同编号的兔子可能会导致未知错误！");--%>
<%--			return false;--%>
<%--		}--%>
<%--	else if(!checkdata($this.find("#birthday input").val())&&$this.find("#birthday input").val()!="")--%>
<%--		{--%>
<%--			alert("生日格式例如：1995-09-30");--%>
<%--			return false;--%>
<%--		}--%>
<%--	else if($this.find("#sex input").val()!="公"&&$this.find("#sex input").val()!="母"&&$this.find("#sex input").val()!="")--%>
<%--		{--%>
<%--			alert("性别请输入“公”或者“母”");--%>
<%--			return false;--%>
<%--		}--%>
<%--	else--%>
		return true;

}

function searchcheck()
{
<%--	if(!checkdata($("#Birthday").val())&&$("#Birthday").val()!="")--%>
<%--	{--%>
<%--		alert("生日格式例如：1995-09-30");--%>
<%--		return false;--%>
<%--	}--%>
<%--	else if($("#Sex").val()!="公"&&$("#Sex").val()!="母"&&$("#Sex").val()!="")--%>
<%--	{--%>
<%--		alert("性别请输入“公”或者“母”");--%>
<%--		return false;--%>
<%--	}--%>
	return true;

}


</script>
<script type="text/javascript">
var permissionlist=["user","super"];
$().ready(

reload("",ad)

);
function chongzhi(id){
	var msg = "您真的确定要重置密码为123456吗？\n\n请确认！";
	if (confirm(msg)==false){
		return;
	}
	$.post("chongzhi.action",{id:id},function(result){
		alert(result);
	},"text");
}
function showpermission(usercode){
	ShowDiv('permissiondiv','fade');
	$("#usercodeh4").html(usercode);
	$("#permissoncontent").html("");
	$.post("selectUserPermission.action",{usercode:usercode},function(result){
		var mycars=new Array();
		console.log(result);
		for(var i in result){
			mycars[i]=result[i].permission;
		}
		for(var i in permissionlist){
			$("#permissoncontent").append('<input name="perm" id="'+permissionlist[i]+'" class="permissioninput" '+($.inArray(permissionlist[i], mycars)!=-1?'checked="checked" ':'')+'type="radio">'+'&nbsp;&nbsp;&nbsp;<span style="font-size:20px;font-family:'+"'YouYuan';"+'">'+permissionlist[i]+'</span>'+'<br><br>');
			//$("#permissoncontent").append('<label><input id="'+permissionlist[i]+'" class="permissioninput" '+($.inArray(permissionlist[i], mycars)!=-1?'checked="checked" ':'')+'type="checkbox"><span></span></label>'+'&nbsp;&nbsp;&nbsp;<span style="font-size:20px;font-family:'+"'YouYuan';"+'">'+permissionlist[i]+'</span>'+'<br><br>');
		}
		$(".permissioninput").click(function(){
			//$(".permissioninput").attr('checked',false);
			//$(this).siblings().each(function(){
			//	alert($(this).attr('id'));
			//});
		});
	},"json");
}
function submitpermission(){
	var permissions="";
	permissions+=$("#usercodeh4").html()+"-";
	$(".permissioninput:checked").each(function(){
		permissions+=$(this).attr("id")+"-";
	});
	
	$.post("newpermission.action",{permissions:permissions},function(result){
		alert(result);
		CloseDiv('permissiondiv','fade');
	},"text");
}
function changeuserinfo(id){
	
	$.post("selectUser.action",{id:id},function(result){
		console.log(result);
		$("#changeid").val(result[0].id);
		$("#changeusername").val(result[0].username);
		$("#changepassword").val(result[0].password2);
		ShowDiv('changeuserinfo','fade');
	},"json");
	
}
function getchangeuserinfo2json(){
    var jsonStr = "{"; // json格式开始
    jsonStr+="\"id\":\""+$("#changeid").val()+"\",";
	jsonStr+="\"username\":\""+$("#changeusername").val()+"\",";
	jsonStr+="\"password2\":\""+$("#changepassword").val()+"\",";

	if(jsonStr[jsonStr.length-1]==",")
	jsonStr=jsonStr.substr(0,jsonStr.length-1);
	jsonStr+="}";
	var jsonObj = jQuery.parseJSON(jsonStr);
	return jsonObj;
}
function changeuserinfo2(){
	$.post("changeuserinfo.action",getchangeuserinfo2json(),function(result){
		alert(result);
		reload("",ad);
		if(result=="操作成功"){
			CloseDiv('changeuserinfo','fade');
		}
	},"text");
	
}
function reload(json,funreload)
{
	 $("#main").html("");
	$.post("selectUser.action",(issearch?searchjson:json),function(data,textStatus)
	{
		var totalrow=0;
		for(var i in data)
		{

		$("#main").append('<tr style="display:none;">'+
							'<td id="id" style="word-break:break-all;display:none;">'+data[i].id+'</td>'+
							'<td id="usercode" style="word-break:break-all">'+data[i].usercode+'</td>'+
							//'<td id="password" style="word-break:break-all">'+data[i].password+'</td>'+
							'<td id="username" style="word-break:break-all">'+data[i].username+'</td>'+
							'<td id="logtimes" style="word-break:break-all">'+data[i].logtimes+'</td>'+
							'<td id="lasttime" style="word-break:break-all">'+data[i].lasttime+'</td>'+
							'<td id="createtime" style="word-break:break-all">'+data[i].createtime+'</td>'+
							//'<td id="chongzhi" style="word-break:break-all"><a href="javascript:chongzhi('+data[i].id+')">重置密码</a></td>'+
							'<td id="chongzhi" style="word-break:break-all"><a href="javascript:changeuserinfo('+data[i].id+')">修改账号信息</a></td>'+
							
							'<td id="showpermission" style="word-break:break-all"><a href="javascript:showpermission('+"'"+data[i].usercode+"'"+')">权限管理</a></td>'+
							'</tr>');
							totalrow++;
		}
							totalpage=Math.ceil(totalrow/pagerow);
							$("#totalpage").html(totalpage);
							if(last=="search"||last=="searchall")
							{
								currentpage=1;
							}
							showpage(currentpage);
							$("#currentpage").html(currentpage);
							
							selectedrow=-1;
		$("#main tr").click(function()
		{
   			if(isedit&&selectedrow!=$(this).index())
			{
				if(!save(ad)) 
				return;
			}
			selectedrow=$(this).index();
			$this=$("#main tr:eq("+$(this).index()+")");
			selected=$this.children("#id").html();
			
			$(this).addClass("trclick");
			$(this).siblings().removeClass("trclick");
 		});
 		
 		$("#main tr").dblclick(function()
		{
 			return;
			edit();
		});
		
		last="reload";
		allop+="reload;";
		funreload();
		
	},"json"); 
	
}



function search(){
	if(!searchcheck())
		return;
	var json="{";
		//json+="\"id\":\""+$("#searchid").val()+"\","; 
		json+="\"usercode\":\""+$("#searchusercode").val()+"\","; 
		//json+="\"password\":\""+$("#searchpassword").val()+"\","; 
		json+="\"username\":\""+$("#searchusername").val()+"\","; 
		json+="\"logtimes\":\""+$("#searchlogtimes").val()+"\","; 
		//json+="\"lasttime\":\""+$("#searchlasttime").val()+"\","; 
		//json+="\"createtime\":\""+$("#searchcreatetime").val()+"\","; 
	if(json[json.length-1]==",")
	json=json.substr(0,json.length-1);
	json+="}";
	var jsonFinal =  $.parseJSON(json);
	issearch=true;
	last="search";
	searchjson=jsonFinal;
	reload(jsonFinal,ad);
}

 
 
 </script>
 <script type="text/javascript">
 
//新增用户
	
	function appendline(){
		return;
		$("#main").prepend(
		"<tr>"+
			//"<td id='id'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='usercode'><input type='text' style='width:100%; height:100%;'/></td>"+
			//"<td id='password'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='username'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='logtimes'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='lasttime'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='createtime'><input type='text' style='width:100%; height:100%;'/></td>"+
		"</tr>"
		);
		
		$("tbody tr:first").click(function(){
			if(isedit&&selectedrow!=$(this).index())
			{
				if(!save(ad))
				return;
			}	 
			selectedrow=$(this).index();
			$this=$("#main tr:eq("+$(this).index()+")");
			selected=$this.children("#id").html();

			$(this).addClass("trclick");
			$(this).siblings().removeClass("trclick");
		
		});
		//选中最后一行
			selectedrow=$("tbody tr:first").index();
			$this=$("#main tr:eq("+selectedrow+")");
			selected=$this.children("#id").html();
			$this.addClass("trclick");
			$this.siblings().removeClass("trclick");
			//处于编辑状态
			isedit=true;
			//上一步操作为append
			last="append";
			allop+="append;";
			return;
	
	}
	
	//保存
	function save(funsave) 
	{
		return;
		if(!isedit||selectedrow==-1)
			return false;
	 	if(!check())
		{
			return false;	
		} 
		isedit=false;
		selectedrow=-1;
		$this.children().each(function() {
	        obj_text = $(this).find("input:text");    // 判断单元格下是否有文本框                   
	        if(obj_text.length)
	            $(this).html(obj_text.val()); 
	            }); 
				
	        $.post("updateUser.action",getRseData(),function(data,textStatus){
			reload("",function(){
			last="save";
		 	allop+="save;";	
		 	if(data!=1)
		 		alert(data);
		 	funsave();	 	
			});	 		
	 		},"text");  
	 	return true;
	}
				//删除
	function remove() {
		if(selectedrow==-1)
		{
			alert("请选择一行后再进行操作");
			return;
		}
		var msg = "您真的确定要删除吗？\n\n请确认！";
		if (confirm(msg)==false){
			return;
		}
	 $.post("deleteUser.action",{ id : selected },function(data,textStatus){
		isedit=false;
		selectedrow=-1;
		if(data!=1)
			alert(data);
		reload("",ad);
	 },"text");
	 last="delete";
	 allop+="delete;";
	}

    
        function getRseData() {
			    var jsonStr = "{"; // json格式开始
					//jsonStr+="\"id\":\""+$this.find("#id").html()+"\",";
					jsonStr+="\"usercode\":\""+$this.find("#usercode").html()+"\",";
					//jsonStr+="\"password\":\""+$this.find("#password").html()+"\",";
					jsonStr+="\"username\":\""+$this.find("#username").html()+"\",";
					jsonStr+="\"logtimes\":\""+$this.find("#logtimes").html()+"\",";
					//jsonStr+="\"lasttime\":\""+$this.find("#lasttime").html()+"\",";
					//jsonStr+="\"createtime\":\""+$this.find("#createtime").html()+"\",";
			    
				if(jsonStr[jsonStr.length-1]==",")
				jsonStr=jsonStr.substr(0,jsonStr.length-1);
				jsonStr+="}";
			    var jsonObj = jQuery.parseJSON(jsonStr);
			    return jsonObj;
	}
	

	</script>

</head>
<body>
	
	<div id="mainwindow">	
	<div id="tou" style="">用户管理</div>
		<h5>查询条件：</h5>

		<div class="input-group" style="margin-bottom: 10px"><%--
  		  <span class="input-group-addon" id="sizing-addon2">id</span><input id="searchid" type="text" class="form-control" placeholder="id" aria-describedby="sizing-addon2">
  		  --%><span class="input-group-addon" id="sizing-addon2">账号</span><input id="searchusercode" type="text" class="form-control" placeholder="usercode" aria-describedby="sizing-addon2">
  		  <%--<span class="input-group-addon" id="sizing-addon2">password</span><input id="searchpassword" type="text" class="form-control" placeholder="password" aria-describedby="sizing-addon2">
  		  --%><span class="input-group-addon" id="sizing-addon2">使用者</span><input id="searchusername" type="text" class="form-control" placeholder="username" aria-describedby="sizing-addon2">
  		  <input id="searchlogtimes" type="hidden" class="form-control" placeholder="logtimes" aria-describedby="sizing-addon2"><%--
  		  <span class="input-group-addon" id="sizing-addon2">lasttime</span><input id="searchlasttime" type="text" class="form-control" placeholder="lasttime" aria-describedby="sizing-addon2">
  		  <span class="input-group-addon" id="sizing-addon2">createtime</span><input id="searchcreatetime" type="text" class="form-control" placeholder="createtime" aria-describedby="sizing-addon2">
		--%></div>

		<div>
			<button id="search" onclick="search()" type="button" class="btn btn-success" style="margin-bottom: 10px">查询</button>
			<button id="search" onclick="searchall()" type="button" class="btn btn-success" style="margin-bottom: 10px">查询全部</button>
		</div>
		<div id="tools">
			<!-- 增加 -->
			<a href="javascript:ShowDiv('MyDiv','fade')"><span class="glyphicon glyphicon-plus icon"/></a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 编辑 --><%--
			<a href="javascript:edit()"><span class="glyphicon glyphicon-pencil icon"/></a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			--%><!-- 删除 -->
			<a href="javascript:remove()"><span class="glyphicon glyphicon-remove icon" style="color:#CE0000"/></a><%-- 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 保存 -->
			<a href="javascript:save(ad)"><span class="glyphicon glyphicon-ok icon"/></a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 取消 -->
			<a href="javascript:cancel()"><span class="glyphicon glyphicon-share-alt icon"/></a>
		--%>
			<a href="javascript:checklast()" style="float: right">查看过程操作</a>
			<p style="float: right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<a href="javascript:checknumber()" style="float: right">查看选中行数</a>
		</div>
		<div>
		
	<table id="table" class="table table-bordered "><!-- table-hover -->
		<thead>
			<tr>

				<th>账号</th>
				<th>使用者</th>
				<th>登陆次数</th>
				<th>最后登录时间</th>
				<th>创建时间</th>
			</tr>
		</thead>
		<tbody id="main">
		</tbody>
	</table>
		<div>
			<div style="float: left">
				<button onclick="showpage(1)">
				首页
				</button>
				<button onclick="lastpage()">
				上一页
				</button>
				<button onclick="nextpage()">
				下一页
				</button>
				<button onclick="showpage(totalpage)">
				末页
				</button>
				&nbsp;
				<button onclick="showpage($('#topage').val())">
				转到第
				</button>
				<input id="topage" style="width: 40px" type="text"/>
				页
			</div>
			<div style="float: left;margin-left: 10px;margin-top: 5px">
				<p id="currentpage" style="display:inline"></p>/<p id="totalpage" style="display:inline"></p>
			</div>
		</div>
	</div>
	</div>
	
	
	
			<div id="fade" class="black_overlay">  
			</div>  
 			 	<div id="permissiondiv" class="white_content" style="height: 230px;">  
					<div style="margin-left: 10px;margin-right: 10px">
					
		  	        <h4 align="center">
		  	      		  账号&nbsp;<span id="usercodeh4"></span>&nbsp;的权限
		            </h4>  
		            <p align="center">
		  	      		  请选择添加删除相应的权限
		            </p>     
		            <div id='permissoncontent'>
		            </div>

			         <div style="float: left;margin-top: 10px;margin-left: 90px">
			          	<button type="button" class="btn btn-primary" onclick="submitpermission()">
				               提交
				        </button>    
			            <button type="button" class="btn btn-default" onclick="CloseDiv('permissiondiv','fade')">
			            	关闭
			            </button>
		 			</div>  
 				</div> 		
		     </div> 
		 	
		 	<div id="MyDiv" class="white_content" style="height: 260px;">  
					<div style="margin-left: 10px;margin-right: 10px">
		  	        <h4 align="center">
		               新增账号
		            </h4>            
					 <div class="input-group newrabbitdiv" style="margin-top: 10px">
					  <span class="input-group-addon" id="basic-addon1">账&nbsp;&nbsp;&nbsp;&nbsp;号</span>
					  <input id="newusercode" type="text" class="form-control" placeholder="UserCode" aria-describedby="basic-addon1">
					</div>
					<div class="input-group newrabbitdiv" style="margin-top: 10px">
					  <span class="input-group-addon" id="basic-addon1">密&nbsp;&nbsp;&nbsp;&nbsp;码</span>
					  <input id="newpassword" type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
					</div>
					<div class="input-group newrabbitdiv" style="margin-top: 10px">
					  <span class="input-group-addon" id="basic-addon1">确认密码</span>
					  <input id="newpassword2" type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
					</div>
					<div class="input-group newrabbitdiv" style="margin-top: 10px">
					  <span class="input-group-addon" id="basic-addon1">使&nbsp;用&nbsp;者</span>
					  <input id="newusername" type="text" class="form-control" placeholder="UserName" aria-describedby="basic-addon1">
					</div>
			        
			         <div style="float: left;margin-top: 10px;margin-left: 90px">
			          	<button type="button" class="btn btn-primary" onclick="newusercode2()">
				               提交
				        </button>    
			            <button type="button" class="btn btn-default" onclick="CloseDiv('MyDiv','fade')">
			            	关闭
			            </button>
		 			</div>  
 				</div> 		
		     </div> 
	
			 	<div id="changeuserinfo" class="white_content" style="height: 180px;">  
					<div style="margin-left: 10px;margin-right: 10px">
		  	        <h4 align="center">
		               修改账号信息
		            </h4>   
		            <input id="changeid" type="hidden">         
					<div class="input-group newrabbitdiv" style="margin-top: 10px">
					  <span class="input-group-addon" id="basic-addon1">密&nbsp;&nbsp;&nbsp;&nbsp;码</span>
					  <input id="changepassword" type="text" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
					</div>
					<div class="input-group newrabbitdiv" style="margin-top: 10px">
					  <span class="input-group-addon" id="basic-addon1">使&nbsp;用&nbsp;者</span>
					  <input id="changeusername" type="text" class="form-control" placeholder="UserName" aria-describedby="basic-addon1">
					</div>
			        
			         <div style="float: left;margin-top: 10px;margin-left: 90px">
			          	<button type="button" class="btn btn-primary" onclick="changeuserinfo2()">
				               提交
				        </button>    
			            <button type="button" class="btn btn-default" onclick="CloseDiv('changeuserinfo','fade')">
			            	关闭
			            </button>
		 			</div>  
 				</div> 		
		     </div> 
	
	
			<div id="toolspop" class="customtoolspop">提示</div>
		<script src="app/js/toolspop.js"></script>
</body>
</html>
