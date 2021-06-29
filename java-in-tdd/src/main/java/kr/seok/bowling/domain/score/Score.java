package kr.seok.bowling.domain.score;


import kr.seok.bowling.domain.Left;
import kr.seok.bowling.domain.engine.State;
import kr.seok.bowling.domain.pin.Pin;

import static kr.seok.bowling.domain.pin.Pin.BOWLING_PIN_MAX_SIZE;

/**
 * The type Score.
 */
public abstract class Score {

    /**
     * The constant PINS_FIRST_STRIKE_AND_CAN_STRIKE.
     */
    public static final String PINS_FIRST_STRIKE_AND_CAN_STRIKE = "초구가 스트라이크인 경우에만 2구에 10개를 쓰러뜨릴 수 있습니다.";
    /**
     * The constant PINS_ERR_OUT_OF_SIZE.
     */
    public static final String PINS_ERR_OUT_OF_SIZE = "2구 까지 핀의 합이 10을 넘을 수 없습니다.";

    /**
     * The First pin.
     */
    protected Pin firstPin;
    /**
     * The Second pin.
     */
    protected Pin secondPin;
    /**
     * The Left.
     */
    protected Left left;

    /**
     * Instantiates a new Score.
     *
     * @param firstPin  the first pin
     * @param secondPin the second pin
     * @param left      the left
     */
    protected Score(Pin firstPin, Pin secondPin, Left left) {
        this.firstPin = firstPin;
        this.secondPin = secondPin;
        this.left = left;
    }

    /**
     * Is second boolean.
     *
     * @return the boolean
     */
    public abstract boolean isSecond();

    /**
     * Total score int.
     *
     * @return the int
     */
    public abstract int totalScore();

    /**
     * State state.
     *
     * @return the state
     */
    public abstract State state();

    /**
     * Bowl score.
     *
     * @param downPins the down pins
     * @return the score
     */
    public abstract Score bowl(int downPins);

    /**
     * Is end boolean.
     *
     * @return the boolean
     */
    public abstract boolean isEnd();

    /**
     * First int.
     *
     * @return the int
     */
    public int first() {
        return firstPin.value();
    }

    /**
     * Second int.
     *
     * @return the int
     */
    public int second() {
        return secondPin.value();
    }

    /**
     * Is strike boolean.
     *
     * @return the boolean
     */
    public boolean isStrike() {
        return firstPin.value() == BOWLING_PIN_MAX_SIZE;
    }

    /**
     * Is miss boolean.
     *
     * @return the boolean
     */
    public boolean isMiss() {
        return first() + second() < BOWLING_PIN_MAX_SIZE;
    }

    /**
     * Is max size boolean.
     *
     * @return the boolean
     */
    public boolean isMaxSize() {
        return totalScore() == BOWLING_PIN_MAX_SIZE;
    }

    /**
     * Is none chance boolean.
     *
     * @return the boolean
     */
    public boolean isNoneChance() {
        return left.value() == 0;
    }

    /**
     * Is one chance boolean.
     *
     * @return the boolean
     */
    public boolean isOneChance() {
        return left.value() == 1;
    }

    /**
     * Is last boolean.
     *
     * @return the boolean
     */
    public boolean isLast() {
        return left.isLast();
    }
}
