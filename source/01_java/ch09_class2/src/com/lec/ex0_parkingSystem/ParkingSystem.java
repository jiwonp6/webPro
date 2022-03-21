package com.lec.ex0_parkingSystem;

import java.util.Scanner;

import com.lec.cons.Constant;

//+숙제+주차장 들어온 횟수로 in/out구분해서 짜보자(스캐너랑 횟수더하는것)
public class ParkingSystem {
	private String carnum;
	private int inTime;
	private int outTime;
	private int fee;
//	private final int HOURLYPARKINGRATE = 2000;	// <--- final 붙여주면 절대 변하지 않는 수
	
	public ParkingSystem() {}
	public ParkingSystem(String carnum, int inTime) {
		this.carnum = carnum;
		this.inTime = inTime;
		System.out.printf("\"%s\"님 어서오세요\n입차시간 : %s시\n", carnum, inTime);
	}
//	메소드( //일반O -> 메모리(main)에 new를 올려야함 
					  //-> 실행한 다음 쓰레기로 쓰레기는 청소됨,
		//vs. static -> 메모리에 올라가지 않고, class에서 실행, 즉, 쓰레기 청소X)
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime)*Constant.HOURLYPARKINGRATE;
		System.out.printf("\"%s\"님 안녕히 가세요\n", carnum);
		System.out.printf("출차시간 : %d시\n", outTime);
		System.out.printf("주차요금 : %d\n", fee);
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
		System.out.println("몇시에 출차하나요?");
		outTime = sc.nextInt();
		 out(outTime);	//위의 outTime메소드 호출
		sc.close();
		 
	}
	
}
