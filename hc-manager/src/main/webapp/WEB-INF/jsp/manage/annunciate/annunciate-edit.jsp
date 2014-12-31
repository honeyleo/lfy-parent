<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/oper/admin/manage/annunciate/edit?navTabId=annunciateLiNav&callbackType=closeCurrent'/>" 
	class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">	
	
	<input type="hidden" value="${annunciate.id}" name="id">

	<div class="pageFormContent" layoutH="58">
	
		<p class="nowrap">
			<label>通告标题: </label>
			<input type="text" name="title" size="30" value="${annunciate.title}" class="required"/>
		</p>		
		<p class="nowrap">
			<label>通告內容: </label>
			<textarea class="editor" name="context"  rows="18" cols="90" tools="full" class="required" >${annunciate.context}</textarea>
		</p>
		<p>
		  <input type="hidden" name="outhre" value="${annunciate.outhre }"> 
		</p>
		<p class="nowrap">
			<label>通告状态：</label>
			<select name="state" class="combox required">
				<option value="">--请选择--</option>
				<c:forEach var="item" items="${constants:annunciateStatusMap()}">
					<option <c:if test="${!(empty annunciate.state) and annunciate.state==item.key}">selected="selected"</c:if> value="${item.key}">${item.value}</option>
				</c:forEach> 
			</select>
		</p>
		<p>
		  <input type="hidden" name="createTime"  /> 
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
