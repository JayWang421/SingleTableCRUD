<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
	request.setAttribute("basePath",basePath) ;
%>
<base href="<%=basePath%>"/>
<%!
	public static final String URL="fenye.jsp" ;
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver" ;
	public static final String DBURL="jdbc:oracle:thin:@localhost:1521:jayw" ;
	public static final String USER="scott" ;
	public static final String PASSWORD="tiger" ;
%>
<%	// 数据库的连接查询处理需要以下的变量
	Connection conn = null ;
	PreparedStatement ps = null ;
	ResultSet rs = null ;
%>
<%
	int currentPage =1 ;
	int lineSize= 5 ;
	int allrecorders=0 ;
	int pageSize= 0 ;
%>
<%	// cp表示的是currentPage参数的内容，接收的都是String，需要将其强制转换为int
	try {
		currentPage = Integer.parseInt(request.getParameter("cp")) ;
	} catch (Exception e) {}	// 分页的参数不正确，就出错
	try {
		lineSize = Integer.parseInt(request.getParameter("ls")) ;
	} catch (Exception e) {}	// 分页的参数不正确，就出错
%>
<%
	Class.forName(DRIVER) ;
	conn=DriverManager.getConnection(DBURL, USER, PASSWORD) ;
	String sql="select * from (select empno,ename,job,sal,comm,rownum rn from emp where rownum<=? )temp where temp.rn>? " ; 
 	ps=conn.prepareStatement(sql) ;
	ps.setInt(1, currentPage*lineSize) ;
	ps.setInt(2, (currentPage-1)*lineSize) ;
	rs=ps.executeQuery() ;
%>
	<table>
		<tr>
			<td>雇员编号</td>
			<td>雇员姓名</td>
			<td>雇员工作</td>
			<td>雇员工资</td>
			<td>雇员佣金</td>
<%
	while(rs.next()){
		int empno=rs.getInt(1) ;
		String ename=rs.getString(2) ;
		String job=rs.getString(3) ;
		Double sal=rs.getDouble(4) ;
		Double comm=rs.getDouble(5) ;
%>
		<tr>
			<td><%=empno %></td>
			<td><%=ename %></td>
			<td><%=job %></td>
			<td><%=sal %></td>
			<td><%=comm%></td>
		</tr>
<%
	}
%>
	</table>
<%
	conn.close() ;
%>