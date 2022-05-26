<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
	<script>
		function chk() {
			if(frmJoin.pw.value!=frmJoin.pwChk.value){
				alert("비밀번호를 확인해주세요");
				return false;
			}
			var mailSendCnt=0;
			for(var i=0; i<frmJoin.mailSend.length; i++){
				if(frmJoin.mailSend[i].selected){
					mailSendCnt++;
				}
			}
			if(!mailSendCnt){
				alert("메일수신 사항을 선택해주세요.");
				return false;
			}
			var hobbyArr = document.getElementsByName('hobby');
			var hobbyCnt = 0;
			for(var i=0; i<hobbyArr.length; i++){
				if(hobbyArr[i].checked){
					hobbyCnt++;
				}
			}
			if(!hobbyCnt){
				alert("취미를 한 개 이상 선택해주세요");
				return false;
			}
		}
	</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="joinForm_wrap">
		<form action="joinPro.jsp" method="post" name="frmJoin" onsubmit="return chk()">
			<div id="join_title">회원가입</div>
			<table>
				<tr>
				<th><label for="name">이름</label></th>
				<td>
					<input type="text" name="name" id="name" class="name" required="required" autofocus="autofocus">
				</td>
				</tr>
				<tr>
				<th><label for="id">아이디</label></th>
				<td>
					<input type="text" name="id" id="id" class="id" required="required">
				</td>
				</tr>
				<tr>
				<th><label for="pw">비밀번호</label></th>
				<td>
					<input type="password" name="pw" id="pw" class="pw" required="required">
				</td>
				</tr>
				<tr>
				<th><label for="pwChk">비밀번호확인</label></th>
				<td>
					<input type="password" name="pwChk" id="pwChk" class="pwChk">
				</td>
				</tr>
				<tr>
				<th><label for="birth">생년월일</label></th>
				<td>
					<input type="date" name="birth" id="birth" class="birth">
				</td>
				</tr>
				<tr>
				<th>취미</th>
				<td>
					<input type="checkBox" name="hobby" id="reading" value="독서"><label for="reading">독서</label>
					<input type="checkBox" name="hobby" id="cooking" value="요리"><label for="cooking">요리</label>
					<input type="checkBox" name="hobby" id="exercise" value="운동"><label for="exercise">운동</label>
					<input type="checkBox" name="hobby" id="sleep" value="취침"><label for="sleep">취침</label>
				</td>
				</tr>
				<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" id="m" value="m" checked="checked"><label for="m">남자</label>
					<input type="radio" name="gender" id="w" value="w"><label for="m">여자</label>
				</td>
				</tr>
				<tr>
				<th><label for="email">이메일</label></th>
				<td>
					<input type="email" name="email" id="email" class="email" required="required">
				</td>
				</tr>
				<tr>
				<th>메일수신</th>
				<td>
					<select name="mailSend" multiple="multiple" size="3">
						<option>광고</option>
						<option>배송</option>
						<option>공지</option>
						<option>답변</option>
					</select>
				</td>
				</tr>
				<tr><td colspan="2"></td></tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">					
						<input type="reset" value="다시하기" class="joinBtn_style">					
						<input type="button" value="뒤로가기" class="joinBtn_style" onclick="history.back()">					
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>