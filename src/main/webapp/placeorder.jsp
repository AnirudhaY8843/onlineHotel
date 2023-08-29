<%@page import="model.FoodDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
	
	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body{
        margin: 0;
        padding: 0;
        font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
        background: linear-gradient(200deg,#2980b9,#8e44ad,#af3e7b);
        width:100%;
        background-image:url("https://wallpapercave.com/wp/wp8521450.jpg");
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
        background-color: aliceblue;
           background-color: rgba(240, 248, 255, 0.618);
        
        border-radius: 15px;
        display: flex;
        flex-direction: column;
        
    }
    .center h1{
        text-align: center;
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
          padding: 20px;
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
       #head{
       		color: black;
       }
    </style>
</head>
<body>

<h1>MENU</h1>
	
	<%
		
		ArrayList<FoodDTO> menu=new ArrayList<FoodDTO>();
	
		menu=(ArrayList)request.getAttribute("menu");
	
		%>
		<table border="1px" rules="all">
		<tr>
			<th>Dish</th>
			<th>Price</th>
		</tr>
	<%
		for(FoodDTO list:menu){
	%>
		
	<tr>
		<td><%=list.getDishName() %></td>
		<td><%=list.getDishPrice() %></td>
	</tr>
		
	
	
	<%
	}%>
	</table>
    
    <div class="center">
    <h1 id="head">Place the order</h1>
    <form action="orderlink">
        <div class="text-feild">
        <label for="dish">Enter Dish </label>
        <input type="text" name="dish" required>
        </div>
        <div class="text-feild">
        <label for="no of dish">No of Dishes</label>
        <input type="text" name="noofdish" required>
        </div>
        <input type="submit" name="submit" id="submit" value="Place Order">
    </form>
</div>
</body>
</html>
</body>
</html>