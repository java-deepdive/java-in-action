package kr.seok.bowling.game;

/**
 * The type Round.
 */
public class Round {

    /**
     * The constant BOWLING_INIT_ROUND.
     */
    public static final int BOWLING_INIT_ROUND = 1;
    /**
     * The constant BOWLING_LAST_ROUND.
     */
    public static final int BOWLING_LAST_ROUND = 10;

    private final int value;

    /**
     * Instantiates a new Round.
     *
     * @param value the value
     */
    public Round(int value) {
        this.value = value;
    }

    /**
     * Init round.
     *
     * @return the round
     */
    public static Round init() {
        return new Round(BOWLING_INIT_ROUND);
    }

    /**
     * Is end boolean.
     *
     * @return the boolean
     */
    public boolean isEnd() {
        return value == BOWLING_LAST_ROUND;
    }

    /**
     * Value int.
     *
     * @return the int
     */
    public int value() {
        return value;
    }

    /**
     * Next round.
     *
     * @return the round
     */
    public Round next() {
        return new Round(value() + 1);
    }

    /**
     * Is bound boolean.
     *
     * @return the boolean
     */
    public boolean isBound() {
        return value >= BOWLING_INIT_ROUND && value <= BOWLING_LAST_ROUND;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
