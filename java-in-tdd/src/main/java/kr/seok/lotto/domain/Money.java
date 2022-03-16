package kr.seok.lotto.domain;

import kr.seok.lotto.exception.LottoException;

import java.math.BigDecimal;
import java.util.Objects;

import static kr.seok.lotto.util.Constants.*;

public class Money {

	private final int money;

	private Money(final int money) {
		if (money < LOTTO_PRICE) {
			throw new LottoException(GUIDE_ERR_CANNOT_BUY_LOTTO);
		}
		this.money = money;
	}

	public static Money of(final int money) {
		return new Money(money);
	}

	public static Money of(final String money) {
		checkValidation(money);
		return new Money(Integer.parseInt(money));
	}

	private static void checkValidation(final String money) {
		try {
			Integer.parseInt(money);
		} catch (NumberFormatException e) {
			throw new LottoException();
		}
	}

	public int autoSize(final int manualCount) {
		return BigDecimal.valueOf(money)
				.divide(BigDecimal.valueOf(LOTTO_PRICE))
				.subtract(BigDecimal.valueOf(manualCount))
				.intValue();
	}

	public int totalSize() {
		return BigDecimal.valueOf(money)
				.divide(BigDecimal.valueOf(LOTTO_PRICE))
				.intValue();
	}

	public void ensureBuyLotto(int manualCount) {
		int totalSize = BigDecimal.valueOf(money)
				.divide(BigDecimal.valueOf(LOTTO_PRICE))
				.intValue();
		if (manualCount > totalSize) {
			throw new LottoException(GUIDE_ERR_GREATER_THAN_LOTTO_COUNT);
		}
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Money money1 = (Money) o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
