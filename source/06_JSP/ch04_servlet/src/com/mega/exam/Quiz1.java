package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet implementation class Quiz2
@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  //@see HttpServlet#HttpServlet()
  public Quiz1() {
      super();
  }
	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>구구단</h3>");
		for(String s : su) {
			int dansu = Integer.parseInt(s);
			out.println("<h4>"+dansu+"단</h4>");
			for(int i=1; i<10; i++ ) {
				out.println(dansu + " * " +i+"="+dansu*i+"<br>");
			}
		}
		out.close();
	}
	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}

