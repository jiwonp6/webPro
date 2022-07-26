package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;

@Service // service 빈 생성
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bDao;
	String backupPath = "D:\\pjw\\webPro\\source\\09_Spring\\ch19_memberBookUp\\src\\main\\webapp\\bookImgFileUpload\\";

	@Override
	public List<Book> mainList() {
		return bDao.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum, Book book) {
		Paging paging = new Paging(bDao.cntBook(book), pageNum, 3, 3);
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bDao.bookList(book);
	}
	
	/*
	@Override
	public int totCntBook() {
		return bDao.totCntBook();
	}
	*/

	@Override
	public Book getDetailBook(int bnum) {
		return bDao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		boolean result = false;
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // 파라미터이름 받음(tempBimg1, tempBimg2)
		String[] bimg = { "", "" };
		// => String[] bimg = new String[2]; 크기가 2인 배열 객체 생성
		int idx = 0;
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 첨부된 파일 객체
			System.out.println(idx + "번째 파라미터 이름 : " + param);
			bimg[idx] = mFile.getOriginalFilename(); // param으로 첨부한 파일의 원래 이름
			if (bimg[idx] != null && !bimg[idx].equals("")) { // 첨부한 파일이 있을 경우
				// 저장할 파일이름이 서버의 파일과 중복될 경우 -> 파일명 변경
				if (new File(uploadPath + bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result == true ? idx + "번째 백업성공" : idx + "번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else {
				// 파일 첨부 안 하면 bimg[idx] = ""
				// bimg[idx] = "";
				System.out.println(idx + "번째는 파일 첨부 안 함");
				result=true;
			}
			idx++;
		} // while
		book.setBimg1(bimg[0]);		//첫번째 첨부한 파일 이름
		book.setBimg2(bimg[1]);		//두번째 첨부한 파일 이름
		System.out.println("1:" +bimg[0]);
		System.out.println("2:" +bimg[1]);
		
		return bDao.registerBook(book);		//DB insert
	}

	/* @Override	//매개변수로 Book 객체X
	public int registerBook(MultipartHttpServletRequest mRequest) {
		boolean result = false;
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // 파라미터이름 받음(tempBimg1, tempBimg2)
		String[] bimg = { "", "" };
		// => String[] bimg = new String[2]; 크기가 2인 배열 객체 생성
		int idx = 0;
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 첨부된 파일 객체
			System.out.println(idx + "번째 파라미터 이름 : " + param);
			bimg[idx] = mFile.getOriginalFilename(); // param으로 첨부한 파일의 원래 이름
			if (bimg[idx] != null && !bimg[idx].equals("")) { // 첨부한 파일이 있을 경우
				// 저장할 파일이름이 서버의 파일과 중복될 경우 -> 파일명 변경
				if (new File(uploadPath + bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result == true ? idx + "번째 백업성공" : idx + "번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else {
				// 파일 첨부 안 하면 bimg[idx] = ""
				// bimg[idx] = "";
				System.out.println(idx + "번째는 파일 첨부 안 함");
				result=true;
			}
			idx++;
		} // while
		Book book = new Book();
		book.setBnum(Integer.parserInt(mRequest.getParameter("bnum"));
		. . . (book객체 파라미터 다 받아옴...)
		book.setBimg1(bimg[0]);		//첫번째 첨부한 파일 이름
		book.setBimg2(bimg[1]);		//두번째 첨부한 파일 이름
		return bDao.registerBook(book);		//DB insert
	}*/
	
	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		boolean result = false;
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // 파라미터이름 받음(tempBimg1, tempBimg2)
		String[] bimg = { "", "" };
		// => String[] bimg = new String[2]; 크기가 2인 배열 객체 생성
		int idx = 0;
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 첨부된 파일 객체
			System.out.println(idx + "번째 파라미터 이름 : " + param);
			bimg[idx] = mFile.getOriginalFilename(); // param으로 첨부한 파일의 원래 이름
			if (bimg[idx] != null && !bimg[idx].equals("")) { // 첨부한 파일이 있을 경우
				// 저장할 파일이름이 서버의 파일과 중복될 경우 -> 파일명 변경
				if (new File(uploadPath + bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result == true ? idx + "번째 백업성공" : idx + "번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else {
				// 파일 첨부 안 하면 bimg[idx] = ""
				// bimg[idx] = "";
				System.out.println(idx + "번째는 파일 첨부 안 함");
				result=true;
			}
			idx++;
		} // while
		book.setBimg1(bimg[0]);		//첫번째 첨부한 파일 이름
		book.setBimg2(bimg[1]);		//두번째 첨부한 파일 이름
		return bDao.modifyBook(book);
	}

	@Override
	public int deleteBook(int bnum) {
		return bDao.deleteBook(bnum);
	}
	
	@Override
	public int cntBook(Book book) {
		return bDao.cntBook(book);
	}

	// fileCopy
	private boolean fileCopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		// 복사로직
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			// 파일을 1byte씩 X 한번에 읽기위해 조정
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];
			while (true) {
				int nReadByte = is.read(buff);
				if (nReadByte == -1)
					break; // 파일 끝 ->break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;

	}

}
