package kr.seok.calculator.v3;

public abstract class CalculatorDecorator implements CalculatorInterface {
	
	private CalculatorInterface calculator;

	public CalculatorDecorator(CalculatorInterface calculator) {
		this.calculator = calculator;
	}

	@Override
	public double calculate(String expression) {
		return calculator.calculate(expression);
	}
}
