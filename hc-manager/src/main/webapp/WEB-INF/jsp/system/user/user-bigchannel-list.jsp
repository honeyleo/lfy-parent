<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<div class="pageContent">

<script type="text/javascript">    

	//遍历被选中CheckBox元素的集合 得到Value值    
	function customFunction() {
		var json = arguments[0], result = "",allResult="";
		$(json.allItems).each(function(i){
			if(this.name == 'name2'){
				allResult += ',' + this.value;
			}
		});
		$('#bigqnids').val(allResult);

	}
</script> 

<form method="post" action="<c:url value='/oper/admin/user/adduserbigqn?navTabId=userLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">	
	
	<input type="hidden" id="bigqnids" name="bigqnids" value="${userBiganStr}">
	<input type="hidden" name="userId" value="${userId}">
	
	<div class="pageFormContent" layoutH="60">
		<div id="t2" style="display: block; overflow: auto; height: 100%; border: solid 0px #CCC; line-height: 25px; background: #FFF;">
        	
			<ul id="t1" class="tree treeFolder treeCheck expand" oncheck="customFunction;">
				<li>
					<a tname="name1" tvalue="value1">所有合作渠道</a> 
					<ul>
						<c:forEach var="item" items="${resultList}" varStatus="varStatus">
							
							<li><a <c:forEach var="per" items="${userBigan}" varStatus="varS"><c:if test="${item.id == per}">checked="true"</c:if></c:forEach> tname="name2" tvalue="${item.id}">${item.name}</a></li>
						</c:forEach>
					</ul>
				</li>
			</ul>
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
