<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
</head>
	<%
	String num = request.getParameter("num");	//null이거나 숫자스트링
	%>
<body>
	<fieldset>
		<legend>숫자입력</legend>
		<form action="" method="get">
			<p>자연수<input type="number" name="num" value="<% if(num!=null) out.print(num); %>"><p>
			<input type="submit" value="누적">
		</form>
	</fieldset>
	<%
	if(num!=null && !num.equals("")){
		int su = Integer.parseInt(num);
		int tot =0;
		for(int i=1; i<=su; i++){
			tot += i;
		}
		out.println("<h2>1부터"+su+"까지 누적합 :"+tot+"</h2>");
	}
	%>
</body>
</html>