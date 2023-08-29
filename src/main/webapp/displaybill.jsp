<%@page import="model.BillDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

 <style>
    body{
        margin: 0;
        padding: 0;
        background: linear-gradient(300deg,#bdc3c7,#2c3e50);
        height: 100vh;
        width: 100%;

    }
    .bill{
        display: flex;
        align-items: center;
        justify-content: center;
        color :white;
        width:500px;
      
        
    }
        table {
            
            border-radius: 15px;
          border-collapse: collapse;
          width:500px;
          
          /* border: 1px solid red; */
          
          background: linear-gradient(300deg,#141e30,#243b55);
          /* width: 100%; */
        }
        
        th, td {
          text-align: left;
          padding: 30px;
        }
        
        tr:nth-child(even) {
            background-color: #c10909;
        }
        h1{
            color: #fff;
        }
        th:first-of-type{
            border-right: 1px solid #fff;
        }
        #final{
            background: linear-gradient(100deg,#a6f77b,#2dbd6e);
          
            color: black;
            border-top: 3px solid white;
            border-style: dashed;
        }
        h3{
            color: #fff;
            letter-spacing: 5px;
        }
        .butn{
            margin-top: 5px;
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
	<center>
	
		<h1>Bill</h1>
		<h3>-------------------------------------------------------------------------------</h3>	
	
		<%
			double total=(double)request.getAttribute("total");
			ArrayList<BillDTO> bill=new ArrayList<BillDTO>();
			
			bill=(ArrayList)request.getAttribute("bill");
			
			for(BillDTO data:bill){
				
			
		%>
		<div class="bill">
		<table>
			<tr>
				<th>Customer Name</th>
				<th><%=data.getUser() %></th>
			<tr>
			<tr>
				<th>Order Id </th>
				<th><%=data.getOrderId() %></th>
			<tr>
			<tr>
				<th>Dish name</th>
				<th><%=data.getDishName()%></th>
			<tr>
			<tr>
				<th>Dish Price</th>
				<th>&#8377;<%=data.getPrice() %></th>
			<tr>
			<tr>
				<th>Total Bill Price</th>
				<th>&#8377;<%=total %></th>
			<tr>
			<tr>
				<th>18% GST</th>
				<th>&#8377;<%=total*0.18%></th>
			<tr>
			<tr id="final">
				<th >Final Amount</th>
				<th>&#8377;<%=total+total*0.18 %></th>
			<tr>
			
		</table>
		</div>
		<%} %>
		</center>
		
		
	

</body>
</html>