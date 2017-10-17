<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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

    $(function() {
        $.get("<%=request.getContextPath()%>/welcome", function(data) {
            $("#iframeContent").html(data);//初始化加载界面  
        });

        $('#indexMenu li').click(function() {//点击li加载界面  
            var current = $(this);
            target = current.find('a').attr('target'); // 找到链接a中的targer的值  
            $('#indexMenu li').removeClass("active");//取消高亮
            current.addClass("active");//
            $('#indexMenu li').find('ul').attr('hidden', true);
            current.find('ul').attr('hidden', false);
            //alert("target:" + target);
            $.get(target, function(data) {
                $("#iframeContent").html(data);
            });
        });
    });
</script>
<style type="text/css">
.subMenu{
font-size: 10px;
/*background-color: rgba(51, 122, 183, 0.68);*/
}
</style>
</head>
<body>
<div class="container-fluid"><!--  -->
    <div class="row" ><h1 class="text-center">信息管理平台</h1></div><!-- header -->
	<div class="row"><!-- body -->
		<div class="col-md-3"><!-- 导航栏 -->
			<ul id="indexMenu" class="nav nav-pills nav-stacked ">
				<li role="presentation" class="active"><a target="<%=request.getContextPath()%>/welcome">Home</a></li>
				<li role="presentation"><a target="<%=request.getContextPath()%>/notice">福建师大后勤公告推送</a>
				    <ul id="noticeMenu" class="nav nav-pills nav-stacked subMenu" hidden >
                        <li role="presentation" ><a >爬虫设置</a></li>
                        <li role="presentation" ><a >推送设置</a></li>
                    </ul>
				</li>
				<li role="presentation"><a target="<%=request.getContextPath()%>/s">2</a></li>
			</ul>
		</div>
		<div id="iframeContent" class="col-md-9" ><!-- 窗体 -->
		</div>
	</div>
	<footer class="bs-docs-footer">
	       <h4 class="text-center">footer</h4>
    </footer>
</div>
</body>
</html>