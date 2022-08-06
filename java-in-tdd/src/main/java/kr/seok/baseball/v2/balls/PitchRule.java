package kr.seok.baseball.v2.balls;

public enum PitchRule {
		MIN(1),
		MAX(10);
		
		private final int value;
		PitchRule(int value) {
			this.value = value;
		}
		
		public int value() {
			return value;
		}
	}