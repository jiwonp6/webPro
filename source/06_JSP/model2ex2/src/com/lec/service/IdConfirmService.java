package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class IdConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.IdChk(mid);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("idConfirmResult", "이미 존재하는 ID입니다");
		}else {
			request.setAttribute("idConfirmResult", "사용가능한 ID입니다");
		}
	}

}
