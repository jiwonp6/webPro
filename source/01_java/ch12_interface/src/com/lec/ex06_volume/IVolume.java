package com.lec.ex06_volume;
//��ħ��
public interface IVolume {
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void setMute(boolean mute) {	
	//�������̽� �� �Ϲ� �޼ҵ� ���� �� ���� -> default �־��ָ� ����
		if(mute)
			System.out.println("���Ұ�");
		else
			System.out.println("���Ұ� ����");
	}
}
