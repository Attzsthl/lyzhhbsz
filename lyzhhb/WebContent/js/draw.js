//abc
var list=['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'];
function draw3Charts(dm) {

 			function getjson(type) {
			    var jsonStr = "{"; // json格式开始
			    jsonStr+="\"dm\":\""+dm+
			    		 "\",\"type\":\""+type+
			    		 "\"}"; 
			    var jsonObj = jQuery.parseJSON(jsonStr);
			    return jsonObj;
			}
           			 $.post("bc.action",getjson("gmsy"),function(result){ 
           			 	
                        console.log(result);
                        var chart= new Highcharts.Chart('gmsycontainer', {          
                        chart: {
                            //backgroundColor: "#FFF5EE ",
                            type: 'line'                         //指定图表的类型，默认是折线图（line）
                        },
                        title: {
                            text: '高锰酸盐浓度统计'                //指定图表标题
                        },
                        xAxis: {
                            categories:list
                            //categories: ['1月', '2月', '3月','4月', '5月', '6月','7月', '8月', '9月','10月', '11月', '12月'] //指定x轴分组
                        },
                        yAxis: {
                            title: {
                                text: '指数'                //指定y轴的标题
                            }
                        },
                        series: result,
                        credits:{
                                enabled:false // 禁用版权信息
                            },
                        colors: ['#FF3333', '#00FF00', '#0000FF','#000000','#FFFF00','#8A2BE2'] 
                    })
            
            
                    })
            
            
                    $.post("bc.action",	getjson("ad"),function(result){  
            
                        console.log(result);
                        var chart= new Highcharts.Chart('adcontainer', {          
                        chart: {
                           // backgroundColor: "#DCDCDC",
                            type: 'line'                         //指定图表的类型，默认是折线图（line）
                        },
                        title: {
                            text: '氨氮浓度统计'                //指定图表标题
                        },
                        xAxis: {
                        	categories:list
                            //categories: ['1月', '2月', '3月','4月', '5月', '6月','7月', '8月', '9月','10月', '11月', '12月'] //指定x轴分组
                        },
                        yAxis: {
                            title: {
                                text: 'mg/L'                //指定y轴的标题
                            }
                        },
                        series: result,
                        credits:{
                                enabled:false // 禁用版权信息
                            },
                        colors: ['#FF3333', '#00FF00', '#0000FF','#000000','#FFFF00','#8A2BE2']     
                    });
            
            
                    })
            
            
                    $.post("bc.action",	getjson("zl"),function(result){  
            
                        console.log(result);
                        var chart= new Highcharts.Chart('zlcontainer', {          
                        chart: {
                           // backgroundColor: "#FFFF77",
                            type: 'line'                         //指定图表的类型，默认是折线图（line）
                        },
                        title: {
                            text: '总磷浓度统计'                //指定图表标题
                        },
                        xAxis: {
                        	categories:list
                            //categories: ['1月', '2月', '3月','4月', '5月', '6月','7月', '8月', '9月','10月', '11月', '12月'] //指定x轴分组
                        },
                        yAxis: {
                            title: {
                                text: 'mg/L'                //指定y轴的标题
                            }
                        },
                        series: result,
                        credits:{
                                enabled:false // 禁用版权信息
                            },
                        colors: ['#FF3333', '#00FF00', '#0000FF','#000000','#FFFF00','#8A2BE2']     
                    });
            
            
                    })
    
    
    
    
    }

    function drawjcdmzb(dmName,year,zhibiao){
    	var step=(year=="全部"?12:1);
   			 year=(year=="全部"?"-1":year);
   			 
			function getjson() {
			    var jsonStr = "{"; // json格式开始
			    jsonStr+="\"dmmc\":\""+dmName+
			    		 "\",\"year\":\""+year+
			    		 "\",\"type\":\""+zhibiao+
			    		 "\"}"; 
			    var jsonObj = jQuery.parseJSON(jsonStr);
			    return jsonObj;
			}

            $.post("jcdm.action",getjson(),function(result){
    

                var danwei = " mg/L";
                if(zhibiao=="水温")danwei=" ℃";
                if(zhibiao=="水深")danwei=" m";
                if(zhibiao=="流量")danwei=" m³/s";
                if(zhibiao=="pH")danwei="";
                if(zhibiao=="电导率")danwei=" ms/m";
    
                var chart= new Highcharts.Chart('jcdmzb', {          
                    chart: {
                        //backgroundColor: "#FFF5EE ",
                        type: 'line'                         //指定图表的类型，默认是折线图（line）
                    },
                    tooltip: {
                        
                        pointFormat: '<b>{point.y}'+danwei+'</b>'
                         },
                    title: {
                        text: zhibiao+'统计 '+danwei               //指定图表标题
                    },
                    xAxis: {
                       // categories: ['1月','2月','3月','4月','5月','6月'] //指定x轴分组
                       tickInterval: step,
                       categories:result[0].xaxis
                    },
                    yAxis: {
                        title: {
                            text: ''                //指定y轴的标题
                        }
                    },
                    series: result[0].series,
                    credits:{
                            enabled:false // 禁用版权信息
                        },
                    colors: ['#FF3333', '#00FF00', '#0000FF','#000000','#FFFF00'] 
                        })
              
            })
    }


    function drawaqi(siteName,type){
    	$("#jczname").html(siteName);
			function getjson() {
			    var jsonStr = "{"; // json格式开始
			    jsonStr+="\"siteName\":\""+siteName+
			    		 "\",\"type\":\""+type+
			    		 "\"}"; 
			    var jsonObj = jQuery.parseJSON(jsonStr);
			    return jsonObj;
			}
            $.post("x24.action",getjson(),function(x){
	            $.post("aqi24.action",	getjson(),function(series){
	
	                var danwei = " μg/m³";
	                if(type=="AQI")danwei="";
	                if(type=="co")danwei=" mg/m³";
	
	                var chart= new Highcharts.Chart('aqi24', {          
	                    chart: {
	                        //backgroundColor: "#FFF5EE ",
	                        type: 'line'                         //指定图表的类型，默认是折线图（line）
	                    },
	                    tooltip: {
	                        
	                        pointFormat: '<b>{point.y}'+danwei+'</b>'
	                         },
	                    title: {
	                        text: '24小时空气质量分析 '+type.split("_").join(".").toLocaleUpperCase()+' '+danwei       //指定图表标题
	                    },
	                    xAxis: {
	                       
	                       categories:x
	                    },
	                    yAxis: {
	                        title: {
	                            text: ''                //指定y轴的标题
	                        }
	                    },
	                    series: series,
	                    credits:{
	                            enabled:false // 禁用版权信息
	                        },
	                    colors: ['#FF3333', '#00FF00', '#0000FF','#000000','#FFFF00'] 
	                        })
	
	            })

			})
    }
    
    function drawxzdm(instring){
    	var dmmc=instring.split("-")[1];
    	var hlmc=instring.split("-")[0];
    	var type=$("#xztype option:selected").val();
    	var year=$("#xzyear option:selected").val();
    	var step=(year=="all"?12:1);
    	year=(year=="all"?"-1":year);
    	
		function getjson() {
		    var jsonStr = "{"; // json格式开始
		    jsonStr+="\"type\":\""+type+
		    		 "\",\"dmmc\":\""+dmmc+
		    		 "\",\"hlmc\":\""+hlmc+
		    		 "\",\"year\":\""+year+
		    		 "\"}"; 
		    var jsonObj = jQuery.parseJSON(jsonStr);
		    return jsonObj;
		}
        $.post("xzdm.action",getjson(),function(result){

            var danwei = "mg/L";
            var chart= new Highcharts.Chart('xzdmzb', {          
                chart: {
                    //backgroundColor: "#FFF5EE ",
                    type: 'line'                         //指定图表的类型，默认是折线图（line）
                },
                tooltip: {
                    
                    pointFormat: '<b>{point.y}'+danwei+'</b>'
                     },
                title: {
                    text:    ''    //指定图表标题
                },
                xAxis: {
//                 tickInterval: step,
                   categories:result[0].xaxis
                },
                yAxis: {
                    title: {
                        text: danwei                //指定y轴的标题
                    }
                },
                series: result[0].series,
                credits:{
                        enabled:false // 禁用版权信息
                    },
                colors: ['#FF3333', '#00FF00', '#0000FF','#000000','#FFFF00'] 
                    })

        })
    }
 