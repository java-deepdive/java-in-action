package kr.seok.lotto.calculator;


import kr.seok.lotto.calculator.exception.CalculatorException;

import java.util.List;

import static kr.seok.lotto.calculator.Number.ZERO;
import static kr.seok.lotto.calculator.Validator.isNotNullAndIsBlank;
import static kr.seok.lotto.calculator.Validator.isSingleLengthAndIsNotNumeric;

public final class StringAddCalculator {

    public static final String NOT_CONVERT_NUMBER = "숫자로 캐스팅할 수 없는 문자입니다.";

    public static int splitAndSum(String text) {
        if(isNotNullAndIsBlank(text)) { // null 또는 "" 처리
            return ZERO;
        }

        if(isSingleLengthAndIsNotNumeric(text)) { // 예외 처리
            throw new CalculatorException(NOT_CONVERT_NUMBER);
        }

        Numbers numberManager = Numbers.of(text);
        List<Number> numbers = numberManager.getNumbers();

        return numbers.stream()
                .map(Number::getNumber)
                .reduce(Integer::sum)
                .get();
    }
}
