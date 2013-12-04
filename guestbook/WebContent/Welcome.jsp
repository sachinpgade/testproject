<%@page import="com.openperception.ConnectionFactory"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.openperception.dao.ConnectionManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guest Book</title>
</head>
<body>
<%
	Connection connection = ConnectionFactory.getConnectionManager().getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = null;
	//String sessionUser = request.getSession().getAttribute("userName").toString();
	
	// Checking if some session is valid
	/*if(sessionUser.equalsIgnoreCase("") || sessionUser == null || sessionUser == "null")
	{
		// not a valid session redirect to Login.jsp page.
		response.sendRedirect("/GuestBookAppSessionManagement/Login.jsp");
	}*/
%>
<form action="messageservlet" name="formmessage" method="GET">
<table>
	<tr>
		<td>Message :</td>
		<td><input type="text" name="messagevalue" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Save Message!!!" /></td>
	</tr>
</table>
</form>
<br />
<br />
<br />
<br />
<%
	pstmt =  connection.prepareStatement("select * from MESSAGE order by MESSAGE_ID");
	rs = pstmt.executeQuery();
	
%>

<table>
<tr><td> Message </td></tr> 
	<%
		while (rs.next()) 
		{
	%>
	<tr>
		<td><%=rs.getString("MESSAGE_VALUE") %> </td>
	</tr>
	<%
		}
		connection.close();
	%>
</table>
<br>
<br>
</body>
</html>
