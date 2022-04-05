package com.lec.ex04_printWrite;

import java.io.*;

public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
			//1
			os = new FileOutputStream("txtFile/outTest.txt", true);	//기본스트림
			printWriter = new PrintWriter(os);	//보조스트림
			//2
			writer = new FileWriter("txtFile/outTest.txt", true);
			printWriter = new PrintWriter(writer);	//보조스트림
			//3
			printWriter = new PrintWriter("txtFile/outTest.txt");	//파일 append불가
			
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\\n반갑습니다");
			
			System.out.println("print는 자동개행이 안되서 개행추가\n");
			printWriter.println("print는 자동개행이 안되서 개행추가\n");
			
			System.out.printf("%s\t %d\t %d\t %5.1f\n", "홍길동", 90, 91, 90.5);
			printWriter.printf("%s\t %d\t %d\t %5.1f\n", "홍길동", 90, 91, 90.5);

			System.out.printf("%s\t %d\t %d\t %5.1f\n", "신길동", 100, 91, 90.5);
			printWriter.printf("%s\t %d\t %d\t %5.1f\n", "신길동", 100, 91, 90.5);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(printWriter!=null) printWriter.close();	//try-catch 필요없음
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException ignore) {}
			if(os!=null)
				try {
					os.close();
				} catch (IOException ignore) {}
			
		}
	}
}
