package kr.seok.baseball.v1.balls;

import kr.seok.baseball.v1.strategy.Strategy;

public class Random {
	
	private Strategy strategy;
	
	/**
	 * 랜덤한 숫자 3개를 생성
	 */
	public static int[] createNum() {
		return new int[]{1, 2, 3};
	}
}
