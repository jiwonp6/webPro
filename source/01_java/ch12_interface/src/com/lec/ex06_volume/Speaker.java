package com.lec.ex06_volume;

public class Speaker implements IVolume {
	private final int SPEAKER_MAX_VOLUME=100;
	private final int SPEAKER_MIN_VOLUME=0;
	private int volumeLevel;
	public Speaker() {}
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("����Ŀ ������ 1�÷� ���� "+volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ִ�ġ�Դϴ�.");
		}
	}
	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= SPEAKER_MAX_VOLUME) {	//level��ŭ ���� �ø�
			volumeLevel += level;
			System.out.println("����Ŀ ������ " +level+ "��ŭ �÷� ���� "+volumeLevel);
		}else {	//level��ŭ ���� ���ø�
			int tempLevel = SPEAKER_MAX_VOLUME-volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("����Ŀ ������ "+level+"��ŭ �� �ø��� "
								+tempLevel+"��ŭ �÷� �ִ�ġ"+SPEAKER_MAX_VOLUME);
		}
	}
	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("����Ŀ ������ 1������ ���� "+volumeLevel);
		}else {
			System.out.println("����Ŀ ������ 0�Դϴ�.");
		}
	}
	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) {	//level��ŭ ���� �ø�
			volumeLevel -= level;
			System.out.println("����Ŀ ������ " +level+ "��ŭ ���� ���� "+volumeLevel);
		}else {	//level��ŭ ���� ���ø�
			int tempLevel = volumeLevel - SPEAKER_MIN_VOLUME;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������ "+level+"��ŭ �� ������ "
								+tempLevel+"��ŭ ���� �ּ�ġ"+SPEAKER_MIN_VOLUME);
		}
	}

}
