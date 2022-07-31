package kr.seok.baseball.v1.game;

import java.util.Random;

public final class Shoot {
	
	private final Random random = new Random();
	
	public int run() {
		return random.nextInt(10) + 1;
	}
}
