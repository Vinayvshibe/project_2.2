package com.project;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class setpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public setpassword() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String newpassword = request.getParameter("newpassword");
		String conformpassword = request.getParameter("conformpassword");
		HttpSession session =request.getSession();
		
		
		
		if(newpassword.equals(conformpassword)) {
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String databaseURL = "jdbc:mysql://localhost:3306/login";
				String username1 = "root";
				String password1 = "vinay@shibe@1234";
				Connection connection = DriverManager.getConnection(databaseURL, username1, password1);
				
	            String paramterizedSQLQuery = "update idpass set password=? where username=?";
	            
				PreparedStatement preparedStatement = connection.prepareStatement(paramterizedSQLQuery);
				preparedStatement.setString(1,conformpassword);
				preparedStatement.setString(2,username);
				int a=preparedStatement.executeUpdate();
				if(a>0){
					RequestDispatcher rd = request.getRequestDispatcher("changesuccessed2.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("failed.jsp");
					rd.forward(request, response);
				}
				
				preparedStatement.close();
				connection.close();	
			}
			catch(Exception e){
				
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("mismatched.html");
			rd.forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
