package com.lec.ex06_volume;
//지침서
public interface IVolume {
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void setMute(boolean mute) {	
	//인터페이스 안 일반 메소드 들어올 수 없음 -> default 넣어주면 가능
		if(mute)
			System.out.println("음소거");
		else
			System.out.println("음소거 해제");
	}
}
