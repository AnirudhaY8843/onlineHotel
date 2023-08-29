<%@page import="model.FoodDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body{
    margin: 0;
    padding: 0;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    background: linear-gradient(200deg,#2980b9,#8e44ad,#af3e7b);
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
            color:white;
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
            background-color: #grey;
        }
        h1{
            color: #fff;
        }
        th:first-of-type{
            border-right: 1px solid #fff;
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
		<td>&#8377;<%=list.getDishPrice() %></td>
	</tr>
		
	
	
	<%
	}%>
	</table>
	<%
	boolean update=(boolean)request.getAttribute("update");
	if(update){ %>
	<h3>Dish Updated...</h3>
	<%} %>
	
     <div class="center">
        <h1>Update price</h1>
    <form action="updatelink" method="get">
        <div class="text-feild">
        <label for="item">Enter Dish name </label>
        <input type="text" name="dish" required>
        </div>
        <div class="text-feild">
        <label for="price">New Price</label>
        <input type="text" name="price" id="price" required>
        </div>
        <input type="submit" name="submit" id="btn" value="Update Dish">
    </form>
    </div>
</body>
</html>