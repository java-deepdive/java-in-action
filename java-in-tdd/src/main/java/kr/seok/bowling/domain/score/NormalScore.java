package kr.seok.bowling.domain.score;


import kr.seok.bowling.domain.Left;
import kr.seok.bowling.domain.engine.State;
import kr.seok.bowling.domain.pin.Pin;
import kr.seok.bowling.domain.state.StateSymbol;
import kr.seok.bowling.exception.PinsOutOfSizeException;

import static kr.seok.bowling.domain.pin.Pin.BOWLING_PIN_MIN_SIZE;

/**
 * The type Normal score.
 */
public class NormalScore extends Score {

	/**
	 * The constant NORMAL_LEFT_SIZE.
	 */
	public static final int NORMAL_LEFT_SIZE = 2;
	/**
	 * The constant NORMAL_LEFT_ZERO.
	 */
	public static final int NORMAL_LEFT_ZERO = 0;

	/**
	 * Instantiates a new Normal score.
	 *
	 * @param firstPin
	 * 		the first pin
	 * @param secondPin
	 * 		the second pin
	 * @param left
	 * 		the left
	 */
	public NormalScore(Pin firstPin, Pin secondPin, Left left) {
		super(firstPin, secondPin, left);
	}

	/**
	 * Init normal score.
	 *
	 * @return the normal score
	 */
	public static NormalScore init() {
		return new NormalScore(Pin.init(), Pin.init(), Left.init(NORMAL_LEFT_SIZE));
	}

	private NormalScore first(final int firstPin) {
		return new NormalScore(Pin.of(firstPin), Pin.of(BOWLING_PIN_MIN_SIZE), left.decrease());
	}

	private NormalScore second(final int secondPin) {
		if (firstPin.isOutOfSize(secondPin)) {
			throw new PinsOutOfSizeException(PINS_ERR_OUT_OF_SIZE);
		}
		return new NormalScore(firstPin, Pin.of(secondPin), left.decrease());
	}

	@Override
	public NormalScore bowl(final int downPins) {
		if (left.value() == NORMAL_LEFT_SIZE) {
			return first(downPins);
		}
		return second(downPins);
	}

	@Override
	public State state() {
		return StateSymbol.ready(this);
	}

	@Override
	public boolean isSecond() {
		return left.isFirst(NORMAL_LEFT_SIZE);
	}

	@Override
	public boolean isEnd() {
		return left.value() == NORMAL_LEFT_ZERO;
	}

	@Override
	public int totalScore() {
		return first() + second();
	}

	@Override
	public String toString() {
		return String.valueOf(totalScore());
	}
}
