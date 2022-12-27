package kr.seok.baseball.v3.vo;

import java.util.Objects;

public class PitchReport {
	private final int strike;
	private final int ball;
	
	public PitchReport(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}
	
	public boolean isStrike() {
		return PitchRule.strike(strike);
	}
	
	public int getBall() {
		return ball;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PitchReport)) return false;
		PitchReport that = (PitchReport) o;
		return strike == that.strike && ball == that.ball;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}
	
	@Override
	public String toString() {
		return
			((strike != 0) ? (strike + " 스트라이크 ") : "") +
				((ball != 0) ? (ball + " 볼") : "");
	}
	
	public static class Builder {
		private int strike;
		private int ball;
		
		public Builder strike(int strike) {
			this.strike = strike;
			return this;
		}
		
		public Builder ball(int ball) {
			this.ball = ball;
			return this;
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
