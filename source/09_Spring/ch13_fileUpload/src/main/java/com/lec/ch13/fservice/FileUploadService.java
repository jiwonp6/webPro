package com.lec.ch13.fservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUploadService {
	//FileUp
	public boolean fileUp(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		boolean isUpload = false;
		//파일 업로드된 파일명 받아, 서버에 업로드, 프로젝트 폴더에 복사
		String uploadPath = mRequest.getRealPath("upload/");	//현재실행되는(Tomcat폴더 안)
		String backupPath = "D:\\pjw\\webPro\\source\\09_Spring\\ch13_fileUpload\\src\\main\\webapp\\upload\\";
		String[] fileNames = new String[3];	//처음엔 null이 들어있음
		int i = 0;
		Iterator<String> params = mRequest.getFileNames(); // file1, file2, file3(파라미터 이름들)
		while(params.hasNext()) {
			String param = params.next();
			System.out.println(i+"번째 파라미터 이름 : "+param);
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 파일 객체
			fileNames[i] = mFile.getOriginalFilename(); // param으로 첨부한 파일의 원래 이름
			// 첨부를 안 하면 빈칸
			if(fileNames[i]!=null && !fileNames[i].equals("")) { // 첨부한 파일이 있을 경우
				if(new File(uploadPath+fileNames[i]).exists()) { // 저장할 파일이름이 서버의 파일과 중복될 경우 -> 파일명 변경
					fileNames[i] = System.currentTimeMillis() + fileNames[i];
				}// if - 중복된 파일이름일 경우 파일명 변경
				try {
					mFile.transferTo(new File(uploadPath+fileNames[i]));	// 서버에 파일 저장
					System.out.println("서버에 저장된 파일 : " + uploadPath + fileNames[i]);
					System.out.println("백업 복사 파일:" + backupPath + fileNames[i]);
					isUpload = fileCopy(uploadPath+fileNames[i], backupPath+fileNames[i]);	//fileCopy로직 함수 이용
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} 
			}else {
				System.out.println(i+"번째는 파일 첨부 안 함");
				isUpload=true;
			}//if-else
			i++;	//file 순서대로 수행하기 위해
		}// while
		mav.addObject("fileNames", fileNames);		
		return isUpload;
		
	}
	//fileCopy
	private boolean fileCopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		//복사로직
		FileInputStream is = null;
		FileOutputStream os = null;
		/* =
		 * InputStream is = null;
		 * OutputStream os = null;
		 * try {
		 * 		is = new FileInputStream(serverFile);
		 * } catch (FileNotFoundException e1) {
		 * 		System.out.println(e1.getMessage());
		 * }
		 */
		try {
			//파일을 1byte씩 X 한번에 읽기위해 조정
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int)file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;	//파일 끝 ->break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
		
	}

}
