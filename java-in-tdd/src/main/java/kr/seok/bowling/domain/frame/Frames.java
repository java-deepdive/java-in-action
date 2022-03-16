package kr.seok.bowling.domain.frame;


import kr.seok.bowling.domain.engine.Frame;
import kr.seok.bowling.game.Round;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Frames.
 */
public class Frames {

	private final List<Frame> frameList;

	/**
	 * Instantiates a new Frames.
	 */
	public Frames() {
		frameList = generateNormalFrame();
		frameList.add(new FinalFrame());
	}

	private List<Frame> generateNormalFrame() {
		return Stream.generate(NormalFrame::new)
				.limit(9)
				.collect(Collectors.toList());
	}

	/**
	 * Bowl.
	 *
	 * @param round
	 * 		the round
	 * @param downPins
	 * 		the down pins
	 */
	public void bowl(Round round, final int downPins) {
		currentFrame(round).bowl(downPins);
	}

	/**
	 * Is next boolean.
	 *
	 * @param round
	 * 		the round
	 * @return the boolean
	 */
	public boolean isNext(Round round) {
		return round.isBound() && currentFrame(round).isNextFrame();
	}

	/**
	 * Is end boolean.
	 *
	 * @param round
	 * 		the round
	 * @return the boolean
	 */
	public boolean isEnd(Round round) {
		return round.isEnd() && currentFrame(round).isEnd();
	}

	/**
	 * Values list.
	 *
	 * @return the list
	 */
	public List<Frame> values() {
		return Collections.unmodifiableList(frameList);
	}

	private Frame currentFrame(Round round) {
		return frameList.get(round.value() - 1);
	}
}
