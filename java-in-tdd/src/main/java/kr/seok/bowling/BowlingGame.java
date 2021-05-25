package kr.seok.bowling;

public class BowlingGame {

    private final String name;

    public BowlingGame(String name) {
        this.name = name;
    }

    public static BowlingGame init(String name) {
        return new BowlingGame(name);
    }

    public boolean isEnd() {
        return false;
    }

    public String round() {
        return null;
    }

    public void bowl(String bowl) {

    }
}
