package kr.seok.bowling.v1.exception;

/**
 * The type Pins out of size exception.
 */
public class PinsOutOfSizeException extends IllegalArgumentException {
	/**
	 * Instantiates a new Pins out of size exception.
	 */
	public PinsOutOfSizeException() {
	}

	/**
	 * Instantiates a new Pins out of size exception.
	 *
	 * @param message
	 * 		the message
	 */
	public PinsOutOfSizeException(String message) {
		super(message);
	}
}
