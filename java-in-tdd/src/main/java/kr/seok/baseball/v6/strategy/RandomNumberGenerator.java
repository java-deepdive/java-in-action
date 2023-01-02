package kr.seok.baseball.v6.strategy;

import kr.seok.baseball.v6.numbers.Ball;
import kr.seok.baseball.v6.numbers.Balls;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static kr.seok.baseball.v6.numbers.Ball.BallSize.NUMBER_MAX_SIZE;
import static kr.seok.baseball.v6.numbers.Ball.BallSize.NUMBER_MIN_SIZE;

public class RandomNumberGenerator implements NumberGenerator {
	
	private static final int INIT_ZERO = 0;
	
	@Override
	public Balls hits(int numberSize) {
		List<Ball> balls = IntStream.rangeClosed(NUMBER_MIN_SIZE.value(), NUMBER_MAX_SIZE.value())
			.boxed()
			.map(Ball::new)
			.collect(Collectors.toList());
		Collections.shuffle(balls);
		return new Balls(balls.subList(INIT_ZERO, numberSize));
	}
}
