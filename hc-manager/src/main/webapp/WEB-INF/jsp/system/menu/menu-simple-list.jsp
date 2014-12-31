<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>

<div class="pageContent">
<div class="table" width="100" layoutH="70">
	<div id="t2" style="display: block; overflow: auto; height: 100%; border: solid 0px #CCC; line-height: 25px; background: #FFF;">
		<ul id="t1" class="tree treeFolder expand" oncheck="customFunction()">
			<c:forEach var="item1" items="${menu1}" varStatus="varStatus">
				<li>
					<a tname="name" tvalue="${item1.id}" href="javascript:"onclick="$.bringBack({parentId:'${item1.id}', parentName:'${item1.name}'})">${item1.name}</a>
					<ul>
						<c:forEach var="item2" items="${menu2}" varStatus="varStatus2">
							<c:if test="${item1.id == item2.parentId}">
								<li><a tname="name2" tvalue="${item2.id}" href="javascript:"onclick="$.bringBack({parentId:'${item2.id}', parentName:'${item2.name}'})">${item2.name}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>  
</div>
</div>