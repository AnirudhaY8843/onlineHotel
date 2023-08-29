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

import model.BillDTO;
import model.FoodDTO;
import model.OrderDAO;


@WebServlet("/orderlink")
public class PlaceOrder2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String dish=req.getParameter("dish");
		int noofDish=Integer.parseInt(req.getParameter("noofdish"));
		
		HttpSession session=req.getSession(false);
		
		String user=(String) session.getAttribute("username");
		
		
		FoodDTO dto=new FoodDTO();
		dto.setDishName(dish);
		dto.setNoofdish(noofDish);
		
		ArrayList<BillDTO> bill=new ArrayList<BillDTO>();
		
		OrderDAO dao=new OrderDAO();
		bill=dao.placeOrder(dto,user);
		
		double total=0;
		for(BillDTO data:bill) {
			total=noofDish*data.getPrice();
		}
		
		req.setAttribute("total", total);
		req.setAttribute("bill", bill);
		RequestDispatcher rd=req.getRequestDispatcher("displaybill.jsp");
		rd.forward(req, resp);
	}
}
