<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>특정 쿠키(쿠키이름이 cookieName인 쿠키) 찾아 값 확인하기</h1>
	<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		int idx=0;
		for(idx=0; idx<cookies.length; idx++){
			//idx번째 cookies이름이 찾고자하는 쿠키의 이름과 같은지확인  O → break;
			String name = cookies[idx].getName();	//idx번째 쿠키 이름
			if(name.equals("cookieName")){
				String value = cookies[idx].getValue();	//idx번째 쿠키의 값
				out.println("<h2>찾고자 하는 쿠키 이름 : "+name+", 쿠키값 : "+value+"</h2>");
				break;
			}
		}
		if(idx==cookies.length){
			out.println("찾고자하는 쿠키가 없습니다");
		}
	}else{
		out.println("생성된 쿠키가 없습니다.");
	}
	%>
	<hr>
	<a href="ex1_cookieConstruct.jsp">쿠키 생성(cookieName)</a> <br>
	<a href="ex2_cookieList.jsp">쿠키들(쿠키이름-쿠키값) 리스트 확인</a> <br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(이름이 cookieName) 찾기</a> <br>
	<a href="ex4_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>