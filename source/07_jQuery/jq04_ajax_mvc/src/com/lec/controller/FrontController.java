package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.IdConfirmService;
import com.lec.service.Service;


//Servlet implementation class FrontController
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //@see HttpServlet#HttpServlet()
    public FrontController() {    }

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
		//idConfirm.do?mid=aaa	/joinView.do
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/idConfirm.do")) {
			service = new IdConfirmService();
			service.execute(request, response);	//mid파라미터로 idConfirmm한 결과를 request 속성 set
			viewPage = "member/idConfirm.jsp";
		}else if(command.equals("/joinView.do")) {
			viewPage="member/join.jsp";
		}
		RequestDispatcher dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
	}

}
