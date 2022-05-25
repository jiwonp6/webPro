<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
	String conPath = request.getContextPath();
	String appPath = application.getContextPath();	//상대경로
	String absolutePath = application.getRealPath(".");	//현재 프로젝트의 절대경로
	%>
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=absolutePath %></h2>
	<%
	String filePath = application.getRealPath("WEB-INF/input.txt");
	out.println(filePath + "의 내용 입니다<br>");
	//스트림 객체생성(파일 연다) - 읽는다 - 스트림객체를닫는다(파일닫는다) 
	BufferedReader br = new BufferedReader(new FileReader(filePath));	//try-catch안해도 500-err남
	while(true){
		String line = br.readLine();
		if(line==null){
			break;
		}
		out.println(line + "<br>");
	}
	br.close();
	/* try-catch이용
	BufferedReader br = null;
	try{
		//1. 스트림객체생성
		br = new BufferedReader(new FileReader(filePath));
		while(true){
			String line = br.readLine();	//파일을 한줄씩 읽어옴(파일 읽기, 한줄씩). 파일끝 → null 반환
			if(line==null){
				break;
			}
			out.println(line + "<br>");
		}
	}catch(Exception e){
		out.println("파일이 존재하지 않거나 읽을 수 없는 파일입니다");
	}finally{
		try{
			if(br!=null){
				br.close();
			}
		}catch(Exception e){
			
		}
	} */
	%>
</body>
</html>