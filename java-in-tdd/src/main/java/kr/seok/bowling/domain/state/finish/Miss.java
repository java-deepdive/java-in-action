package kr.seok.bowling.domain.state.finish;

import kr.seok.bowling.domain.engine.State;

import java.util.Objects;

/**
 * The type Miss.
 */
public class Miss implements State {

	private final int firstPin;
	private final int secondPin;

	/**
	 * Instantiates a new Miss.
	 *
	 * @param firstPin
	 * 		the first pin
	 * @param secondPin
	 * 		the second pin
	 */
	public Miss(final int firstPin, final int secondPin) {
		this.firstPin = firstPin;
		this.secondPin = secondPin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Miss miss = (Miss) o;
		return firstPin == miss.firstPin && secondPin == miss.secondPin;
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
