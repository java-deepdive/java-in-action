package kr.seok.bowling.domain.score;


import kr.seok.bowling.domain.Left;
import kr.seok.bowling.domain.engine.State;
import kr.seok.bowling.domain.pin.Pin;
import kr.seok.bowling.domain.state.StateSymbol;
import kr.seok.bowling.exception.PinsOutOfSizeException;

import static kr.seok.bowling.domain.pin.Pin.BOWLING_PIN_MAX_SIZE;

/**
 * The type Final score.
 */
public class FinalScore extends Score {

    /**
     * The constant BOWLING_PIN_LAST_LEFT.
     */
    public static final int BOWLING_PIN_LAST_LEFT = 1;
    /**
     * The constant BOWLING_PIN_TWO_LEFT.
     */
    public static final int BOWLING_PIN_TWO_LEFT = 2;
    /**
     * The constant BOWLING_PIN_INIT_LEFT.
     */
    public static final int BOWLING_PIN_INIT_LEFT = 3;

    private final Pin bonusPin;

    /**
     * Instantiates a new Final score.
     *
     * @param firstPin  the first pin
     * @param secondPin the second pin
     * @param bonusPin  the bonus pin
     * @param left      the left
     */
    public FinalScore(Pin firstPin, Pin secondPin, Pin bonusPin, Left left) {
        super(firstPin, secondPin, left);
        this.bonusPin = bonusPin;
    }

    /**
     * Init final score.
     *
     * @return the final score
     */
    public static FinalScore init() {
        return new FinalScore(Pin.init(), Pin.init(), Pin.init(), Left.init(BOWLING_PIN_INIT_LEFT));
    }

    private FinalScore first(final int firstPin) {
        if(firstPin > BOWLING_PIN_MAX_SIZE) {
            throw new PinsOutOfSizeException();
        }
        return new FinalScore(Pin.of(firstPin), Pin.init(), Pin.init(), left.decrease());
    }

    private FinalScore second(final int secondPin) {
        if (firstPin.isLessThanMaxSize() && secondPin == BOWLING_PIN_MAX_SIZE) {
            throw new PinsOutOfSizeException(PINS_FIRST_STRIKE_AND_CAN_STRIKE);
        }
        return new FinalScore(firstPin, Pin.of(secondPin), Pin.init(), left.decrease());
    }

    private FinalScore last(final int downPins) {
        return new FinalScore(firstPin, secondPin, Pin.of(downPins), left.decrease());
    }

    @Override
    public FinalScore bowl(int downPins) {
        if((firstPin.isStrike() || (firstPin.isSpare(secondPin.value()))) && left.value() == BOWLING_PIN_LAST_LEFT) {
            return last(downPins);
        }
        if(left.value() == BOWLING_PIN_TWO_LEFT) {
            return second(downPins);
        }
        return first(downPins);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public State state() {
        return StateSymbol.ready(this);
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public boolean isSecond() {
        return left.value() == (BOWLING_PIN_INIT_LEFT - 1);
    }

    @Override
    public int totalScore() {
        return first() + second() + bonusPin.value();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.valueOf(totalScore());
    }
}
