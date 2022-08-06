package kr.seok.baseball.v2.balls;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Randoms {
	
	private Randoms() {}
	/**
	 * 랜덤한 숫자 3개를 생성
	 */
	public static int[] createNum() {
		return new int[]{1, 2, 3};
	}
	
	public static List<Integer> createRangeRandom(int start, int end) {
		return IntStream.range(start, end)
			.boxed()
			.limit(3)
			.collect(Collectors.toList());
	}
	
	
}
