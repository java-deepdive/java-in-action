package kr.seok.baseball.v3.component;

import kr.seok.baseball.v3.vo.Balls;
import kr.seok.baseball.v3.vo.PitchReport;

public class Pitch {
	
	private Pitch() {}
	
	public static PitchReport report(Balls com, Balls user) {
		int strike = 0;
		int ball = 0;
		for(int i = 0 ; i < com.value().size() ; i++) {
			if(com.value().get(i).value() == user.value().get(i).value()) {
				strike++;
			} else if(com.value().contains(user.value().get(i))) {
				ball++;
			}
		}
		return new PitchReport.Builder()
			.strike(strike)
			.ball(ball)
			.build();
	}
}
