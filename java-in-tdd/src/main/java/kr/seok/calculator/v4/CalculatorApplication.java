package kr.seok.calculator.v4;

public class CalculatorApplication {
	
	private final Input input;
	private final Output output;
	
	public CalculatorApplication(Input input, Output output) {
		this.input = input;
		this.output = output;
	}
	
	public void run() {
		Expression expression = new Expression(input.inputExpression());
		double calculate = Calculator.calculate(expression);
		output.report(calculate);
	}
	
	public static void main(String[] args) {
		new CalculatorApplication(new Input(), new Output()).run();
	}
}
