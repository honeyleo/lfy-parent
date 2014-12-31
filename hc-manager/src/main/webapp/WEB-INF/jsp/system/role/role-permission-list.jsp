<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<div class="pageContent">

<script type="text/javascript">    

	//遍历被选中CheckBox元素的集合 得到Value值    
	function customFunction() {
		var json = arguments[0], result = "",allResult="";
		$(json.allItems).each(function(i){
			if(this.name == 'name3'){
				allResult += ',' + this.value;
			}
		});
		$('#threeMenuIds').val(allResult);
	}
</script> 

<form method="post" action="<c:url value='/oper/admin/role/addrolepermission?navTabId=userLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">	
	
	<input type="hidden" id="threeMenuIds" name="threeMenuIds" value="${rolePermissionStr}">
	<input type="hidden" name="roleId" value="${param.roleId}">
	
	<div class="pageFormContent" layoutH="60">
		<div id="t2" style="display: block; overflow: auto; height: 100%; border: solid 0px #CCC; line-height: 25px; background: #FFF;">
			
			 <ul id="t1" class="tree treeFolder treeCheck expand" oncheck="customFunction;">
				<c:forEach var="item1" items="${menu1}" varStatus="varStatus">
					<li>
						<a tname="name1" tvalue="${item1.id}">${item1.name}</a>
						<ul>
							<c:forEach var="item2" items="${menu2}" varStatus="varStatus2">
								<c:if test="${item1.id == item2.parentId}">
									<li><a tname="name2" tvalue="${item2.id}" >${item2.name}</a>
										<ul>
											<c:forEach var="item3" items="${menu3}" varStatus="varStatus3">
												<c:if test="${item2.id == item3.parentId}">
													<li><a <c:if test="${!(empty item3.roleId) and item3.roleId > 0}">checked="true"</c:if> tname="name3" tvalue="${item3.id}" >${item3.name}</a></li>
												</c:if>
											</c:forEach>
										</ul>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
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
