package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.login(mid, mpw);
		if(result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", mdao.modifyView_replyView(mid));
		}else {
			request.setAttribute("loginErrorMsg", "사용자의 id와 pw를 다시 확인해주세요");
		}
	}

}
