<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>车王之王运营平台</title>

<link href="/styles/dwz/themes/css/login.css" rel="stylesheet" type="text/css" />
<link href="<c:url value='/styles/dwz/themes/default/style.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/styles/dwz/themes/css/core.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/styles/css/common.css'/>" rel="stylesheet" type="text/css" />

<script src="<c:url value='/styles/dwz/js/speedup.js'/>" type="text/javascript"></script>
<script src="<c:url value='/styles/dwz/js/jquery-1.7.2.js'/>" type="text/javascript"></script>
<script src="<c:url value='/styles/dwz/js/jquery.cookie.js'/>" type="text/javascript"></script>
<script src="<c:url value='/styles/dwz/js/jquery.validate.js'/>" type="text/javascript"></script>
<script src="<c:url value='/styles/dwz/js/jquery.bgiframe.js'/>" type="text/javascript"></script>
<script src="<c:url value='/styles/xheditor/xheditor-1.2.1.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/styles/xheditor/xheditor_lang/zh-cn.js'/>" type="text/javascript"></script>

<script src="<c:url value='/styles/dwz/js/dwz.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/styles/dwz/js/dwz.regional.zh.js'/>" type="text/javascript"></script>

<script type="text/javascript">

	$(function(){
		DWZ.init("<c:url value='/styles/dwz/dwz.frag.xml'/>", {
			callback:function(){
				$("body").append(DWZ.frag["dwzFrag"]);
				if ($.browser.msie && /6.0/.test(navigator.userAgent)) {
					try {
						document.execCommand("BackgroundImageCache", false,
								true);
					} catch (e) {
					}
				}
				if ($.browser.msie) {
					window.setInterval("CollectGarbage();", 10000);
				}
				$(window).resize(function() {
					initLayout();
					$(this).trigger(DWZ.eventType.resizeGrid);
				});
				var ajaxbg = $("#background,#progressBar");
				ajaxbg.hide();
				$(document).ajaxStart(function() {
					ajaxbg.show();
				}).ajaxStop(function() {
					ajaxbg.hide();
				});
			}
		});
		$('#loginButton').bind('click', loginVerify);
		
		$('#username').focus();
	});

	function loginVerify() {

		var params = $("#loginForm").serialize();
		$.ajax({
			type : 'POST',
			url : '/login/loginverify',
			async : false,
			data : params,
			success : function(data) {
				if(data == true || data == 'true'){
					window.location.href="/oper/admin/index";
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				
				var status = XMLHttpRequest.status;
				var jsonStr = XMLHttpRequest.responseText;
				var obj = jQuery.parseJSON(jsonStr);
				var code = obj.code;
				if (parseInt(status) == 403) {
					if(parseInt(code) == 1){
						window.location.href="/oper/admin/index";
					}else{
						alertMsg.error(obj.message);
					}
				} else{
					serverException(status, stateCode);
				}
			}
		});
	}
function KeyDown()
{
    if (event.keyCode == 13)
    {
        event.returnValue=false;
        event.cancel = true;
        $("#loginButton").click();
    }
}
</script>
</head>

<body>

	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="#"><img src="/styles/dwz/themes/default/images/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
<!-- 						<li><a href="#">设为首页</a></li> -->
<!-- 						<li><a href="http://bbs.dwzjs.com">反馈</a></li> -->
<!-- 						<li><a href="/styles/doc/dwz-user-guide.pdf" target="_blank">帮助</a></li> -->
					</ul>
				</div>
				<h2 class="login_title"><img src="/styles/dwz/themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form id="loginForm" name="loginForm">
					<p>
						<label>用户名：</label>
						<input type="text" id="username" name="username" size="20" class="login_input"  />
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="password" size="20" class="login_input"  onkeydown="KeyDown()"/>
					</p>
					<div class="login_bar">
						<input id="loginButton" name="loginButton" class="sub" type="button" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="/styles/dwz/themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
<!--  				<ul class="helpList">
					<li><a href="#">下载驱动程序</a></li>
					<li><a href="#">如何安装密钥驱动程序？</a></li>
					<li><a href="#">忘记密码怎么办？</a></li>
					<li><a href="#">为什么登录失败？</a></li>
				</ul>  -->
<!-- 				<div class="login_inner">
					<p>您可以使用 网易网盘 ，随时存，随地取</p>
					<p>您还可以使用 闪电邮 在桌面随时提醒邮件到达，快速收发邮件。</p>
					<p>在 百宝箱 里您可以查星座，订机票，看小说，学做菜…</p>
				</div> -->
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2014 www.huizhi.com Inc. All Rights Reserved.
		</div>
	</div>
</body>
</html>