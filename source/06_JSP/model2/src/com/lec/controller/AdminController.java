package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.ALoginService;
import com.lec.service.ALogoutService;
import com.lec.service.IdConfirmService;
import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.Service;
import com.lec.service.emailConfirmService;

//Servlet implementation class MvcMemberController
@WebServlet("*.me")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //@see HttpServlet#HttpServlet()
    public AdminController() {  }
	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionMe(request, response);
	}
	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionMe(request, response);
	}
	private void actionMe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();	// uri받아오기
		String conPath = request.getContextPath();	// conPath받아오기
		String command = uri.substring(conPath.length());	// do모델 이름 받아오기(uri-conPath=do모델)
		String viewPage = null;
		Service service = null;		
		if(command.equals("/mAllView.do")) {	
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(command.equals("/aloginView.me")) {	
			viewPage = "admin/login.jsp";
		}else if(command.equals("/alogin.me")) {		
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "mAllView.do";
		}else if(command.equals("/aLogout.me")) {
			service = new ALogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}
		RequestDispatcher dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
	}
}
