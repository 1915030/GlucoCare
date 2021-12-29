<%@ page import="com.GC.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

	<%
		User user = (User)session.getAttribute("keyUser");
	%>

	<center>
		<h3>Welcome Home, Dear <%= user.name %></h3>
		<h4><%= user.email %></h4>
	
		<h3>Log Your Blood Sugar Details Here</h3>
		<a href="viewSugar.jsp">VIEW ALL BLOOD SUGAR LEVEL RECORDS</a>
		<br><br>
		
		<form action="addSugar.jsp" method="get">
			<input type="text" name="txtSugar" val="eg: 99">
			<input type="submit" value="LOG SUGAR LEVEL">
		</form>
		
		<br>
		
		<table>
		</table>
		
	</center>

</body>
</html>