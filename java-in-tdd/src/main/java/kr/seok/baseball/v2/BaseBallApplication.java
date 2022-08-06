package kr.seok.baseball.v2;

import kr.seok.baseball.v2.game.BaseBallGame;
import kr.seok.baseball.v2.view.Input;
import kr.seok.baseball.v2.view.Output;

public class BaseBallApplication {
	public static void main(String[] args) {
		new BaseBallGame.Builder()
			.input(new Input())
			.output(new Output())
			.build()
			.run();
	}
}
