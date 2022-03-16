package kr.seok.ladder.wrapper;


import kr.seok.ladder.domain.Bar;
import kr.seok.ladder.domain.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static kr.seok.ladder.domain.Position.MOVABLE_COUNT;

/**
 * The type Bars.
 */
public class Bars {

	private final List<Bar> line;

	private Bars(final List<Bar> bars) {
		this.line = bars;
	}

	/**
	 * Value of bars.
	 *
	 * @param bars
	 * 		the bars
	 * @return the bars
	 */
	public static Bars valueOf(final List<Bar> bars) {
		return new Bars(bars);
	}

	/**
	 * Value of bars.
	 *
	 * @param bars
	 * 		the bars
	 * @return the bars
	 */
	public static Bars valueOf(final Bar... bars) {
		return new Bars(Arrays.asList(bars));
	}

	/**
	 * Bars list.
	 *
	 * @return the list
	 */
	public List<Bar> bars() {
		return Collections.unmodifiableList(line);
	}

	/**
	 * Move position.
	 *
	 * @param userPosition
	 * 		the user position
	 * @return the position
	 */
	public Position move(final Position userPosition) {
		int currentPosition = userPosition.currentPosition();

		if (isMoveLeft(currentPosition)) {
			return userPosition.left();
		}
		if (isMoveRight(currentPosition)) {
			return userPosition.right();
		}
		return userPosition;
	}

	private boolean isMoveLeft(final int currentPosition) {
		return line.get(currentPosition).isExist();
	}

	private boolean isMoveRight(final int currentPosition) {
		int nextPosition = currentPosition + MOVABLE_COUNT;
		return isLadderBound(nextPosition) && line.get(nextPosition).isExist();
	}

	private boolean isLadderBound(final int nextPosition) {
		return nextPosition < line.size();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Bars)) return false;
		final Bars bars1 = (Bars) o;
		return Objects.equals(line, bars1.line);
	}

	@Override
	public int hashCode() {
		return Objects.hash(line);
	}

	@Override
	public String toString() {
		return String.valueOf(line);
	}
}
