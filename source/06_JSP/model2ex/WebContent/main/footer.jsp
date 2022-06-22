<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/footer.css" rel="stylesheet">
</head>
<body>
	<footer>
		<div class="footer_h">
			
		</div>
		<div class="office_logo">
			<img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png">
		</div>
		<div class="office_address">
			<ul>
				<li>서울시 어떤구 모르는로 105 엑스빌딩 8F | TEL : 02-123-1234 | FAX : 02-123-1233</li>
				<li>사업자등록번호 : 000-12-00000 | 통신판매업신로 : 강남 제0000호 | 대표이사 : 홍길동</li>
				<li>조은시스템 문의 메일 : webmaster@mula.com | 
				<c:if test="${empty admin }">
					<a href="${conPath }/aloginView.do">관리자모드</a>
				</c:if>
				</li>
			</ul>
		</div>
		<div class="copyright">
			ⓒ2022 JOEUNSYSTEM.Co.,Ltd. All Rights Reserved.
		</div>
	</footer>
	
</body>
</html>