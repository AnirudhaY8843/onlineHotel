<%@page import="model.TableDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
  body{
        margin: 0;
        padding: 0;
        font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
        background: linear-gradient(200deg,#2980b9,#8e44ad,#af3e7b);
        width:100%;
        background-image:url("https://images.unsplash.com/photo-1552960226-639240203497?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
		background-repeat:no-repeat;
		background-size:cover;
        height: 100vh;
        overflow: hidden;
    }
    
    .center{
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        width: 400px;
        height: 500px;
		background-color: rgba(240, 248, 255, 0.618);
		color:white;
        border-radius: 15px;
        display: flex;
        flex-direction: column;
        
    }
    .center h1{
        text-align: center;
        		color:white;
        
        padding: 0 0 20px 0;
        border-bottom: 1px solid silver;
    }
    
    .center form{
        padding: 0 40px;
        box-sizing: border-box;
    
    }
    form .text-feild{
        position: relative;
        border-bottom: 2px solid #adadad;
        margin: 30px 0;
    }
    
    .text-feild input{
        width: 100%;
        padding: 0 5px;
        height: 40px;
        font-size: 16px;
        font-weight: 600;
        border: none;
        background: none;
       
        outline: none;
    }
    input[type="submit"]{
        width: 100%;
        height: 50px;
        border: 1px solid;
        border-radius: 50px;
        color: white;
        font-size: 18px;
        font-weight: 400;
        background: #2691d9;
        cursor: pointer;
        
    }
    table {
            
            border-radius: 15px;
          border-collapse: collapse;
          width:300px;
          color:white;
          /* border: 1px solid red; */
          
          background: linear-gradient(300deg,#141e30,#243b55);
          /* width: 100%; */
        }
        
        th, td {
          text-align: left;
          padding: 10px;
        }
        
        tr:nth-child(even) {
            
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
        
        #b{
        color: black;
        }
    </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Available Tables</h1>
	<table rules="all" border="1px">
		<tr>
			<th>Table Id</th>
			<th>Table No</th>
		</tr>
	<%
		ArrayList<TableDTO> available=new ArrayList();
		available=(ArrayList)request.getAttribute("available");
		
		for(TableDTO data:available){
	%>
	
	
		<tr>
			<th><%=data.getTabllId() %></th>
			<th><%=data.getTableNo() %></th>
		</tr>
		
		<%} %>
	</table>
	
	
	<div class="center">
    <h1 id="b">Book Table</h1>
    <form action="booklink">
        <div class="text-feild">
        <label for="table">Enter Table No</label>
        <input type="text" name="table" required>
        </div>
        <div class="text-feild">
        <label for="date">Select Date</label>
        <input type="date" name="date" required>
        </div>
       	
        <input type="submit" name="submit" id="submit" value="Book Table">
    </form>
	
	
	
	
</body>
</html>