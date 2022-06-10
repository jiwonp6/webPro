<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/서버프로그램평가/css/join.css" rel="stylesheet">
	<script>
		function chk() {
			if(frmJoin.pw.value!=frmJoin.pwChk.value){
				alert("비밀번호를 확인해주세요");
				return false;
			}
		}
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
	<form action="joinPro.jsp" method="post" name="frmJoin" onsubmit="chk()">
		<div id="join_title">회원가입</div>
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id" class="id" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pw" name="pw" class="pw" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" id="pwChk" name="pwChk" class="pwChk"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="name" name="name" class="name" required="required"></td>
			</tr>
			<tr>
				<th>전화</th>
				<td><input type="text" id="tel" name="tel" class="tel" required="required"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" id="email" name="email" class="email" ></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" id="address" name="address" class="address" ></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" id="tempbirth" name="tempbirth" class="birth" required="required"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" id="gender" name="gender" value="m" checked="checked">남자
					<input type="radio" id="gender" name="gender" value="w">여자
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입하기" class="joinBtn_style">
					<input type="reset" value="다시하기" class="joinBtn_style">
					<input type="button" value="로그인" class="joinBtn_style" onclick="location.href='login.jsp'">
				</td>
			</tr>
		</table>	
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>