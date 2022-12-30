package kr.seok.bowling.v1.domain.state.finish;

import kr.seok.bowling.v1.domain.engine.State;

/**
 * The type Strike.
 */
public class Strike implements State {

	/**
	 * Instantiates a new Strike.
	 */
	public Strike() {
	}

	@Override
	public String toString() {
		return "X";
	}
}
