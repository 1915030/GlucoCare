<%@page import="com.GC.dao.DB"%>
<%@page import="com.GC.model.Sugar"%>
<%@page import="com.GC.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Sugar Level</title>
</head>
<body>

	<%
		User user = (User)session.getAttribute("keyUser");
	%>

	<center>
		<h4>Welcome to Blood Sugar Level Management</h4> 
		<b><%= user.name %></b>
	

	<%
		
		Sugar sugar = new Sugar();
		sugar.userId = user._id;
		sugar.sugar = Double.parseDouble(request.getParameter("txtFever"));
		
		DB db = new DB();
		db.logSugar(sugar);
		
	%>
	
	<p>Your Sugar Level has been Recorded Successfully: <%= sugar.sugar %></p>
	
	
	
	</center>
	

</body>
</html>