<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>

<c:import url="/WEB-INF/jsp/layout/_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/oper/admin/manage/annunciate/list.page'/>" onsubmit="return navTabSearch(this)">
<!-- <input type="hidden" name="numPerPage" value="10" /> -->
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>通告名称：</label>
				<input type="text" name="kwName" value="${param.kwName}"/>
			</li>
			<li>
			    <label>状态：</label>
			    <select name="state" class="combox required">
			      <option value="">请选择</option>
			      <c:forEach var="annunciateStatusMap" items="${constants:annunciateStatusMap()}">
			        <option <c:if test="${!(empty param.state) and param.state==annunciateStatusMap.key}">selected="selected"</c:if>value="${annunciateStatusMap.key}" >${annunciateStatusMap.value}</option>
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
			<li><a class="add" target="dialog" mask="true" rel="annunciateLiNav" width="850" height="520" href="<c:url value='/oper/admin/manage/annunciate/new'/>" title="添加通告"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" mask="true" rel="annunciateLiNav"  width="850" height="520" href="<c:url value='/oper/admin/manage/annunciate/edit?annunciateid={slt_objId}'/>" title="编辑通告"><span>编辑</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" target="ajaxTodo" mask="true" href="<c:url value='/oper/admin/manage/annunciate/updatestatus?id={slt_objId}&operation=NONE'/>" title="确定要将此通告设为无效?" ><span>无效</span></a></li>
			<li><a class="icon" target="ajaxTodo" mask="true" href="<c:url value='/oper/admin/manage/annunciate/updatestatus?id={slt_objId}&operation=DISPLAY'/>"title="确定要将此通告设为有效?"><span>有效</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th width="70">通告标题</th>
				<th width="100">发布者</th>
				<th width="120">通告状态</th>
				<th width="250">发布日期</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${resultPage.dataRows}" varStatus="varStatus">
			<tr target="slt_objId" rel="${item.id}">
				<td>${varStatus.count}</td>
				<td>${item.title}</td>
				<td>${item.outhre}</td>
				<td>${constants:annunciateStatusMap()[item.state]}</td>
				<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="/WEB-INF/jsp/layout/_frag/pager/panelBar.jsp"></c:import>
</div>