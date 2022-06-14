package com.lec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet implementation class Ex1
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //@see HttpServlet#HttpServlet()
    public Ex1() {    }
	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	//actionDo 메소드 생성
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//넘어온 파라미터 id, pw를 이용하여 객체를 만든 후 view단으로 넘긴다(forward)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDto member = new MemberDto(id, pw);
		request.setAttribute("member", member);
		//View단으로 forward
		RequestDispatcher dp = request.getRequestDispatcher("1_dispatcher/ex2_View.jsp");
		dp.forward(request, response);
	}
}
