package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookingDAO;

@WebServlet("/reset")
public class ResetTables extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String date1=req.getParameter("date");
		System.out.println("html"+date1);
		SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(date);
		java.util.Date parseDate=null;
		
		try {
			parseDate=date.parse(date1);
			System.out.println("parse"+parseDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date date2=new Date(parseDate.getTime());
		System.out.println(date2);
		
		BookingDAO dao=new BookingDAO();
		boolean up=dao.resetTable(date2);
		System.out.println(up);
		
			PrintWriter pw=resp.getWriter();
			RequestDispatcher rd=req.getRequestDispatcher("reseted.jsp");
			rd.forward(req, resp);
			
	}
	

}
