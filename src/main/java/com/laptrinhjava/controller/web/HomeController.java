package com.laptrinhjava.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap" ,"/thoat"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 7253508122648689956L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse	 response)
			throws SecurityException, IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
		
	}
	
}
