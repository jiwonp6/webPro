package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	public int joinMember(Member member, HttpSession httpSession);	//id, pw 세션에 저장
	public int idConfirm(String mid);
	public String loginCheck(String mid, String mpw, HttpSession httpSession);	//로그인 성공/실패 메세지 뿌려주기위함
	public Member getDetailMember(String mid);
	public int modifyMember(Member member);	//세션의 값도 바꿔줘야함
	public int drawalMember(String mid);
}
