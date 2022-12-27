package kr.seok.baseball.v6;

import kr.seok.baseball.v6.facade.BaseBallGame;
import kr.seok.baseball.v6.io.InputBaseBallConsole;
import kr.seok.baseball.v6.io.OutputBaseBallConsole;
import kr.seok.baseball.v6.strategy.RandomNumberGenerator;

public class BaseBallApplication {
	private static final int HITS_SIZE = 3;
	public static void main(String[] args) {
		new BaseBallGame(new InputBaseBallConsole(), new OutputBaseBallConsole())
			.run(HITS_SIZE, new RandomNumberGenerator());
	}
}
