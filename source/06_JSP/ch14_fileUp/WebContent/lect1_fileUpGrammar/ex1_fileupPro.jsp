<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
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
	<%
	String path = request.getRealPath("fileUpFolder");
	//out.println(path);
	int maxSize = 1024*1024*10;	// 업로드 최대 용량을 10MB
	String filename = "";	//서버에 저장될 파일 이름
	String originalFilename = "";	//업로드한 오리지널 파일이름
	try{
		MultipartRequest mpr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());	
											//request객체, save디렉토리, maxSize, 인코딩, 서버에 동일명 존재할 경우 rename(1.jpg -> 11.jpg)
		Enumeration<String> paramNames =mpr.getFileNames();	//파라미터 이름들
		String param = paramNames.nextElement();	//파라미터 이름 "file"
		filename = mpr.getFilesystemName(param);	//파라미터 이름으로 저장된 파일 이름
		originalFilename = mpr.getOriginalFileName(param);	//오리지널 파일 이름
		//파일첨부를 하지 않을 경우 filename과 originalFilename에는 null
		System.out.println("파라미터 이름 : "+param+" /서버에 저장된 파일이름 : "+filename+" /사용자가 업로드한 오리지널 파일이름 : "+originalFilename);
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
	//서버 fileUpFolder폴더에 업로드한 파일 ->  소스의 fileUpFolder폴더로 copy
	InputStream is = null;	//서버에
	OutputStream os = null;	//소스폴더로 복사할 것
	try{
		File serverFile = new File(path+"/"+filename);
		if(serverFile.exists()){	//첨부한 파일 있는지, 첨부하지 않았으면 파일 복사X
			is = new FileInputStream(serverFile);	//원본 파일
			os = new FileOutputStream("D:/pjw/webPro/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/"+filename);	//복사될 파일
			//복사할 때 한번에 복사하기 위해
			byte[] bs = new byte[(int)serverFile.length()];	//serverFile.length() long형이라 int형으로 형변환
			//byte[] bs = new byte[1024*1024];	//1024*1024 바이트 짜리
			while(true){
				int nReadCnt = is.read(bs);	//파일의 끝이 아닐경우 읽어들인 byte수 : nReadCnt
				if(nReadCnt==-1) break;	//다 읽어와서 file의 끝이면 nReadCnt가 -1
				os.write(bs, 0, nReadCnt);	//0번 idx부터 nReadCnt idx까지(0 ~ nReadCnt)
			}
			System.out.println("서버첨부 & 복사완료");
		}
	}catch(Exception e){	
		System.out.println(e.getMessage());
	}finally{
		if(os!=null) os.close();
		if(is!=null) is.close();
	}
	if(filename!=null){	//첨부함
	%>
		<h3>첨부한 오리지널 파일 이름 : <%=originalFilename %></h3>
		<h3>서버에 저장된 파일 : <%=path %>/<%=filename %></h3>
		<img alt="첨부파일" src="<%=conPath %>/fileUpFolder/<%=filename %>" >		
	<%
	}else{	//첨부안함
		out.println("<h2>첨부 안 함</h2>");
	}
	%>
</body>
</html>