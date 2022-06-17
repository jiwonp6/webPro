package com.lec.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MemberJoinService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		Timestamp birth = null;
		if(!request.getParameter("birth").equals("")) {
			birth = Timestamp.valueOf(request.getParameter("birth")+" 00:00:00");
		}
		MemberDto member = new MemberDto(id, pw, name, birth, null);
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.joinMember(member);
		request.setAttribute("joinResult", result);
	}

}
