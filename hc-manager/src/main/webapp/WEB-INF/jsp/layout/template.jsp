<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title><decorator:title/><fmt:message key="ui.title" /></title>
<decorator:head/>
</head>

<body>
<div id="container">

	<c:import url="/WEB-INF/jsp/layout/header.jsp" charEncoding="UTF-8"/>
	<decorator:body/>
	<c:import url="/WEB-INF/jsp/layout/footer.jsp" charEncoding="UTF-8"/>

</div>

<div id="dialogBox" class="viewlist" style="display:none;">
	<div class="dialogHeader">
		<a href="#close" class="close" style="float:right;">close</a>
		<h1>Dialog</h1>
	</div><div class="dialogContent"></div>
</div>

</body>
</html>
