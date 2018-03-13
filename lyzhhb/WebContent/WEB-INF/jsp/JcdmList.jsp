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
    
    <title>My JSP 'overview.jsp' starting page</title>
    
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
var zhibiaolist=['andan','diandaolv','flza','fuhuawu','ge','gmsy','gong','huifafen','hxxyl','liuhuawu','liujiage','liuliang','liusuanyan','lvhuawu','ph','qian','rongjieyanng','shen','shiyoulei','shuishen','shuiweng','shxyl','sqdm','xi','xiaosuanyan','xuanfuwu','yxsy','zjhw','zongdan','zongling','zongyingdu'];
function detialinfo(id){
	ShowDiv('infodiv', 'fade');
	$.post("selectJcdm.action",{id:id},function(data){
		$("#infoid").val(data[0].id);
		for(var i in zhibiaolist){
			var str=zhibiaolist[i];
			//str=str.substring(0,1).toUpperCase()+str.substring(1);
			$("#"+str).val(data[0][str]);
		}
	},"json");
}
function saveinfo(){
	$.post("updateJcdm.action",getsavinfojson(),function(result){
		alert(result);
		CloseDiv('infodiv','fade');
	},"text");
}
function getsavinfojson() {
    var jsonStr = "{"; // json格式开始
    jsonStr+="\"id\":\""+$("#infoid").val()+"\",";
    for(var i in zhibiaolist){
    	var st=zhibiaolist[i];
    	jsonStr+="\""+st+"\":\""+$("#"+st).val()+"\",";
    }
		
    
	if(jsonStr[jsonStr.length-1]==",")
	jsonStr=jsonStr.substr(0,jsonStr.length-1);
	jsonStr+="}";
    var jsonObj = jQuery.parseJSON(jsonStr);
    return jsonObj;
}
function reload(json,funreload)
{
	 $("#main").html("");
	$.post("selectJcdm.action",(issearch?searchjson:json),function(data,textStatus)
	{
		var totalrow=0;
		for(var i in data)
		{

		$("#main").append('<tr style="display:none;">'+
							'<td id="id" hidden="hidden" style="word-break:break-all">'+data[i].id+'</td>'+
							
							
							
							'<td id="dmmc" style="word-break:break-all">'+data[i].dmmc+'</td>'+
							
							'<td id="hlmc" style="word-break:break-all">'+data[i].hlmc+'</td>'+
							
							'<td id="year" style="word-break:break-all">'+data[i].year+'</td>'+
							
							'<td id="month" style="word-break:break-all">'+data[i].month+'</td>'+							
							
							'<td id="date" style="word-break:break-all">'+data[i].date+'</td>'+
							'<td id="number" style="word-break:break-all"><a href="javascript:detialinfo('+data[i].id+')">查看</a></td>'+
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
		json+="\"id\":\""+$("#searchid").val()+"\","; 
		json+="\"date\":\""+$("#searchdate").val()+"\","; 
		json+="\"dmmc\":\""+$("#searchdmmc").val()+"\","; 
		json+="\"hlmc\":\""+$("#searchhlmc").val()+"\",";  
		json+="\"month\":\""+$("#searchmonth").val()+"\","; 
		json+="\"year\":\""+$("#searchyear").val()+"\","; 
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
			"<td id='id' hidden='hidden'><input type='text' style='width:100%; height:100%;'/></td>"+
			
			"<td id='dmmc'><input type='text' style='width:100%; height:100%;'/></td>"+			
			"<td id='hlmc'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='year'><input type='text' style='width:100%; height:100%;'/></td>"+
			"<td id='month'><input type='text' style='width:100%; height:100%;'/></td>"+		
			"<td id='date'><input type='text' style='width:100%; height:100%;'/></td>"+
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
				
	        $.post("updateJcdm.action",getRseData(),function(data,textStatus){
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
	 $.post("deleteJcdm.action",{ id : selected },function(data,textStatus){
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
					jsonStr+="\"date\":\""+$this.find("#date").html()+"\",";
					jsonStr+="\"dmmc\":\""+$this.find("#dmmc").html()+"\",";
					jsonStr+="\"hlmc\":\""+$this.find("#hlmc").html()+"\",";
					jsonStr+="\"month\":\""+$this.find("#month").html()+"\",";	
					jsonStr+="\"year\":\""+$this.find("#year").html()+"\",";

			    
				if(jsonStr[jsonStr.length-1]==",")
				jsonStr=jsonStr.substr(0,jsonStr.length-1);
				jsonStr+="}";
			    var jsonObj = jQuery.parseJSON(jsonStr);
			    return jsonObj;
	}
	
        function inputjcdm(){
       	 
       	 $("#fileupload").submit();
       	 
        }
	</script>

</head>
<body>
	<form id="searchform" method="post" action="logshow.action" target="_blank">
		<input id="result" name="result" type="hidden" value="${result}"/>
		<input id="uninput" name="uninput" type="hidden" value="${uninput}"/>
	</form>
	
	<div id="mainwindow">	
	<div id="tou" style="">例行监测断面数据管理</div>
		<h5>查询条件：</h5>

		<div class="input-group" style="margin-bottom: 10px">
  		  <input id="searchid" type="hidden" class="form-control" placeholder="id" aria-describedby="sizing-addon2">
  		  <input id="searchdate" type="hidden" class="form-control" placeholder="date" aria-describedby="sizing-addon2">
  		  <span class="input-group-addon" id="sizing-addon2">断面名称</span><input id="searchdmmc" type="text" class="form-control" placeholder="dmmc" aria-describedby="sizing-addon2">
  		  <span class="input-group-addon" id="sizing-addon2">河流名称</span><input id="searchhlmc" type="text" class="form-control" placeholder="hlmc" aria-describedby="sizing-addon2">
		  <span class="input-group-addon" id="sizing-addon2">年份</span><input id="searchyear" type="text" class="form-control" placeholder="year" aria-describedby="sizing-addon2">
  		  <span class="input-group-addon" id="sizing-addon2">月份</span><input id="searchmonth" type="text" class="form-control" placeholder="month" aria-describedby="sizing-addon2">
  		  
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
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 导入 -->
			<a href="javascript:ShowDiv('MyDiv', 'fade')"><span class="glyphicon glyphicon-download-alt icon"/></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 模板下载 -->
			<a href="download.action?filepath=例行监测断面导入模板.xls"><span class="glyphicon glyphicon-save icon"/></a>

			<a href="javascript:checklast()" style="float: right">查看过程操作</a>
			<p style="float: right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
			<a href="javascript:checknumber()" style="float: right">查看选中行数</a>
		</div>
		<div>
		
	<table id="table" class="table table-bordered "><!-- table-hover -->
		<thead>
			<tr>
				<th hidden='hidden'>id</th>
				
				<th>断面名称</th>
				<th>河流名称</th>
				<th>年份</th>
				<th>月份</th>
				<th>日期</th>
				<th>具体数据</th>
				

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
	
	
		<div id="MyDiv" class="white_content">
			<button onclick="CloseDiv('MyDiv','fade')" style="float: right" class="btn btn-danger">X</button>
			<div style="margin-top: 30px; margin-left: 25px; width: 250px;">
			
				<sf:form id="fileupload" method="post" enctype="multipart/form-data" action="inputjcdm.action">
			        <%--这里设置文件上传--%>
			        本地文件:
			        <input type="file" id="file" name="file"/>
				 </sf:form>
			        <input onclick="inputjcdm()" style="margin-top: 10px" type="button" class="btn btn-info" value="导入"/>
     			    <div class="progress" style="margin-top: 10px">
					  <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
					  </div>
					</div>
			   
				
			</div>
		</div>

		<div id="infodiv" class="white_content" style="height: 550px;top:5%;width: 310px;left: 40%;">
			<button onclick="CloseDiv('infodiv','fade')" style="float: right" class="btn btn-danger">X</button>
			<div style="margin-top: 30px; margin-left: 25px; width: 250px;">
					<h4 align="center">
		  	      		  监测数据
		            </h4>
					<br>
					<input type="hidden" id="infoid"/>
<div class="input-group"><span class="input-group-addon">氨&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;氮&nbsp;（mg/l）</span><input id="andan" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">电&nbsp;&nbsp;导&nbsp;&nbsp;率&nbsp;（ms/m）</span><input id="diandaolv" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">非&nbsp;离&nbsp;子&nbsp;氨（mg/l）</span><input id="flza" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">氟&nbsp;&nbsp;化&nbsp;&nbsp;物&nbsp;（mg/l）</span><input id="fuhuawu" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;铬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（mg/l）</span><input id="ge" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">高&nbsp;锰&nbsp;酸&nbsp;盐（mg/l）</span><input id="gmsy" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;汞&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（mg/l）</span><input id="gong" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">挥&nbsp;&nbsp;发&nbsp;&nbsp;酚&nbsp;（mg/l）</span><input id="huifafen" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">化学需氧量&nbsp;（mg/l）</span><input id="hxxyl" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">硫&nbsp;&nbsp;化&nbsp;&nbsp;物&nbsp;（mg/l）</span><input id="liuhuawu" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">六&nbsp;&nbsp;价&nbsp;&nbsp;铬&nbsp;（mg/l）</span><input id="liujiage" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">流&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量&nbsp;（m³/s）</span><input id="liuliang" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">硫&nbsp;&nbsp;酸&nbsp;&nbsp;盐&nbsp;（mg/l）</span><input id="liusuanyan" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">氯&nbsp;&nbsp;化&nbsp;&nbsp;物&nbsp;（mg/l）</span><input id="lvhuawu" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;pH&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input id="ph" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;铅&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（mg/l）</span><input id="qian" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">溶&nbsp;&nbsp;解&nbsp;&nbsp;氧&nbsp;（mg/l）</span><input id="rongjieyanng" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;砷&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（mg/l）</span><input id="shen" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">石&nbsp;&nbsp;油&nbsp;&nbsp;类&nbsp;（mg/l）</span><input id="shiyoulei" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">水&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;深&nbsp;（m）</span><input id="shuishen" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">水&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;温&nbsp;（℃）</span><input id="shuiweng" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">生化需氧量&nbsp;（mg/l）</span><input id="shxyl" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">水&nbsp;&nbsp;&nbsp;期&nbsp;&nbsp;&nbsp;代&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;</span><input id="sqdm" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;硒&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（mg/l）</span><input id="xi" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">硝&nbsp;&nbsp;酸&nbsp;&nbsp;盐&nbsp;（mg/l）</span><input id="xiaosuanyan" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">悬&nbsp;&nbsp;浮&nbsp;&nbsp;物&nbsp;（mg/l）</span><input id="xuanfuwu" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">亚&nbsp;硝&nbsp;酸&nbsp;盐（mg/l）</span><input id="yxsy" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">氰&nbsp;&nbsp;化&nbsp;&nbsp;物&nbsp;（mg/l）</span><input id="zjhw" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;氮&nbsp;（mg/l）</span><input id="zongdan" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;磷&nbsp;（mg/l）</span><input id="zongling" type="text" class="form-control" aria-describedby="basic-addon1"></div>
<div class="input-group"><span class="input-group-addon">总&nbsp;&nbsp;硬&nbsp;&nbsp;度&nbsp;（mg/l）</span><input id="zongyingdu" type="text" class="form-control" aria-describedby="basic-addon1"></div>


 <input onclick="saveinfo()" style="margin-top: 10px;float: left;margin-left: 90px;margin-bottom: 10px;" type="button" class="btn btn-info" value="保存修改"/>
			</div>
		</div>


		<div id="fade" class="black_overlay"></div>
		<script>
		var result=$("#result").val();
		var uninput=$("#uninput").val();
		if(result!=""){
			console.log(uninput);
			alert(result);
			$("#searchform").submit();
			//location.href="JcdmList.action";
		}
		
		</script>
		<div id="toolspop" class="customtoolspop">提示</div>
		<script src="app/js/toolspop.js"></script>
	</body>
</html>
