package kr.seok.bowling.domain.pin;

/**
 * The type Bonus pin.
 */
public class BonusPin {

	private final Pin value;

	private BonusPin(final Pin bonusPin) {
		this.value = bonusPin;
	}

	/**
	 * Of bonus pin.
	 *
	 * @param bonusPin
	 * 		the bonus pin
	 * @return the bonus pin
	 */
	public static BonusPin of(final int bonusPin) {
		return new BonusPin(Pin.of(bonusPin));
	}

	/**
	 * Score int.
	 *
	 * @return the int
	 */
	public int score() {
		return value.value();
	}
}
