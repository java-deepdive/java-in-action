package kr.seok.baseball.v1.user;

import kr.seok.baseball.v1.balls.Balls;
import kr.seok.baseball.v1.balls.Random;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	
	private List<Integer> values = new ArrayList<>();
	
	private Computer() {}
	
	public static Balls turn() {
		System.out.println("컴퓨터 턴");
		return new Balls(Random.createNum());
	}
}
