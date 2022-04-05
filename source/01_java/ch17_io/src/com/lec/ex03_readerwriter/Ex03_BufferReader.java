package com.lec.ex03_readerwriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex03_BufferReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");		//1.기본스트림 생성
			br = new BufferedReader(reader);	//보조스트림 생성
			int cnt =0;
			while(true) {
				String linedata = br.readLine();	//2.한줄씩 데이터 읽기(한줄씩이라 String)
				if(linedata == null) break;		//파일의 끝인 경우 break
				System.out.println(++cnt +"\t"+ linedata);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(br!=null) br.close();
				if(reader!=null) reader.close();
			} catch (Exception ignore) {}
		}
	}
}
