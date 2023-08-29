package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderDAO;

@WebServlet("/deletelink")
public class DeleteOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int orderNo=Integer.parseInt(req.getParameter("number"));
		
		OrderDAO dao=new OrderDAO();
		boolean order=dao.deleteOrder(orderNo);
		
		req.setAttribute("status", order);
		req.setAttribute("orderno", orderNo);
		RequestDispatcher rd=req.getRequestDispatcher("Deleted.jsp");
		rd.forward(req, resp);
		
	}
}
