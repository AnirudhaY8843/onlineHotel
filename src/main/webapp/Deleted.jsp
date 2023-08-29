<%@page import="javax.accessibility.AccessibleStateSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deleted</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

<style type="text/css">
  body{
        margin: 0;
        padding: 0;
        background: linear-gradient(300deg,#bdc3c7,#2c3e50);
        height: 100vh;
        width: 100%;

    }
    .center{
        display: flex;
        align-items: center;
        justify-content: center;
        color :white;
    }
    h1{
            color: #fff;
            letter-spacing: 5px;
        }
        .butn{
            margin-top: 50px;
            display: flex;
            height: 50px;
            width: 100%;
            align-items: center;
            justify-content: space-around;
        }
        </style>
</head>
<body>

	  <div class="butn">

        <a href="home.html"><button type="button" class="btn btn-primary">Home</button></a>
        <a href="logoutlink"><button type="button" class="btn btn-danger">Log out</button></a>
    </div>
	<div class="center">
	<%
		boolean status=(boolean)request.getAttribute("status");
		int id=(int)request.getAttribute("orderno");
		if(status){
	%>
			<h1>Order Deleted</h1>
	<%}
		else{
		%>
		
	<h1>Some problem order not deleted</h1>	
	<%} %>
	</div>
</body>
</html>