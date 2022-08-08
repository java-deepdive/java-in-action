package kr.seok.baseball.v2;

public class PitchReport {
	
	private final int strike;
	private final int ball;
	
	protected PitchReport(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}
	
	public boolean isStrike() {
		return strike == 3;
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
	
}
