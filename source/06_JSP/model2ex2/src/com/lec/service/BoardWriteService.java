package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.FileBoardDao;
import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getRealPath("freeBoardUp");
		int maxSize = 1024*1024;	//사진업로드 제한 용량 : 1M
		String ffilename = "";	//첨부된 파일이 저장된 파일 이름
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			ffilename = mRequest.getFilesystemName(param);
			HttpSession httpSession = request.getSession();
			MemberDto member = (MemberDto)httpSession.getAttribute("member");
			if(member!=null) {
				String mid = mRequest.getParameter("mid");
				String ftitle = mRequest.getParameter("ftitle");
				String fcontent = mRequest.getParameter("fcontent");
				ffilename = (ffilename == null ? "" : ffilename);
				String fip = request.getRemoteAddr();
				FileBoardDao fDao = FileBoardDao.getInstance();
				int result = fDao.write(mid, ftitle, fcontent, ffilename, fip);
				if(result == FileBoardDao.SUCCESS) {
					request.setAttribute("writeResult", "글쓰기 성공");
				}else {
					request.setAttribute("writeErrorMsg", "글쓰기실패");
				}
			}else {
				request.setAttribute("boaredWriteResult", "로그인 한 사람만 글쓸 수 있어요");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//서버에 업로드 된 파일을 소스폴더로 복사(tomcat껐다 켰다 할 것이기 때문)
		if(!ffilename.equals("")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + ffilename);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\pjw\\webPro\\source\\06_JSP\\model2ex2\\WebContent\\freeBoardUp\\"+ffilename);
				byte [] bs = new byte[(int) serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt==-1) {
						break;
					}
					os.write(bs, 0, readByteCnt);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (IOException e) {}
			}
		}
	}

}