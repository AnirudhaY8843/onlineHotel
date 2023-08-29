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
import model.OrderDAO;
import model.OrderDTO;

@WebServlet("/bill")
public class GenerateBill extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int orderNo=Integer.parseInt(req.getParameter("number"));
		HttpSession session =req.getSession(false);
		
		String user=(String) session.getAttribute("username");
		
		OrderDTO dto=new OrderDTO();
		dto.setOrderNo(orderNo);
		
		
		ArrayList<BillDTO> bill=new ArrayList<BillDTO>();
		OrderDAO dao=new OrderDAO();
		bill=dao.getBill(dto, user);
		

		
		
		double total=0;
		for(BillDTO data:bill) {
			total=data.getNo_dish()*data.getPrice();
		}
		
		req.setAttribute("total", total);
		req.setAttribute("bill", bill);
		RequestDispatcher rd=req.getRequestDispatcher("displaybill.jsp");
		rd.forward(req, resp);
		
	}
}
