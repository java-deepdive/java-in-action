package kr.seok.bowling.domain;

/**
 * The type Left.
 */
public class Left {

	/**
	 * The constant BOWLING_FIRST_TRY.
	 */
	public static final int BOWLING_FIRST_TRY = 1;
	/**
	 * The constant BOWLING_SECOND_TRY.
	 */
	public static final int BOWLING_SECOND_TRY = 2;
	/**
	 * The constant BOWLING_BONUS_TRY.
	 */
	public static final int BOWLING_BONUS_TRY = 3;

	private final int value;

	/**
	 * Instantiates a new Left.
	 *
	 * @param count
	 * 		the count
	 */
	public Left(int count) {
		this.value = count;
	}

	/**
	 * Init left.
	 *
	 * @param initSize
	 * 		the init size
	 * @return the left
	 */
	public static Left init(int initSize) {
		return new Left(initSize);
	}

	/**
	 * Decrease left.
	 *
	 * @return the left
	 */
	public Left decrease() {
		return new Left(value - 1);
	}

	/**
	 * Is first boolean.
	 *
	 * @param leftSize
	 * 		the left size
	 * @return the boolean
	 */
	public boolean isFirst(int leftSize) {
		return value == (leftSize - 1);
	}

	/**
	 * Value int.
	 *
	 * @return the int
	 */
	public int value() {
		return value;
	}

	/**
	 * Is last boolean.
	 *
	 * @return the boolean
	 */
	public boolean isLast() {
		return value == 0;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
