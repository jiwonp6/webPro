package com.lec.ex0_parkingSystem;

import java.util.Scanner;

import com.lec.cons.Constant;

//+����+������ ���� Ƚ���� in/out�����ؼ� ¥����(��ĳ�ʶ� Ƚ�����ϴ°�)
public class ParkingSystem {
	private String carnum;
	private int inTime;
	private int outTime;
	private int fee;
//	private final int HOURLYPARKINGRATE = 2000;	// <--- final �ٿ��ָ� ���� ������ �ʴ� ��
	
	public ParkingSystem() {}
	public ParkingSystem(String carnum, int inTime) {
		this.carnum = carnum;
		this.inTime = inTime;
		System.out.printf("\"%s\"�� �������\n�����ð� : %s��\n", carnum, inTime);
	}
//	�޼ҵ�( //�Ϲ�O -> �޸�(main)�� new�� �÷����� 
					  //-> ������ ���� ������� ������� û�ҵ�,
		//vs. static -> �޸𸮿� �ö��� �ʰ�, class���� ����, ��, ������ û��X)
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime)*Constant.HOURLYPARKINGRATE;
		System.out.printf("\"%s\"�� �ȳ��� ������\n", carnum);
		System.out.printf("�����ð� : %d��\n", outTime);
		System.out.printf("������� : %d\n", fee);
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public void out() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ÿ� �����ϳ���?");
		outTime = sc.nextInt();
		 out(outTime);	//���� outTime�޼ҵ� ȣ��
		sc.close();
		 
	}
	
}
