package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet implementation class Quiz3
@WebServlet("/Quiz4")
public class Quiz4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //@see HttpServlet#HttpServlet()
    public Quiz4() {
        super();
    }

	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String textArea = request.getParameter("textArea");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// <link href = "/ch04_servlet/css/style.css" rel="stylesheet">
		out.println("<link href = \"/ch04_servlet/css/style.css\" rel=\"stylesheet\">");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th colspan='2'>");
		out.println("반갑습니다 "+name+"님");
		out.println("</th>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th>");
		out.println("글제목");
		out.println("</th>");
		out.println("<th>");
		out.println(title);
		out.println("</th>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th>");
		out.println("글내용");
		out.println("</th>");
		out.println("<th>");
		out.println("<pre>");
		out.println(textArea);
		out.println("</pre>");
		out.println("</th>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</body>");

	}

	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}