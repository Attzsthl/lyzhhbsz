//弹出隐藏层  
function ShowDiv(show_div,bg_div){  
$("#"+bg_div).width($(document).width);
$("#"+bg_div).height($(document).height());  
$("#"+bg_div).show(400);
$("#"+show_div).show(400);
};  
//关闭弹出层  
function CloseDiv(show_div,bg_div)  
{  
$("#"+bg_div).hide(400);
$("#"+show_div).hide(400);
}; 
//分页
var pagerow=6;
var currentpage=1;
var totalpage;
function showpage(page)
{
var firstrow=page*pagerow-pagerow;
var lastrow=page*pagerow-firstrow;
		$("#table tr:not(:eq(0))").hide();
		$("#table tr:gt("+firstrow+"):lt("+lastrow+")").show(500);
}
//下一页
function nextpage(){
if(currentpage<totalpage)
{
currentpage++;
$("#currentpage").html(currentpage);
showpage(currentpage);
}
}
//上一页
function lastpage(){
if(currentpage>1)
{
currentpage--;
$("#currentpage").html(currentpage);
showpage(currentpage);
}
}

//变量
var selected;
var last="reload";
var allop="";
var $this;
var selectedrow=-1;
var html;
var isedit=false;
var issearch=false;
var searchjson="";

	//增加
function append() {
//判断是否编辑
	if(isedit)
	{
		if(!save(function(){
	//增加文本框
		appendline();	
		}))
			return;
	}
	
	appendline();
	return;


}
//取消
function cancel() {
		if(last!="edit"&&last!="append")
			return;
		if(last=="edit")
			$this.html(html);
		if(last=="append")
			$this.remove();
		selectedrow=-1;
		$this.removeClass("trclick");
		isedit=false;
		last="cancel";
		allop+="cancel;";
}
//对象编辑
function edit(){
//判断是否执行
	if(isedit||selectedrow==-1)
	{
		return;
	}
//准备取消html
	html=$this.html();
	//文字变成文本框
    $this.children().each(function() {
        obj_text = $(this).find("input:text");    // 判断单元格下是否有文本框           
        if(!obj_text.length)   // 如果没有文本框，则添加文本框使之可以编辑
        {
            $(this).html("<input type='text' style='width:100%; height:100%;' value='"+$(this).text()+"'>");
        }
    });
    //处于编辑状态
    isedit=true;
    allop+="edit;";
    last="edit";
}





//日期校验
function checkdata(data)
{
	if(birthday.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/)==null)
		return false;
	else
		return true;
	
}

//初始化函数
function ad(){}



//查询全部
function searchall(){
	issearch=false;
	last="searchall";
	reload('',ad);
	}
//显示选中行
function checknumber() {
	alert("第"+ (selectedrow+1)+"行");
	}
//显示操作步骤
function checklast() {
alert(allop);
}