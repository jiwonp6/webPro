package com.lec.ex03_phone;
//c�� : : DMB�ۼ��źҰ�, LTE, TV������ ��ž��
public class CModel implements IAcorporation{
	private String modelName;
	public CModel() {
		modelName = "C��";
	}
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �ۼ��� �Ұ�");	
	}
	@Override
	public void lte() {
		System.out.println(modelName + "�� lte");	
	}
	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV������ ��ž��");
	}

}
