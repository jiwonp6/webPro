package com.lec.ex02_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis);	//보조스트림은 기본스트림을 통해서 생성
			while(true) {
				String name = dis.readUTF();
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.printf("%s는 %d학년 %.1f점\n", name, grade, score);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음"+e.getMessage());
		} catch (IOException e) {
			System.out.println("이상 데이터 끝"+e.getMessage());
		}finally {
			try {
				if(dis!=null) dis.close();	//dos먼저 닫아야함
				if(fis!=null) fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
