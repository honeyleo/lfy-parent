<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<c:import url="/WEB-INF/jsp/layout/_frag/pager/pagerForm.jsp"></c:import>
<script type="text/javascript">    

	//遍历被选中CheckBox元素的集合 得到Value值    	
	function customFunction() {
		var json = arguments[0], result = "",allResult="";
		if(json == undefined) return;
		$(json.allItems).each(function(i){
			if(this.name == 'name3'){
				allResult += ',' + this.value;
			}
		});
		$('#threeMenuIds').val(allResult);

	}
	
	//遍历被选中CheckBox元素的集合 得到Value值    
	function treeclick() {
		var oidStr = ""; //定义一个字符串用来装值的集合    
		//jquery循环t2下的所有选中的复选框    
		$("#t2 input").each(function(i, a) {
			if(a.checked) {
				oidStr += a.value + ','; //拼接字符串    
			}
		});
		console.log(oidStr);
	}
</script>  

<form method="post" rel="pagerForm" action="<c:url value='/oper/admin/role/list.page'/>" onsubmit="return navTabSearch(this)">
<!-- <input type="hidden" name="numPerPage" value="10" />  overflow: auto; height: 100%;  collapse-->
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
		</ul>
		<div class="subBar">
			<ul>						
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" mask="true" rel="menuNav" href="<c:url value='/oper/admin/menu/new'/>" title="添加菜单"><span>添加</span></a></li>
			<li><a class="delete" onclick="treeclick()" title="你确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<div id="t2" style="display:block; margin:10px; overflow:auto; height:480px; border:solid 2px #CCC; line-height:21px; background:#FFF;">
		 <ul id="t1" class="tree treeFolder treeCheck expand" oncheck="customFunction()">
			<c:forEach var="item1" items="${menu1}" varStatus="varStatus">
				<li>
					<a tname="name" tvalue="${item1.id}" target="dialog" mask="true" rel="menuNav" href="<c:url value='/oper/admin/menu/edit?menuId=${item1.id}&level=1'/>" >${item1.name}</a>
					<ul>
						<c:forEach var="item2" items="${menu2}" varStatus="varStatus2">
							<c:if test="${item1.id == item2.parentId}">
								<li><a tname="name" tvalue="${item2.id}" target="dialog" mask="true" rel="menuNav" href="<c:url value='/oper/admin/menu/edit?menuId=${item2.id}&level=2'/>">${item2.name}</a>
									<ul>
										<c:forEach var="item3" items="${menu3}" varStatus="varStatus3">
											<c:if test="${item2.id == item3.parentId}">
												<li><a tname="name" tvalue="${item3.id}" target="dialog" mask="true" rel="menuNav" href="<c:url value='/oper/admin/menu/edit?menuId=${item3.id}&level=3'/>">${item3.name}</a></li>
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