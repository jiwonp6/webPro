<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	int j=0;	//실행 할 때마다 지역변수 계속 초기화
	i++; j++;
	strBuf.append("<span>♥</span>");	//append한 후 그 값을 출력
	out.println("strBuf = "+strBuf+"<br>");
	out.println("sum(5,2) = "+sum(5,2)+"<br>");
	%>
	전역변수 i = <%=i %><br>
	지역변수 j = <%=j %><br>
	<!-- 스크립트립 내의 out.println("strBuf = "+strBuf+"<br>"); 
									=> strBuf = <%=strBuf %> -->				
	
	<%!	//선언부가 가장먼저 실행, 한 번 실행 후 실행X
	int i;	//0으로 초기화	(선언부와 스크립트릿의 차이점), 전역변수로써 초기화
	StringBuffer strBuf = new StringBuffer("Good");
	public int sum(int a, int b){
		return a + b;
	}
	%>
</body>
</html>