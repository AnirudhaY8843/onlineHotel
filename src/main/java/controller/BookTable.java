package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookingDAO;
import model.TableDTO;

@WebServlet("/booking")
public class BookTable extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		BookingDAO dao=new BookingDAO();
		ArrayList<TableDTO> ava=new ArrayList();
		ava=dao.avaTable();
		
		for(TableDTO data:ava) {
			System.out.println("Iam main");
			System.out.println(data.getTabllId());
			System.out.println(data.getTableNo());
		}
		req.setAttribute("available", ava);
		RequestDispatcher rd=req.getRequestDispatcher("booktable.jsp");
		rd.forward(req, resp);
	}

	
}
