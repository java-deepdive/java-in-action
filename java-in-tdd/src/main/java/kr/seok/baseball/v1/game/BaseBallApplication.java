package kr.seok.baseball.v1.game;

import kr.seok.baseball.v1.view.Input;
import kr.seok.baseball.v1.view.Output;

public class BaseBallApplication {
	
	public static void main(String[] args) {
		BaseBall baseBall = new BaseBall(new Input(), new Output());
		baseBall.run();
	}
}
