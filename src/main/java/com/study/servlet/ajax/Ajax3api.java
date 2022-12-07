package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;



@WebServlet("/api/ajax3")
public class Ajax3api extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonData = request.getParameter("data");
		
		Map<String,Object> dataMap = gson.fromJson(jsonData, Map.class);
		
		/*
		map에서 들고오면 object이므로 다운캐스팅 해줘야함.
		 		 
		List<String> phoneNumbers = new ArrayList<>();
		
		dataMap.forEach((key, value) ->{
			if(value.getClass() == String.class){
			phoneNumbers.add((String)value);
		}
		*/
		
		//response.setContentType("text/plain; charset=utf8");
		response.setContentType("application/json; charset=utf8");
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
		PrintWriter out = response.getWriter();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		dataMap.forEach((key, value) -> {
			
			stringBuilder.append(value); 
			stringBuilder.append("-");  // stringBuilder는 문자열 합칠때 사용 
				
		});
		
		stringBuilder.delete(stringBuilder.length() -1, stringBuilder.length()); //010-9918-1916-  14번째에 있는 '-' 를 삭제한다.
		//delete(a,b) = a에서 b까지 없앤다 => '-'이 하나 더 붙기때문에 그걸 없애주기 위해서 사용
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty ("responseData", stringBuilder.toString()); //소매치기
		
		
		out.print(jsonObject.toString());	
		
	}
		
		
		
}
