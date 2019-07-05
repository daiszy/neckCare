package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.RecordNeckAngleService;

//用于处理http请求
public class RecordNeckAngleServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		//接收客户端信息
				String neckangle = request.getParameter("mIdNeck");
				neckangle = new String(neckangle.getBytes("ISO-8859-1"),"UTF-8");
				String username = request.getParameter("mIdName");
				username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
				//新建服务对象
				RecordNeckAngleService service = new RecordNeckAngleService();
				//验证处理
				boolean loged = service.recordAngle(neckangle,username);
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
		String neckangle = request.getParameter("mIdNeck");
		neckangle = new String(neckangle.getBytes("ISO-8859-1"),"UTF-8");
		String username = request.getParameter("mIdName");
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		//新建服务对象
		RecordNeckAngleService service = new RecordNeckAngleService();
		//验证处理
		boolean loged = service.recordAngle(neckangle,username);
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(loged);
		out.flush();
		out.close();
	}
}
