     var LayerName="";
     var outid="";
     
     var graohicshow=true;
     var selectgraohicshow=true;
     
	 var version=0;
	 
	 var iscallback=false;
	 var allpoint=new Array();
	 
	 var mainriverlist=["丹金溧漕河","常州河","南河","芜太运河","梅渚河","胥河","大溪河","竹箦河"];
	 //var mainriverlist=[];
	 var istreaure=false;
	 var flag=true;
	 
 	var checklist=["xqyzqh","sthx"];
	 
	 dmclick = "";
	 siteName = "";
     //查询querytask
     function SearchQuery(layername,cluse,geometry,isreturngeometry,isfilltable,isdrawgraphic,layerid,isloading,nouseorignal,callback,changequeryResult){
		console.log(layername+","+cluse+","+geometry+","+isreturngeometry+","+isfilltable+","+isdrawgraphic+","+layerid+","+isloading+","+nouseorignal);
     	var thisversion=version;
     	var layerDefinitions = [];



	   	eval(layername).setLayerDefinitions(layerDefinitions);
	   	
	   	
		//if(nouseorignal!=undefined&&nouseorignal==false){
			if(isloading){
				if(isfilltable){
				 	$("#usedcont").hide();
					$("#loading").show();
				}
				if(isdrawgraphic){
					$("#maploading").show();
				}

				
	    	}


			
			if(isdrawgraphic){
				
				select.clear();
				map.removeLayer(select);
				map.addLayer(select);
				highLight.clear();
				map.removeLayer(highLight);
				map.addLayer(highLight); 
			}
		//}

     	/*************************************
     	 * 筛选图层中的要素，筛选条件是cluse
     	*************************************/
     	query.where = cluse;
     	query.outFields=["*"];
		if(geometry!="nogeometry")
			query.geometry = geometry;
		query.returnGeometry = isreturngeometry;
		
		if(layerid=="alllayers"){
			
			showallthislayer();
			layercount=$("#selectbody option").length-1;
			featurescount=0;
			for(var i=0;i<layercount;i++){
				layerDefinitions[i] = cluse;
			}
			var nowlayer=0;
			var queryTaskarray= new Array(layercount);
			queryResult.features.length=0;
			for(var i=0;i<layercount;i++){
				queryTaskarray[i]=new sQueryTask(eval(layername+"url")+"/"+i);
				queryTaskarray[i].execute(query, function(results) {
					if(thisversion++==version){
						version++;
					}else{
						console.log("查询过期");
						return;
					}
					Array.prototype.push.apply(queryResult.features, results.features);
					//console.log(queryResult.features);
					featurescount+=results.features.length;
					if(--layercount==0)
						allfinish();
				});
			}
			
			
		}else{
			eval(layername).setVisibleLayers([layerid]);
		   	layerDefinitions[layerid] = cluse;

	     	queryTask = new sQueryTask(eval(layername+"url")+"/"+layerid);	
			//queryTask = new sQueryTask("http://112.33.15.169:6868/arcgis/rest/services/liyangxin/"+layername+"/MapServer/"+layerid);	
			//console.log("before");
			queryTask.execute(query, function(results) {		
				if(thisversion==version){
					version++;
				}else{
					console.log("查询过期");
					return;
				}
				if(callback!=undefined){
					//console.log("onlyreturn");
					//console.log(results);
					callback(results);
					if(nouseorignal)
						return;
				}
				//console.log("after");
				if(changequeryResult){
					queryResult=results;
					//console.log("changequeryResult");
				}
					
				//console.log(results);
				
				if(isfilltable)
					filltable(results,layername);
				if(isdrawgraphic)				
					drawgraphic(results,false,"");
			});
		}
     }
     	function allfinish(){
     		if(queryResult.features.length==featurescount){  			
				filltable(queryResult,LayerName);			
				drawgraphic(queryResult,false,"");				
     			return;
     		}   			
 			var t=setTimeout("allfinish()",100);
     	}
	 
     //json转where
     function jsontowhere(json){
     	var result="1=1";
     	if(LayerName=="sdc"){
			for (var key in json) 
			{
				console.log(key);
				if(key=="年度"){
					result+=json[key]!="全部"?" AND "+key+"="+json[key]:" AND 1=1";
				}else if(key=="镇区名称"){
					result+=json[key]!="全部"?" AND "+key+" LIKE '%"+json[key]+"%'":" AND 1=1";
				}else if(key=="设施工艺"){
					result+=json[key]!="全部"?" AND "+key+" LIKE '%"+json[key]+"%'":" AND 1=1";
				}else if(key=="设施规模1"&&!isNaN(Number(json[key]))){
					result+=" AND 设施规模>"+json[key];
				}else if(key=="设施规模2"&&!isNaN(Number(json[key]))){
					result+=" AND 设施规模<"+json[key];
				}else if(key=="行政村"){
					result+=" AND "+key+" LIKE '%"+json[key]+"%'";
				}else{
					
				}
	
			}
     	}else{
			for (var key in json){
				if(json[key]!=""){
					result+=" AND "+key+" LIKE '%"+json[key]+"%'";
					//result+=!isNaN(Number(json[key]))?" AND "+key+"="+json[key]:" AND "+key+" LIKE '%"+json[key]+"%'";
				}
	
			}
     	}
		return result;
     }
     //绘制graphic
     function drawgraphic(results,isHighLight,geometry,highLightIndex,isotherlayer,isZoom){	
     	//console.log(results);
     	//其他绘制层
     	if(isotherlayer){
     		//console.log(results);
     		otherlayer.clear();
     		if(results.features.length == 0){
				return;
			}
     		
			if(results.features[0].geometry.type == "point"){
				
				var pt = new sPoint(geometry.x/*-0.0006544*/,geometry.y/*-0.0000429153*/);
				var symbol = new sPictureMarkerSymbol('images/point.png',40,40);
				 for(var i = 0;i < results.features.length;i++){
					 var pt = new sPoint(results.features[i].geometry.x/*-0.0006544*/,results.features[i].geometry.y-0.0000429153);		
					 
					 var graphic = new sGraphic(pt, symbol,{"id":i,"TP2013":results.features[i].attributes.TP2013,"dm":results.features[i].attributes[setname]},null);
					 graphic.visible=selectgraohicshow;
					 otherlayer.add(graphic);
				 }
			}else if(results.features[0].geometry.type == "polygon"){
				var symbol = new sSimpleFillSymbol();
				symbol.setStyle(sSimpleFillSymbol.STYLE_SOLID);
				symbol.setOutline(new sSimpleLineSymbol(sSimpleLineSymbol.STYLE_SOLID,new sColor([255,255,0]),2));
				symbol.setColor(new sColor([255,255,0,0.1]));
				
				for(var i = 0;i < results.features.length;i++){	
					var graphic = new sGraphic(results.features[i].geometry, symbol,{"id":i},null);
					graphic.visible=selectgraohicshow;
					otherlayer.add(graphic);
				}
			}else if(results.features[0].geometry.type == "polyline"){
				var symbol = new sSimpleLineSymbol(sSimpleLineSymbol.STYLE_SOLID,new sColor([255,0,0]),3);

				for(var i = 0;i < results.features.length;i++){	
					var graphic = new sGraphic(results.features[i].geometry, symbol,{"id":i},null);
					graphic.visible=selectgraohicshow;
					otherlayer.add(graphic);
				}
			}else{
				console.log("otherlayer other geometry types!"+geometry.type);
			}
     		return;
     	}
     	//高亮
		if(isHighLight){
	     	otherlayer.clear();
			highLight.clear();
			if(geometry.type == "point"){//点
				var pt = new sPoint(geometry.x/*-0.0006544*/,geometry.y/*-0.0000429153*/);
				var symbol = new sPictureMarkerSymbol('images/1.gif',40,40);
				var graphic = new sGraphic(pt,symbol,{"id":highLightIndex},null);
				graphic.visible=graohicshow;
				highLight.add(graphic);
				if(isZoom ==false){
					
				}else{
					map.centerAndZoom(pt,11);
				}
				$("#popup").hide();
			}else if(geometry.type == "polygon"){//面
				var symbol = new sSimpleFillSymbol();
				symbol.setStyle(sSimpleFillSymbol.STYLE_SOLID);
				symbol.setOutline(new sSimpleLineSymbol(sSimpleLineSymbol.STYLE_SOLID,new sColor([255,0,0]),3))
				symbol.setColor(new sColor([0,150,0,0.1]));
				var graphic = new sGraphic(geometry,symbol,{"id":highLightIndex},null);
				graphic.visible=graohicshow;
				highLight.add(graphic);
				if(isZoom ==false){
					
				}else{
					var extent=geometry.getExtent();
					var x=(extent.xmax+extent.xmin)/2;
					var y=(extent.ymax+extent.ymin)/2;
					map.centerAndZoom(new sPoint(x,y), 11);
				}
			}else if(geometry.type == "polyline"){//线
				var symbol = new sSimpleLineSymbol(sSimpleLineSymbol.STYLE_SOLID,new sColor([255,0,0]),3);
				var graphic = new sGraphic(geometry,symbol,{"id":highLightIndex},null);
				graphic.visible=graohicshow;
				highLight.add(graphic);
				if(isZoom ==false){
					
				}else{
					if(LayerName=="sxt"){
						
					}else{
						var extent=geometry.getExtent();
						if($.inArray(selectedname, mainriverlist)!=-1){
							map.setExtent(extent);
						}else{
							var x=(extent.xmax+extent.xmin)/2;
							var y=(extent.ymax+extent.ymin)/2;
							map.centerAndZoom(new sPoint(x,y), 13);
						}
					}


						
				}
			}else{
				console.log("highlightlayer other geometry types!"+geometry.type);
			}

			if(geometry.type == "point"){
				map.removeLayer(select);
				map.addLayer(select);
			}

			highLight.enableMouseEvents();
			highLight.on("mouse-move", showfunction);
			highLight.on("mouse-out",hidefunction); 

			if(LayerName=="xzc"){
				//console.log(queryResult.features[highLightIndex].attributes.name);
				var sql="1=1 AND name = '"+queryResult.features[highLightIndex].attributes.name+"'";
				//console.log(sql);
				SearchQuery("zrc",sql,"nogeometry",true,false,false,0,false,true,function(result){				
					drawgraphic(result,false,"",0,true);
				},true)
			}
		//提示框绘制层
		}else {
			allpoint.splice(0,allpoint.length);
			select.clear();
			highLight.clear();
			if(results.features.length == 0){
				alert("未查询到信息！");
				$("#maploading").hide();
				return;
			}
			if(results.features[0].geometry.type == "point"){
				
				var symbol = new sSimpleMarkerSymbol().setStyle(
					sSimpleMarkerSymbol.STYLE_CIRCLE).setColor(
					 new sColor([255, 255, 255, 0])
				  );
				 symbol.setSize(25);
				 symbol.setOutline(null);
				 var oldid;
				 for(var i = 0;i < results.features.length;i++){
				 	oldid=-1;
					 var pt = new sPoint(results.features[i].geometry.x/*-0.0006544*/,results.features[i].geometry.y-0.0000429153);	
					 /******************************************************/
					 
					 for(var j in allpoint){
					 	if(pt.x==allpoint[j].x&&pt.y==allpoint[j].y){
					 		oldid=j;
					 		//console.log("a");
					 		
					 		//oldid=i;
					 		break;
					 	}
					 }
					 
					 //console.log("oldid");
					 /******************************************************/
					 if(oldid==-1){
					 	allpoint.push(pt);
					 	var setname=(LayerName=='zqsgnkhdm'?results.features[i].attributes.河流+"-"+results.features[i].attributes.断面名称:results.features[i].attributes.name);
					 	
					 	var graphic = new sGraphic(pt, symbol,{"id":i,"TP2013":results.features[i].attributes.TP2013,"dm":setname},null);
 						graphic.visible=selectgraohicshow;
						select.add(graphic);
					 }else{
					 	//var graphic = new sGraphic(pt, symbol,{"id":i,"TP2013":results.features[i].attributes.TP2013,"dm":results.features[i].attributes.name},null);
					 	select.graphics[oldid].setAttributes({"id":(select.graphics[oldid].attributes.id+"-"+i)});
					 	//console.log(select.graphics[oldid]);
					 }
					 	

				 }
			}else if(results.features[0].geometry.type == "polygon"){
				var symbol = new sSimpleFillSymbol();
				if($("#selectbody option:selected").text()=="禁养区"&&false){
					symbol.setOutline(new sSimpleLineSymbol(sSimpleLineSymbol.STYLE_SOLID,new sColor([255,0,0]),0.8))
				}else{
					symbol.setOutline(new sSimpleLineSymbol(sSimpleLineSymbol.STYLE_SOLID,new sColor([255,255,255,0.1]),1));
				}
				symbol.setColor(new sColor([255,255,255,0]));
				symbol.setStyle(sSimpleFillSymbol.STYLE_SOLID);
				
				
				for(var i = 0;i < results.features.length;i++){	
					var graphic = new sGraphic(results.features[i].geometry, symbol,{"id":i},null);
					graphic.visible=selectgraohicshow;
					select.add(graphic);
				}
			}else if(results.features[0].geometry.type == "polyline"){
				var symbol = new sSimpleLineSymbol(sSimpleLineSymbol.STYLE_SOLID,new sColor([255,255,255,0]),3);

				for(var i = 0;i < results.features.length;i++){	
					var graphic = new sGraphic(results.features[i].geometry, symbol,{"id":i},null);
					graphic.visible=selectgraohicshow;
					select.add(graphic);
				}
			}else{
				console.log("selectlayer other geometry types!"+geometry.type);
			}

			
			select.enableMouseEvents();
			
			if(typeof(overevent) == "undefined"){

				overevent=select.on("mouse-move", showfunction);
			}
			if(typeof(outevent) == "undefined"){
				outevent=select.on("mouse-out",hidefunction);
			}
			if(typeof(clickevent) == "undefined"){
				clickevent=select.on("click",function(event){
					//console.log(event.graphic.attributes.dm);
					
					if(istreaure||iscallback)
						return;
					drawgraphic(null,true,event.graphic.geometry,event.graphic.attributes.id,"",false);

					if(LayerName == "qybcdm"){
						$("#dmmc").html(event.graphic.attributes.dm);
						drawqyCharts(event.graphic.attributes.dm);
						$("#qybcdmcharts").show();
					}
					if(LayerName == "jcz"){
						
						if(event.graphic.attributes.id==0)
							siteName="溧阳市东门子站";
						if(event.graphic.attributes.id==1)
							siteName="燕山子站";
						if(event.graphic.attributes.id==2)
							siteName="凤凰公园";
						var type=$("#airtype option:selected").val();
						drawaqi(siteName,type);
						$("#jczcharts").show();

						
					}
					if(LayerName=="zqsgnkhdm"){
						drawxzdm(event.graphic.attributes.dm);
						$("#xzdm").html(event.graphic.attributes.dm);
						$("#xzdmcharts").show();
					}
					if(LayerName=="jcdm"){
						$("#jcdmdmmc").html(event.graphic.attributes.dm);
						
						dmclick = event.graphic.attributes.dm;
						//console.log(dmmc);
						var year = $("#nianfen option:selected").text();
						var type = $("#type option:selected").text();
						drawjcdmzb(dmclick,year,type);
						$("#jcdmcharts").show();
					}
					if(LayerName=="wsc"){
							
						var data = queryResult.features[event.graphic.attributes.id].attributes;
							var result;
							//console.log(data.name)
							for (var i = 0; i <water.length; i++) {
								if(water[i].name==data.name)
								{result=water[i]}
							}
							
							var html="<li class='out-tit'><p>"+data.name+"</p></li>";
							html+="<li><span>处理能力(万吨/天)："+data["处理能力（"]+"</span></li>";
							html+="<li><span>公司简介：</span><p>"+result.info+"</p></li>";
							$("#info").html(html);
							$("#pic").html("<img src=\"images/wscpic/"+data.图片2+"\" alt=\"\">");
							$("#introduction").show();
						
					}	
					if(LayerName=="sxt"){
							
						var data = queryResult.features[event.graphic.attributes.id].attributes;
							var result;
//							console.log(data.name);
//							console.log(river[0].name);
							for (var i = 0; i <river.length; i++) {
								if(river[i].name==data.name)
								{
									result=river[i];
									break;
								}
							}
							
							var html="<li class='out-tit'><p>"+data.name+"</p></li>";
							html+="<li><span>河流级别：</span><p>"+data["Layer"]+"</p></li>";
							html+="<li><span>基本情况：</span><p>"+result.content+"</p></li>";
							$("#info").html(html);
							$("#pic").html("<img src=\"images/river/"+result.url+"\" alt=\"\">");
							$("#introduction").show();
						
					}
					if(LayerName=="zljp"){
							
						var data = queryResult.features[event.graphic.attributes.id].attributes;
							
							var html="<li class='out-tit'><p>"+data.name+"</p></li>";
							html+="<li><span>公司简介：</span><p>"+data.简介+"</p></li>";
							html+="<li><span>减排成果：</span><p>"+data.减排成果+"</p></li>";
							$("#info").html(html);
							$("#pic").html("<img src=\"images/wscpic/"+data.picture+"\" alt=\"\">");
							$("#introduction").show();
						
					}

				});
			}
			
			

			
		}
		$("#maploading").hide();
     }
     //加载底图后填充表格
     function filltable(results,layername) {
     	$(".stuff-show").show();
     	var attribs;
     	var totalrow = 0;
     	
     	$("#content").html("");
     	for(var i in results.features) {
     		attribs = results.features[i].attributes;

     			
     		var html=
     			"<tr id='" + i
     			+ "' style=\"display:none;\">";
     		if(layername=="sdc")
 				html+="<td id='listname'>" + attribs.行政村 + "</td>";
 			if(layername=="xqyzqh")
     			html+="<td id='listname'>" + attribs.address + "</td>";
 			if(layername=="xzxq")
     			html+="<td id='listname'>" + attribs.行政区名称 + "</td>";
 			if(layername=="xzc")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="gyyq")
     			html+="<td id='listname'>" + attribs.name_1 + "</td>";
 			if(layername=="thlyhfqy")
     			html+="<td id='listname'>" + attribs.镇名 + "</td>";
 			if(layername=="sxt")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="wsc")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="sthx")
     			html+="<td id='listname'>" + attribs.name + "</td>";
     		if(layername=="jcdm")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="pwk")
     			html+="<td id='listname'>" + attribs.企业名称 + "</td>";
 			if(layername=="zdhjfxyfb")
     			html+="<td id='listname'>" + attribs.填报单位详 + "</td>";
 			if(layername=="gyfqzz")
     			html+="<td id='listname'>" + attribs.企业名称 + "</td>";
 			if(layername=="qybcdm")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="jcz")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="hjfxqy")
// 				if($("#selectbody").val()==0)
// 					html+="<td id='listname'>" + attribs.企业名称 + "</td>";
//				else
     			html+="<td id='listname'>" + attribs.名称 + "</td>";
     		if(layername=="yzc")
     			html+="<td id='listname'>" + attribs.养殖场小区 + "</td>";
 			if(layername=="zljp")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="els")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="zqsgnkhdm")
     			html+="<td id='listname'>" + attribs.河流+"-"+attribs.断面名称 + "</td>";
 			if(layername=="sstkhdm")
     			html+="<td id='listname'>" + attribs.河流+" "+attribs.断面名称 + "</td>";
 			if(layername=="jrq")
     			html+="<td id='listname'>" + attribs.name + "</td>";
 			if(layername=="lsxx")
     			html+="<td id='listname'>" + attribs.学校_name + "</td>";
 			if(layername=="stc")
     			html+="<td id='listname'>" + attribs.Sheet3__村 + "</td>";
 			if(layername=="zdqy")
     			html+="<td id='listname'>" + attribs.填报单位详 + "</td>";
 			html+="</tr>";
     		if(html.indexOf("<td id='listname'> </td>")>=0)
     		{
     			continue;
     			//console.log(html);
     			//html=html.split("<tr").join("<tr hidden='hidden'");
     		}
     		$("#content").append(html);
     		totalrow++;
     	};
     	totalpage = Math.ceil(totalrow / pagerow);

     	//if(last == "search" || last == "searchall") {
     		currentpage = 1;
     	//}
     	showpage(currentpage);
		$("#totalrow").html(totalrow);
     	$("#totalpage").html(totalpage);
     	$("#currentpage").html(currentpage);
     	last = "reload";

     	$("#content tr").click(function() {
     		
     		selectedrow = $(this).attr("id");
     		$this = $("#content tr:eq(" + $(this).index() + ")");
     		selectedname = $this.children("#listname").html();
			
     		$(this).addClass("biaoge-seled");
     		$(this).siblings().removeClass("biaoge-seled");

     		drawgraphic("",true,queryResult.features[selectedrow].geometry,selectedrow);
     		
	
			if(LayerName=="zqsgnkhdm"){
				drawxzdm(selectedname);
				$("#xzdm").html(selectedname);
				$("#xzdmcharts").show();
			}
			if(LayerName=="jcdm"){
				dmclick=selectedname;
				$("#jcdmdmmc").html(selectedname);
				var year = $("#nianfen option:selected").text();
				var type = $("#type option:selected").text();
				drawjcdmzb(selectedname,year,type);
				$("#jcdmcharts").show();
			}
     		
     		
     		if(layername=="sxt"){
     			
     			if($.inArray(selectedname, mainriverlist)!=-1){
     				
     			return;
	     			var htm="";
	     			//console.log(selectedname);
	     			$("#rivername").html(selectedname);
	     			$.post("rivermean.action",{hlmc:selectedname},function(data){
	     				console.log(data);
	     				
	     				var htm="";
	     				var year=2010;
	     				for(var i in data){
	     					htm+="<tr><td>"+year+"</td><td>"+data[i].hxxyl+"</td><td>"+"</td><td>"+data[i].andan+"</td><td>"+"</td><td>"+data[i].shiyoulei+"</td><td>"+"</td><td>"+"</td></tr>";
	     				}
	     				
	     				$("#showtablecontent").html(htm);
	         			
	         			$("#showtable").show(); 
	     			},"json");
     					
	     			
     			}
    
     		}
     	});
     	$("#usedcont").show();
		$("#loading").hide();
     	isloading=false;
     }
/*     function getjson(){
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
     }*/
     //设置遮罩透明度
     function setzhezhao(num) {
     	//graphic.setSymbol(simpleFillSymbol.setColor(new sColor([213, 215, 222, parseFloat(num)])));
     	zhezhaographiclayer.setOpacity(parseFloat(num));
     }
     //graphic鼠标移上事件
     function showfunction(event){
		if(istreaure||iscallback)
			return;
     	var id = event.graphic.attributes.id;
		var bc = event.graphic.attributes.bc;
     		
     	$("#popupdiv").html("");

		
		$("#popHead").empty();
		$("#popData").empty(); 	
		var ids=String(event.graphic.attributes.id).split("-");
		var alldata=new Array();
		//console.log(ids);
		for(var i in ids){
			//console.log(queryResult.features[ids[i]]);
			alldata[i]=queryResult.features[ids[i]].attributes;
		}
		var data=alldata[0];
		
		if(LayerName=="sdc"){
			for(var i in alldata){
				data=alldata[i];
				
					var html="<h3>年度</h3>"+
					"<p>"+data.年度+"</p>"+
					"<h3>镇区名称</h3>"+
					"<p>"+data.镇区名称+"</p>"+
					"<h3>行政村</h3>"+
					"<p>"+data.行政村+"</p>"+
					"<h3>受益自然村</h3>"+
					"<p>"+data.受益自然村+"</p>"+
					"<h3>建设类型</h3>"+
					"<p>"+data.建设类型+"</p>"+
					"<h3>设施规模 (吨/日)</h3>"+
					"<p>"+data.设施规模+"</p>"+
					"<h3>设施工艺</h3>"+
					"<p>"+data.设施工艺+"</p>"+
					"<span>";		
				$("#popupdiv").append(html);
			}

		}
		

		else if(LayerName=="xqyzqh"){
			if($("#selectbody option:selected").text()=="禁养区"){
				var html="<h3>名称</h3>"+
				"<p>"+data.Name+"</p>"+
				"<h3>代码</h3>"+
				"<p>"+data.Cid+"</p>";
//				if(data.address.indexOf("主要道路")==-1&&data.address.indexOf("主要河流")==-1){
					html+="<h3>所在区域</h3>"+
					"<p>"+data.address+"</p>";
//				}
				html+="<h3>面积(平方公里)</h3>"+
				"<p>"+parseFloat(data.Area).toFixed(2)+"</p>"+
				"<h3>类型</h3>"+
				"<p>"+data.区+"</p>";		
				$("#popupdiv").append(html);			 				
			}
			else{
				return;
			}
		}else if(LayerName=="sthx"){
			var html="<h3>名称</h3>"+
			"<p>"+data.name+"</p>"+
			"<h3>简介</h3>"+
			"<p>"+data.介绍+"</p>"+
			"<h3>面积(平方公里)</h3>"+
			"<p>"+parseFloat(data.面积).toFixed(2)+"</p>";
					
	$("#popupdiv").append(html);	

		}else if(LayerName=="pwk"){

			var html="<h3>乡镇</h3>"+
			"<p>"+data.乡镇+"</p>"+
			"<h3>企业名称</h3>"+
			"<p>"+data.企业名称+"</p>"+
			"<h3>序号</h3>"+
			"<p>"+data.序号+"</p>"+
			"<h3>纬度</h3>"+
			"<p>"+data.纬度+"</p>"+
			"<h3>经度</h3>"+
			"<p>"+data.经度+"</p>";	
	$("#popupdiv").append(html);
		}else if(LayerName=="xzxq"){
			
			var html="<h3>行政区名称</h3>"+
			"<p>"+data.行政区名称+"</p>"+
			"<h3>行政区划代码</h3>"+
			"<p>"+data.行政区划代+"</p>"+
			"<h3>面积(平方公里)</h3>"+
			"<p>"+(parseFloat(data.Shape_Area)/1000000).toFixed(2)+"</p>"+
			"<h3>农村人口(万人)</h3>"+
			"<p>"+(parseFloat(data.乡村人口)/10000).toFixed(2)+"</p>"+
			"<h3>城镇人口(万人)</h3>"+
			"<p>"+(parseFloat(data.城镇人口)/10000).toFixed(2)+"</p>"+
			"<h3>人口密度（人/平方公里）</h3>"+
			"<p>"+data.密度人_km2.toFixed(2)+"</p>"+
			"<h3>一产(亿元)</h3>"+
			"<p>"+(parseFloat(data.一产)).toFixed(2)+"</p>"+
			"<h3>二产(亿元)</h3>"+
			"<p>"+(parseFloat(data.二产)).toFixed(2)+"</p>"+
			"<h3>三产(亿元)</h3>"+
			"<p>"+(parseFloat(data.三产)).toFixed(2)+"</p>";
	$("#popupdiv").append(html);
		}else if(LayerName=="qybcdm") {
			var html="<h3>名称</h3>"+
			"<p>"+data.name+"</p>"+
			"<h3>类型</h3>"+
			"<p>"+data.类型+"</p>";
			$("#popupdiv").append(html);
			
		}else if(LayerName == "xzc") {
			var html="<h3>村名</h3>"+
			"<p>"+data.name+"</p>"+
			"<h3>所在乡镇</h3>"+
			"<p>"+data.镇名+"</p>"+
			"<h3>面积(平方公里)</h3>"+
			"<p>"+(parseFloat(data.Shape_Area)/1000000).toFixed(2)+"</p>"
			$("#popupdiv").append(html);
		}else if(LayerName == "jcz"){
			//$("#apiloading").show();
			//console.log(data.name);
			$("#proploading").show();
			if(data.name=="东门子站")
				data.name="溧阳市东门子站";
			$.post("site.action",{siteName:data.name},function(result){
				console.log(result);
				result=result[0];
				var html;
				html="<h3>站名</h3>"+
				"<p>"+data.name+"</p>"+
				
				"<h3>AQI</h3>"+
				"<p>"+result.aqi+"</p>"+
				"<h3>质量等级</h3>"+
				"<p>"+result.quality+"</p>"+
				"<h3>PM2.5</h3>"+
				"<p>"+result.pm25+"</p>"+
				"<h3>PM10</h3>"+
				"<p>"+result.pm10+"</p>"+
				"<h3>CO</h3>"+
				"<p>"+result.co+"</p>"+
				"<h3>NO2</h3>"+
				"<p>"+result.no2+"</p>"+
				"<h3>O3</h3>"+
				"<p>"+result.o3+"</p>"+
				"<h3>SO2</h3>"+
				"<p>"+result.so2+"</p>"+
				"<h3>最后更新时间</h3>"+
				"<p>"+result.ct+"</p>";
				
				$("#popupdiv").html(html);
				$("#proploading").hide();
				//$("#apiloading").hide();
			},"json");

		}else if(LayerName == "thlyhfqy"){
			var html="<h3>名称</h3>"+
			"<p>"+data.name+"</p>"+
			"<h3>所在乡镇</h3>"+
			"<p>"+data.镇名+"</p>"+
			"<h3>包含村</h3>"+
			"<p>"+data.包含村+"</p>"+		
			"<h3>面积（平方公里）</h3>"+
			"<p>"+(parseFloat(data.Shape_Area)/1000000).toFixed(2)+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "jcdm"){
			var html="<h3>编号</h3>"+
			"<p>"+data.number+"</p>"+
			"<h3>名称</h3>"+
			"<p>"+data.name+"</p>"+
			"<h3>所在河流</h3>"+
			"<p>"+data.river+"</p>"+
			"<h3>水质目标</h3>"+
			"<p>"+data.水质+"</p>"+
			"<h3>达标情况</h3>"+
			"<p>"+data.达标情况+"</p>";
			$("#popupdiv").append(html);	
			SearchQuery("sxt","1=1 AND name = '"+data.river+"'","nogeometry",true,false,false,0,false,true,function(result){				
				drawgraphic(result,true,"",0,true);
			},true)
			
		}else if(LayerName == "wsc"){
			return;
			var html="<h3>名称</h3>"+
			"<p>"+data.name+"</p>"+
			"<h3>处理能力</h3>"+
			"<p>"+data["处理能力（"]+"</p>";
			$("#popupdiv").append(html);

		}else if(LayerName == "sxt"){
			var html=(data.name!=" "?("<h3>河流名称</h3>"+
			"<p>"+data.name+"</p>"):"")+
			"<h3>河流分级</h3>"+
			"<p>"+data["Layer"]+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "zdhjfxyfb"){
			var html="<h3>风险源企业名称</h3>"+
			"<p>"+data.填报单位详+"</p>"+
			"<h3>所在乡镇</h3>"+
			"<p>"+data.镇名+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "gyfqzz"){
			var html="<h3>企业名称</h3>"+
			"<p>"+data.企业名称+"</p>"+
			"<h3>序号</h3>"+
			"<p>"+data.序号+"</p>"+
			"<h3>纬度</h3>"+
			"<p>"+data.纬度+"</p>"+
			"<h3>经度</h3>"+
			"<p>"+data.经度+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "hjfxqy"){
//			if($("#selectbody").val()==0){
//				var html="<h3>企业名称</h3>"+
//				"<p>"+data.企业名称+"</p>"+
//				"<h3>等级</h3>"+
//				"<p>"+data.等级+"</p>"+
//				"<h3>行政辖区</h3>"+
//				"<p>"+data.行政辖区+"</p>"+
//				"<h3>所属风险区</h3>"+
//				"<p>"+data.所属风险区+"</p>";			
//			}else{
				var html="<h3>名称</h3>"+
				"<p>"+data.名称+"</p>"+
				"<h3>面积(平方公里)</h3>"+
				"<p>"+parseFloat(data.面积).toFixed(2)+"</p>";
//			}

			$("#popupdiv").append(html);
		}else if(LayerName == "yzc"){
			for(var i in alldata){
				data=alldata[i];
				
				var html="<h3>养殖场（户）名称</h3>"+
				"<p>"+data.养殖场小区+"</p>"+
				"<h3>负责人</h3>"+
				"<p>"+data.负责人+"</p>"+
				"<h3>联系电话</h3>"+
				"<p>"+data.联系电话+"</p>"+
				"<h3>饲养种类</h3>"+
				"<p>"+data.饲养种类+"</p>"+
				"<h3>规模</h3>"+
				"<p>"+data.规模1+"</p>"+
				"<h3>当前存栏</h3>"+
				"<p>"+data.当前存栏+"</p>"+
				"<h3>2016年出栏</h3>"+
				"<p>"+data["2016年出栏"]+"</p>"+
				"<span>";
				$("#popupdiv").append(html);
				
			}


		}else if(LayerName == "gyyq"){
			var html="<h3>名称</h3>"+
			"<p>"+data.name_1+"</p>";

			$("#popupdiv").append(html);
		}else if(LayerName == "zljp"){
			return;
			var html="<h3>名称</h3>"+
			"<p>"+data.name+"</p>";
//			"<h3>简介</h3>"+
//			"<p>"+data.简介+"</p>"+
//			"<h3>图片</h3>"+
//			"<p>"+"<img src=\"images/wscpic/"+data.picture+"\" alt=\"\">"+"</p>"+
//			"<h3>减排成果</h3>"+
//			"<p>"+data.减排成果+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "els"){
			var html="<h3>名称</h3>"+
			"<p>"+data.name+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "zqsgnkhdm"){
			var html="<h3>名称</h3>"+
			"<p>"+data.断面名称+"</p>"+
			"<h3>所在河流</h3>"+
			"<p>"+data.河流+"</p>"+
			"<h3>镇（区）</h3>"+
			"<p>"+data["镇（区）"]+"</p>";
			$("#popupdiv").append(html);
			SearchQuery("sxt","1=1 AND name = '"+data.河流+"'","nogeometry",true,false,false,0,false,true,function(result){				
				drawgraphic(result,true,"",0,true);
			},true)
		}else if(LayerName == "sstkhdm"){
			var html="<h3>名称</h3>"+
			"<p>"+data.断面名称+"</p>"+
			"<h3>河流</h3>"+
			"<p>"+data.河流+"</p>"+
			"<h3>水质考核目标</h3>"+
			"<p>"+($("#selectbody option:selected").text()=="国考断面"?data.水质考核目:data.水质考核)+"</p>"+
			"<h3>达标年限</h3>"+
			"<p>"+data.达标年限+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "jrq"){
			var html="<h3>名称</h3>"+
			"<p>"+data.name+"</p>"+
			"<h3>面积（平方公里）</h3>"+
			"<p>"+(parseFloat(data.mj)).toFixed(2)+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "lsxx"){
			var html="<h3>名称</h3>"+
			"<p>"+data.学校_name+"</p>"+
			"<h3>学校等级</h3>"+
			"<p>"+data.Sheet3___1+"</p>"+
			"<h3>命名年份</h3>"+
			"<p>"+data.Sheet3__命+"</p>";
			if(data.学校_addre!=null&&data.学校_addre!=" "){
				html+="<h3>地址</h3>"+
				"<p>"+data.学校_addre+"</p>";
			}

			$("#popupdiv").append(html);
		}else if(LayerName == "stc"){
			var html="<h3>名称</h3>"+
			"<p>"+data.Sheet3__村+"</p>"+
			"<h3>所在镇</h3>"+
			"<p>"+data.Sheet3__所+"</p>"+
			"<h3>级别</h3>"+
			"<p>"+data.Sheet3__级+"</p>"+
			"<h3>称号</h3>"+
			"<p>"+data.Sheet3__生+"</p>";
			$("#popupdiv").append(html);
		}else if(LayerName == "zdqy"){
			var html="<h3>名称</h3>"+
			"<p>"+data.填报单位详+"</p>"+
			"<h3>企业规模</h3>"+
			"<p>"+data.企业规模+"企业</p>"+
			"<h3>企业状态</h3>"+
			"<p>"+data.企业状态.split("企业").join("")+"</p>"+
			"<h3>地址</h3>"+
			"<p>"+data.详细地址县 +" "+data.详细地址街 +"</p>"+
			"<h3>电话</h3>"+
			"<p>"+data.联系方式电+"</p>"+
			"<h3>法定代表人</h3>"+
			"<p>"+data.法定代表人+"</p>"+
			"<h3>所在流域</h3>"+
			"<p>"+data.所在流域名+"</p>"+
			"<h3>排水去向</h3>"+
			"<p>"+data.排水去向_1+"</p>"+
			"<h3>受纳水体</h3>"+
			"<p>"+data.受纳水体名+"</p>"+
			"<h3>备注</h3>"+
			"<p>"+data.备注+"</p>";
			$("#popupdiv").append(html);
		}

		$("#popup").css("left",(event.pageX+20)+"px");
		$("#popup").css("top",(event.pageY+20)+"px");
		$("#popup").show();
	}

	//graphic鼠标移除事件
	function hidefunction(event) {
		//outid=LayerName+event.graphic.attributes.id.toString();
		$("#proploading").hide();
		$("#popHead").empty();
		$("#popData").empty();
		$("#popup").hide();
	}
	//动画播放
	function changrange(num){	
		var sqll= " ";
		var year = 2013;
		for(var i=1;i<=num;i++){
			sqll= sqll + " 年度=" + year +" OR";
			year++;
		}
		sqll = sqll.substring(0,sqll.length-3);
		SearchQuery("sdc",sqll,"nogeometry",true,true,true,0,false,false,function(result){
			//drawgraphic(result,true,"",0,true);
			$("#playyear").html(year-1);
			
		},true);
	}
	function notable(page){
		$("#maploading").show();
		clearall();
		showlayer(page);
	}
	//清除高亮，查询的数据，表格，选中的点
	function clearall(){
		//高亮清除
		highLight.clear();
		//绘制清除
		select.clear();
		
		//表格内容
		
/*		$("#content").html("");
		//隐藏表格以及搜索框
		$("#showinfodiv").hide();
		//隐藏右侧表格*/
		$(".stuff-show").hide();	
	}
	//更换查询层
	function selectchange(){
		if($("#selectbody").val()=="alllayers"){
			$("#jwdjc").hide();
			SearchQuery(LayerName,"1=1","nogeometry",true,true,true,"alllayers",true,false,undefined,true);
			setExtent();
		}else{
			if($.inArray(LayerName,checklist)!=-1){
				$("#jwdjc").show();
			}
			SearchQuery(LayerName,"1=1","nogeometry",true,true,true,$("#selectbody").val(),true,false,undefined,true);
			setExtent();
		}

	}
	function kongqi(){
		window.open("kongqi.action");
	}
	//主要河流下拉框切换
	function changemainriver(){
		var selectcontent=$("#mainriver").val();
		console.log(selectcontent);
		$("#content tr").each(function(){
			if($(this).html().indexOf(selectcontent)!=-1){
				$(this).click();
				console.log($(this).html());
			}
		});
	}
	function turnbc(){
		window.open("bcfenxi.action");
	}
