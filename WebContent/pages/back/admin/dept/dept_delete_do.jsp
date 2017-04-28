<%@page import="wzj.util.factory.Factory"%>
<%@page import="wzj.service.*"%>
<%@page import="wzj.vo.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%!
	public static final String DEPT_LIST_URL="pages/back/admin/dept/dept_list.jsp" ;
%>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
	request.setAttribute("basePath",basePath) ;
%>
<base href="<%=basePath%>"/>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/back/admin/dept/dept_add.js"></script>
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">  
<html>
<head>
<title>部门删除</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8") ;
	String ids=request.getParameter("ids") ;
	String result [] =ids.split(",") ;
	Set<Integer> setIds=new HashSet<Integer>()  ;
	for(int x=0 ; x<result.length ; x++){
		setIds.add(Integer.parseInt(result[x])) ;
	}
	IDeptService deptService=Factory.getServiceInstance("dept.service") ;
	boolean flag=false ;
	String msg="部门删除失败" ;
	flag=deptService.delete(setIds) ;
	if(flag){
		msg="部门删除成功" ;
	}
%>	
<jsp:include page="/pages/plugins/forward.jsp">
	<jsp:param name="msg" value="<%=msg %>"/> 
	<jsp:param name="url" value="<%=DEPT_LIST_URL%>"/>
</jsp:include>	
</body>
</html>