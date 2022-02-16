package com.project;

import java.io.IOException; 

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Flyaway extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Flyaway() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String databaseURL = "jdbc:mysql://localhost:3306/flyaway";
			String username = "root";
			String password = "vinay@shibe@1234";
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			Statement statement = connection.createStatement();
			String paramterizedSQLQuery = "select * from flight where start= ? and destination= ? and source= ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(paramterizedSQLQuery);
			String start = request.getParameter("start");
			String destination = request.getParameter("destination");
			String source = request.getParameter("source");
			String date = request.getParameter("date");
			preparedStatement.setString(1, start);
			preparedStatement.setString(2, destination);
			preparedStatement.setString(3, source);
		
			ResultSet resultSet = preparedStatement.executeQuery();
			double time = 0;
			int price = 0;
			
			while( resultSet.next()) {
			  double time1 = resultSet.getDouble("time");
			  time = time1;
			  int price1 = resultSet.getInt("tk_price");
			  price = price1;
			 
			 int seats = Integer.parseInt(request.getParameter("seats"));
			 int amount = (int) (price*seats);
			 }
			if (price==0) {
				RequestDispatcher rd = request.getRequestDispatcher("noflight.jsp");
				rd.forward(request, response);
			}
			
			int seats = Integer.parseInt(request.getParameter("seats"));
			int amount = (int) (price*seats );
			request.setAttribute("seats",seats);
			request.setAttribute("amount",amount);
			request.setAttribute("price",price);
			request.setAttribute("start",start);
		    request.setAttribute("destination",destination);
			request.setAttribute("source",source);
			request.setAttribute("time", time);
			request.setAttribute("date",date);
			HttpSession session=request.getSession();
			
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
			session.setAttribute("start",start);
			session.setAttribute("destination",destination);
			session.setAttribute("source",source);
			session.setAttribute("time", time);
			session.setAttribute("price",price);
			session.setAttribute("date",date);
			session.setAttribute("seats", seats);
			session.setAttribute("amount",amount);
			
			resultSet.close();
			statement.close();
			connection.close();
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
