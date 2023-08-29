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

import model.AuthorityDAO;
import model.AuthorityDTO;

@WebServlet("/authlink")
public class HotelAuthority extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		AuthorityDTO dto=new AuthorityDTO();
		dto.setAuthName(username);
		dto.setPassword(password);
		
		AuthorityDAO dao=new AuthorityDAO();
		boolean login=dao.logInAuth(dto);
		
		if(login) {
			HttpSession session=req.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			
			RequestDispatcher rd=req.getRequestDispatcher("authorityhome.html");
			try {
				rd.include(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			PrintWriter pw;
			try {
				pw = resp.getWriter();
				pw.print("<h1>Invalid Username Password</h1>");
				resp.sendRedirect("authlogin.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
