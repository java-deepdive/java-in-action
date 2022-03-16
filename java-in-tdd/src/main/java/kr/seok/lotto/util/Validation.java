package kr.seok.lotto.util;


import kr.seok.lotto.exception.LottoException;

import java.util.Objects;

import static kr.seok.lotto.util.Constants.GUIDE_ERR_NOT_USE_VALUE;

public class Validation {

	private Validation() {
	}

	public static boolean isNotNullAndIsBlank(final String inputMoney) {
		return Objects.isNull(inputMoney) || inputMoney.isEmpty();
	}

	public static int parseInt(final String bonusNumber) {
		try {
			return Integer.parseInt(bonusNumber);
		} catch (NumberFormatException e) {
			throw new LottoException(GUIDE_ERR_NOT_USE_VALUE);
		}
	}
}
