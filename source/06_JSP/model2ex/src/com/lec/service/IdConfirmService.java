package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.Mvc_MemberDao;

public class IdConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		Mvc_MemberDao mdao = Mvc_MemberDao.getInstance();
		int result = mdao.IdChk(mid);
		if(result == Mvc_MemberDao.EXISTENT) {
			request.setAttribute("idConfirmResult", "이미 존재하는 ID입니다");
		}else {
			request.setAttribute("idConfirmResult", "사용가능한 ID입니다");
		}
	}

}
