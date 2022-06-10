<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%	//한글 인코딩처리 - multipartRequest 객체 생성 - 첨부된 파일명 get - 그 외 파라미터에 입력된 정보 get - insert
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("bookImg");
	int maxSize = 1024*1024*5;	//최대 업로드 용량 5MG
	String[] image = {"", ""};	//저장된 파일명 저장소 배열로 선언+초기화
	MultipartRequest mpr = null;
	//첨부파일 받아오기 위한 DB연결
	try{
		//multipartRequest객체 생성
		mpr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		//서버에 저장된 파일명 get
		Enumeration<String> paramNames = mpr.getFileNames();	//파라미터 이름들
		int idx = 0;
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement();	//파라미터 이름
			image[idx] = mpr.getFilesystemName(param);	//저장된 파일명
			idx++;
		}
	} catch(Exception e){
		System.out.println(e.getMessage());
	}
	//서버(tomcat)의 bookImg폴더 파일을 소스의 bookImg폴더로 복사
	for(String img : image){
		if(img!=null){
			InputStream is = null;
			OutputStream os = null;
			File serverFile = new File(path+"/"+img);
			try{
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\pjw\\webPro\\source\\06_JSP\\ch14_fileUp\\WebContent\\bookImg\\"+img);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int readbyteCnt = is.read(bs);
					if(readbyteCnt==-1) break;
					os.write(bs, 0, readbyteCnt);
				}
			} catch(Exception e){
				System.out.println(e.getMessage());
			} finally{
				try{
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch(Exception e2){	}
			}
		}
	}
	//파일첨부외 파라미터에서 입력된 정보 get
	int bid = 0;
	String btitle = mpr.getParameter("btitle");
	int bprice = Integer.parseInt(mpr.getParameter("bprice"));
	String bimage1 = image[1]==null ? "noImg.png":image[1];
	String bimage2 = image[0]==null ? "NOTHING.JPG":image[0];
	String bcontent = mpr.getParameter("bcontent");
	int bdiscount = Integer.parseInt(mpr.getParameter("bdiscount"));
	Timestamp brdate = null;
	//DB에 insert
	BookDao bDao = BookDao.getInstance();
	BookDto book = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
	int result = bDao.insertBook(book);
	if(result == BookDao.SUCCESS){
		out.println("<h2>책 등록 성공</h2>");
	}else{
		out.println("<h2>책 등록 실패</h2>");
	}
	%>
	
	<!-- 출력 -->
	<h3>책이름 : <%=btitle %></h3>
	<h3>책대표이미지 : <%=path %>/<%=bimage1 %></h3>
	<img alt="대표" src="<%=conPath %>/bookImg/<%=bimage1 %>">
	<h3>책이미지2 : <%=path+"/"+bimage2 %></h3>
	<img src="../bookImg/<%=bimage2 %>">	
	<h3>책설명</h3>
	<pre><%=bcontent %></pre>	<!-- enter까지 그대로 -->
	<h3>책 가격 : <del><%=bprice %></del><%=bprice*(100-bdiscount)/100 %>원</h3>
	<h3>할인율 : <%=bdiscount %>%</h3>
	<a href = "ex3_list_board.jsp">책 전체 리스트(게시판 스타일)</a>
	<a href = "ex3_list_boardp.jsp">책 리스트(paging 게시판 스타일)</a>
	<a href = "ex3_list_product.jsp">책 전체 리스트(쇼핑몰 스타일)</a>
	<a href = "ex3_list_productp.jsp">책 리스트(paging 쇼핑몰 스타일)</a>
</body>
</html>