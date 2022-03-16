package kr.seok.calculator.v1.pattern;


/**
 * {@inheritDoc The interface Pattern separator.}
 */
@FunctionalInterface
public interface PatternSeparator {
	String[] matches(String text);
}
