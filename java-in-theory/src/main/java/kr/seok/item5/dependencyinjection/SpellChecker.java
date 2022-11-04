package kr.seok.item5.dependencyinjection;

import java.util.List;

public class SpellChecker {
	private final ExpressionRegExp dictionary;
	
	public SpellChecker(ExpressionRegExp dictionary) {
		this.dictionary = dictionary;
	}
	
	public boolean isValid(String word) {
		return dictionary.checkWord(word);
	}
	
	public List<String> suggestions(String typo) {
		return dictionary.correctTypo(typo);
	}
}
