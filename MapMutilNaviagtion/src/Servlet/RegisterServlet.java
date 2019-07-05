package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.GetUserInfoService;
import Service.RegisterService;

public class RegisterServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
		//String nickName = request.getParameter("nickName");
		String name = request.getParameter("name");
		String telphone = request.getParameter("telphone");
		String password = request.getParameter("password");
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		telphone = new String(telphone.getBytes("ISO-8859-1"),"UTF-8");		
		password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
		Date date=new Date();
		SimpleDateFormat simpledate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = simpledate.format(date);
		
		//新建服务对象
		RegisterService registerService = new RegisterService();
		
		boolean isTrue = registerService.register(name,telphone,password,dateString);

		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		System.out.println(dateString);
		PrintWriter writer = response.getWriter();
		writer.print(isTrue);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
		
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String telphone = request.getParameter("telphone");
		String password = request.getParameter("password");
		Date date=new Date();
		SimpleDateFormat simpledate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = simpledate.format(date);
		System.out.println(dateString);
		//新建服务对象
		RegisterService registerService = new RegisterService();
		boolean isTrue = registerService.register(name,telphone,password,dateString);
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		System.out.println(isTrue);
		writer.print(isTrue);
		
		
	}
}
