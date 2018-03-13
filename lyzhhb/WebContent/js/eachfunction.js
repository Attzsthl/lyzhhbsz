//点击不同图层，对内容进行切换
function changepage(topage){
	$(".out").hide();
	isloading=true;
	LayerName=topage;
	if(flag){
		showlayer(topage);
	}else{
		kaiguan();
	}
	
	

	showsearch(topage);
	
	setExtent();//缩放至全图
	
//	if(topage=="sxt"){
//		$("#mainriverdiv").show();
//	}else{
//		$("#mainriverdiv").hide();
//	}
	

	if($.inArray(topage,checklist)!=-1){
		$("#jwdjc").show();
	}else{
		$("#jwdjc").hide();
	}
	
	
	var layerinfo=eval(topage).layerInfos;
	if(layerinfo.length>1){
		$("#selectbody").html("");
		$("#selectbody").append("<option value=\"alllayers\">全部</option>");
		
		for(var i in layerinfo){
			var html='<option value ="'+i+'"'+(i==0?'selected="selected"':'')+'>'+layerinfo[i].name+'</option>';
			$("#selectbody").append(html);
		}			
			$("#selectlayer").show();
	}		
	else
		$("#selectlayer").hide();
	var $tuli=$(".tuli img");
	$tuli.hide();
//	$tuli.each(function(){
//		if($(this).data("tuli")==topage){
//			$(this).siblings().fadeOut(300);
//			$(this).fadeIn(300);
//
//		}
//	})
	

	SearchQuery(topage,"1=1","nogeometry",true,true,true,0,true,false,undefined,true);
}
//显示某个图层，隐藏其他图层
function showlayer(layername){
	$("#charts").hide();
	$("#qybcdmcharts").hide();
	$("#jcdmcharts").hide();
	$("#jczcharts").hide();
	$("#xzdmcharts").hide();
	otherlayer.clear();
	hidealllayer();
	eval(layername).setVisibility(true);
	if(layername=="yzc"){
		xqyzqh.setVisibility(true);
		xqyzqh.setVisibleLayers([0,1,2]);
	}
		
	if(layername=="noise"||layername=="tdly")
	{
		$("#maploading").hide();
	}
}

//控制图层显示
function kaiguan(){	
		var kaiguan1=$("#kaiguan1");
		var kaiguan2=$("#kaiguan2");
		if(flag){
			otherlayer.clear();
			kaiguan1.removeClass("open1").addClass("close1");
			kaiguan2.removeClass("open2").addClass("close2");
			hidealllayer();
			flag=false;
		} else {
			kaiguan1.removeClass("close1").addClass("open1");
			kaiguan2.removeClass("close2").addClass("open2");
			showlayer(LayerName);
			flag=true;
		}
}
//隐藏所有数据图层
function hidealllayer(){
	for(var i in map.layerIds){
		if(i==0||i==1||i==2)
			continue;
		map.getLayer(map.layerIds[i]).setVisibility(false);
	}
}
//显示一个搜索框
function showsearch(layername){
	$("#search"+layername).show().siblings().hide();
}
//重置
function chongzhi(){
	$(".tiaojian").val("");
	searchfunction(true);
}
//搜索函数
 function searchfunction(isall){
 	setExtent();
 	var layername=LayerName;
 	if(isall)
 	{
 		SearchQuery(layername,"1=1","nogeometry",true,true,false,0,true,false,undefined,false);
 		return;
 	}
	 var json = "{";
	 //***********************getjson*****************************
	 if(layername=="xqyzqh"){
		 if($("#search"+layername+"Name").val() != '' && $("#search"+layername+"Name").val() != undefined)
		 json += "\"address\":\"" + $("#search"+layername+"Name").val() + "\",";
	 }

	 if(layername=="sdc"){
		 
 		 
		json += "\"年度\":\"" + $("#sdcyear option:selected").text() + "\",";
	 	json += "\"镇区名称\":\"" + $("#sdczm option:selected").text() + "\",";
	 	json += "\"设施工艺\":\"" + $("#sdcssgy option:selected").text() + "\",";
	 	
		if($("#search"+layername+"guimo1").val() != '' && $("#search"+layername+"guimo1").val() != undefined)
		 	json += "\"设施规模1\":\"" + $("#search"+layername+"guimo1").val() + "\",";
		if($("#search"+layername+"guimo2").val() != '' && $("#search"+layername+"guimo2").val() != undefined)
		 	json += "\"设施规模2\":\"" + $("#search"+layername+"guimo2").val() + "\",";
 		if($("#search"+layername+"zqname").val() != '' && $("#search"+layername+"zqname").val() != undefined)
		 	json += "\"行政村\":\"" + $("#search"+layername+"zqname").val() + "\",";
	}
	 //***********************还没做*****************************
 	 if(layername=="xzxq"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"行政区名称\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="xzc"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="gyyq"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name_1\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="thlyhfqy"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
	 if(layername=="sxt"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="wsc"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="sthx"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }


 	 if(layername=="jcdm"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="pwk"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"企业名称\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="zdhjfxyfb"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"填报单位详\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="gyfqzz"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"企业名称\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
  	 if(layername=="qybcdm"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
   	 if(layername=="jcz"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
	 if(layername=="hjfxqy"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"名称\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="yzc"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"养殖场小区\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
  	 if(layername=="zljp"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
   	 if(layername=="els"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
	 if(layername=="zqsgnkhdm"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"断面名称\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
	 if(layername=="sstkhdm"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
 	 if(layername=="jrq"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
  	 if(layername=="lsxx"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
   	 if(layername=="stc"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"Sheet3__村\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
	 if(layername=="zdqy"){
		 if($("#search"+layername+"name").val() != '' && $("#search"+layername+"name").val() != undefined)
		 json += "\"name\":\"" + $("#search"+layername+"name").val() + "\",";
	 }
	//***********************getjson*****************************
	 if(json[json.length - 1] == ",")
 		json = json.substr(0, json.length - 1);
 	json += "}";
	 var jsonFinal = $.parseJSON(json);
 	issearch = true;
 	last = "search";
 	searchjson = jsonFinal;
 	var selectedbody=$("#selectbody").val();
 	//console.log($("#selectbody").val());
 	SearchQuery(layername,jsontowhere(jsonFinal),"nogeometry",true,true,true,selectedbody==null?0:selectedbody,true,false,undefined,true);
 	//SearchQuery(layername,cluse,geometry,isreturngeometry,isfilltable,isdrawgraphic,layerid,isloading,nouseorignal,callback,changequeryResult)
 }
 
 function setExtent() {
 	map.setExtent(startExtent);
 }
 
 
var overyzc=new Array();
var yzcinarea=new Array();
 function diejiafenxi(){

 	$("#usedcont").hide();
	$("#loading").show();

	$("#maploading").show();
	
 	overyzc.splice(0,overyzc.length);
 	yzcinarea.splice(0,yzcinarea.length);
 	var sql="FID in (";
	SearchQuery("xqyzqh","1=1","nogeometry",true,false,false,1,true,true,function(data){

		
	 	for(var i in queryResult.features){

 		var inarea="";
 		
		for (var j in data.features) {

			if(data.features[j].geometry.contains(queryResult.features[i].geometry))
				inarea+=data.features[j].attributes.Name+"、";
		}
		if(inarea!=""){
			overyzc.push(queryResult.features[i].attributes.FID);
			yzcinarea.push(inarea);		
			
			}
	 	}
	 	sql+=overyzc+")";
	 	SearchQuery("yzc",sql,"nogeometry",true,true,true,0,true,false,undefined,true);
	 	alert("共有"+overyzc.length+"家养殖场处于禁养区！");

	},false);

 }
 function showallthislayer(){
 	var layerids=new Array();
 	for(var i in eval(LayerName).layerInfos)
 		layerids.push(i);
	eval(LayerName).setVisibleLayers(layerids);
 }
 
 function putposition(){
  	var x=$("#jingdu").val();
  	var y=$("#weidu").val();
	if(!jinweiducheck(x,y)){
		return;
	}

  	otherlayer.clear();
 	var pt = new sPoint(x,y);
	var symbol = new sPictureMarkerSymbol('images/1.gif',40,40);
	var graphic = new sGraphic(pt, symbol);

	otherlayer.add(graphic);
	map.setZoom(10);
	map.centerAt(pt);

	//map.centerAndZoom(pt,10);
 }
 
  function outcheck(){
  	var x=$("#jingdu").val();
  	var y=$("#weidu").val();
	if(!jinweiducheck(x,y)){
		return;
	}
  	
  	$("#maploading").show();
  	otherlayer.clear();
 	var pt = new sPoint(x,y);
	var symbol = new sPictureMarkerSymbol('images/1.gif',40,40);
	var graphic = new sGraphic(pt, symbol);
	var result="";
	var index;
	var content="";
	if(LayerName=="sthx"){
		index=$("#selectbody").val();
		result=$("#selectbody").find("option:selected").text();
		content="name";
	}if(LayerName=="xqyzqh"){
		index=$("#selectbody").val();
		result=$("#selectbody").find("option:selected").text();
		content="Name";
	}
	SearchQuery(LayerName,"1=1","nogeometry",true,false,false,index,true,true,function(data){

 		var inarea="处在 ";
		for (var j in data.features) {
			if(data.features[j].geometry.contains(pt))
				inarea+=data.features[j].attributes[content]+"、";
		}
		otherlayer.add(graphic);
		map.setZoom(10);
		map.centerAt(pt);

		//map.centerAndZoom(pt,10);
		$("#maploading").hide();
		if(inarea!="处在 "){
			inarea=inarea.substring(0,inarea.length-1);
			alert(inarea);
		}else{
			alert("不处在"+result+"内");
		}
		inarea="";
		

	},false);
	
	

 }
  
  function numbercheck(text){
  	if(/^[-]?[0-9]+\.?[0-9]+?$/.test(text)){//这是用正则表达是检查
  		return true;
	}else{		
		return false;
	}
  }
  
  function jinweiducheck(x,y){
  	

  	if(numbercheck(x)&&numbercheck(y)){
  		x=parseFloat(x);
  		y=parseFloat(y);
  		if(x<0||180<x){
  			alert("经度范围在0.0-180.0之间");
  			return false;
  		}else if(y<0||90<y){
  			alert("纬度范围在0.0-90.0之间");
  			return false;
  		}else{
  			return true;
  		}
  	}else{
  		alert("请输入小数数字坐标！");
  		return false;
  	}
  	
  }
  
 	function problemscallback(){
		iscallback=true;
		$("#moveimg").show();
	}
 	function submitcallback(){
 		if(!(/^1[34578]\d{9}$/.test($("#phone").val()))){
 			alert("请输入11位手机号码!");
 			return;
 		}
 		$.post("updateProblems.action",GetCallBackJson(),function(data){
 			
 			alert(data);
 			if(data=="操作成功"){
 	 	 		$("#disc").val("");
 	 	 		$("#phone").val("");
 			}

 		},"text");
		CloseDiv('Callbackproblems','fade')
	}
 	function GetCallBackJson(){
 		var disc=$("#disc").val();
 		disc=disc.split("\n").join("\\n");
 		var phone=$("#phone").val();
 		var json="{";
 		json += "\"lon\":\"" +problempoint.x + "\",";
 		json += "\"lat\":\"" +problempoint.y + "\",";
		json += "\"disc\":\"" +disc + "\",";
		json += "\"telephone\":\"" +phone+"\"";
		json += "}";
	 	var jsonFinal = $.parseJSON(json);
	 	return jsonFinal;
 	}
 	function cejuidv(){
 		
 		$(".ceju").show(500);
 		istreaure=true;
 	}
 	function closecejuidv(){
 		$(".dijitStretch").each(function(){
 			if($(this).attr("aria-pressed")=="true"){
 				$(this).click();
 			}
 			
 		});
 		
 		$(".ceju").hide(500);
 		istreaure=false;
 	}

//var test=new Array();
//var a=123;
//var b=12;
//test.push(a);
//alert($.inArray(b,test));


