//Hello.java--(������)-->Hello.class--(���� java Hello NCT ����)-->���
public class Hello {
	public static void main(String[] args) {	//args�� 2��¥�� ��(NCT, ����) ����
		System.out.print("Hello");
		for(int idx=0 ; idx<args.length ; idx++) {
			System.out.print(", " + args[idx]);
		}
	}
}
