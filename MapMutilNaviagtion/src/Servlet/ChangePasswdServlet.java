package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.changePwdService;

public class ChangePasswdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		//接收客户端信息
				String username = request.getParameter("mIdString");
				username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
				String password = request.getParameter("newPwdString");
				System.out.println(username+"--------"+password);
				
				//新建服务对象
				changePwdService service = new changePwdService();
				//验证处理
				boolean is = service.changePwd(username, password);
				if(is)
				{
					System.out.println("success");
					
				}else {
					System.out.println("failed");
				}
				
				//返回信息到客户端
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("修改成功");
				out.flush();
				out.close();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
	
		//接收客户端信息
		String username = request.getParameter("mIdString");
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		String password = request.getParameter("newPwdString");
		System.out.println(username+"--"+password);
		
		//新建服务对象
		changePwdService service = new changePwdService();
		//验证处理
		boolean is = service.changePwd(username, password);
		if(is)
		{
			System.out.println("success");
			
		}else {
			System.out.println("failed");
		}
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("修改成功");
		out.flush();
		out.close();
		}
	}

