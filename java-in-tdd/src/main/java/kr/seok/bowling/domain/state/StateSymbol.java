package kr.seok.bowling.domain.state;


import kr.seok.bowling.domain.engine.State;
import kr.seok.bowling.domain.score.Score;
import kr.seok.bowling.domain.state.finish.Miss;
import kr.seok.bowling.domain.state.finish.Spare;
import kr.seok.bowling.domain.state.finish.Strike;
import kr.seok.bowling.domain.state.run.Hit;

/**
 * The enum State symbol.
 */
public enum StateSymbol {
	/**
	 * Strike state symbol.
	 */
	STRIKE("X"),
	/**
	 * Spare state symbol.
	 */
	SPARE("/"),
	/**
	 * Miss state symbol.
	 */
	MISS("-");

	private final String symbol;

	StateSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Ready state.
	 *
	 * @param pins
	 * 		the pins
	 * @return the state
	 */
	public static State ready(Score pins) {
		if (pins.isSecond() && pins.isStrike()) {
			return new Strike();
		}
		return running(pins);
	}

	private static State running(Score pins) {
		if (pins.isEnd() && pins.isMaxSize()) {
			return new Spare(pins.first(), pins.second());
		}
		if (pins.isEnd() && pins.isMiss()) {
			return new Miss(pins.first(), pins.second());
		}
		return new Hit(pins.first());
	}
}
