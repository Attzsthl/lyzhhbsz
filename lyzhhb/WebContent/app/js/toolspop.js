		function changtext($this){
			
			$this=$this.find(" span");
			var text="";
			if($this.hasClass("glyphicon-plus")){
				text="新增";
			}else if($this.hasClass("glyphicon-pencil")){
				text="编辑";
			}else if($this.hasClass("glyphicon-remove")){
				text="删除";
			}else if($this.hasClass("glyphicon-ok")){
				text="保存";
			}else if($this.hasClass("glyphicon-share-alt")){
				text="取消";
			}else if($this.hasClass("glyphicon-download-alt")){
				text="导入";
			}else if($this.hasClass("glyphicon-edit")){
				text="处理问题";
			}else if($this.hasClass("glyphicon-save")){
				text="模板下载";
			}
			$("#toolspop").html(text);			
		};
		$("#tools a").hover(function(){
			changtext($(this));
		    $("#toolspop").show();
		},function(){
		    $("#toolspop").hide();
		});
		$(document).mousemove(function(e){
			$("#toolspop").css("left",e.pageX+15);
			$("#toolspop").css("top",e.pageY+10);
		  });