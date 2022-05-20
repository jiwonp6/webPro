package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Servlet implementation class Ex2_suOut
@WebServlet(name = "Ex2suOut", description = "sumOut", urlPatterns = { "/Ex2suOut" })
public class Ex2_suOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //@see HttpServlet#HttpServlet()
    public Ex2_suOut() {
        super();
    }

	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");
		// request.getParameter("num") : ex2_suInput에서 name="num"인 것을 받음
		if(numStr==null || numStr.equals("")) {
			numStr = "1";
		}
		int num = Integer.parseInt(numStr);
		int sum = 0;
		for(int i=0; i<=num; i++) {
			sum += i;
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	//web에 뿌려주게 해주는 
		out.println("<h1>1부터 "+num+"까지 누적합은 "+sum+"입니다</h1>");
		out.close();	//PrintWriter 닫아줌
	}

	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
