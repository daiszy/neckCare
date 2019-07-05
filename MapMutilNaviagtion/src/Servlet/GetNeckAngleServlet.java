package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.getNeckAngleService;

public class GetNeckAngleServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
		String username = request.getParameter("mIdName");
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(username);
		getNeckAngleService getneckAngleService=new getNeckAngleService();
		String result=getneckAngleService.find(username);
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(result);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
				String username = request.getParameter("mIdName");
				
				username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
				getNeckAngleService getneckAngleService=new getNeckAngleService();
				String result=getneckAngleService.find(username);
				//返回信息到客户端
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				PrintWriter writer = response.getWriter();
				writer.print(result);
			}

}
