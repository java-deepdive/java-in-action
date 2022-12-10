package kr.seok.item6;

import java.util.regex.Pattern;

public class RomanNumerals {
	// Performance can be greatly improved! (Page 22)
	static boolean isRomanNumeralSlow(String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
			+ "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}
	
	// Reusing expensive object for improved performance (Page 23)
	private static final Pattern ROMAN = Pattern.compile(
		"^(?=.)M*(C[MD]|D?C{0,3})"
			+ "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	
	static boolean isRomanNumeralFast(String s) {
		return ROMAN.matcher(s).matches();
	}
}