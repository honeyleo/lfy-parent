<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="<c:url value='/oper/admin/menu/edit?navTabId=menuLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
	
	<input type="hidden" name="level" value="${level}"/>
	<input type="hidden" name="id" value="${menu.id}"/>
	
	<div class="pageFormContent" layoutH="60">
		<p class="nowrap">
			<label>菜单名称: </label>
			<input value="${menu.name}" type="text" name="name" class="required" size="30"/>
		</p>
		<div class="unit">
			<label>父级菜单: </label>
			<input id="parentId" name="parentId" class="" value="${menu.parentId}" type="hidden"/>
			<input id="parentName" name="parentName" value="${parentName}" type="text" disabled="disabled" class="readonly"/>
			<a id="findBack" class="btnLook" href="/oper/admin/menu/list?returnView=simple" height="610" width="400" lookupGroup="">选择菜单</a>
		</div>	
		<div class="unit">
			<label>排序: </label>
			<input value="${menu.sort}" type="text" name="sort" size="30"/>
		</div>
		<div class="unit">
			<label>请求地址: </label>
			<input value="${menu.url}" type="text" name="url" size="50"/>
		</div>
		<div class="unit">
			<label>引用: </label>
			<input value="${menu.rel}" type="text" name="rel" size="50"/>
		</div>
		<div class="unit">
			<label>菜单类型: </label>
			<select name="level" class="combox required">
				<option <c:if test="${level == 1}">selected="selected"</c:if> value="1">一级菜单</option>
				<option <c:if test="${level == 2}">selected="selected"</c:if> value="2">二级菜单</option>
				<option <c:if test="${level == 3}">selected="selected"</c:if> value="3">三级功能菜单</option>
			</select>
		</div>		
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
