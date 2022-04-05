package com.lec.ex01_inputstreamOutputstream;
//(1)파일을 연다(입력용 스트림객체생성) 
//(2)데이터를 읽는다 : read() 1byte씩 읽는다. 속도가 느림/ read(byte[]) byte[]만큼 일기
//(3)파일을 닫는다
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");	//1. 파일을 연다
			byte[] bs = new byte[10];
			while(true) {	//2.데이터를 읽는다
				int readByteCount = is.read(bs);	//bs의 byte만큼씩 읽기
				if(readByteCount==-1) break;	//파일의 끝이면 반복문 break;
				for(int i=0; i<readByteCount; i++) {	//byte수에 모자른 문자로 인해 확장for사용 불가
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {	//catch절의 예외는 큰 게 밑으로 가야함
			System.out.println(e.getMessage());
		} finally {	//3.파일을 닫는다.
			try {
				if(is != null) {	//위의 파일이름이 잘못입력돼서 is가 null이면 close못할 수도 있기때문에 if문 사용
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
