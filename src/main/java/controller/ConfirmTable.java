package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BookingDAO;
import model.BookingDTO;
import model.TableDTO;

@WebServlet("/booklink")
public class ConfirmTable extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int tableNo=Integer.parseInt(req.getParameter("table"));
		
		//logic for date
		String date1=req.getParameter("date");
		
		SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date parseDate=null;
		
		try {
			parseDate=date.parse(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date date2=new Date(parseDate.getTime());
//		BookingDTO dto=new BookingDTO();
		
		
		HttpSession session=req.getSession(false);
		
		String user=(String)session.getAttribute("username");
		TableDTO dto=new TableDTO();
		dto.setTableNo(tableNo);
		
		BookingDAO dao=new BookingDAO();
		boolean status=dao.bookTable(dto,user,date2);
		if(status) {
			req.setAttribute("user", user);
			req.setAttribute("date", date2);
			req.setAttribute("tableno", tableNo);
			req.setAttribute("status", status);
			RequestDispatcher rd=req.getRequestDispatcher("Booked.jsp");
			rd.forward(req, resp);
		}
	}
}
