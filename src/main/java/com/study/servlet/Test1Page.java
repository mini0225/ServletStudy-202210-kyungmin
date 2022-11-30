package com.study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test/page/1") //요청페이지
public class Test1Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/test1.html").forward(request, response); //요청이 들어왔을때 해당페이지로 응답을 해준다.
		//Dispatcher 객체는 /WEB-INF/test1.html 여기 접근 가능
		//페이지를 띄울때는 항상 이런방식으로.......
		
	}

}
