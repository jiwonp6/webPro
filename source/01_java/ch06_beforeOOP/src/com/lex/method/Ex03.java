package com.lex.method;
//Arithmetic.sum / evenOdd(static) v.s. abs(�Ϲ�)
public class Ex03 {
//	<static �Լ� ȣ��>	public�̸� �� �� ���� (private X, �ƹ��͵� �Ⱦ��� �� �������� �� �� ����)
	//static�� ��� �� ���� �ʴ´�. heap�޸� ������ �ȵǱ� ����
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);	//Arithmetic class�� �ִ°� �ҷ���
		System.out.println("1���� 10������ ���� " + tot);
		System.out.println(Arithmetic.evenOdd(tot));
		
//	<abs �Լ� ȣ��>	 <-----��üȭ ���� �ʿ�(heap�޸��� ���赵�� ar(��ü)�� ����� ���� ����)
		Arithmetic ar = new Arithmetic();	
		//�޸� Ȯ�� ���� new ���, ar�� class�ּҸ� �޾� ������ ����
		System.out.println("-8�� ������" + ar.abs(-8));
	}
}
