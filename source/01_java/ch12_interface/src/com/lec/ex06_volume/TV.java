package com.lec.ex06_volume;
//TV tv = new TV();
//tv.volumeDown()
public class TV implements IVolume {
	private static final byte TV_MAX_VOLUME = 50;
	private static final byte TV_MIN_VOLUME = 0;
	private int volumeLevel;
	public TV() {}
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("TV ������ 1�÷� ���� "+volumeLevel);
		}else {
			System.out.println("TV ������ �ִ�ġ�Դϴ�.");
		}
	}
	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= TV_MAX_VOLUME) {	//level��ŭ ���� �ø�
			volumeLevel += level;
			System.out.println("TV ������ " +level+ "��ŭ �÷� ���� "+volumeLevel);
		}else {	//level��ŭ ���� ���ø�
			int tempLevel = TV_MAX_VOLUME-volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ "+level+"��ŭ �� �ø��� "
								+tempLevel+"��ŭ �÷� �ִ�ġ"+TV_MAX_VOLUME);
		}
	}
	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("TV ������ 1������ ���� "+volumeLevel);
		}else {
			System.out.println("TV ������ 0�Դϴ�.");
		}
	}
	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= TV_MIN_VOLUME) {	//level��ŭ ���� �ø�
			volumeLevel -= level;
			System.out.println("TV ������ " +level+ "��ŭ ���� ���� "+volumeLevel);
		}else {	//level��ŭ ���� ���ø�
			int tempLevel = volumeLevel - TV_MIN_VOLUME;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV ������ "+level+"��ŭ �� ������ "
								+tempLevel+"��ŭ ���� �ּ�ġ"+TV_MIN_VOLUME);
		}
	}

}
