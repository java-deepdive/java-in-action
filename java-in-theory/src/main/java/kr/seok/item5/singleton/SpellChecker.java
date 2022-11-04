package kr.seok.item5.singleton;

import java.util.List;

/**
 * 싱긅턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어려움
 */
public class SpellChecker {
	public static final SpellChecker INSTANCE = new SpellChecker();
	private final ExpressionRegExp dictionary = new ExpressionRegExp();
	
	private SpellChecker() {
	} // Noninstantiable
	
	
	public boolean isValid(String word) {
		return dictionary.checkWord(word);
	}
	
	public List<String> suggestions(String typo) {
		return dictionary.correctTypo(typo);
	}
}
