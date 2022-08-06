package kr.seok.baseball.v1.game;

import kr.seok.baseball.v2.game.BaseBallGame;
import kr.seok.baseball.v2.view.Input;
import kr.seok.baseball.v2.view.Output;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {
	
	@Test
	void testCase1() {
		new BaseBallGame.Builder()
			.input(new Input())
			.output(new Output())
			.build()
			.run();
	}
}