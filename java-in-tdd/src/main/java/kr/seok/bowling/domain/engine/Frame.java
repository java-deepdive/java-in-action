package kr.seok.bowling.domain.engine;

/**
 * The interface Frame.
 */
public interface Frame {

	/**
	 * Bowl.
	 *
	 * @param pins
	 * 		the pins
	 */
	void bowl(final int pins);

	/**
	 * Is next frame boolean.
	 *
	 * @return the boolean
	 */
	boolean isNextFrame();

	/**
	 * Score int.
	 *
	 * @return the int
	 */
	int score();

	/**
	 * Is end boolean.
	 *
	 * @return the boolean
	 */
	boolean isEnd();

	/**
	 * State state.
	 *
	 * @return the state
	 */
	State state();
}
