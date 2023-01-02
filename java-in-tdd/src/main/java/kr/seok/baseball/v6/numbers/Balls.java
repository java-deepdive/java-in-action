package kr.seok.baseball.v6.numbers;

import java.util.List;
import java.util.Objects;

/**
 * 투구한 숫자를 표현하는 클래스
 */
public class Balls {
	private final List<Ball> balls;
	
	public Balls(List<Ball> balls) {
		this.balls = balls;
	}
	
	public boolean isStrike(Balls user, int i) {
		return balls.get(i).isMatches(user.balls.get(i));
	}
	
	public boolean isBall(Balls user, int i) {
		return balls.contains(user.balls.get(i));
	}
	
	public int size() {
		return balls.size();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Balls balls1)) return false;
		return Objects.equals(balls, balls1.balls);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(balls);
	}
}
