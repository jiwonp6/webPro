package com.lec.ex03_phone;
//b�� : DMB�ۼ��Ű���, LTE, TV������ ž�� 
public class BModel implements IAcorporation{
	private String modelName;
	public BModel() {
		modelName = "B��";
	}
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB ��� ����");	
	}
	@Override
	public void lte() {
		System.out.println(modelName + "�� lte");	
	}
	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV������ ž��");
	}

}
