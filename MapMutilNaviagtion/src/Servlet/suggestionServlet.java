package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.suggestionService;

public class suggestionServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username =request.getParameter("username");
		username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
		String suggestion = request.getParameter("suggestion");
		suggestion=new String(suggestion.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(username+"  "+suggestion);
		suggestionService service = new suggestionService();
		Boolean is =service.setSuggestion(username, suggestion);
		if(is==true){
			System.out.println("success");
		}else{
			System.out.println("falied");
		}
		
		//返回信息到客户端
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("提交成功");
				out.flush();
				out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username =request.getParameter("username");
		username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
		String suggestion = request.getParameter("suggestion");
		suggestion=new String(suggestion.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(username+"  "+suggestion);
		suggestionService service = new suggestionService();
		Boolean is =service.setSuggestion(username, suggestion);
		if(is==true){
			System.out.println("success");
		}else{
			System.out.println("falied");
		}
		
		//返回信息到客户端
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("提交成功");
				out.flush();
				out.close();
		
	}



}
