package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.Mvc_MemberDao;

public class MDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		//String mpw = request.getParameter("mpw");
		Mvc_MemberDao mdao = Mvc_MemberDao.getInstance();
		request.setAttribute("deleteResult", mdao.delete(mid));
	}
}
