package com.lec.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet implementation class EmpSch
@WebServlet("/empSch")
public class EmpSch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //@see HttpServlet#HttpServlet()
    public EmpSch() { }

	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		EmpDao eDao = new EmpDao();
		String schName = request.getParameter("schName");
		String schJob = request.getParameter("schJob");
		ArrayList<EmpDto> emps = eDao.searchEmp(schName, schJob);
		request.setAttribute("emps", emps); /* session에 설정해준 이름이랑 다른 이름으로 설정해야함 */
		RequestDispatcher dp = request.getRequestDispatcher("3_emp/empSch.jsp");
		dp.forward(request, response);
	}

}
