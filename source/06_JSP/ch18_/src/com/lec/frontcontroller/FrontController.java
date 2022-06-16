package com.lec.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.*;

//Servlet implementation class FrontController
@WebServlet("*.do") /* 프론트 컨트롤러 : 요청에 따라 작업해줌 → 출력 할 것들 request.setAttribute해줌 → jsp로 전송 */
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
		actionDo(request, response);
	}
	//actionDo
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);		// uri : /ch18_/*.do
		String conPath = request.getContextPath();
		System.out.println("conPath : " + conPath);		// conPath : /ch18_
		String command = uri.substring(conPath.length());	//conPath 글자 뒤부터
		System.out.println("들어온 요청 : " + command);
		String viewPage = null;		//뷰단의 이름
		Service service = null;
		if(command.equals("/insert.do")) {
			//insert 로직 수행하는 객체 호출
			service = new InsertService();
			//객체이름.메소드(request, response)
			service.execute(request, response);
			//request.setAttribute("result", "insert결과");
				//결과를 "수행됨"이라고 보지 않고 리스트로 추가 됐는지 확인하기 위해 select.do 호출해서 수행 후 뿌려줌
			viewPage = "select.do";
		}else if(command.equals("/select.do")) {
			//select 로직 수행하는 객체 호출
			service = new SelectService();
			//객체이름.메소드(request, response)
			service.execute(request, response);
			//request.setAttribute("list", "list결과");
			viewPage = "ex2/select.jsp";
		}else if(command.equals("/delete.do")) {
			//delete 로직 수행하는 객체 호출
			service = new DeleteService();
			//객체이름.메소드(request, response)
			service.execute(request, response);
			//request.setAttribute("result", "delete결과");
			viewPage = "select.do";
		}else if(command.equals("/update.do")) {
			//update 로직 수행하는 객체 호출
			service = new UpdateService();
			//객체이름.메소드(request, response)
			service.execute(request, response);
			//request.setAttribute("result", "update결과");
			viewPage = "select.do";
		}
		RequestDispatcher dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
	}

}
