$(".lead li").click(function(event) {
	$(this).css('background', '#C9D3C6');
	$(this).siblings('li').css('background', '#fff');
});
    $(".lead>li>div").click(function(event) {
        $(".lead ."+$(this).data('num')).parent().show('400');
        $(".lead a:not('."+$(this).data('num')+"')").parent().hide('200');
    });
var list=['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'];
    function drawqyCharts(dm) {
		var type=$("#qytype option:selected").text();
		var year=$("#qyyear option:selected").text();
		if(year=="全部"){
			year=-1;
		}
		var danwei;
		if(type=="高锰酸盐")
			danwei="指数";
		else
			danwei="g/m3";
			
		
			function getjson() {
		    var jsonStr = "{"; // json格式开始
		    jsonStr+="\"dm\":\""+dm+
		    		"\",\"year\":\""+year+
		    		 "\",\"type\":\""+type+
		    		 "\"}"; 
					/*jsonStr+="\"dmmc\":\""+dm+
		    		"\",\"year\":\""+year+
		    		 "\",\"type\":\""+type+
		    		 "\"}"; */
			    console.log(jsonStr);
		    var jsonObj = jQuery.parseJSON(jsonStr);
		    return jsonObj;
		}
       			 $.post("newbc.action",getjson(),function(result){ 
					/*var str=JSON.stringify(result);
					alert("123"+str);
                    console.log(str);*/
                    var chart= new Highcharts.Chart('qybcdmzb', {          
                    chart: {
                        //backgroundColor: "#FFF5EE ",
                        type: 'line'                         //指定图表的类型，默认是折线图（line）
                    },
                    title: {
                        text: type+'浓度统计'                //指定图表标题
                    },
                    xAxis: {
                        categories:list
                        //categories: ['1月', '2月', '3月','4月', '5月', '6月','7月', '8月', '9月','10月', '11月', '12月'] //指定x轴分组
                    },
                    yAxis: {
                        title: {
                            text: danwei                //指定y轴的标题
                        }
                    },
                    series: result,
                    credits:{
                            enabled:false // 禁用版权信息
                        },
                    colors: ['#FF3333', '#00FF00', '#0000FF','#000000','#FFFF00','#8A2BE2'] 
                })
        
        
                })
     }