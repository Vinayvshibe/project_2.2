package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public register() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session=request.getSession();
		String name =  request.getParameter("name");
		String email = request.getParameter("email");
		String amount = session.getAttribute("amount").toString();
		String seats = session.getAttribute("seats").toString();
		String start = session.getAttribute("start").toString();
		String destination = session.getAttribute("destination").toString();
		String source = session.getAttribute("source").toString();
		String time = session.getAttribute("time").toString();
		String date = session.getAttribute("date").toString();
		String price = session.getAttribute("price").toString();

		RequestDispatcher rd = request.getRequestDispatcher("payment.jsp");
		rd.forward(request, response);
		session.setAttribute("name",name);
		session.setAttribute("email",email);
		session.setAttribute("seats",seats);
		session.setAttribute("start",start);
		session.setAttribute("source",source);
		session.setAttribute("destination",destination);
		session.setAttribute("date",date);
		session.setAttribute("time",time);
		session.setAttribute("amount",amount);
		session.setAttribute("price",price);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
