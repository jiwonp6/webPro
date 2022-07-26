package com.lec.ch19.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.dto.Member;

@Mapper
public interface MemberDao {
	public int joinMember(Member member);
	public int idConfirm(String mid);
	public Member getDetailMember(String mid);
	public int modifyMember(Member member);
	public int drawalMember(String mid);
}
