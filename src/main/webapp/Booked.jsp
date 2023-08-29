<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
body{
 margin: 0;
    padding: 0;
    width:100%;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    background-image:url("https://media.istockphoto.com/id/539282181/photo/table-setting.jpg?b=1&s=170667a&w=0&k=20&c=Xt4cNVsQ1jg__MKo_NlUcuh3cFpHqYRLKJ5ApbQb0T4=");
    background-repeat:no-repeat;
    background-size:cover;
   
    height: 100vh;
    overflow: hidden;
    display: flex;
    color:white;
    justify-content: space-around;
}

h3{
	color:black;	
     background-color: rgba(240, 248, 255, 0.618);
	
}
</style>
<meta charset="ISO-8859-1">
<title>Booked</title>
</head>
<body>
<div>
	<%
	String user=(String)request.getAttribute("user");
	Date date=(Date)request.getAttribute("date");
	int tableno=(int)request.getAttribute("tableno");
	boolean status=(boolean)request.getAttribute("status"); 
	if(status){%>
	
	<h1>Table Booked....</h1>
	<h2>---------------------------------------------------------</h2>
	<h3>Customer name :<%=user %></h3>
	<h3>Date :<%=date %></h3>
	<h3>Table Number  :<%=tableno %></h3>
	
	<%}else{ %>
	<h1>Table not available...</h1>
	<%} %>
	
	</div>
</body>
</html>