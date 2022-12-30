package kr.seok.bowling.v1.domain.state.finish;

import kr.seok.bowling.v1.domain.engine.State;

import java.util.Objects;

/**
 * The type Spare.
 */
public class Spare implements State {

	private final int firstPin;
	private final int secondPin;

	/**
	 * Instantiates a new Spare.
	 *
	 * @param firstPin
	 * 		the first pin
	 * @param secondPin
	 * 		the second pin
	 */
	public Spare(final int firstPin, final int secondPin) {
		this.firstPin = firstPin;
		this.secondPin = secondPin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Spare spare = (Spare) o;
		return firstPin == spare.firstPin && secondPin == spare.secondPin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstPin, secondPin);
	}

	@Override
	public String toString() {
		return String.format("%s|%s", firstPin, secondPin);
	}
}
