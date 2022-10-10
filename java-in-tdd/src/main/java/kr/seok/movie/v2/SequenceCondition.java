package kr.seok.movie.v2;

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
