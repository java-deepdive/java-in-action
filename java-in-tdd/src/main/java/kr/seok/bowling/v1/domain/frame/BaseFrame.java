package kr.seok.bowling.v1.domain.frame;

import kr.seok.bowling.v1.domain.engine.Frame;
import kr.seok.bowling.v1.domain.engine.State;
import kr.seok.bowling.v1.domain.score.Score;
import kr.seok.bowling.v1.domain.state.StateSymbol;
import kr.seok.bowling.v1.domain.state.run.Ready;

/**
 * The type Base frame.
 */
public abstract class BaseFrame implements Frame {

	/**
	 * The State.
	 */
	protected State state;
	/**
	 * The Score.
	 */
	protected Score score;

	/**
	 * Instantiates a new Base frame.
	 *
	 * @param score
	 * 		the score
	 */
	BaseFrame(Score score) {
		this.score = score;
		this.state = new Ready();
	}

	/**
	 * Change bowling state state.
	 *
	 * @param score
	 * 		the score
	 * @return the state
	 */
	public State changeBowlingState(final Score score) {
		return StateSymbol.ready(score);
	}

	@Override
	public int score() {
		return score.totalScore();
	}
}
