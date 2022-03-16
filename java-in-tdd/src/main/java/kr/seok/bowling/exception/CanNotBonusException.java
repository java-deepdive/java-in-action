package kr.seok.bowling.exception;

/**
 * The type Can not bonus exception.
 */
public class CanNotBonusException extends IndexOutOfBoundsException {
	/**
	 * Instantiates a new Can not bonus exception.
	 */
	public CanNotBonusException() {
		super();
	}

	/**
	 * Instantiates a new Can not bonus exception.
	 *
	 * @param message
	 * 		the message
	 */
	public CanNotBonusException(String message) {
		super(message);
	}
}
