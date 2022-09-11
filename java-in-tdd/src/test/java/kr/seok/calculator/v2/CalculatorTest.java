package kr.seok.calculator.v2;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	@Test
	void testCase1() {
		
		double calculate = Calculator.calculate(new Expression("1 + 2"));
		System.out.println("calculate = " + calculate);
	}
}