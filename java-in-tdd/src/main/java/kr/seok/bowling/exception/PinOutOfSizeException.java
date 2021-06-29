package kr.seok.bowling.exception;

/**
 * The type Pin out of size exception.
 */
public class PinOutOfSizeException extends RuntimeException {
    /**
     * Instantiates a new Pin out of size exception.
     */
    public PinOutOfSizeException() {
    }

    /**
     * Instantiates a new Pin out of size exception.
     *
     * @param message the message
     */
    public PinOutOfSizeException(String message) {
        super(message);
    }
}
