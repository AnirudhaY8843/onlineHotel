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
import javax.servlet.http.HttpSession;


import model.UserDAO;
import model.UserDTO;

@WebServlet(urlPatterns = {"/loginlink","/signuplink"})
public class LoginController  extends HttpServlet {
	
	
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String path=req.getServletPath();//to fetch html link from urlpatterns we use req.getServletPath()
			
			
			switch(path) {
			case "/loginlink" :
				login(req,resp);
				break;
			case "/signuplink" :
				signUp(req, resp);
				break;
			
			}
		}
		
		
		
		//create new user or signup
		private void signUp(HttpServletRequest req,HttpServletResponse resp) {
			String username=req.getParameter("username");
			long cno=Long.parseLong(req.getParameter("contact"));
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			String cpassword=req.getParameter("cpassword");
			
			
			UserDTO dto=new UserDTO();
			dto.setUsername(username);
			dto.setContact(cno);
			dto.setEmail(email);
			dto.setPassword(password);
			dto.setCpass(cpassword);
			
			UserDAO dao=new UserDAO();
			boolean signup=dao.signingUp(dto);
			
			if(signup) {
				try {
					resp.sendRedirect("login.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("signup.html");
				try {
					PrintWriter pw=resp.getWriter();
					pw.print("<h1>User Already Exist or password mismatch<h1>");
					rd.include(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		
		//method for logout
		
		
		
		
		//user login method
		private void login(HttpServletRequest req,HttpServletResponse resp) {
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			
			UserDTO dto =new UserDTO();
			dto.setUsername(username);
			dto.setPassword(password);
			
			UserDAO dao=new UserDAO();
			boolean login=dao.logIn(dto);
//			
			if(login) {
				HttpSession session=req.getSession(true);
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				
				//change is imp
				RequestDispatcher rd=req.getRequestDispatcher("operation.html");
				try {
					rd.include(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				PrintWriter pw;
				try {
					pw = resp.getWriter();
					pw.print("<h1>Invalid Username Password</h1>");
					resp.sendRedirect("login.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
			
		}

		
}
