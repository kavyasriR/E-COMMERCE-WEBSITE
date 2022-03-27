package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/registration?" + "user=root&password=Vis@6101");
			
			String sql = "insert into login values(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, pwd);
			st.execute();
			
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
