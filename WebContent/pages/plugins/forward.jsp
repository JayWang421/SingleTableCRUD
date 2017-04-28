<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String msg=request.getParameter("msg") ;
	String url=request.getParameter("url") ;
%>
<script type="text/javascript">
	window.onload=function(){
		goForward() ;
	}
	function goForward(){
		spanObject=document.getElementById("countSpan") ;
		count=parseInt(spanObject.innerHTML) ;
		count-- ;
		if(count==0){
			window.location="<%=url%>" ;
		}else{
			spanObject.innerHTML=count ;
			setTimeout(goForward,1000) ;
		}
	}
</script>
<div><%=msg %></div>
<div><span id="countSpan">2</span>秒后跳转到其他页面！！</div>