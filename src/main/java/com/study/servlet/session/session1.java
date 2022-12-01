package com.study.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/1")
public class session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주소창에 get요청 처음 실행됨
		
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("user_name"));
		System.out.println(session.getAttribute("user_phone"));
		System.out.println(session.getAttribute("user_email"));
		System.out.println(session.getAttribute("user_address"));
		System.out.println(session.getAttribute("user_password"));
		
		request.getRequestDispatcher("/WEB-INF/form1.html").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//submit 눌렀을때 session에 저장됨
		request.setCharacterEncoding("UTF-8"); 
		HttpSession session = request.getSession();  //헬스장 등록하고 열쇠받는거
		
		session.setAttribute("user_name", request.getParameter("name")); //parameter 는 웹에서 입력해서 submit 한 값임.
		session.setAttribute("user_phone", request.getParameter("phone"));
		session.setAttribute("user_email", request.getParameter("email"));
		session.setAttribute("user_address", request.getParameter("address"));
		session.setAttribute("user_password", request.getParameter("pw"));


		
	}

}
