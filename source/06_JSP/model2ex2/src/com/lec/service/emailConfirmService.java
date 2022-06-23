package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;


public class emailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.EmailChk(memail);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("emailConfirmResult", "이미 존재하는 EMAIL입니다");
		}else {
			request.setAttribute("emailConfirmResult", "사용가능한 EMAIL입니다");
		}
	}

}
