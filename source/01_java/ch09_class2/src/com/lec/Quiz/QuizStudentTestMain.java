package com.lec.Quiz;

public class QuizStudentTestMain {
	public static void main(String[] args) {
		QuizStudent s1 = new QuizStudent("정우성", 90, 90, 90);
		QuizStudent s2 = new QuizStudent("김하늘", 81, 90, 90);
		QuizStudent s3 = new QuizStudent("황정민", 91, 90, 90);
		QuizStudent s4 = new QuizStudent("강동원", 80, 90, 90);
		QuizStudent s5 = new QuizStudent("유아인", 70, 90, 90);
		QuizStudent[] student = {s1, s2, s3, s4, s5};
		String[] title = {"번호","이름","국어","영어","수학","총점","평균"};
		int[] tot = new int[5];
		double[] avg = new double[5];
		
		printLine();
		System.out.println("\t\t\t\t성적표");
		printLine('-',55);
		for(String t : title) {
			System.out.print('\t'+t);
		}
		System.out.println();
		printLine('-',55);
		for(QuizStudent s : student) {
			s.print();
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg();
		}
		for(int idx=0 ; idx<avg.length ; idx++) {	
			avg[idx] = tot[idx]/(double)(student.length);
		}
		printLine();	
		System.out.print("\t\t총점\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		}
		System.out.print("\n\t\t평균\t");
		for(double a : avg) {
			System.out.print(a+"\t");
		}
		System.out.println("");
		printLine();
	}
	
	private static void printLine() {
		for(int i=0 ; i<70 ; i++) {
			System.out.print('■');
		}
		System.out.println();
	}
	private static void printLine(char ch, int cnt) {
		System.out.print("\t");
		for(int i=0 ; i<cnt ; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
