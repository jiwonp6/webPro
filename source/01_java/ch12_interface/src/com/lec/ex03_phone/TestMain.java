package com.lec.ex03_phone;

public class TestMain {
	public static void main(String[] args) {
		IAcorporation a = new AModel();
		IAcorporation b = new BModel();
		IAcorporation c = new CModel();
		IAcorporation[] phone = {a, b, c};
		for(IAcorporation p : phone) {
			System.out.println(p.getClass().getName());		//Å¬·¡½º com.lec.ex03_phone.xModel
			p.dmbReceive();
			p.lte();
			p.tvRemoteControl();
			System.out.println("======================");
		}
	}
}
