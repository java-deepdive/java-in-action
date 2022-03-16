package kr.seok.ladder.wrapper;


import kr.seok.ladder.domain.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The type Ladder.
 */
public class Ladder {

	private final List<Line> lines;

	private Ladder(final Line... lines) {
		this.lines = Arrays.asList(lines);
	}

	/**
	 * Value of ladder.
	 *
	 * @param lines
	 * 		the lines
	 * @return the ladder
	 */
	public static Ladder valueOf(final Line... lines) {
		return new Ladder(lines);
	}

	/**
	 * Find end position position.
	 *
	 * @param movePosition
	 * 		the move position
	 * @return the position
	 */
	public Position findEndPosition(Position movePosition) {
		for (Line line : lines) {
			movePosition = line.move(movePosition);
		}
		return movePosition;
	}

	/**
	 * Lines list.
	 *
	 * @return the list
	 */
	public List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Ladder)) return false;
		final Ladder ladder = (Ladder) o;
		return Objects.equals(lines, ladder.lines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines);
	}

	@Override
	public String toString() {
		return String.valueOf(lines);
	}
}
