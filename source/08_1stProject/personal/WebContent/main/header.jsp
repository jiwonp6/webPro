<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/header.css" rel="stylesheet">
	<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
    <style>
    .lnbFixed {
        position: fixed;
        top: 0;
        right:0;
      }
    </style>
    <script>
      $( document ).ready( function() {
        var jbOffset = $( '.lnb' ).offset();
        $( window ).scroll( function() {
          if ( $( document ).scrollTop() > jbOffset.top ) {
            $( '.lnb' ).addClass( 'lnbFixed' );
          }
          else {
            $( '.lnb' ).removeClass( 'lnbFixed' );
          }
        });
      } );
      $(document).ready(function () {   
    	  $('.mybag').hover(function(){        
    		  $('.mybag_sub').css('display','block');    
    	  	}, function() {        
    		  	$('.mybag_sub').css('display','none');    
    		  });
      });
    </script>
</head>
<body>
	<header>
		<div class="header_wrap">
			<div class="gnb">
				<c:if test="${member eq null}">
					<ul>
						<li><a href="${conPath }/joinView.do">회원가입</a></li>
						<li><a href="${conPath }/loginView.do">로그인</a></li>
					</ul>
				</c:if>
				<c:if test="${not empty member}">
					<ul>
						<li class="mybag">
							<a>MY BAG</a>
							<ul class="mybag_sub">
								<li><a>${member.mId }님</a></li>
								<li><a href="${conPath }/uploadView.do">MY BAG</a></li>
								<li><a href="${conPath }/likeyView.do">LIKEY!</a></li>
								<li><a href="${conPath }/modifyView.do">MODIFY</a></li>
								<li><a href="${conPath }/logout.do">LOGOUT</a></li>
							</ul>
						</li>
					</ul>
				</c:if>
			</div>
			<div class="logo">
				<a>What's in My Bag</a>
			</div>
			<div class="lnb">
				<ul>
					<li><a href="${conPath }/main.do">HOME</a></li>
					<li><a href="${conPath }/uploadView.do">UPLOADmyBag</a></li>
					<li><a href="${conPath }/itemboardList.do">ItemQ&A</a></li>
					<li><a href="#">?</a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>