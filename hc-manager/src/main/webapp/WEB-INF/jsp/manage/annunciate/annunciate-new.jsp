<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/oper/admin/manage/annunciate/new?navTabId=annunciateLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">	
	<div class="pageFormContent" layoutH="58">
	
		<p class="nowrap">
			<label>通告标题: </label>
			<input type="text" name="title" size="30" class="required"/>
		</p>	
			
		<p class="nowrap">
			<label>通告内容: </label>
			<textarea class="editor" name="context" rows="18" cols="90" tools="full" class="required" ></textarea>
		</p>
		
		<p class="nowrap">
			<label>通告状态: </label>
			<select name="state" class="combox required">
			   <c:forEach var="item" items="${constants:annunciateStatusMap()}">
			      <option value="${item.key}">${item.value}</option>
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
