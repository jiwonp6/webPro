package com.lec.ex03_readerwriter;

import java.io.FileReader;
import java.io.Reader;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			while(true) {
				int i = reader.read();
				if(i==-1) break;	//-1이면 file의 끝임
				System.out.print((char)i);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(reader!=null) reader.close();
			} catch (Exception e2) {}
		}
	}
}
