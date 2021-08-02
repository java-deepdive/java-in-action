package kr.seok.testdome;

import java.util.Arrays;
import java.util.List;

public class StringSplit {

    private static final String NUMERIC_REGEXP = "[0-9]";
    private static final String FOUR_OPERATION_CALCULATION = "[+|-|*|/]";
    private static final String FOUR_OPERATION_AND_NUMERIC_REGEXP = "[0-9|+|-|*|/]";
    private static final List<String> FOUR_OPERATION_LIST = Arrays.asList("+", "-", "*", "/");
    List<String> util = Arrays.asList("+", "-", "*", "/");

    public String[] split(String s) {
        String[] split = s.replaceAll(FOUR_OPERATION_AND_NUMERIC_REGEXP, "").split("\\s");
        for (String item : split) {
            System.out.println(item);
        }
        return new String[]{};
    }
}
