//Hello.java--(컴파일)-->Hello.class--(실행 java Hello NCT 지성)-->결과
public class Hello {
	public static void main(String[] args) {	//args가 2개짜리 방(NCT, 지성) 생성
		System.out.print("Hello");
		for(int idx=0 ; idx<args.length ; idx++) {
			System.out.print(", " + args[idx]);
		}
	}
}
