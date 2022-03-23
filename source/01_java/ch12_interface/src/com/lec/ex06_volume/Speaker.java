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
			System.out.println("스피커 볼륨을 1올려 현재 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치입니다.");
		}
	}
	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= SPEAKER_MAX_VOLUME) {	//level만큼 볼륨 올림
			volumeLevel += level;
			System.out.println("스피커 볼륨을 " +level+ "만큼 올려 현재 "+volumeLevel);
		}else {	//level만큼 볼륨 못올림
			int tempLevel = SPEAKER_MAX_VOLUME-volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨을 "+level+"만큼 못 올리고 "
								+tempLevel+"만큼 올려 최대치"+SPEAKER_MAX_VOLUME);
		}
	}
	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("스피커 볼륨을 1내려서 현재 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 0입니다.");
		}
	}
	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) {	//level만큼 볼륨 올림
			volumeLevel -= level;
			System.out.println("스피커 볼륨을 " +level+ "만큼 내려 현재 "+volumeLevel);
		}else {	//level만큼 볼륨 못올림
			int tempLevel = volumeLevel - SPEAKER_MIN_VOLUME;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨을 "+level+"만큼 못 내리고 "
								+tempLevel+"만큼 내려 최소치"+SPEAKER_MIN_VOLUME);
		}
	}

}
