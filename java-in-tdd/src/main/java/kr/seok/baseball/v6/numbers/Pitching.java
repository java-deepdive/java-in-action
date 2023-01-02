package kr.seok.baseball.v6.numbers;

/**
 * 투구를 기반으로 스트라이크, 볼을 판단하는 클래스
 */
public class Pitching {
	
	private final Balls target;
	
	public Pitching(Balls target) {
		this.target = target;
	}
	
	public Pitching matches(Balls userNumber) {
		return null;
	}
	
	public boolean isStrike() {
		return false;
	}
	
	@Override
	public String toString() {
		return "Pitching{}";
	}
}
