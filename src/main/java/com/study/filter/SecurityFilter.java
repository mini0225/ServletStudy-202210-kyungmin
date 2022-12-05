package com.study.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.domain.User;


@WebFilter("/*")
public class SecurityFilter extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = 1L;

	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request; //다운캐스팅
		HttpServletResponse resp = (HttpServletResponse) response; //다운캐스팅
		
		String requestURI = req.getRequestURI();
		String antMatchers1 = "/mypage, /mypage/password" ;
		String antMatchers2 = "/login, /register" ;
		String logoutURI = "/logout" ;
		String adminpage = "/admin";
		
		
		
		
		if(antMatchers1.contains(requestURI) && !authorization(req.getSession())) {  //인증에서 걸리면 로그인으로 보내버린다.
			resp.sendRedirect("/login");
			return;
		}
		if(antMatchers2.contains(requestURI) && authorization(req.getSession())) {
			resp.sendRedirect("/mypage");
			return;
		}
		if(logoutURI.equalsIgnoreCase(requestURI)) {
			req.getSession().invalidate();  // session 을 강제로 중지시켜서 로그인정보를 강제로 날림.
			resp.sendRedirect("/login");
			
			return;
		}
		if(requestURI.contains(adminpage) && !hasRole(req.getSession(), "ADMIN")) { //권한이 없으면~
			
			resp.sendError(403, "Forbidden"); //권한이 없습니다.
			
			return;
			
		}
		
		
			
		chain.doFilter(request, response);
	}

	private boolean authorization(HttpSession session) {
		User principalUser = (User) session.getAttribute("principal");
		
		return principalUser != null;
		
	}
	
	private boolean hasRole(HttpSession session, String role) {
		
		
		AtomicBoolean result = new AtomicBoolean(false);
		
		if(authorization(session)) {
			
			User principaluser = (User) session.getAttribute("principal");
			
			String [] roleArray = principaluser.getRoles().replaceAll(" ","").split(",");
			List<String> roleList = Arrays.asList(roleArray);

			
			roleList.forEach(r ->{
				
				if(r.startsWith("ROLE_") && r.contains(role)) {
					result.set(true);
				}
			});
		}
		
		
		
		return result.get();
	}

	
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
