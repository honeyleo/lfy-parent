<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/common/include.inc.jsp"%>

<style type="text/css"> 
.linebr {  
	clear: both; /* 清除左右浮动 */  
	
	/*width: 100px;  必须定义宽度 */  
	
	word-break: break-word; /* 文本行的任意字内断开 */  
	
	word-wrap: break-word; /* IE */  
	
	white-space: -moz-pre-wrap; /* Mozilla */  
	
	white-space: -hp-pre-wrap; /* HP printers */  
	
	white-space: -o-pre-wrap; /* Opera 7 */  
	
	white-space: -pre-wrap; /* Opera 4-6 */  
	
	white-space: pre; /* CSS2 */  
	
	white-space: pre-wrap; /* CSS 2.1 */  
	
	white-space: pre-line; /* CSS 3 (and 2.1 as well, actually) */  

}  
</style>

<div class="pageContent">
		
		<div layoutH="58">
			<div style="width: 830px;text-align:center;margin-top: 30px;font-size: 34px;font-weight: 900;">${annunciate.title}</div>
			<div class="linebr" style="width: 700px;margin: 50px 75px 0 75px;line-height:20px;">${annunciate.context}</div>
			<div style="width: 770px; text-align:right; margin: 100px 0 0 0" >发布日期：<fmt:formatDate value="${annunciate.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
		</div>	
	
		<div class="formBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
</div>
