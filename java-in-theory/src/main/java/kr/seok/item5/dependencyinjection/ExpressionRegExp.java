package kr.seok.item5.dependencyinjection;

import java.util.List;

public interface ExpressionRegExp {
	boolean checkWord(String word);
	
	List<String> correctTypo(String typo);
}
