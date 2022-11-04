package kr.seok.item5.staticmemberfield;

import java.util.List;

public class SpellChecker {
	private static final ExpressionRegExp dictionary = new ExpressionRegExp();
	
	private SpellChecker() {
	} // Noninstantiable
	
	public static boolean isValid(String word) {
		return dictionary.checkWord(word);
	}
	
	public static List<String> suggestions(String typo) {
		return dictionary.correctTypo(typo);
	}
}
