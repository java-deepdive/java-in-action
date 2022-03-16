package kr.seok.bowling.domain.frame;


import kr.seok.bowling.domain.engine.State;
import kr.seok.bowling.domain.score.FinalScore;
import kr.seok.bowling.domain.state.States;
import kr.seok.bowling.exception.CanNotBonusException;

import java.util.List;

/**
 * The type Final frame.
 */
public class FinalFrame extends BaseFrame {

	private final States status;

	/**
	 * Instantiates a new Final frame.
	 */
	public FinalFrame() {
		super(FinalScore.init());
		this.status = new States();
	}

	private void checkBonusChance() {
		if (isNotBonusChance()) {
			throw new CanNotBonusException();
		}
	}

	private boolean isNotBonusChance() {
		return score.isOneChance() && status.isBonusState();
	}

	/**
	 * Status list.
	 *
	 * @return the list
	 */
	public List<State> status() {
		return status.values();
	}

	@Override
	public void bowl(final int downPins) {
		checkBonusChance();

		score = score.bowl(downPins);

		state = changeBowlingState(score);
		status.add(state);
	}

	@Override
	public boolean isNextFrame() {
		return false;
	}

	@Override
	public boolean isEnd() {
		return score.isOneChance() && score.isMiss() || score.isLast();
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
