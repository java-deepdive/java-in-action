package kr.seok.baseball.v3.component;

import kr.seok.baseball.v3.vo.Balls;
import kr.seok.baseball.v3.vo.PitchReport;

public final class Pitch {
	
	private Pitch() {
	}
	
	public static PitchReport report(Balls com, Balls user) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < com.value().size(); i++) {
			if (com.isStrike(user, i)) {
				strike++;
			} else if (com.isBall(user, i)) {
				ball++;
			}
		}
		return new PitchReport.Builder()
			.strike(strike)
			.ball(ball)
			.build();
	}
}
