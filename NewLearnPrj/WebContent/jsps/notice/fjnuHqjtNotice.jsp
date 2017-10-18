<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/3.3.7/css/bootstrap.css" crossorigin="anonymous">
<link href="<%=request.getContextPath()%>/jsps/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link href="<%=request.getContextPath()%>/jsps/css/bootstrap-switch.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/jquery/3.2.1/jquery.js"></script>
<script src="<%=request.getContextPath()%>/bootstrap/3.3.7/js/bootstrap.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="<%=request.getContextPath()%>/jsps/js/bootstrap-switch.js"></script>

<title>福建师大后勤公告推送</title>
<script type="text/javascript">
$(document).ready(function(){
    $("#addCatchTime").click(function(){//添加抓取时间    //动态生成 时间选择
      $("#catchTime").append("<div class=\"input-group date form_time col-md-5 catchTimeDiv\" data-date=\"\" data-date-format=\"hh:ii\" data-link-field=\"dtp_input3\" data-link-format=\"hh:ii\"> <input name=\"catchTimeList\" class=\"form-control\" size=\"16\" type=\"text\" value=\"\" readonly> <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-remove\"></span></span> <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-time\"></span></span> <span class=\"input-group-addon\"><span  class=\"glyphicon glyphicon-minus removeTime\"></span></span> </div>");
      $.initDataPlugin();
    });
    
    $("#addReceiveEmail").click(function () {//添加接收邮箱
        $("#addReceiveEmail").parent().append("<div class=\"input-group hand col-md-5 receiveEmailDiv\"> <input name=\"receiveMailList\" type=\"email\" class=\"form-control\"   placeholder=\"邮箱\"> <span class=\"input-group-addon\"><span  class=\"glyphicon glyphicon-minus removeReceiveEmail\"></span></span> </div>");
    });
    
  });    
  
$(document).on("click", ".removeTime", function() {//删除抓抓取时间
    if($(".catchTimeDiv").length==1){
        alert("至少需要一个抓取时间");
        return;
    }
    $(this).parent().parent().remove();
});

$(document).on("click", ".removeReceiveEmail", function() {//删除接受邮箱
    if($(".receiveEmailDiv").length==1){
        alert("接受邮箱至少需要一个");
        return;
    }
    $(this).parent().parent().remove();
});


$(function () {//初始化 bootstrap-Switch
    $("[name='isSendImm']").bootstrapSwitch({
        onSwitchChange:function(event,state){
            if(state==true){
                $('#sendTimeDiv').attr('hidden', true);
            }else{
                $('#sendTimeDiv').attr('hidden', false);
            }
        }
    });
});
</script>
<style type="text/css">
.littleTittle{
color: #0593fb;
}
.photoButton{
border-style :none;
background-color :rgba(0, 0, 0, 0);
padding: 0px;
}
.hand{
cursor:pointer;
}
</style>
</head>
<body>
<div class="container col-md-12" >
    <h1 class="text-center" >福建师大后勤公告推送</h1>
    <form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/notice/submitConf">
    <h3 class="text-left littleTittle">爬虫设置</h1>
	  <div id="catchTime" class="form-group">
	   <label >抓取信息时间：每日</label>
	    <button id="addCatchTime"  type="button" class="glyphicon glyphicon-plus-sign photoButton" > </button>
	   <div  class="input-group date form_time col-md-5 catchTimeDiv" data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" 
	       data-link-format="hh:ii">
          <input name="catchTimeList" class="form-control" size="16" type="text" value="" readonly>
          <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
          <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
          <span class="input-group-addon"><span  class="glyphicon glyphicon-minus removeTime"></span></span>
       </div>
	  </div>
	  <h3 class="text-left littleTittle">推送设置</h1>
	  <div class="form-group ">
        <label >发送邮箱</label>
        <div class="input-group  col-md-5 receiveEmailDiv">
            <input name="sendEmail" type="email" class="form-control"   placeholder="发送邮箱">
        </div>
        <label >发送邮箱密码</label>
        <div class="input-group  col-md-5 receiveEmailDiv">
            <input name="sendEmailPwd" type="password" class="form-control"   placeholder="发送密码">
        </div>
      </div>
        <div class="form-group ">
            <label >抓取消息立刻推送</label>
            <input  name="isSendImm"  type="checkbox" checked="true" data-size="small" data-on-text="开" 
            data-off-text="关" data-off-color="warning" value="true"/>
            <div id="sendTimeDiv" hidden>
            <div class="input-group date form_time col-md-5" data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii" hidden="hidden">
	          <input name="sendTime" class="form-control" size="16" type="text" value="" readonly>
	          <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
	          <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
	         <!-- <span class="input-group-addon"><span  class="glyphicon glyphicon-minus removeTime"></span></span>  --> 
             </div>
             </div>
        </div>
	  <div class="form-group ">
        <label >接收邮箱</label>
        <button id="addReceiveEmail"  type="button" class="glyphicon glyphicon-plus-sign photoButton" > </button>
        <div class="input-group  col-md-5 receiveEmailDiv">
	        <input name="receiveMailList" type="email" class="form-control"   placeholder="邮箱">
	        <span class="input-group-addon"><span  class="hand glyphicon glyphicon-minus removeReceiveEmail" ></span></span>
        </div>
      </div>
	   <button type="submit" class="btn btn-default" >保存</button>
    </form>
</div>
<script type="text/javascript">
$.initDataPlugin = function(){ //初始化bootstrap-datetimepicker
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