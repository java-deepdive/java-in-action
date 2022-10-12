package kr.seok.movie.v3.time;

import kr.seok.movie.v3.Screening;

public class SequenceCondition implements DiscountCondition {
	private final int sequence;
	
	public SequenceCondition(int sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}
}
