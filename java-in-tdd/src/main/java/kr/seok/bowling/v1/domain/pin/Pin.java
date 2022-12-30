package kr.seok.bowling.v1.domain.pin;

import kr.seok.bowling.v1.exception.PinOutOfSizeException;

import java.util.Objects;

/**
 * The type Pin.
 */
public class Pin {

	/**
	 * The constant BOWLING_PIN_MAX_SIZE.
	 */
	public static final int BOWLING_PIN_MAX_SIZE = 10;
	/**
	 * The constant BOWLING_PIN_MIN_SIZE.
	 */
	public static final int BOWLING_PIN_MIN_SIZE = 0;
	private final int value;

	private Pin(final int value) {
		this.value = value;
	}

	/**
	 * Of pin.
	 *
	 * @param pin
	 * 		the pin
	 * @return the pin
	 */
	public static Pin of(final int pin) {
		if (isLessThanMinSize(pin) || isLargerThanMaxSize(pin)) {
			throw new PinOutOfSizeException();
		}
		return new Pin(pin);
	}

	/**
	 * Init pin.
	 *
	 * @return the pin
	 */
	public static Pin init() {
		return new Pin(BOWLING_PIN_MIN_SIZE);
	}

	private static boolean isLargerThanMaxSize(final int pin) {
		return pin > BOWLING_PIN_MAX_SIZE;
	}

	private static boolean isLessThanMinSize(final int pin) {
		return pin < BOWLING_PIN_MIN_SIZE;
	}

	/**
	 * Is out of size boolean.
	 *
	 * @param secondPin
	 * 		the second pin
	 * @return the boolean
	 */
	public boolean isOutOfSize(final int secondPin) {
		return value + secondPin > BOWLING_PIN_MAX_SIZE;
	}

	/**
	 * Is less than max size boolean.
	 *
	 * @return the boolean
	 */
	public boolean isLessThanMaxSize() {
		return value < BOWLING_PIN_MAX_SIZE;
	}

	/**
	 * Is strike boolean.
	 *
	 * @return the boolean
	 */
	public boolean isStrike() {
		return value == BOWLING_PIN_MAX_SIZE;
	}

	/**
	 * Is spare boolean.
	 *
	 * @param value
	 * 		the value
	 * @return the boolean
	 */
	public boolean isSpare(int value) {
		return this.value + value == BOWLING_PIN_MAX_SIZE;
	}

	/**
	 * Value int.
	 *
	 * @return the int
	 */
	public int value() {
		return value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Pin)) return false;
		final Pin pin = (Pin) o;
		return value == pin.value;
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
