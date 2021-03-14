package kr.seok.lotto.calculator.pattern;

@FunctionalInterface
public interface PatternSeparator {
    String[] matches(String text);
}
