package kr.seok.baseball.v1.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
	
	public static final int LIMIT_BALL = 3;
	private List<Integer> values;
	
	public Balls() {}
	
	public Balls(int... values) {
		if(values.length != LIMIT_BALL) {
			throw new RuntimeException("투구는 총 3차례 던져야 합니다.");
		}
		this.values = Arrays.stream(values)
			.boxed()
			.collect(Collectors.toList());
	}
	
	public int size() {
		return values.size();
	}
	
	public int get(int idx) {
		return values.get(idx);
	}
	
	public boolean isMatches(int idx, int ball) {
		return values.get(idx).equals(ball);
	}
	
	public boolean contains(int ball) {
		return values.contains(ball);
	}
}
