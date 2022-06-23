package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;

public class MWithdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.delete(mid, mpw); 
		if(result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("withdrawalResult", "회원탈퇴 성공");
		}else {
			request.setAttribute("withdrawalMsg", "회원탈퇴 실패");
		}
	}
}
