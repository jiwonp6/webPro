<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
#content {
	width: 800px;
	height: 350px;
	margin: 50px auto;
}
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${conPath }/js/address.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function() {
		$('.idconfirm').click(function() {
			$.ajax({
				url : '${conPath}/member.do',
				datatype : 'html',
				data : "method=idConfirm&mid=" + $('#mid').val(),
				success : function(data, status) {
					$('#idConfirmMsg').html(data);
				}
			});
		});
		$('form').submit(function() {
			var idConfirmResult = $('#idConfirmMsg').text().trim();
			if (idConfirmResult != '사용가능한 ID입니다') {
				alert('사용가능한 ID인지 중복확인후 가입가능');
				$('input[name="mid"]').focus();
				return false;
			}
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content">
		<form action="${conPath }/member.do?method=join" method="post">

			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mid" id="mid" style="width: 400px;"> 
						<input type="button" class="idconfirm" value="중복확인" style="width: 70px;"><br>
						<span id="idConfirmMsg"></span></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mpw" style="width: 400px; margin-right: 75px;"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="mname" style="width: 400px; margin-right: 75px;"></td>
				</tr>
				<tr>
					<td>메일</td>
					<td><input type="text" name="mmail" style="width: 400px; margin-right: 75px;"></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" id="sample4_postcode" name="mpost" class="text_box" placeholder="우편번호" style="width: 400px;"> 
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" style="width: 100px;">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" id="sample4_roadAddress" name="maddr" placeholder="도로명주소" style="width: 400px; margin-right: 75px;" > 
						<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소"> 
						<span id="guide"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="가입" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>
