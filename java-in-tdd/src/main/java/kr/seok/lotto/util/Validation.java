package kr.seok.lotto.util;


import kr.seok.lotto.exception.LottoException;

import java.util.Objects;

import static kr.seok.lotto.util.Constants.GUIDE_ERR_CANNOT_PARSE_STRING_TO_INTEGER;
import static kr.seok.lotto.util.Constants.LOTTO_PRICE;

public class Validation {

    private Validation() { }

    public static boolean isNumeric(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLackOfMoney(final String inputMoney) {
        return Integer.parseInt(inputMoney) < LOTTO_PRICE;
    }

    public static boolean isNotNullAndIsBlank(final String inputMoney) {
        return Objects.isNull(inputMoney) || inputMoney.isEmpty();
    }

    public static boolean isCanNotBuyLotto(final String input) {
        return !isNumeric(input) || isLackOfMoney(input);
    }

    public static void checkValidation(final boolean notNullAndIsBlank, final String guideNotFoundMoney) {
        if (notNullAndIsBlank) {
            throw new LottoException(guideNotFoundMoney);
        }
    }

    public static int parseInt(final String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new LottoException(GUIDE_ERR_CANNOT_PARSE_STRING_TO_INTEGER);
        }
    }
}
