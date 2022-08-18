package kr.seok.calculator.v2;

import java.util.Scanner;

public class CalculatorV2Application {
	
	private static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		Expression expression = new Expression(in.nextLine());
		
		CalculatorV2.calculate(expression);
		
	}
}
