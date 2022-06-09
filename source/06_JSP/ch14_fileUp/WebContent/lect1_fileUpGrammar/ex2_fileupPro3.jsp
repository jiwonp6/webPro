<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	int maxSize = 1024*1024*10;	//최대용량 업로드
	String[] filename = {"", "", ""};	//""로 초기화
	String[] originFilename = {"", "", ""};
	try{
		MultipartRequest mpr = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Enumeration<String> paramNames = mpr.getFileNames();	//파라미터 이름들 받아옴
		int idx = 0;
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement();	//파라미터 이름
			filename[idx] = mpr.getFilesystemName(param);	//해당 파라미터 이름으로 저장된 파일 이름
			originFilename[idx] = mpr.getOriginalFileName(param);
			System.out.println(idx +"번째 파라미터 : "+param+", 저장파일 : "+filename[idx]+", 원파일명 : "+originFilename[idx]);
			idx++;
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	//서버에 저장된 파일을 소스폴더로 복사
	for(String f : filename){
		if(f!=null){
			//파일 복사
			InputStream is = null;	//서버에
			OutputStream os = null;	//소스폴더로 복사할 것
			try{
				File serverFile = new File(path+"/"+f);
				if(serverFile.exists()){	//첨부한 파일 있는지, 첨부하지 않았으면 파일 복사X
					is = new FileInputStream(serverFile);	//원본 파일
					os = new FileOutputStream("D:/pjw/webPro/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/"+f);	//복사될 파일
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
		}
	}
	%>
	<%=Arrays.toString(filename) %>
	<%=Arrays.toString(originFilename) %>
	<h2>파일0 첨부내용</h2>
	<h5><%=path %>/<%=filename[2]%></h5>
	<img src="../fileUpFolder/<%=filename[2] %>" alt="첫번째 첨부파일">
	<h2>파일1 첨부내용</h2>
	<h5><%=path %>/<%=filename[1]%></h5>
	<img src="../fileUpFolder/<%=filename[1] %>" alt="두번째 첨부파일">
	<h2>파일2 첨부내용</h2>
	<h5><%=path %>/<%=filename[0]%></h5>
	<img src="../fileUpFolder/<%=filename[0] %>" alt="세번째 첨부파일">
</body>
</html>