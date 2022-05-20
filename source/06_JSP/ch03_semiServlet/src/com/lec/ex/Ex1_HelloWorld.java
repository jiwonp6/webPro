package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class Ex1_HelloWorld
 */
//@WebServlet(name = "HelloWorld", urlPatterns = { "/HWorld" })	//브라우저에서 볼 수 있도록 해줌 (url맵핑)
public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet호출");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	// 스트림 객체 생성
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h1{color:blue;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. 첫 servlet 예제입니다.</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost호출");
		doGet(request, response);
	}
}
