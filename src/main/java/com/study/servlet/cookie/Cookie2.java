package com.study.servlet.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie/2")
public class Cookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies(); //cookie를 꺼낸다, cookies - 복수임, 배열 , string 값만 저장한다.
		
		//List<Cookie> cookieList = Arrays.asList(cookies);  cookie 는 기본적으로 배열로 관리이지만 이거는 리스트로 관리하는 방법임
		
//		for(Cookie c : cookies) {
//			System.out.println("key : " + c.getName());
//			System.out.println("value : " + c.getValue());
//			
//		}
		
		
		for(Cookie c : cookies) {
			System.out.println("key : " + c.getName());
			System.out.println("value : " + URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8));
			
		}
		
	}


}
