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
			System.out.println("TV 볼륨을 1올려 현재 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최대치입니다.");
		}
	}
	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= TV_MAX_VOLUME) {	//level만큼 볼륨 올림
			volumeLevel += level;
			System.out.println("TV 볼륨을 " +level+ "만큼 올려 현재 "+volumeLevel);
		}else {	//level만큼 볼륨 못올림
			int tempLevel = TV_MAX_VOLUME-volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못 올리고 "
								+tempLevel+"만큼 올려 최대치"+TV_MAX_VOLUME);
		}
	}
	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("TV 볼륨을 1내려서 현재 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 0입니다.");
		}
	}
	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= TV_MIN_VOLUME) {	//level만큼 볼륨 올림
			volumeLevel -= level;
			System.out.println("TV 볼륨을 " +level+ "만큼 내려 현재 "+volumeLevel);
		}else {	//level만큼 볼륨 못올림
			int tempLevel = volumeLevel - TV_MIN_VOLUME;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못 내리고 "
								+tempLevel+"만큼 내려 최소치"+TV_MIN_VOLUME);
		}
	}

}
