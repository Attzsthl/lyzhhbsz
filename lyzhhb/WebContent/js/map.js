require([
	"dojo/parser",
	"esri/dijit/Scalebar",
	"tdlib/TDTLayer",
	"tdlib/TDTImageLayer",
	"tdlib/TDTAnnoLayer",
	"esri/map",
	"dojo/dom",
	"dojo/keys",
	"esri/sniff",
	"esri/SnappingManager",
	"esri/dijit/Measurement",
	"esri/units",
	"esri/InfoTemplate",
	"esri/layers/ArcGISDynamicMapServiceLayer",
	"esri/symbols/SimpleFillSymbol",
	"esri/symbols/SimpleLineSymbol",
	"esri/tasks/IdentifyTask",
	"esri/tasks/IdentifyParameters",
	"esri/dijit/Popup",
	"dojo/_base/array",
	"esri/Color",
	"dojo/dom-construct",
	"esri/layers/FeatureLayer",
	"esri/dijit/Search",
	"esri/geometry/Point",
	"esri/graphic",
	"esri/symbols/SimpleMarkerSymbol",
	"esri/symbols/PictureMarkerSymbol",
	"esri/layers/GraphicsLayer",
	"esri/tasks/query",
	"esri/tasks/QueryTask",
	"esri/SpatialReference",
	"esri/layers/LayerInfo",
	"dijit/form/CheckBox",
	"dojo/domReady!"
], function(
	parser,Scalebar,TDTLayer, TDTImageLayer, TDTAnnoLayer, Map, dom, keys, has, SnappingManager, Measurement, Units, InfoTemplate, ArcGISDynamicMapServiceLayer, SimpleFillSymbol,
	SimpleLineSymbol, IdentifyTask, IdentifyParameters, Popup, arrayUtils, Color, domConstruct, FeatureLayer, Search, Point, 
	Graphic, SimpleMarkerSymbol,PictureMarkerSymbol,GraphicsLayer, Query, QueryTask,SpatialReference,LayerInfo
) {
	//esri.config.defaults.io.proxyUrl= "http://www.jacksung.cn:8080/Java/proxy.jsp";
	esri.config.defaults.io.proxyUrl= "http://123.206.213.109:8080/Java/proxy.jsp";
	
	esri.config.defaults.io.alwaysUseProxy= false;
	
	esri.config.defaults.io.corsDetection=false;
	sLayerInfo=LayerInfo;
	sQueryTask=QueryTask;
	sPoint = Point;
	sGraphic = Graphic;
	sPictureMarkerSymbol = PictureMarkerSymbol;
	sSimpleMarkerSymbol = SimpleMarkerSymbol;
	sColor = Color;
	sSimpleFillSymbol = SimpleFillSymbol;
	sSimpleLineSymbol = SimpleLineSymbol;
	select = new GraphicsLayer();
	highLight = new GraphicsLayer();	
	otherlayer = new GraphicsLayer();

	parser.parse();
	/*设置视域*/
	startExtent = new esri.geometry.Extent({
		"xmin": 119.13306869617914,
		"ymin": 31.15137808790051,
		"xmax": 119.6179470297808,
		"ymax": 31.686929459109187,
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
	/*比例尺*/
    var scalebar = new Scalebar({
		map: map, // 必须的  
		scalebarUnit: "metric",
		attachTo: "bottom-left"
	});
	scalebar.show();
    
	/*图层参数定义*/
//	sthxurl = "http://112.33.15.169:6868/arcgis/rest/services/lyzhhb/sthx/MapServer";
//	xmyzurl = "http://112.33.15.169:6868/arcgis/rest/services/lyzhhb/xmyz/MapServer";
	sdcurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/sdc/MapServer";
//	noiseurl ="http://www.jacksung.cn:6080/arcgis/rest/services/lyxin/noise/MapServer";
	

	xzxqurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/xzxq/MapServer";
	xzcurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/xzc/MapServer";
	gyyqurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/gyyq/MapServer";
	thlyhfqyurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/thlyhfqy/MapServer";
	sxturl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/sxt/MapServer";
	wscurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/wsc/MapServer";
	sthxurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/sthx/MapServer";
	xqyzqhurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/xqyzqh/MapServer";
	
	jcdmurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/jcdm/MapServer";
	pwkurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/pwk/MapServer";
	zdhjfxyfburl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/zdhjfxyfb/MapServer";
	gyfqzzurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/gyfqzz/MapServer";
	qybcdmurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/qybcdm/MapServer";
	
	jczurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/jcz/MapServer";
	//tdlyurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/tdly/MapServer";
	zrcurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/zrc/MapServer";
	hjfxqyurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/hjfxqy/MapServer";
	
	yzcurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/yzc/MapServer";
	zljpurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/zljp/MapServer";
	//elsurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/els/MapServer";
	
	zqsgnkhdmurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/zqsgnkhdm/MapServer";
	sstkhdmurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/sstkhdm/MapServer";
	jrqurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/jrq/MapServer";
	lsxxurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/lsxx/MapServer";
	
	stcurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/stc/MapServer";
	zdqyurl = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/zdqy/MapServer";
	//parcelsURLzhezhao = "http://www.jacksung.cn:6080/arcgis/rest/services/lyzhhb/zhezhao/MapServer/0";
	parcelsURLzhezhao = "http://112.33.15.169:6868/arcgis/rest/services/liyangxin/zhezhao/MapServer/0";
	
	
	
	
	
	
//	sthx = new ArcGISDynamicMapServiceLayer(sthxurl, {opacity: 0.8,	visible: true});
//	xmyz = new ArcGISDynamicMapServiceLayer(xmyzurl, {opacity: 0.5,	visible: false});
	sdc = new ArcGISDynamicMapServiceLayer(sdcurl, {opacity: 0.8,	visible: true});
//	noise = new ArcGISDynamicMapServiceLayer(noiseurl, {opacity: 0.8,visible: false});
	
	xzxq = new ArcGISDynamicMapServiceLayer(xzxqurl, {opacity: 0.8,visible: false});
	xzc = new ArcGISDynamicMapServiceLayer(xzcurl, {opacity: 0.8,visible: false});
	gyyq = new ArcGISDynamicMapServiceLayer(gyyqurl, {opacity: 0.8,visible: false});	
	thlyhfqy = new ArcGISDynamicMapServiceLayer(thlyhfqyurl, {opacity: 0.8,visible: false});
	sxt = new ArcGISDynamicMapServiceLayer(sxturl, {opacity: 0.8,visible: false});
	wsc = new ArcGISDynamicMapServiceLayer(wscurl, {opacity: 0.8,visible: false});
	sthx = new ArcGISDynamicMapServiceLayer(sthxurl, {opacity: 0.8,visible: false});
	xqyzqh = new ArcGISDynamicMapServiceLayer(xqyzqhurl, {opacity: 0.8,visible: false});
	
	jcdm = new ArcGISDynamicMapServiceLayer(jcdmurl, {opacity: 0.8,visible: false});
	pwk = new ArcGISDynamicMapServiceLayer(pwkurl, {opacity: 0.8,visible: false});
	zdhjfxyfb = new ArcGISDynamicMapServiceLayer(zdhjfxyfburl, {opacity: 0.8,visible: false});
	gyfqzz = new ArcGISDynamicMapServiceLayer(gyfqzzurl, {opacity: 0.8,visible: false});
	qybcdm = new ArcGISDynamicMapServiceLayer(qybcdmurl, {opacity: 0.8,visible: false});

	jcz = new ArcGISDynamicMapServiceLayer(jczurl, {opacity: 0.8,visible: false});
	//tdly = new ArcGISDynamicMapServiceLayer(tdlyurl, {opacity: 0.8,visible: false});
	zrc = new ArcGISDynamicMapServiceLayer(zrcurl, {opacity: 0.8,visible: false});
	hjfxqy = new ArcGISDynamicMapServiceLayer(hjfxqyurl, {opacity: 0.8,visible: false});
	
	yzc = new ArcGISDynamicMapServiceLayer(yzcurl, {opacity: 0.8,visible: false});
	zljp = new ArcGISDynamicMapServiceLayer(zljpurl, {opacity: 0.8,visible: false});
	//els = new ArcGISDynamicMapServiceLayer(elsurl, {opacity: 0.8,visible: false});
	
	zqsgnkhdm = new ArcGISDynamicMapServiceLayer(zqsgnkhdmurl, {opacity: 0.8,visible: false});
	sstkhdm = new ArcGISDynamicMapServiceLayer(sstkhdmurl, {opacity: 0.8,visible: false});
	jrq = new ArcGISDynamicMapServiceLayer(jrqurl, {opacity: 0.8,visible: false});
	lsxx = new ArcGISDynamicMapServiceLayer(lsxxurl, {opacity: 0.8,visible: false});
	
	
	stc = new ArcGISDynamicMapServiceLayer(stcurl, {opacity: 0.8,visible: false});
	zdqy = new ArcGISDynamicMapServiceLayer(zdqyurl, {opacity: 0.8,visible: false});
	
/*	map.addLayer(xmyz);
	map.addLayer(sthx);*/
	map.addLayer(otherlayer);
	
	
	map.addLayer(sdc);
//	noise.on("visibility-change", vischange);
//	map.addLayer(noise);
	
	map.addLayer(xzxq);
	map.addLayer(xzc);
	
	map.addLayer(gyyq);
	map.addLayer(thlyhfqy);
	
	map.addLayer(sxt);
	map.addLayer(wsc);
	
	map.addLayer(sthx);
	map.addLayer(xqyzqh);
	
	
	map.addLayer(jcdm);
	
	map.addLayer(pwk);
	
	map.addLayer(zdhjfxyfb);
	map.addLayer(gyfqzz);
	map.addLayer(qybcdm);
	
	map.addLayer(jcz);
	map.addLayer(zljp);
	//map.addLayer(els);
	
	map.addLayer(zqsgnkhdm);
	map.addLayer(sstkhdm);
	map.addLayer(jrq);
	map.addLayer(lsxx);
	
	
	map.addLayer(stc);
	map.addLayer(zdqy);
	
	//tdly.on("visibility-change", vischange);
	function vischange(layer){
		//if()
//		console.log(layer.target.url)
//		var layername=layer.target.url;
//		if(layername.indexOf("noise")!=-1||layername.indexOf("tdly")!=-1)
//		{
//			$("#maploading").hide();
//		}
	}
	//map.addLayer(tdly);
	map.addLayer(zrc);
	map.addLayer(hjfxqy);

	map.addLayer(yzc);
	
	//测距
	var parcelsLayer = new FeatureLayer("http://112.33.15.169:6868/arcgis/rest/services/liyangxin/zhezhao/MapServer/0", {
		mode: FeatureLayer.MODE_ONDEMAND,
		outFields: ["*"]
	});
	
	var snapManager = map.enableSnapping({
		snapKey: has("mac") ? keys.META : keys.CTRL
	});
	var layerInfos = [{
		layer: parcelsLayer
	}];
	snapManager.setLayerInfos(layerInfos);

	var measurement = new Measurement({
		map: map,
		defaultAreaUnit: Units.SQUARE_MILES,
		defaultLengthUnit: Units.KILOMETERS
	}, dom.byId("measurementDiv"));
	measurement.startup();
	
	var fistlayer="xzxq";
	dojo.connect(eval(fistlayer), "onLoad", loadok);
	function loadok(layer){
		changepage(fistlayer);
	}
	function mapReady() {
		

		queryTask = new QueryTask(parcelsURLzhezhao);
		query = new Query();
		query.returnGeometry = true;
		query.where = "1 = 1";
		queryTask.execute(query, function(results) {
			var zhezhaocolor = new Color([213, 215, 222]);
			simpleFillSymbol = new SimpleFillSymbol();
			simpleFillSymbol.setColor(zhezhaocolor);
			graphic = new Graphic(results.features[0].geometry, simpleFillSymbol);
			//select.add(graphic);
			zhezhaographiclayer=new GraphicsLayer();
			zhezhaographiclayer.add(graphic);
			zhezhaographiclayer.setOpacity(0.75);
			map.addLayer(zhezhaographiclayer);
			//map.graphics.add(graphic);
			//map.graphics.setOpacity(0.75);
			zhezhaographiclayer.on('mouse-out',function(event){
				//console.log("zhezhao-out");
			})
			map.on('click',function(event){
				$("#jingdu").val(event.mapPoint.x.toFixed(6));
				$("#weidu").val(event.mapPoint.y.toFixed(6));
				console.log(event.mapPoint.x.toFixed(6)+','+event.mapPoint.y.toFixed(6));
		 		if(iscallback){
		 			problempoint=event.mapPoint;

		 			ShowDiv("Callbackproblems","fade");
		 			iscallback=false;
		 			
		 			$("#moveimg").hide();
		 		}
			})
			map.on('mouse-move',function(event){
				$("#moveimg").css("left",event.pageX-50);
				$("#moveimg").css("top",event.pageY-50);
			})
//			map.on('zoom-start',function(event){
//				console.log("start"+event.level);
//			})
//			map.on('zoom-end',function(event){
//				console.log("end"+event.level);
//				if(event.level>14){
//					map.setZoom(14);
//				}
//			})
		});

		
		

	}

	mapReady();
	
	$("#xzxq").click(function(){
	})
	
	
	var layerStatus = 0
	$(".changebasemap").click(function(){
		if(layerStatus==0){
			$(".changebasemap .img").css({"background":"url(images/vec.png) no-repeat","background-size":"auto 100%"});
			map.getLayer("layer1").setVisibility(false);
			layerStatus = 1;
		}else {
			$(".changebasemap .img").css({"background":"url(images/img.png) no-repeat","background-size":" auto 100%"});
			map.getLayer("layer1").setVisibility(true);
			layerStatus = 0;
		}
		
	})
	
})