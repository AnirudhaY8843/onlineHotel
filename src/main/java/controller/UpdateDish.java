package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FoodDAO;
import model.FoodDTO;


@WebServlet("/updatelink")
public class UpdateDish extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double price=Double.parseDouble(req.getParameter("price"));
		String dish=req.getParameter("dish");
		
		FoodDAO dao=new FoodDAO();
		
		FoodDTO dto=new FoodDTO();
		dto.setDishName(dish);
		dto.setDishPrice(price);
		boolean update=dao.updateDish(dto);
		
		
		if(update) {
			PrintWriter pw=resp.getWriter();
			ArrayList<FoodDTO> menu=new ArrayList<FoodDTO>();
			menu=dao.displayDish();
			RequestDispatcher rd=req.getRequestDispatcher("updateprice.jsp");
			req.setAttribute("menu", menu);
			req.setAttribute("update", update);
			rd.include(req, resp);

//			pw.print("<h1>Price Updated Sucessfullyy...</h1>");
//			RequestDispatcher rd=req.getRequestDispatcher("updateprice.jsp");
//			rd.include(req, resp);
		}
	}
}
