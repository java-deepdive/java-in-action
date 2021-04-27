package kr.seok.calculator;

public final class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (Validator.isNotNullAndIsBlank(text)) { // null 또는 "" 처리
            return 0;
        }
        Numbers numberManager = Numbers.of(text);
        return numberManager.sumNumbers();
    }
}
