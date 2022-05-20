package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet implementation class Ex1
@WebServlet(asyncSupported = true, urlPatterns = { "/Ex1" })
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //@see HttpServlet#HttpServlet()
    public Ex1() {
        super();
    }
	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id, pw 파라미터 받아 브라우저 화면 뿌리기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		response.setContentType("text/html; charset=utf-8");	//response 출력의 한글 처리
		PrintWriter out = response.getWriter();
		out.println("<h2>아이디 : "+id+"</h2>");
		out.println("<h2>비밀번호 : "+pw+"</h2>");
		out.close();
	}
	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
