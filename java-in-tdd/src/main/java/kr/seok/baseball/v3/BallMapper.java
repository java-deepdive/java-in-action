package kr.seok.baseball.v3;

import kr.seok.baseball.v3.vo.Ball;
import kr.seok.baseball.v3.vo.Balls;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BallMapper {
	
	public static final String STRING_EMPTY = "";
	
	private BallMapper() {
	}
	
	public static Balls from(String userInput) {
		String[] userBalls = userInput.split(STRING_EMPTY);
		List<Ball> balls = Arrays.stream(userBalls)
			.map(Integer::parseInt)
			.map(Ball::new)
			.collect(Collectors.toUnmodifiableList());
		return new Balls(balls);
	}
}
