package com.lec.ex2_human.main;

//com.lec.ex2_human ��Ű���� ��� class�� import
import com.lec.ex2_human.*;
//import com.lec.ex2_human.*;�� ��� ��Ű�� import��
//							��, ---> import com.lec.ex2_human.Woman;
//								---> import com.lec.ex2_human.Man;
public class TestMain {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		System.out.println((i==j) ? "����" : "�ٸ���");		//���ʵ����� Ÿ�Կ����� ������ ��(==)
		
		String name = "ȫ�浿";
		String name2 = "ȫ�浿";	//name�̶� name2�� ���� �̸��̸� ���� �� ����Ŵ, �� ����
		if(name.equals(name2)) {
			System.out.println("name�� name2�� ����.");
		}
		Woman hee1 = new Woman();	//ctrl + shift + o	---> �ʿ��� �͸� import����(���ʿ��� �� ����)
		Woman hee2 = new Woman();
//		hee1.method();
		if(hee1.equals(hee2)) {
			System.out.println("hee1�� hee2�� ����");
		}
		Man kang = new Man(22, 165, 60.2);
		Man kim = new Man(22, 180, 65.6);
		Man kim1;	// ���۷��� ����(��ü����) ����
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6);
		if(kim.equals(kim1)) {
			System.out.println("kim�� kim1�� ����.");	//���� �ּҸ� ����Ų��.
		}
		if(!kim.equals(kim2)) {
			System.out.println("kim�� kim2�� �ٸ���.");	//������ ���������� ���� �ٸ� �ּҿ� �����ϹǷ� ���� �ٸ�.
		}
		kang.setHeight(160);
		kang.setWeight(50.9);	//�Ű����� �ȿ� double�� ���� int�� ������ ������ ����ȯ �߻�
		if(kang.calculateBMI() > 30) {
			System.out.println("�ǰ��ϼ���.");
		}else {
			System.out.println("�ǰ��ϰڳ׿�.");
		}
	}
}
