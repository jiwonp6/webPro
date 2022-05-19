<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- 지시자(<%@ ~ %>) : 페이지 속성 --%> 
	<%-- 스크립트릿(<% ~ %>) : 자바코드 --%> 
	<%-- 선언부(<%! ~ %>) : 변수, 함수 --%> 
	<% 
	long result = power(2,3);
	%>
	<p>2의 3승은 <%=result %>입니다</p>
	<p>9의 11승은 <%=power(9,11) %>입니다</p>
	<%!	//선언부 : 먼저 실행함
	private long power(int a, int b){	//a^b return할 power 함수 선언
		long temp = 1;
		for(int i=1; i<=b; i++){
			temp *= a;
		}
		return temp;
	}
	%>
</body>
</html>