package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FoodDAO;
import model.FoodDTO;


@WebServlet("/placeorder")
public class PlaceOrder extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FoodDTO dto=new FoodDTO();
		FoodDAO dao=new FoodDAO();
		
		HttpSession session=req.getSession(false);
		ArrayList<FoodDTO> foodList=new ArrayList<FoodDTO>();
		
		foodList=dao.placeOrder();
		
		req.setAttribute("menu", foodList);
		
		RequestDispatcher rd=req.getRequestDispatcher("placeorder.jsp");
		
		rd.forward(req, resp);
		
	}
	

}
