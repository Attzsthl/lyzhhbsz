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

	<link rel="stylesheet" href="http://112.33.15.169:8181/arcgis_js_api/library/3.21/3.21/esri/themes/calcite/dijit/calcite.css ">
    <link rel="stylesheet" href="http://112.33.15.169:8181/arcgis_js_api/library/3.21/3.21/esri/css/esri.css" />
    <script type="text/javascript" src="http://112.33.15.169:8181/arcgis_js_api/library/3.21/3.21/init.js"></script>




</head>
<body style="background-color: inherit;">

	<div id="mainwindow" style="float: left;margin-left: 15px;margin-right:15px;">	

	<div id="tou" style="float: left">问题反馈</div>
		<h5>查询条件：</h5>

		<div class="input-group" style="margin-bottom: 10px">
  		  <input id="searchdisc" type="hidden" class="form-control" placeholder="disc" aria-describedby="sizing-addon2">
  		  <span class="input-group-addon" id="sizing-addon2">反馈者</span><input id="searchusername" type="text" class="form-control" placeholder="username" aria-describedby="sizing-addon2">
  		  
  		  <span class="input-group-addon" id="sizing-addon2">反馈者电话</span><input id="searchtelephone" type="text" class="form-control" placeholder="telephone" aria-describedby="sizing-addon2">
  		  <input id="searchsubmittime" type="hidden" class="form-control" placeholder="submittime" aria-describedby="sizing-addon2">
  		  <span class="input-group-addon" id="sizing-addon2">状态</span><input id="searchstatus" type="text" class="form-control" placeholder="status" aria-describedby="sizing-addon2">
  		  <input id="searchsuggest" type="hidden" class="form-control" placeholder="suggest" aria-describedby="sizing-addon2">
  		  <span class="input-group-addon" id="sizing-addon2">处理人</span><input id="searchsolver" type="text" class="form-control" placeholder="solver" aria-describedby="sizing-addon2">
  		  <input id="searchslovetime" type="hidden" class="form-control" placeholder="searchslovetime" aria-describedby="sizing-addon2">
		</div>

		<div>
			<button id="search" onclick="search()" type="button" class="btn btn-success" style="margin-bottom: 10px">查询</button>
			<button id="search" onclick="searchall()" type="button" class="btn btn-success" style="margin-bottom: 10px">查询全部</button>
		</div>
		<div id="tools">
			<!-- 处理问题 -->
			<a href="javascript:opendiv()"><span class="glyphicon glyphicon-edit icon"/></a> 
			<br>
		</div>
		<div>
		
	<table id="table" class="table table-bordered "><!-- table-hover -->
		<thead>
			<tr>
				
				<th>反馈者</th>
				<th>联系电话</th>
				<th>反馈时间</th>
				<th>状态</th>
				<th>处理意见</th>
				<th>处理时间</th>
				<th>处理人</th>
				<th>详细描述</th>
				
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
	<div id="map" style="width: 350px;height: 470px;margin:auto;color: black;margin-top:50px;float: left;">		
		</div>
		<div id="MyDiv" class="white_content">
			<button onclick="CloseDiv('MyDiv','fade')" style="float: right" class="btn btn-danger">X</button>
			<div style="margin-top: 30px; margin-left: 25px; width: 250px;">
					<h4 align="center">
		  	      		  处理意见
		            </h4>
			
				<textarea id="Approved" style="width: 230px;height: 150px"></textarea>
				<div>
					<input onclick="solve()" style="margin-top: 10px;float: right;" type="button" class="btn btn-info" value="提交"/>
				</div>
			   
			</div>
		</div>

		<div id="discdiv" class="white_content">
			<button onclick="CloseDiv('discdiv','fade')" style="float: right" class="btn btn-danger">X</button>
			<div style="margin-top: 30px; margin-left: 25px; width: 250px;">
					<h4 align="center">
		  	      		  问题详细描述
		            </h4>
				<div id="disccontent" style="width: 230px;height: 150px;"></div>
			   
			</div>
		</div>


        <div id="popup" style="position:absolute;display:none;z-index:998;background-color: white;">
        
        </div>

		<div id="fade" class="black_overlay"></div>
	

	<script>
			require([
			"dojo/parser",
			"tdlib/TDTLayer",
			"tdlib/TDTImageLayer",
			"tdlib/TDTAnnoLayer",
			"esri/map",
			"esri/layers/ArcGISDynamicMapServiceLayer",
			"esri/symbols/SimpleFillSymbol",
			"esri/symbols/SimpleLineSymbol",
			"esri/Color",
			"esri/layers/FeatureLayer",
			"esri/dijit/Search",
			"esri/geometry/Point",
			"esri/graphic",
			"esri/symbols/SimpleMarkerSymbol",
			"esri/symbols/PictureMarkerSymbol",
			"esri/layers/GraphicsLayer",
			"esri/tasks/query",
			"esri/tasks/QueryTask",
			"esri/symbols/TextSymbol",
			"dojo/domReady!"
		], function(
			parser,TDTLayer, TDTImageLayer, TDTAnnoLayer, Map, ArcGISDynamicMapServiceLayer, SimpleFillSymbol,
			SimpleLineSymbol, Color, FeatureLayer, Search, Point,Graphic, SimpleMarkerSymbol,PictureMarkerSymbol,GraphicsLayer, Query, QueryTask,
			TextSymbol
		) {
	esri.config.defaults.io.proxyUrl= "http://123.206.213.109:8080/Java/proxy.jsp";
	
	esri.config.defaults.io.alwaysUseProxy= false;
	
	esri.config.defaults.io.corsDetection=false;
	sPoint=Point;
	sGraphic=Graphic;
	sColor=Color;
	sTextSymbol=TextSymbol;
	sSimpleMarkerSymbol=SimpleMarkerSymbol;
	sPictureMarkerSymbol=PictureMarkerSymbol;
	pointcolor = new Color([100,235,230]);
	simpleMarkerSymbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.STYLE_CIRCLE);
	simpleMarkerSymbol.setColor(pointcolor);
	
	pointcolorunsolve = new Color([255,100,100]);
	simpleMarkerSymbolunsolve = new SimpleMarkerSymbol(SimpleMarkerSymbol.STYLE_CIRCLE);
	simpleMarkerSymbolunsolve.setColor(pointcolorunsolve);
			/*设置视域*/
	startExtent = new esri.geometry.Extent({
		"xmin": 118.574979,
		"ymin": 31.112567,
		"xmax": 119.948170,
		"ymax": 31.734767,
		"spatialReference": {
		"wkid": 4326
		}
	});
	/*地图信息*/
	map = new Map("map", {
		showLabels: true,
		extent: startExtent,
		logo: false,
		showSlider: true,
		sliderPosition: 'top-left',
        force3DTransforms: true,
        optimizePanAnimation: true,
	});

	var tdtLayer = new TDTLayer(); //天地图矢量
	var imgLayer = new TDTImageLayer(); //天地图影像
	var annolayer = new TDTAnnoLayer(); //天地图标注
	map.addLayer(imgLayer);
	map.addLayer(tdtLayer);	
    map.addLayer(annolayer);
    
	parcelsURLzhezhao = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/zhezhao/MapServer/0";
	
		function mapReady() {
			reload("",ad);
		zhezhaographiclayer=new GraphicsLayer();
		map.addLayer(zhezhaographiclayer);
		zhezhaographiclayer.enableMouseEvents();

		
		pointgraphiclayer=new GraphicsLayer();
		map.addLayer(pointgraphiclayer);
		pointgraphiclayer.enableMouseEvents();
		
		
		highlight=new GraphicsLayer();
		map.addLayer(highlight);
		highlight.enableMouseEvents();
		
		
		pointgraphiclayer.on("mouse-move", showfunction);
		pointgraphiclayer.on("mouse-out",hidefunction); 

		highlight.on("mouse-move", showfunction);
		highlight.on("mouse-out",hidefunction); 
		
		textgraphiclayer=new GraphicsLayer();
		map.addLayer(textgraphiclayer);
		

		queryTask = new QueryTask(parcelsURLzhezhao);
		query = new Query();
		query.returnGeometry = true;
		query.where = "1 = 1";
		queryTask.execute(query, function(results) {
			var zhezhaocolor = new Color([213, 215, 222,0.3]);
			simpleFillSymbol = new SimpleFillSymbol();
			simpleFillSymbol.setColor(zhezhaocolor);
			graphic = new Graphic(results.features[0].geometry, simpleFillSymbol);
			//select.add(graphic);
			
			zhezhaographiclayer.add(graphic);
		});


	}

	mapReady();
		});
			
			
			function showfunction(event){
				var thisrow;
				$("#main").children("tr").each(function(){
					
					if($(this).children("#id").html()==event.graphic.attributes.id){
						thisrow=$(this);
					}
						
				});
				var html="";
				html+="反馈人："+thisrow.children("#username").html()+"<br>";
				html+="反馈人联系方式："+thisrow.children("#telephone").html()+"<br>";				
				html+="问题提交日期："+thisrow.children("#submittime").html()+"<br>";
				html+="问题状态："+thisrow.children("#status").html()+"<br>";
				html+="处理意见："+thisrow.children("#suggest").html()+"<br>";
				html+="处理人："+thisrow.children("#solver").html()+"<br>";
				html+="处理日期："+thisrow.children("#slovetime").html()+"<br>";
				$("#popup").html(html);
				$("#popup").css("left",(event.pageX+20)+"px");
				$("#popup").css("top",(event.pageY+20)+"px");
				$("#popup").show();
			}
			function hidefunction(event){
				$("#popup").html();
				$("#popup").hide();
			}
		</script>
	<script type="text/javascript">
function opendisc(id){
	ShowDiv('discdiv', 'fade');
	$.post("selectProblems.action",{id:id},function(result){
		$("#disccontent").html(result[0].disc);
	},"json");
}
function reload(json,funreload)
{
	 $("#main").html("");
	$.post("selectProblems.action",(issearch?searchjson:json),function(data,textStatus)
	{
		var totalrow=0;
		
		pointgraphiclayer.clear();
		for(var i in data)
		{
			drawpoint(data[i].lon,data[i].lat,data[i].id,data[i].status);
		$("#main").append('<tr style="display:none;">'+
							'<td id="id" hidden="hidden" style="word-break:break-all">'+data[i].id+'</td>'+
							'<td id="lon" hidden="hidden" style="word-break:break-all">'+data[i].lon+'</td>'+
							'<td id="lat" hidden="hidden" style="word-break:break-all">'+data[i].lat+'</td>'+							
							
							'<td id="username" style="word-break:break-all">'+data[i].username+'</td>'+
							'<td id="telephone" style="word-break:break-all">'+data[i].telephone+'</td>'+
							'<td id="submittime" style="word-break:break-all">'+data[i].submittime+'</td>'+
							'<td id="status" style="word-break:break-all">'+data[i].status+'</td>'+
							'<td id="suggest" style="word-break:break-all">'+data[i].suggest+'</td>'+
							'<td id="slovetime" style="word-break:break-all">'+data[i].slovetime+'</td>'+
							'<td id="solver" style="word-break:break-all">'+data[i].solver+'</td>'+
							'<td id="opendisc" style="word-break:break-all"><a href="javascript:opendisc('+data[i].id+')">查看</a></td>'+
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
			var lon=$this.children("#lon").html();
			var lat=$this.children("#lat").html();
			var pt=new sPoint(lon,lat);
			highlightfunction(lon,lat,$this.children("#id").html());
			console.log(pt);			
			map.setLevel(11);
			map.centerAt(pt);
 		});
 		
		
		last="reload";
		allop+="reload;";
		funreload();
		
	},"json"); 
	
}



function search(){
	var json="{";
		json+="\"id\":\""+$("#searchid").val()+"\","; 
		json+="\"telephone\":\""+$("#searchtelephone").val()+"\","; 
		json+="\"username\":\""+$("#searchusername").val()+"\","; 
		json+="\"status\":\""+$("#searchstatus").val()+"\","; 
		json+="\"slovetime\":\""+$("#searchslovetime").val()+"\","; 
		json+="\"suggest\":\""+$("#searchsuggest").val()+"\","; 
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
	
        function getData() {
		    var jsonStr = "{"; // json格式开始
				jsonStr+="\"id\":\""+selected+"\",";
				jsonStr+="\"approved\":\""+$("#Approved").val()+"\",";
		    
			if(jsonStr[jsonStr.length-1]==",")
			jsonStr=jsonStr.substr(0,jsonStr.length-1);
			jsonStr+="}";
		    var jsonObj = jQuery.parseJSON(jsonStr);
		    return jsonObj;
}
        
        function opendiv(){
    		if(selectedrow==-1)
    		{
    			alert("请选择行");
    			return;
    		}
    		if($this.children("#status").html()!="未处理")
    		{
    			alert("该问题已经被处理");
    			return;
    		}
    		ShowDiv('MyDiv', 'fade');
        }
        function solve(){
    		if(selectedrow==-1)
    		{
    			alert("请选择行");
    			return;
    		}
    		if($this.children("#status").html()!="未处理")
    		{
    			alert("该问题已经被处理");
    			return;
    		}
	    	 $.post("solveproblems.action",getData(),function(data,textStatus){
	    		selectedrow=-1;
	    		if(data=="-1")
	    			alert("该问题已经被处理了，请刷新后再次查看");
	    		else if(data=="0")
	    			alert("该问题不存在，请刷新后再次查看");
	    		else if(data=="1")
	    			alert("修改成功");
	    		reload("",ad);
	    		CloseDiv('MyDiv','fade');
	    	 },"text");
        }

	</script>
	<script type="text/javascript">
	function drawpoint(lon,lat,id,status){
		var point=new sPoint(lon,lat);
		if(status=="未处理"){
			var	graphic = new sGraphic(point, simpleMarkerSymbolunsolve,{"id":id},null);
		}else{
			var	graphic = new sGraphic(point, simpleMarkerSymbol,{"id":id},null);
		}
		
		pointgraphiclayer.add(graphic);
	}
	function highlightfunction(lon,lat,id){
		highlight.clear();
		var pt = new sPoint(lon,lat);
		var symbol = new sPictureMarkerSymbol('images/1.gif',40,40);
		var graphic = new sGraphic(pt,symbol,{"id":id},null);
		highlight.add(graphic);
	}
	</script>
		<div id="toolspop" class="customtoolspop">提示</div>
		<script src="app/js/toolspop.js"></script>
</body>
</html>
