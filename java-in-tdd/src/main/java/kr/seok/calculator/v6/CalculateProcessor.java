package kr.seok.calculator.v6;

// 뭐 하고 싶냐면?
//
public class CalculateProcessor {
	
	public void orchestration(String expression) {
		// 1. expression을 분리한다.
		Expression exp = new Expression(expression);
		// 2. 분리된 expression을 계산한다.
		Calculator calculator = new AddCalculator();
		int result = calculator.process(exp.getLeft(), exp.getRight());
		// 3. 결과를 출력한다.
		System.out.println(result);
	}
}
