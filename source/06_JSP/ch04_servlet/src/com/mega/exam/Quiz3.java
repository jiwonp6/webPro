package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet implementation class Quiz3
@WebServlet("/Quiz3")
public class Quiz3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //@see HttpServlet#HttpServlet()
    public Quiz3() {
        super();
    }

	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String textArea = request.getParameter("textArea");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<style>");
		out.println("body { \r\n" + 
				"	background-color: #FFF0B5; \r\n" + 
				"	font-size: 9pt;\r\n" + 
				"}");
		out.println("table {border: 2px solid pink; width:95%; margin: 10px auto;}");
		out.println("table tr { background-color: #FFE271; height: 40px;}");
		out.println("table tr:hover { background-color: orange;\r\n" + 
				"	cursor: pointer;\r\n" + 
				"}");
		out.println("td, th {text-align: center; padding:5px; }");
		out.println("caption {font-size: 20px; padding:10px;}");
		out.println("h2, b{text-align: center; color:red;}");
		out.println("a { text-decoration: none; color:black}");
		out.println(".left{text-align: left;}");
		out.println(".paging {text-align: center;}");
		out.println("input:not(.btn), textarea {\r\n" + 
				"	width: 90%;\r\n" + 
				"}");
		out.println("</style>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>");
		out.println("반갑습니다 "+name+"님");
		
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
