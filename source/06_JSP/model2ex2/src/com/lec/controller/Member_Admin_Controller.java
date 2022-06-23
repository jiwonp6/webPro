package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.ALoginService;
import com.lec.service.BoardListService;
import com.lec.service.BoardWriteService;
import com.lec.service.IdConfirmService;
import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MModifyService;
import com.lec.service.MWithdrawalService;
import com.lec.service.Service;
import com.lec.service.boardContentService;
import com.lec.service.emailConfirmService;

//Servlet implementation class MvcMemberController
@WebServlet("*.do")
public class Member_Admin_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean write_view = false;   
    //@see HttpServlet#HttpServlet()
    public Member_Admin_Controller() {  }
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
		Service service = null;		
		if(command.equals("/joinView.do")) {	
			viewPage = "member/join.jsp";
		}else if(command.equals("/join.do")) {	
			service = new MJoinService();	
			service.execute(request, response);
			viewPage="member/login.jsp";
		}else if(command.equals("/idConfirm.do")){
			service = new IdConfirmService();
			service.execute(request, response);	//mid파라미터로 idConfirmm한 결과를 request 속성 set
			viewPage = "member/idConfirm.jsp";
		}else if(command.equals("/emailConfirm.do")){
			service = new emailConfirmService();
			service.execute(request, response);	//mid파라미터로 idConfirmm한 결과를 request 속성 set
			viewPage = "member/emailConfirm.jsp";
		}else if(command.equals("/mAllView.do")) {	
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(command.equals("/loginView.do")) {	
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) {		
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/modifyView.do")) {
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) {
			service = new MModifyService();	
			service.execute(request, response);
			viewPage="main/main.jsp";
		}else if(command.equals("/logout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/withdrawalView.do")) {
			viewPage = "member/withdrawal.jsp";
		}else if(command.equals("/withdrawal.do")) {
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}
		
		else if(command.equals("/adminLogin.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}
		
		else if(command.equals("/BoardList.do")) {
			service = new BoardListService();
			service.execute(request, response);
			viewPage = "freeBoard/boardList.jsp";
		} else if(command.equals("/boardWriteView.do")) { //원글쓰기 view(form화면)
			viewPage="freeBoard/boardWrite.jsp"; 
			write_view = true; 
		} else if(command.equals("/boardWrite.do")) { //원글쓰기 DB 저장 if(write_view) 
			{ 	
				service = new BoardWriteService(); 
				service.execute(request, response); 
				write_view = false; 
			}
		 	viewPage="BoardList.do"; 
		} else if(command.equals("/boardContent.do")) { //글 상세보기
			service = new boardContentService(); 
		 	service.execute(request, response);
		 	viewPage="freeboard/boardContent.jsp"; }
		 /*else if(command.equals("/modify_view.do")) { //글 수정 view (form태그) service = new
		 * BModifyViewService(); service.execute(request, response);
		 * viewPage="board/modify_view.jsp"; }else if(command.equals("/modify.do")) {
		 * //수정 DB 저장 service = new BModifyService(); service.execute(request,
		 * response); viewPage="list.do"; }else if(command.equals("/delete.do")){ //글 삭제
		 * DB service = new BDeleteService(); service.execute(request, response);
		 * viewPage = "list.do"; }else if(command.equals("/reply_view.do")){ //답변글 쓰기
		 * view (form태그) service = new BReplyViewService(); service.execute(request,
		 * response); viewPage = "board/reply_view.jsp"; }else
		 * if(command.equals("/reply.do")) { service = new BReplyService();
		 * service.execute(request, response); viewPage = "list.do"; }
		 */
		RequestDispatcher dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
	}

}
