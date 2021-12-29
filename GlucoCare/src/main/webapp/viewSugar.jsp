<%@page import="com.GC.model.Sugar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.GC.dao.DB"%>
<%@page import="com.GC.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blood Sugar Levels</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

	<%
		User user = (User)session.getAttribute("keyUser");
		DB db = new DB();
	%>
	
	<div class="container">
  <h2>Blood Sugar Levels Record</h2>
  <p>Dear <%= user.name%>, your sugar level records till date: </p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Date Time</th>
        <th>Sugar Levels</th>
      </tr>
    </thead>
    <tbody>
    
   	   <%
			ArrayList<Sugar> sugarlvl = db.fetchSugarl(user._id);
		
			for(Sugar sugar : sugarlvl){
				
		%>
    
	      <tr>
	        <td><%= sugar.dateTimeStamp %></td>
	        <td><%= sugar.sugar %></td>
	      </tr>
	      
      	<%			
				
			}
		%>
    </tbody>
  </table>
</div>
	

</body>
</html>