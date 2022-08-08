package kr.seok.baseball.v2;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomBall {
	
	private final List<Ball> values;
	
	public RandomBall(int min, int max) {
		List<Ball> balls = make(min, max);
		Collections.shuffle(balls);
		this.values = balls.subList(0, 3);
	}
	
	public List<Ball> value() {
		return Collections.unmodifiableList(values);
	}
	
	public boolean contains(Ball ball) {
		return values.contains(ball);
	}
	
	private List<Ball> make(int min, int max) {
		return IntStream.rangeClosed(min, max)
			.boxed()
			.map(Ball::new)
			.collect(toList());
	}
	
	@Override
	public String toString() {
		return "RandomBall{" +
			"values=" + values +
			'}';
	}
}
