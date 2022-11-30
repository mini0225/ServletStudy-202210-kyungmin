package com.study.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/form/1")
public class FormApi1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get요청옴!!");
		System.out.println(request.getParameter("name")); //parameter string 이니까 숫자로 쓰고 싶으면 형변환필요
		System.out.println(request.getParameter("phone"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("pw"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post요청옴!!");
		request.setCharacterEncoding("UTF-8"); //post 할때는....하..............response ...........
		
		System.out.println(request.getParameter("name")); //parameter string 이니까 숫자로 쓰고 싶으면 형변환필요
		System.out.println(request.getParameter("phone"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("pw"));
		
		response.setContentType("text/plain; charset = utf8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("name : " + request.getParameter("name"));
		out.println("phone : " + request.getParameter("phone"));
		out.println("email : " + request.getParameter("email"));
		out.println("address : " + request.getParameter("address"));
		out.println("pw : " + request.getParameter("pw"));
		
				
	}

}
