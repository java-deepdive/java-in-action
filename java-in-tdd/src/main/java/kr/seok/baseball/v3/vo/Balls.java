package kr.seok.baseball.v3.vo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
	private final List<Ball> values;
	
	public Balls(List<Ball> values) {
		this.values = values;
	}
	
	public static Balls generateRandomBalls() {
		List<Ball> balls = IntStream.rangeClosed(
				Ball.BallRule.MIN.value(), Ball.BallRule.MAX.value()
			)
			.boxed()
			.map(Ball::new)
			.collect(Collectors.toList());
		Collections.shuffle(balls);
		return new Balls(balls.subList(0, 3));
	}
	
	public List<Ball> value() {
		return Collections.unmodifiableList(values);
	}
	
	public boolean isStrike(Balls user, int idx) {
		return values.get(idx).isMatches(user.value().get(idx));
	}
	
	public boolean isBall(Balls user, int idx) {
		return values.contains(user.value().get(idx));
	}
	
	@Override
	public String toString() {
		return "Balls{" +
			"values=" + values +
			'}';
	}
}
