package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Service.Setquestion;

//用于处理http请求
public class GetQuestionServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		//接收客户端信息
				String question = request.getParameter("question");
				question = new String(question.getBytes("ISO-8859-1"),"UTF-8");
				String username = request.getParameter("username");
				username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(username);
				
				//新建服务对象
				Setquestion service = new Setquestion();
				//验证处理
				boolean loged = service.setQuestion(question,username);
				if(loged)
				{
					System.out.println("success");
					
				}else {
					System.out.println("failed");
				}
				
				//返回信息到客户端
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println(loged);
				out.flush();
				out.close();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		//接收客户端信息
		String question = request.getParameter("question");
		question = new String(question.getBytes("ISO-8859-1"),"UTF-8");
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(username);
		
		//新建服务对象
		Setquestion service = new Setquestion();
		//验证处理
		boolean loged = service.setQuestion(question,username);
		if(loged)
		{
			System.out.println("success");
			
		}else {
			System.out.println("failed");
		}
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(loged);
		out.flush();
		out.close();
	}
}
