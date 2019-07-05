package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Setquestion;
import Service.searchSuggestion;
import net.sf.json.JSONArray;

public class getSuggestionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		//接收客户端消息
				String username=request.getParameter("username");
				username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(username);
				searchSuggestion searchQuestionService=new searchSuggestion();
				JSONArray result = searchQuestionService.searchSuggestion(username);
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print(result);
				out.flush();
				out.close();
			}

			public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
				String username=request.getParameter("username");
				username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(username);
				searchSuggestion searchQuestionService=new searchSuggestion();
				JSONArray result = searchQuestionService.searchSuggestion(username);
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print(result);
				out.flush();
				out.close();

				
			}

		}
