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
    
    <title>用户权限管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>

	</style>
	
    <link href="app/css/bootstrap.min.css" rel="stylesheet">
    <link href="app/css/customstyle.css" rel="stylesheet">
    <link rel="shortcut icon" href="app/img/favicon.ico" type="image/x-icon" />
    <script src="app/js/jquery-3.1.1.min.js"></script>
	<script src="app/js/bootstrap.min.js"></script>
	<script src="app/js/customjjs.js"></script> 


<script type="text/javascript">
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
$().ready(

reload("",ad)

);

function reload(json,funreload)
{
	 $("#main").html("");
	$.post("selectUserPermission.action",(issearch?searchjson:json),function(data,textStatus)
	{
		var totalrow=0;
		for(var i in data)
		{

		$("#main").append('<tr style="display:none;">'+
							'<td id="id" style="word-break:break-all;display:none;">'+data[i].id+'</td>'+
							'<td id="usercode" style="word-break:break-all">'+data[i].usercode+'</td>'+
							'<td id="permission" style="word-break:break-all">'+data[i].permission+'</td>'+
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
		json+="\"permission\":\""+$("#searchpermission").val()+"\","; 
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
 

	
	function appendline(){
		$("#main").prepend(
		"<tr>"+
			"<td id='id' style='display:none;'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='usercode'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='permission'><input type='text' style='width:100%; height:100%;'/></td>"+
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
				
	        $.post("updateUserPermission.action",getRseData(),function(data,textStatus){
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
	 $.post("deleteUserPermission.action",{ id : selected },function(data,textStatus){
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
					jsonStr+="\"id\":\""+$this.find("#id").html()+"\",";
					jsonStr+="\"usercode\":\""+$this.find("#usercode").html()+"\",";
					jsonStr+="\"permission\":\""+$this.find("#permission").html()+"\",";
			    
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
	<div id="tou" style="">用户权限管理</div>
		<h5>查询条件：</h5>

		<div class="input-group" style="margin-bottom: 10px">
  		  <%--<span class="input-group-addon" id="sizing-addon2">id</span><input id="searchid" type="text" class="form-control" placeholder="id" aria-describedby="sizing-addon2">
  		  --%><span class="input-group-addon" id="sizing-addon2">usercode</span><input id="searchusercode" type="text" class="form-control" placeholder="usercode" aria-describedby="sizing-addon2">
  		  <span class="input-group-addon" id="sizing-addon2">permission</span><input id="searchpermission" type="text" class="form-control" placeholder="permission" aria-describedby="sizing-addon2">
		</div>

		<div>
			<button id="search" onclick="search()" type="button" class="btn btn-success" style="margin-bottom: 10px">查询</button>
			<button id="search" onclick="searchall()" type="button" class="btn btn-success" style="margin-bottom: 10px">查询全部</button>
		</div>
		<div id="tools">
			<!-- 增加 -->
			<a href="javascript:append()"><span class="glyphicon glyphicon-plus icon"/></a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 编辑 -->
			<a href="javascript:edit()"><span class="glyphicon glyphicon-pencil icon"/></a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 删除 -->
			<a href="javascript:remove()"><span class="glyphicon glyphicon-remove icon" style="color:#CE0000"/></a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 保存 -->
			<a href="javascript:save(ad)"><span class="glyphicon glyphicon-ok icon"/></a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 取消 -->
			<a href="javascript:cancel()"><span class="glyphicon glyphicon-share-alt icon"/></a>
			<a href="javascript:checklast()" style="float: right">查看过程操作</a>
			<p style="float: right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<a href="javascript:checknumber()" style="float: right">查看选中行数</a>
		</div>
		<div>
		
	<table id="table" class="table table-bordered "><!-- table-hover -->
		<thead>
			<tr>
				<th style="display: none;">id</th>
				<th>usercode</th>
				<th>permission</th>
			</tr>
		</thead>
		<tbody id="main">
		</tbody>
	</table>
		<div>
			<div style="float: left">
				<button onclick="lastpage()">
				上一页
				</button>
				<button onclick="nextpage()">
				下一页
				</button>
			</div>
			<div style="float: left;margin-left: 10px;margin-top: 5px">
				<p id="currentpage" style="display:inline"></p>/<p id="totalpage" style="display:inline"></p>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
