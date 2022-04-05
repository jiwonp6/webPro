package com.lec.ex01_inputstreamOutputstream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//(1)스트림객체(입력용, 출력용) (2)읽고 쓴다 (3)파일닫는다(스트림객체.close)
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_filecopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:\\pjw\\webPro\\nctdream.jpg");	//(1)
			os = new FileOutputStream("d:\\pjw\\webPro\\nctdream_copy.jpg");
			int cnt = 0;
			byte[] bs = new byte[1024];	//1KB씩 읽을 예정
			while(true) {	//(2)
				int readByteCount = is.read(bs);	//1024 byte읽기
				if(readByteCount == -1) break;		//파일의 끝인지 여부
				os.write(bs, 0, readByteCount);		//bs를 0번 idx부터 readBytecount만큼 쓴다
				cnt++;
			}
			System.out.println(cnt+ "번 while문 실행하여 힘들게 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) {
					os.close();
				}
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
