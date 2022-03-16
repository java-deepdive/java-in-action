package kr.seok.bowling.domain.frame;

import kr.seok.bowling.domain.engine.State;
import kr.seok.bowling.domain.score.NormalScore;

/**
 * The type Normal frame.
 */
public class NormalFrame extends BaseFrame {

	/**
	 * Instantiates a new Normal frame.
	 */
	public NormalFrame() {
		super(NormalScore.init());
	}

	@Override
	public void bowl(final int downPins) {
		score = score.bowl(downPins);
		state = changeBowlingState(score);
	}

	@Override
	public boolean isNextFrame() {
		return score.isMaxSize() || score.isNoneChance();
	}

	@Override
	public boolean isEnd() {
		return score.isSecond();
	}

	@Override
	public State state() {
		return null;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", state, score);
	}

}
