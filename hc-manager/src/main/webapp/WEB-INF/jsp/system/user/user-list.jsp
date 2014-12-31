<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>

<c:import url="/WEB-INF/jsp/layout/_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/oper/admin/user/list.page'/>" onsubmit="return navTabSearch(this)">
<!-- <input type="hidden" name="numPerPage" value="10" /> -->
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>用户名：</label>
				<input type="text" name="kwName" value="${param.kwName}"/>
			</li>		
			<li>
				<label>用户状态：</label>
				<select name="kwStatus" class="combox required">
					<option value="">--请选择--</option>
					<c:forEach var="item" items="${constants:userStatusMap()}">
						<option <c:if test="${param.kwStatus == item.key}">selected="selected"</c:if> value="${item.key}">${item.value}</option>
					</c:forEach>
				</select>				
			</li>
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" mask="true" rel="userNav" href="<c:url value='/oper/admin/user/new'/>" title="添加用户"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" mask="true" rel="userNav" href="<c:url value='/oper/admin/user/edit?userId={slt_objId}'/>" title="编辑用户"><span>编辑</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" target="ajaxTodo" mask="true" href="<c:url value='/oper/admin/user/updatestatus?userId={slt_objId}&operation=FORBIDDEN'/>" title="确定要将此资源上线?"><span>禁用</span></a></li>
			<li><a class="icon" target="ajaxTodo" mask="true" href="<c:url value='/oper/admin/user/updatestatus?userId={slt_objId}&operation=NORMAL'/>" title="确定要将此资源下线?"><span>可用</span></a></li>
<%-- 			<li><a class="delete" target="ajaxTodo" href="<c:url value='/car/admin/user/delete?userId={slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li> --%>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="200">昵称</th>
				<th width="200">用户名</th>
				<th width="100">角色</th>
				<th width="100">状态</th>
				<th width="130">合作渠道</th>
				<th>功能权限管理</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${resultPage.dataRows}" varStatus="varStatus">
			<tr target="slt_objId" rel="${item.id}">
				<td>${varStatus.count}</td>
				<td>${item.userName}</td>
				<td>${item.nickname}</td>
				<td>${constants:roleMap()[item.roleId]}</td>
				<td <c:if test="${item.status == 2 }">class="txtBlue"</c:if> >${constants:userStatusMap()[item.status]}</td>
				<td><a class="txtBlue" target="dialog" mask="true" rel="userNav" height="610" width="400" href="<c:url value='/oper/admin/user/userbigqn?userId=${item.id}'/>" title="合作渠道权限管理">合作渠道权限管理</a></td>
				<td><a class="txtBlue" target="dialog" mask="true" rel="userNav" height="610" width="400" href="<c:url value='/oper/admin/user/userpermission?userId=${item.id}'/>" title="用户权限管理">权限管理</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="/WEB-INF/jsp/layout/_frag/pager/panelBar.jsp"></c:import>
</div>