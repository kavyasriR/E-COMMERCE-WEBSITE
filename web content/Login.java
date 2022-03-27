package com.login;

import java.io.IOException;

import com.login.dao.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		
		if(dao.checkCredentials(name, pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
}
