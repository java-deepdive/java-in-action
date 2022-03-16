package kr.seok.lotto.domain;


import kr.seok.lotto.exception.LottoException;
import kr.seok.lotto.util.Validation;

import java.util.Objects;

import static kr.seok.lotto.service.LottoFactory.MAX_NUMBER_BOUND;
import static kr.seok.lotto.service.LottoFactory.MIN_NUMBER_BOUND;
import static kr.seok.lotto.util.Constants.GUIDE_ERR_NOT_USE_VALUE;

/**
 * 로또 숫자 번호에 대한 wrapper class
 */
public class LottoNumber implements Comparable<LottoNumber> {

	private final int number;

	protected LottoNumber(final String bonusNumber) {
		this(Validation.parseInt(bonusNumber));
	}

	protected LottoNumber(final int number) {
		if (isInvalidNumber(number)) {
			throw new LottoException(GUIDE_ERR_NOT_USE_VALUE);
		}
		this.number = number;
	}

	private boolean isInvalidNumber(final int number) {
		return MIN_NUMBER_BOUND > number || MAX_NUMBER_BOUND < number;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof LottoNumber)) return false;
		final LottoNumber that = (LottoNumber) o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(number, o.number);
	}
}
