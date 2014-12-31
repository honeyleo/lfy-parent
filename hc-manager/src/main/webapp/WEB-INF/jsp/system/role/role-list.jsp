<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>

<c:import url="/WEB-INF/jsp/layout/_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/oper/admin/role/list.page'/>" onsubmit="return navTabSearch(this)">
<!-- <input type="hidden" name="numPerPage" value="10" /> -->
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>角色权限：</label>
				<select name="kwType" class="combox required">
					<option value="">--请选择--</option>
					<c:forEach var="item" items="${constants:roleTypeMap()}">
						<option <c:if test="${param.kwType == item.key}">selected="selected"</c:if> value="${item.key}">${item.value}</option>
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
			<li><a class="add" target="dialog" mask="true" rel="roleNav" href="<c:url value='/oper/admin/role/new'/>" title="添加角色"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" mask="true" rel="roleNav" href="<c:url value='/oper/admin/role/edit?roleId={slt_objId}'/>" title="编辑角色"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/oper/admin/role/delete?roleId={slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="200">角色名称</th>
				<th width="150">角色权限</th>
				<th width="200">描述</th>
				<th>权限管理</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${resultPage.dataRows}" varStatus="varStatus">
			<tr target="slt_objId" rel="${item.id}">
				<td>${varStatus.count}</td>
				<td>${item.name}</td>
				<td>${constants:roleTypeMap()[item.type]}</td>
				<td>${item.description}</td>
				<td><a class="txtBlue" target="dialog" mask="true" rel="userNav" height="610" width="400" href="<c:url value='/oper/admin/role/rolepermission?roleId=${item.id}'/>" title="角色权限管理">权限管理</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="/WEB-INF/jsp/layout/_frag/pager/panelBar.jsp"></c:import>
</div>