<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<c:import url="/WEB-INF/jsp/layout/_frag/pager/pagerForm.jsp"></c:import>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>车王之王运营平台</title>

<link href="<c:url value='/styles/dwz/themes/default/style.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/styles/dwz/themes/css/core.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/styles/css/common.css'/>" rel="stylesheet" type="text/css" />
<!--[if IE]>
<link href="<c:url value='/styles/dwz/themes/css/ieHack.css'/>" rel="stylesheet" type="text/css" />
<![endif]-->

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
		loginTitle:"登录",	// 弹出登录对话框
		loginUrl:"<c:url value='/dialoglogin' />",	// 跳到登录页面
		pageInfo:{pageNum:"pageNum", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"}, 
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"<c:url value='/styles/dwz/themes'/>"});
		}
	});
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)">Logo</a>
				<ul class="nav">
					<li><a href="<c:url value='/passport/logout'/>"></a></li>
					<li><a href="<c:url value='/exit'/>">登出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">blue</div></li>
					<li theme="green"><div>green</div></li>
					<li theme="purple"><div>purple</div></li>
					<li theme="silver"><div>silver</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>赛车查询后台</h2><div>collapse</div></div>
  					<div class="accordion" fillSpace="sideBar">
						<c:forEach var="menu1" items="${firstMenu}">
							<div class="accordionHeader">
								<h2><span>Folder</span>${menu1.name}</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									<c:forEach var="menu2" items="${secondMenu}">
										<c:if test="${menu1.id == menu2.parentId}">
											<li><a href="<c:url value='${menu2.url}'/>" title="${menu2.name}" target="navTab" rel="${menu2.rel}">${menu2.name}</a></li>
										</c:if>
									</c:forEach>
								</ul>
							</div>
						</c:forEach>
					</div>
					
<%--   				<div class="accordion" fillSpace="sideBar">
					<div class="accordionHeader">
						<h2><span>Folder</span>数据管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/car/admin/manage/bigchannel/list.page'/>" title="合作渠道信息管理" target="navTab" rel="bigchannelLiNav">合作渠道信息管理</a></li>
							<li><a href="<c:url value='/car/admin/manage/channel/list.page'/>" title="渠道号管理" target="navTab" rel="channelLiNav">渠道号管理</a></li>
							<li><a href="<c:url value='/car/admin/manage/paychannel/list.page'/>" title="支付渠道管理" target="navTab" rel="paychannelLiNav">支付渠道管理</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>数据查询</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/car/admin/query/orderquery/list.page'/>" title="支付订单查询" target="navTab" rel="payorderqueryLiNav">支付订单查询</a></li>
							<li><a href="<c:url value='/car/admin/query/paystatistisc/list.page'/>" title="充值统计数据查询" target="navTab" rel="paystatisticsLiNav">充值统计数据查询</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="<c:url value='/car/admin/role/list.page'/>" title="角色列表" target="navTab" rel="roleLiNav">角色管理</a></li>
							<li><a href="<c:url value='/car/admin/user/list.page'/>" title="人员列表" target="navTab" rel="userLiNav">人员管理</a></li>
							<li><a href="<c:url value='/car/admin/menu/list'/>" title="功能菜单列表" target="navTab" rel="menuLiNav">功能菜单管理</a></li>
						</ul>
					</div>									
				</div> --%>
				
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">My Home</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">My Home</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<div class="accountInfo">
							<div class="right">
								<p><fmt:formatDate value="${now}" pattern="yyyy-MM-dd EEEE"/></p>
							</div>
							<p><span>Welcome： ${user.nickname}</span></p>
						</div>
						
						<c:if test="${!empty annunciateList}">
							<!--显示通告  -->
							<div style="width: 800px;border: 0px solid red;">
								   <c:if test="${annunciateList != null}">
										<p style="margin: 10px 0 0 50px">
											<label style="font-size:26px;font-weight: 900;">通告:</label>
										</p>				
									</c:if>
							  <table style="margin: 10px 0 0 112px">
								  <c:forEach var="item" items="${annunciateList}">
								    <tr style="height: 20px;">
								      <td class="size17"><a target="dialog" mask="true" width="860" height="740"  title="通告" href="<c:url value='/oper/admin/manage/annunciate/view?annunciateid=${item.id}'/>"><span style="font-size: 15px;">${item.title}</span></abbr></a></td>
								      <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								    </tr>
								   </c:forEach>
							  </table>
							</div>
							<!--显示通告  -->						
						</c:if>
						
						
<%-- 				
<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>	
							<p>
								<label>用户名:</label><span class="unit">${contextUser.username}</span>
							</p>
							<p>
								<label>姓名:</label><span class="unit">${contextUser.nickname}</span>
							</p>
							<p>
								<label>电话:</label><span class="unit">${contextUser.phone}</span>
							</p>
							<p>
								<label>Email:</label><span class="unit">${contextUser.email}</span>
							</p>
 --%>							
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="footer"><fmt:message key="ui.copyrights" /></div>


</body>
</html>