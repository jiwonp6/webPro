<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/join.css" rel="stylesheet">
	<script>
		function chk() {
			if(frmJoin.cpw.value!=frmJoin.pwChk.value){
				alert("수정한 비밀번호를 확인해주세요");
				return false;
			}
		}
	</script>
</head>
<body>
	<%!String cid, cname, ctel, cemail, caddress, cgender ; Date cbirth; %>
	<%
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	if(customer==null){
		response.sendRedirect("../customer/login.jsp");
	}else{
		cid = customer.getCid();
		cname = customer.getCname();
		
		ctel = customer.getCtel();
		cemail = customer.getCemail();
		caddress = customer.getCaddress();
		cgender = customer.getCgender();
		cbirth = customer.getCbirth();
	}
	%>
	
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<form action="modifyPro.jsp" method="post" name="frmJoin" onsubmit="chk()">
			<div id="join_title">회원정보수정</div>
			<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="cid" name="cid" class="cid" value="<%=cid %>"  required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>현 비밀번호</th>
				<td><input type="password" id="oldpw" name="oldpw"  required="required"></td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td><input type="password" id="cpw" name="cpw" placeholder="비밀번호 수정을 원하시면 입력해주세요"></td>
			</tr>
			<tr>
				<th>새 비밀번호확인</th>
				<td><input type="password" id="pwChk" name="pwChk"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="cname" name="cname" value="<%=cname %>" required="required"></td>
			</tr>
			<tr>
				<th>전화</th>
				<td><input type="text" id="ctel" name="ctel" value="<%=ctel %>" required="required"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" id="cemail" name="cemail" value="<%=cemail!=null ? cemail:"-" %>" ></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" id="caddress" name="caddress" value="<%=caddress!=null ? caddress:"-" %>" ></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" id="tempbirth" name="tempbirth" value="<%=cbirth %>" required="required"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<%
					if("m".equals(cgender)){
					%>
						<input type="radio" name="cgender" value="m" checked="checked">남
						<input type="radio" name="cgender" value="w">여
					<%	
					}else if("w".equals(cgender)){
					%>
						<input type="radio" name="cgender" value="m">남
						<input type="radio" name="cgender" value="w" checked="checked">여
					<%	
					}
					%>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기" class="joinBtn_style">
					<input type="reset" value="다시하기" class="joinBtn_style">
					<input type="button" value="이전으로" class="joinBtn_style" onclick="history.back()">
				</td>
			</tr>
		</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>