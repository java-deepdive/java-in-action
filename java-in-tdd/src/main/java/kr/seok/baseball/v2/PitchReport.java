package kr.seok.baseball.v2;

public class PitchReport {
	
	private final int strike;
	private final int ball;
	
	protected PitchReport(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}
	
	public boolean threeStrike() {
		return PitchRule.strike(strike);
	}
	
	@Override
	public String toString() {
		return "PitchReport{" +
			"strike=" + strike +
			", ball=" + ball +
			'}';
	}
	
	static class Builder {
		private final int strike;
		private final int ball;
		
		public Builder(int strike, int ball) {
			this.strike = strike;
			this.ball = ball;
		}
		
		public PitchReport build() {
			return new PitchReport(strike, ball);
		}
	}
	
	enum PitchRule {
		STRIKE(3);
		
		private final int value;
		
		PitchRule(int value) {
			this.value = value;
		}
		
		public int value() {
			return value;
		}
		
		public static boolean strike(int value) {
			return value == STRIKE.value;
		}
	}
}
