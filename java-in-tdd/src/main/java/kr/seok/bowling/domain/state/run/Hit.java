package kr.seok.bowling.domain.state.run;

import kr.seok.bowling.domain.engine.State;

/**
 * The type Hit.
 */
public class Hit implements State {

    private final int firstPin;

    /**
     * Instantiates a new Hit.
     *
     * @param downPin the down pin
     */
    public Hit(final int downPin) {
        this.firstPin = downPin;
    }

    @Override
    public String toString() {
        return String.format("%s|", firstPin);
    }
}
