package kr.seok.calculator.v2;

import kr.seok.racing.step2.Operator;

import java.util.Scanner;

public class CalculatorV2 {
	
	private static final int ZERO_SIZE = 0;
	
	private CalculatorV2() {
	}
	
	public static double calculate(Expression expression) {
		Operand result = expression.operand();
		while(expression.size() > ZERO_SIZE) {
			Operator operator = expression.operator();
			Operand operand = expression.operand();
			result = new Operand(operator.calculate(result, operand));
		}
		return result.value();
	}
}
