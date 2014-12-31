<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/oper/admin/role/new?navTabId=roleLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">	
	<div class="pageFormContent" layoutH="60">
	
		<p class="nowrap">
			<label>角色名称: </label>
			<input type="text" name="name" size="30" class="required"/>
		</p>		
		<p class="nowrap">
			<label>角色权限：</label>
			<select name="type" class="combox required">
				<option value="">--请选择--</option>
				<c:forEach var="item" items="${constants:roleTypeMap()}">
					<option value="${item.key}">${item.value}</option>
				</c:forEach>
			</select>	
		</p>
		<p class="nowrap">
			<label>描述: </label>
			<textarea name="description" rows="5" cols="60" maxlength="255"></textarea>
		</p>			
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
