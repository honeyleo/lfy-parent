<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/oper/admin/user/edit?navTabId=userLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">	
	
	<input value="${user.id}" type="hidden" name="id"/>
	<input value="${user.roleId}" type="hidden" name="oldRoleId"/>
	
	
	<div class="pageFormContent" layoutH="60">
	
		<p class="nowrap">
			<label>真实姓名: </label>
			<input value="${user.userName}" type="text" name="userName" size="30" class="required"/>
		</p>		
		<p class="nowrap">
			<label>昵称(登录名): </label>
			<input value="${user.nickname}" type="text" name="nickname" size="30" class="required"/>
		</p>		
		<p class="nowrap">
			<label>登录密码: </label>
			<input type="password" id="passwd" name="passwd" size="30" alt="字母、数字、下划线" minlength="6" maxlength="20" class="alphanumeric textInput"/>
		</p>		
		<p class="nowrap">
			<label>请重复输入密码: </label>
			<input type="password" name="passwd2" size="30" equalTo="#passwd" class="alphanumeric textInput"/>
		</p>
		<p>
			<label>角色</label>
			<select name="roleId" class="combox required">
				<option value="">--请选择--</option>
				<c:forEach var="item" items="${constants:roleMap()}">
					<option <c:if test="${user.roleId == item.key}">selected="selected"</c:if> value="${item.key}">${item.value}</option>
				</c:forEach>
			</select>
		</p>		
		<p class="nowrap">
			<label>状态：</label>
			<select name="status" class="combox required">
				<c:forEach var="item" items="${constants:userStatusMap()}">
					<option <c:if test="${user.status == item.key}">selected="selected"</c:if> value="${item.key}">${item.value}</option>
				</c:forEach>
			</select>
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
