package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class places extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public places() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String databaseURL = "jdbc:mysql://localhost:3306/flyaway";
			String username = "root";
			String password = "vinay@shibe@1234";
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			Statement statement1 = connection.createStatement();
			String Query1 = "select distinct destination from flight";
			String Query2 = "select distinct start from flight";
			
			Statement statement2 = connection.createStatement();
			ResultSet resultSet1 = statement1.executeQuery(Query1);
			ResultSet resultSet2 = statement2.executeQuery(Query2);
			out.println("<html><head>");
			out.println("<title>All places</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
			out.println("</head><body>");
			out.println("<div class=\"container\">");
			out.println("<div class=\"top\"> ");
			out.println("<div class=\"cl1\">");
			out.println("<h3>FlyAway</h3>");
			out.println("</div><div class=\"cl9\">");
			out.println("<h3>FlyAway a safest way to fly across the Globe</h3></div></div>");
			out.println("<div class=\"sec1\">");
			out.println("<h2>Places available for sources:</h2>");
			while(resultSet2.next()){
				String start = resultSet2.getString("start");
				out.println("<h3>");
				out.println(start);
				out.println("</h3>");
			}
			out.println(" ");
			out.println("<h2>Places available for destination:</h2>");
			while(resultSet1.next()){
				String destination = resultSet1.getString("destination");
				out.println("<h3>");
				out.println(destination);
				out.println("</h3>");	
			}
			out.println("<a href=\"welcome1.jsp\">");
			out.println("Go back");
			out.println("</a>");
			out.println("</div></div></body></html>");
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
