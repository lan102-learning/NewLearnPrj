<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" crossorigin="anonymous">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-switch.css" rel="stylesheet">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="js/bootstrap-switch.js"></script>

<title>福建师大后勤公告推送</title>
<script type="text/javascript">
$(document).ready(function(){
    $("#addCatchTime").click(function(){//动态生成 时间选择
      $("#catchTime").append("<div class=\"input-group date form_time col-md-5\" data-date=\"\" data-date-format=\"hh:ii\" data-link-field=\"dtp_input3\" data-link-format=\"hh:ii\"> <input class=\"form-control\" size=\"16\" type=\"text\" value=\"\" readonly> <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-remove\"></span></span> <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-time\"></span></span> <span class=\"input-group-addon\"><span  class=\"glyphicon glyphicon-minus removeTime\"></span></span> </div>");
      $.initDataPlugin();
    });
  
    $(document).on("click", ".removeTime", function() {
        if($(".removeTime").length==1){
            alert("至少需要一个时间");
            return;
        }
        $(this).parent().parent().remove();
    });
    
  });    
  
$(function () {
    $("input[type=\"checkbox\"], input[type=\"radio\"]").not("[data-switch-no-init]").bootstrapSwitch();
    $("[name='my-checkbox']").bootstrapSwitch();
})
  
</script>
<style type="text/css">
.littlebutton{
padding: 0px;
}
.littleTittle{
color: #0593fb;
}

</style>
</head>
<body>
<div class="container col-md-12" >
    <h1 class="text-center" >福建师大后勤公告推送</h1>
    <form class="form-horizontal">
    <h3 class="text-left littleTittle">爬虫设置</h1>
	  <div id="catchTime" class="form-group">
	   <label >抓取信息时间：每日</label>
	   <button id="addCatchTime" type="button" class="btn btn-default glyphicon glyphicon-plus littlebutton" > </button>
	   <div class="input-group date form_time col-md-5" data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">
          <input class="form-control" size="16" type="text" value="" readonly>
          <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
          <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
          <span class="input-group-addon"><span  class="glyphicon glyphicon-minus removeTime"></span></span>
       </div>
	  </div>
	  <h3 class="text-left littleTittle">推送设置</h1>
	   <!--  <div class="control-group">
        <div><label >抓取消息立刻推送</label></div>
        <div><input type="checkbox" data-off-color="warning" name="my-checkbox" checked /></div>
      </div>-->
		<div class="control-group">
		    <label class="control-label" for="notification2">Notification 2</label>
		    <div class="controls">
		        <div class="switch" tabindex="0">
		            <input id="notification2"  name="my-checkbox" type="checkbox" checked/>
		        </div>
		    </div>
		</div>
	  <div class="form-group">
        <label >推送邮箱</label>
        <div> <input type="email" class="form-control" size="16" id="exampleInputEmail1" placeholder="邮箱"></div>
      </div>
	   <button type="submit" class="btn btn-default">保存</button>
    </form>
</div>
<script type="text/javascript">
$.initDataPlugin = function(){
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
};

$.initDataPlugin();
</script>
</body>
</html>