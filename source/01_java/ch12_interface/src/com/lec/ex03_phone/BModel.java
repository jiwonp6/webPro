package com.lec.ex03_phone;
//b모델 : DMB송수신가능, LTE, TV리모콘 탑재 
public class BModel implements IAcorporation{
	private String modelName;
	public BModel() {
		modelName = "B모델";
	}
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 통신 가능");	
	}
	@Override
	public void lte() {
		System.out.println(modelName + "은 lte");	
	}
	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 TV리모컨 탑재");
	}

}
