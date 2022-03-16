package kr.seok.ladder.domain;

import java.util.Objects;

/**
 * The type Bar.
 */
public class Bar {

	private static final Bar BAR = Bar.valueOf(false);
	/**
	 * The Flag.
	 */
	public final boolean flag;

	private Bar(final boolean flag) {
		this.flag = flag;
	}

	/**
	 * Value of bar.
	 *
	 * @param flag
	 * 		the flag
	 * @return the bar
	 */
	public static Bar valueOf(final boolean flag) {
		return new Bar(flag);
	}

	/**
	 * Init bar.
	 *
	 * @return the bar
	 */
	public static Bar init() {
		return BAR;
	}

	/**
	 * Is exist boolean.
	 *
	 * @return the boolean
	 */
	public boolean isExist() {
		return flag;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Bar)) return false;
		final Bar bar = (Bar) o;
		return flag == bar.flag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(flag);
	}

	@Override
	public String toString() {
		return String.valueOf(flag);
	}
}
