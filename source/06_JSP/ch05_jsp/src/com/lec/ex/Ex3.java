package com.lec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet implementation class Ex3
@WebServlet("/Ex3")	// eg. *.do
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//@see HttpServlet#HttpServlet()
    public Ex3() {
        super();
    }

     //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 요청(eg. /insert.do /delete.do /update.do )이 들어왔는지?
		String conPath = request.getContextPath();	//conPath = "/ch05_jsp"
		String uri = request.getRequestURI();	//uri = "/ch05_jsp/Ex3"
		String command = uri.substring(conPath.length());
		System.out.println("conpath = "+conPath);
		System.out.println("uri = "+uri);
		System.out.println("command = "+command);
	}

	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
