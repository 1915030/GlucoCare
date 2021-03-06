package com.GC.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GC.dao.DB;
import com.GC.model.User;


@WebServlet({ "/LoginController", "/Login" })
public class LoginController extends HttpServlet {


	public void init(ServletConfig config) throws ServletException {
		System.out.println("[LoginController] - init executed");
	}

	public void destroy() {
		System.out.println("[LoginController] - destroy executed");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LoginController] - service executed");
		
		
		User user = new User();
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		
		System.out.println("[LOGIN CONTROLLER] User Data:"+user);
		
		System.out.println(user);
		
		
		DB db = new DB();
		boolean result = db.loginUser(user);
		
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		
		String html = "";
		if(result) {
			
			HttpSession session = request.getSession();
			session.setAttribute("keyUser", user);
			
			html = "<html><body><center>THANK YOU "+user.getName()+"<br>Login Success<br><br>"
					+ "<a href='home.jsp'>Enter Home</a>"
					+ "</center></body></html>";
			
		}else {
			html = "<html><body><center>Invalid Credentials"+user.email+"<br>Please try Again</center></body></html>";
		}
		
		writer.println(html);
		
		
		
	}

}

