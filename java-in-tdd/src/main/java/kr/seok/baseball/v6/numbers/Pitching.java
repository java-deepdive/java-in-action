package kr.seok.baseball.v6.numbers;

/**
 * 투구를 기반으로 스트라이크, 볼을 판단하는 클래스
 */
public class Pitching {
	
	private static final int BASEBALL_STRIKE = 3;
	private final int strike;
	private final int ball;
	
	private Pitching(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}
	
	public static Pitching matches(Balls target, Balls user) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < target.size(); i++) {
			if (target.isStrike(user, i)) {
				strike++;
			} else if (target.isBall(user, i)) {
				ball++;
			}
		}
		return new Pitching(strike, ball);
	}
	
	public boolean isStrike() {
		return strike == BASEBALL_STRIKE;
	}
	
	@Override
	public String toString() {
		return "Pitching{" +
			"strike=" + strike +
			", ball=" + ball +
			'}';
	}
}
