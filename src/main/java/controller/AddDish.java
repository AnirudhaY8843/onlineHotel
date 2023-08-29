package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FoodDAO;
import model.FoodDTO;

@WebServlet("/addlink")
public class AddDish extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String dish=req.getParameter("dish");
		double price=Double.parseDouble(req.getParameter("price"));
		HttpSession session=req.getSession(false);
		
		String user=(String) session.getAttribute("username");
		String password=(String) session.getAttribute("password");
		PrintWriter pw=resp.getWriter();
		if(session!=null) {
			//need to cast in String
			FoodDTO dto=new FoodDTO();
			dto.setDishName(dish);
			dto.setDishPrice(price);
			
			FoodDAO dao=new FoodDAO();
			boolean add=dao.addDish(dto);
			if(add) {
//				pw.print("<h1>Dish Added Sucessfully...");
				RequestDispatcher rd=req.getRequestDispatcher("itemadded.jsp");
				rd.include(req, resp);
			}
			
		}
		
		
	}
}
