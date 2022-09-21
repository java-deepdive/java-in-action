package kr.seok.calculator.v4;

import java.util.Scanner;

public final class Input {
	
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public String inputExpression() {
		return SCANNER.nextLine();
	}
}
