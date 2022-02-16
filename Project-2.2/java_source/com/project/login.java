package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String databaseURL = "jdbc:mysql://localhost:3306/login";
			String username1 = "root";
			String password1 = "vinay@shibe@1234";
			Connection connection = DriverManager.getConnection(databaseURL, username1, password1);
			out.println("hhh");
            String paramterizedSQLQuery = "select * from idpass  where username=? and password=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(paramterizedSQLQuery);
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			ResultSet resultSet = preparedStatement.executeQuery();
			String usernamedb=null;
			String passworddb =null;
			if(resultSet.next()) {
				usernamedb = resultSet.getString("username");
				passworddb = resultSet.getString("password");
				
			}
			if(username.equals(usernamedb) && password.equals(passworddb)) {
				
				RequestDispatcher rd = request.getRequestDispatcher("welcome1.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				
				
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
