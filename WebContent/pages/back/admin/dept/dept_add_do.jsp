<%@page import="wzj.util.factory.Factory"%>
<%@page import="wzj.service.*"%>
<%@page import="wzj.vo.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%!
	public static final String DEPT_ADD_URL="pages/back/admin/dept/dept_add.jsp" ;
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
<title>部门增加</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8") ;
	Dept vo=new Dept() ;
	vo.setDeptno(Integer.parseInt(request.getParameter("deptno"))) ;
	vo.setDname(request.getParameter("dname")) ;
	vo.setLoc(request.getParameter("loc")) ;
	IDeptService deptService=Factory.getServiceInstance("dept.service") ;
	boolean flag=false ;
	String msg="部门增加失败" ;
	flag=deptService.add(vo) ;
	if(flag){
		msg="部门增加成功" ;
	}
%>	
<jsp:include page="/pages/plugins/forward.jsp">
	<jsp:param name="msg" value="<%=msg %>"/> 
	<jsp:param name="url" value="<%=DEPT_ADD_URL%>"/>
</jsp:include>	
</body>
</html>