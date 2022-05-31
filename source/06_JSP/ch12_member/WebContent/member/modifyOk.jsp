<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
	String tempbirth = request.getParameter("tempbirth");
	if(tempbirth.equals("")){
		dto.setBirth(Timestamp.valueOf(tempbirth+" 00:00:00"));
	}
	MemberDto member = (MemberDto)session.getAttribute("member");
	String sessionPw = null;
	if(member!=null){
		sessionPw = member.getPw();	//세션의 pw를 sessionPw에 할당
	}
	String oldPw = request.getParameter("oldPw");
	if(sessionPw.equals(oldPw)){	//현비밀번호 맞게 입력한 경우 정보 수정 진행
		//새 비밀번호(pw파라미터)가 null로 입력되지 않을 경우 현 비밀번호로 수정
		if(dto.getPw()==null){
			dto.setPw(oldPw);
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.modifyMember(dto);
		if(result == MemberDao.SUCCESS){	//수정성공
			session.setAttribute("member", dto);	//수정된 db내용을 session 속성도 수정
		%>
			<script>
				alert('회원정보수정완료');
				location.href='main.jsp';
			</script>
		<%
		}else{	//수정실패
		%>
			<script>
				alert('회원정보수정실패');
				history.back();
			</script>
		<%	
		}
	}else{	//현 비밀번호를 틀리게 입력한 경우 정보 수정 안 함
	%>	
		<script>
			alert('현 비밀번호가 바르지 않습니다');
			history.back();
		</script>
	<%
	}
	%>
</body>
</html>