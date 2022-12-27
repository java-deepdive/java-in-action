package kr.seok.baseball.v6.io;

import kr.seok.baseball.v6.numbers.Numbers;

public interface Input {
	boolean isReGame();
	
	Numbers numbers(int numberSize);
}
