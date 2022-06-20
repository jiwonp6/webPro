package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MAllViewService;
import com.lec.service.MDeleteService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MModifyService;
import com.lec.service.Service;

//Servlet implementation class MvcMemberController
@WebServlet("*.do")
public class MvcMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //@see HttpServlet#HttpServlet()
    public MvcMemberController() {  }
	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();	// uri받아오기
		String conPath = request.getContextPath();	// conPath받아오기
		String command = uri.substring(conPath.length());	// do모델 이름 받아오기(uri-conPath=do모델)
		String viewPage = null;
		Service service = null;		//do모델 하나로 묶어주기
		if(command.equals("/joinView.do")) {	//회원가입화면
			viewPage = "member/join.jsp";
		}else if(command.equals("/join.do")) {	//회원가입 DB처리
			service = new MJoinService();	//execute메소드 : mid중복체크 후 회원가입
			service.execute(request, response);
			viewPage="member/login.jsp";
		}else if(command.equals("/mainView.do")) {	//main화면
			viewPage = "member/main.jsp";
		}else if(command.equals("/loginView.do")) {	//로그인화면
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) {		//로그인 DB처리
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/modifyView.do")) {	//정보수정
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) {	//정보수정
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/mAllView.do")) {	//회원리스트
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(command.equals("/mLogout.do")) {	//로그아웃
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/mdeleteView.do")) {	//회원탈퇴화면
			viewPage = "member/delete.jsp";
		}else if(command.equals("/mdelete.do")) {	//회원탈퇴 DB처리
			service = new MDeleteService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}
		RequestDispatcher dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
	}

}
