package kr.seok.racing.step3.domain;

import java.util.Objects;

import static kr.seok.racing.step3.util.Constants.NUMBER_ONE;
import static kr.seok.racing.step3.util.Constants.NUMBER_ZERO;

/**
 * primitive 타입 데이터의 관리
 * <pre>
 *      // 생성자를 통한 값 주입이 아닌 이상 값이 변하지 않는 immutable object
 *      public Position move() {
 *         return new Position(position + 1);
 *     }
 * </pre>
 * <pre>
 *     // 내부에서 관리하는 값이 변하는 mutable object (위 문제의 성능 이슈를 줆임)
 *     public Position move() {
 *         position = position + 1;
 *         return this;
 *     }
 * </pre>
 */
public class Position implements Comparable<Position> {

	public static final String CANNOT_NEGATIVE_VALUES = "Position 은 음수 값을 가질 수 없다.";

	private final int value;

	public Position() {
		this(NUMBER_ZERO);
	}

	public Position(int position) {
		if (position < NUMBER_ZERO) {
			throw new IllegalArgumentException(CANNOT_NEGATIVE_VALUES);
		}
		this.value = position;
	}

	public Position move() {
		return new Position(value + NUMBER_ONE);
	}

	public int getValue() {
		return value;
	}

	public Position greaterThan(Position maxPosition) {
		if (compareTo(maxPosition) >= 0) {
			return maxPosition;
		}
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Position position1 = (Position) o;
		return value == position1.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getValue());
	}

	@Override
	public int compareTo(Position o) {
		return o.value - value;
	}

	@Override
	public String toString() {
		return value + "";
	}
}
