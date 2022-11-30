package com.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/req/1")
public class RequestPrams1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContentType());
		System.out.println(request.getLocalPort());
		System.out.println(request.getMethod());
		System.out.println(request.getRequestURI());
		System.out.println(request.getQueryString());
		String test = request.getParameter("test");
		String name = request.getParameter("name");
		
		response.setCharacterEncoding("UTF-8");  //response header 에 담긴다.
		response.setContentType("text/plain; charset=utf8"); //응답시에 utf8 로 바꿔라 response header 에 담긴다.
		
		response.getWriter().print("test: " + test );
		response.getWriter().print("name: " + name );
			
		
	}
}