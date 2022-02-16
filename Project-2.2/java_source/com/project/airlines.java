package com.project;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class airlines extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public airlines() {
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
			String Query1 = "select distinct source from flight";
			ResultSet resultSet1 = statement1.executeQuery(Query1);
			
			out.println("<html><head>");
			out.println("<title>All Airlines</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
			out.println("</head><body>");
			out.println("<div class=\"container\">");
			out.println("<div class=\"top\"> ");
			out.println("<div class=\"cl1\">");
			out.println("<h3>FlyAway</h3>");
			out.println("</div><div class=\"cl9\">");
			out.println("<h3>FlyAway a safest way to fly across the Globe</h3></div></div>");
			out.println("<div class=\"sec1\">");
			out.println("<h1>Available Airlines:</h1>");
			
			while(resultSet1.next()){
				String source = resultSet1.getString("source");
				out.println("<h3>");
				out.println(source);
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
