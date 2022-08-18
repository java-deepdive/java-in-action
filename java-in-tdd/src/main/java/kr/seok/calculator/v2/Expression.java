package kr.seok.calculator.v2;

import java.util.LinkedList;
import java.util.Queue;

public class Expression {
	private final Queue<Operand> operands;
	private final Queue<Operator> operators;

	public Expression(String... inputs) {
		validateFormulaLength(inputs);
		operands = new LinkedList<>();
		operators = new LinkedList<>();
		parseFormula(inputs);
	}

	public int size() {
		return operands.size() + operators.size();
	}

	public Operand operand() {
		return operands.poll();
	}

	public Operator operator() {
		return operators.poll();
	}

	private void parseFormula(String[] inputs) {
		for (String input : inputs) {
			classifyFormula(input);
		}
	}

	private void classifyFormula(String input) {
		if (isOperand()) {
			operands.offer(new Operand(input));
			return;
		}
		operators.offer(new Operator(input));
	}

	private boolean isOperand() {
		return isEvenNumber(size());
	}

	private void validateFormulaLength(String[] inputs) {
		if (isEvenNumber(inputs.length)) {
			throw new NotCalculateFormulaException(inputs.length);
		}
	}

	private boolean isEvenNumber(int number) {
		return number % 2 == 0;
	}
}
