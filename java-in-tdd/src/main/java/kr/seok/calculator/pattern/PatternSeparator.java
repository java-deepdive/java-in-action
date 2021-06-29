package kr.seok.calculator.pattern;


/**
 * {@inheritDoc The interface Pattern separator.}
 */
@FunctionalInterface
public interface PatternSeparator {
    String[] matches(String text);
}
