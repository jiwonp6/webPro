package com.lec.ex03_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		while(true) {
			try {
				writer = new FileWriter("txtFile/outTest.txt", true);
				String msg = "\n\n추가한 텍스트 파일입니다. 안녕하세요";
				writer.write(msg);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(writer!=null) writer.close();
				} catch (Exception ignore) {}
			}
		}
	}
}
