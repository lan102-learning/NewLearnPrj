<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="tag_lib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/3.3.7/css/bootstrap.css" crossorigin="anonymous">
<script src="<%=request.getContextPath()%>/jquery/3.2.1/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/bootstrap/3.3.7/js/bootstrap.js" crossorigin="anonymous"></script>
<title>信息管理平台</title>
<script type="text/javascript">
/*$(document).ready(function(){
    alert($(window).width());
    if($(window).width()<=1000){
        alert($(window).width());
   };
   
});*/

    $(function() {
        $.get("<%=request.getContextPath()%>/welcome", function(data) {
            $("#iframeContent").html(data);//初始化加载界面  
        });
        
        $(document).on("click", "#indexMenu li", function() {//点击li加载界面  
            var current = $(this);
            if(current.hasClass('active')) return;
            target = current.find('a').attr('target'); // 找到链接a中的targer的值  
            $('#indexMenu li').removeClass("active");//取消高亮
            current.addClass("active");//
            $('#indexMenu li').find('ul').attr('hidden', true);
            current.find('ul').attr('hidden', false);
            //alert();
            if(current.find('ul').attr('class')==null){
                //alert("发送请求");
	            $.post("<%=request.getContextPath()%>/getsubmenu",
	              {
	                menuId:current.attr('id')
	               },
	               function(data,status){
	                   //alert("状态：" + status + "\n数据：" + obj );
	                   var obj = eval (data);
	                   var newUl = '<ul  class="nav nav-pills nav-stacked subMenu" >';
	                   $(obj).each(function(){
	                       newUl = newUl+'<li role="presentation" id="'+this.menuId+'"><a target="'+this.path+'">'+this.menuName+'</a></li>';
	                   })
	                   newUl = newUl+'</ul>';
	                   current.append(newUl);
	                 },"json");
            } 
            //alert("target:" + target);
            $.get(target, function(data) {
                $("#iframeContent").html(data);
            });
        });
        
    });

$(document).on("click", "#dropdown_menu li", function() {//点击li加载界面  
    var current = $(this);
    if(current.hasClass('active')) return;
    target = current.find('a').attr('target'); // 找到链接a中的targer的值  
    alert(target);
    $('#indexMenu li').removeClass("active");//取消高亮
    current.addClass("active");//
    $('#indexMenu li').find('ul').attr('hidden', true);
    current.find('ul').attr('hidden', false);
    $.get(target, function(data) {
        $("#iframeContent").html(data);
    });
});

$(document).on("click", "#dropdown_navigation", function() {
    //alert($("#indexMenu").html());
    var menuData = $("#indexMenu").html()
    //$(this).parent().find('ul').remove();
    //$(this).parent().append('<ul class="dropdown-menu" id="dropdown_menu" >'+menuData+'</ul>');
    $(this).parent().find('ul').append(menuData);
});
</script>
<style type="text/css">
.subMenu {
	font-size: 10px;
	/*background-color: rgba(51, 122, 183, 0.68);*/
}

.bar {
	float: left;
	border-right: 1px solid #e1e1e1;
	padding-bottom: 1600px;
	margin-bottom: -1600px;
}

.hand {
	cursor: pointer;
}
@media screen and (max-width: 991px) {
    .hidden-xs {
    display: none !important; 
  }
  .show-xs{
     display: inline-block !important;
  } 

}

.show-xs{
    display: none; 
    float: left; 
    margin-left: 20px;
  } 
</style>
</head>
<body>
<div class="container-fluid"><!--  -->
    <div class="row" >
    <!-- 屏幕过小时的导航栏 -->
        <h1 class="text-center" ><div class="show-xs" >
            <li role="presentation" class="dropdown" type="none" >
	            <a  class="dropdown-toggle" data-toggle="dropdown" href="#" id="dropdown_navigation"
	                role="button" aria-haspopup="true" aria-expanded="false">
	                <div class="glyphicon glyphicon-align-justify hand" style="color:black;"></div>
	            </a>
	            <ul class="dropdown-menu" id="dropdown_menu">
	            </ul>
            </li>
        </div>信息管理平台</h1>
    </div><!-- header -->
	<div class="row"><!-- body -->
		<div class="col-md-3 hidden-xs"><!-- 导航栏 -->
			<ul id="indexMenu" class="nav nav-pills nav-stacked ">
		      	<c:forEach items="${menuList}" var="menu">
		      	<li role="presentation" class="hand" id="${menu.getMenuId()}"><a target="${menu.getPath()}">${menu.getMenuName()}</a></li>
			   </c:forEach>
			</ul>
		</div>
		<div class="bar"></div>
		<div id="iframeContent" class="col-md-9 " ><!-- 窗体 -->
		</div>
	</div>
	<footer class="bs-docs-footer">
	       <h4 class="text-center">footer</h4>
    </footer>
</div>
</body>
</html>