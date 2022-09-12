package kr.seok.calculator.v3;

public abstract class CalculatorDecorator implements CalculatorInterface {
	
	private final CalculatorInterface core;
	
	protected CalculatorDecorator(CalculatorInterface core) {
		this.core = core;
	}
	
	@Override
	public double calculate(String expression) {
		return core.calculate(expression);
	}
}
