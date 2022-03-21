package com.lec.ex0_warmup;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 81, 90, 90);
		Student s3 = new Student("황정민", 91, 90, 90);
		Student s4 = new Student("강동원", 80, 90, 90);
		Student s5 = new Student("유아인", 70, 90, 90);
		Student[] student = {s1, s2, s3, s4, s5};
		String[] title = {"이름","국어","영어","수학","총점","평균"};
		int[] tot = new int[5];	//tot[0] 국어누적, tot[1] 영어누적 ...
		double[] avg = new double[5];	//avg[0] 국어평균, avg[1] 영어평균 ...
		
		printLine();
		System.out.println("\t\t\t성적표");
		printLine('-',50);
		for(String t : title) {
			System.out.print('\t'+t);
		}
		System.out.println();
		printLine('-',50);
		for(Student s : student) {
			s.print();	//출력 후 누적
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg();	//tot[4] = (int)(tot[4]+s.getAvg());
		}
		for(int idx=0 ; idx<avg.length ; idx++) {	//출력할 평균계산avg[0] = tot[0]/5 
			//배열 수정할 때는 확장for문 쓰면 안됨
			avg[idx] = tot[idx]/(double)(student.length);	//avg[1]=tot[1]/5
		}
		printLine();	
		System.out.print("\t총점\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		}
		System.out.print("\n\t평균\t");
		for(double a : avg) {
			System.out.print(a+"\t");
		}
		System.out.println("");
		printLine();	//static함수라서 이탤릭체
	}
	
	private static void printLine() {
		for(int i=0 ; i<65 ; i++) {
			System.out.print('■');
		}
		System.out.println();
	}
	private static void printLine(char ch, int cnt) {
		System.out.print("\t");
		for(int i=0 ; i<cnt ; i++) { // 한줄에 cnt번 ch를 출력
			System.out.print(ch);
		}
		System.out.println(); // 개행
	}
}
