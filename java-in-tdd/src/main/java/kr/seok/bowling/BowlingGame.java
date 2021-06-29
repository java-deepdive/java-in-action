package kr.seok.bowling;

/**
 * The type Bowling game.
 */
public class BowlingGame {

    private final String name;

    /**
     * Instantiates a new Bowling game.
     *
     * @param name the name
     */
    public BowlingGame(String name) {
        this.name = name;
    }

    /**
     * Init bowling game.
     *
     * @param name the name
     * @return the bowling game
     */
    public static BowlingGame init(String name) {
        return new BowlingGame(name);
    }

    /**
     * Is end boolean.
     *
     * @return the boolean
     */
    public boolean isEnd() {
        return false;
    }

    /**
     * Round string.
     *
     * @return the string
     */
    public String round() {
        return null;
    }

    /**
     * Bowl.
     *
     * @param bowl the bowl
     */
    public void bowl(String bowl) {

    }
}
