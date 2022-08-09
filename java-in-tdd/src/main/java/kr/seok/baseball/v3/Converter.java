package kr.seok.baseball.v3;

import kr.seok.baseball.v3.vo.Ball;
import kr.seok.baseball.v3.vo.Balls;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
	
	public static final String STRING_EMPTY = "";
	
	public static Balls from(String user) {
		String[] userBalls = user.split(STRING_EMPTY);
		List<Ball> balls = Arrays.stream(userBalls)
			.map((String value) -> new Ball(Integer.parseInt(value)))
			.collect(Collectors.toList());
		return new Balls(balls);
	}
}
