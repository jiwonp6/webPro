package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.Mvc_MemberDao;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		Mvc_MemberDao mdao = Mvc_MemberDao.getInstance();
//		request.setAttribute("login_result", mdao.login(mid, mpw));
		int result = mdao.login(mid, mpw);
		if(result == Mvc_MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", mdao.modifyView_replyView(mid));
		}else {
			request.setAttribute("loginErrorMsg", "ID랑 PW확인해");
		}
	}

}
