package kr.seok.ladder.domain;

import java.util.Objects;

/**
 * The type Height.
 */
public class Height {

	private static final String GUIDE_ERR_HEIGHT_LESS_THAN = "높이가 1보다 작을 수는 없습니다.";
	private static final int MIN_HEIGHT = 1;

	private final int value;

	private Height(final int value) {
		this.value = value;
	}

	/**
	 * Value of height.
	 *
	 * @param value
	 * 		the value
	 * @return the height
	 */
	public static Height valueOf(final int value) {
		if (value < MIN_HEIGHT) {
			throw new IllegalArgumentException(GUIDE_ERR_HEIGHT_LESS_THAN);
		}
		return new Height(value);
	}

	/**
	 * Size int.
	 *
	 * @return the int
	 */
	public int size() {
		return value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Height)) return false;
		final Height height = (Height) o;
		return value == height.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
