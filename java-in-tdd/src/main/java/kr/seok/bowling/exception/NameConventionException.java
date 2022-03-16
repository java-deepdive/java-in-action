package kr.seok.bowling.exception;

/**
 * The type Name convention exception.
 */
public class NameConventionException extends IllegalArgumentException {
	/**
	 * Instantiates a new Name convention exception.
	 */
	public NameConventionException() {
	}

	/**
	 * Instantiates a new Name convention exception.
	 *
	 * @param message
	 * 		the message
	 */
	public NameConventionException(String message) {
		super(message);
	}
}
