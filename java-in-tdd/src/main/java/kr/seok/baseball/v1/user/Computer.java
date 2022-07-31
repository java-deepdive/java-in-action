package kr.seok.baseball.v1.user;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	
	private List<Integer> values = new ArrayList<>();
	
	private Computer() {}
	
	public static Balls turn() {
		return new Balls(Random.createNum());
	}
}
