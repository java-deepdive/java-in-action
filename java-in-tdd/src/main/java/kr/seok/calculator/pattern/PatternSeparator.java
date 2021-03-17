package kr.seok.calculator.pattern;

@FunctionalInterface
public interface PatternSeparator {
    String[] matches(String text);
}
