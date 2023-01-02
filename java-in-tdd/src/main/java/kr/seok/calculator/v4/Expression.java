package kr.seok.calculator.v4;

import kr.seok.calculator.v3.OperationProcessor;

import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Expression {
	private final String value;
	
	public Expression(String expression) {
		checkValidation(expression);
		value = PostFix.convert(expression);
	}
	
	private void checkValidation(String expression) {
		if (expression == null || expression.isEmpty()) {
			throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자입니다.");
		}
	}
	
	public String[] getValue() {
		return value.split(" ");
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Expression)) return false;
		Expression that = (Expression) o;
		return Objects.equals(value, that.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
	
	static final class PostFix {
		private final String value;
		
		private PostFix(String inFixExpression) {
			value = parsePostFix(inFixExpression);
		}
		
		public static String convert(String expression) {
			return new PostFix(expression).value;
		}
		
		private String parsePostFix(String inFixExpression) {
			StringBuilder stringBuilder = new StringBuilder();
			Deque<String> stack = new ConcurrentLinkedDeque<>();
			String[] expSplit = inFixExpression.split(" ");
			for (String s : expSplit) {
				parse(stringBuilder, stack, s);
			}
			while (!stack.isEmpty()) {
				stringBuilder.append(stack.pop());
				stringBuilder.append(" ");
			}
			return stringBuilder.toString().trim();
			
		}
		
		private void parse(StringBuilder stringBuilder, Deque<String> stack, String s) {
			if (OperationProcessor.isOperator(s)) {
				if (!stack.isEmpty() && OperationProcessor.compareTo(stack.peek(), s)) {
					stringBuilder.append(stack.pop());
					stringBuilder.append(" ");
				}
				stack.push(s);
			} else {
				stringBuilder.append(s);
				stringBuilder.append(" ");
			}
		}
	}
}
