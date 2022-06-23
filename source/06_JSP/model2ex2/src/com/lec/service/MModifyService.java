package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024;	//사진업로드 제한 용량 : 1M
		String mphoto = "";	//첨부된 파일이 저장된 파일 이름
		try {
			//mRequest 객체 생성 후 mPhoto 파일 이름 얻어옴
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			mphoto = mRequest.getFilesystemName(param);
			//mRequest 이용하여 파라미터 받아와서 DB 저장
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			String dbfilename = mRequest.getParameter("dbfilename");
			mphoto = (mphoto == null ? dbfilename : mphoto);
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			MemberDao mdao = MemberDao.getInstance();
			//mid 중복체크
			int result = mdao.updateMember(mid, mpw, mname, memail, mphoto, mbirth, maddress);
			if(result == MemberDao.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("member", mdao.modifyView_replyView(mid));
				session.setAttribute("modifyResult", "회원정보수정 완료");
			}else {
				request.setAttribute("modifyErrorMsg", "회원정보수정 실패");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//서버에 업로드 된 파일을 소스폴더로 복사(tomcat껐다 켰다 할 것이기 때문)
		File serverFile = new File(path + "/" + mphoto);
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\pjw\\webPro\\source\\06_JSP\\model2ex2\\WebContent\\memberPhotoUp\\"+mphoto);
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
