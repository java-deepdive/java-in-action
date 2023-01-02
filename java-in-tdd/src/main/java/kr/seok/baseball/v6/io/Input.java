package kr.seok.baseball.v6.io;

import kr.seok.baseball.v6.numbers.Balls;

public interface Input {
	boolean isReGame();
	
	Balls numbers(int numberSize);
}
