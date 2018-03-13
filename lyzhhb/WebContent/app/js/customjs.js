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