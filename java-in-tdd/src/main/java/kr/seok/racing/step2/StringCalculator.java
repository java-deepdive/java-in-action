package kr.seok.racing.step2;

import java.util.Queue;

import static kr.seok.racing.step2.Constants.NOT_FOUND_ARGUMENT;
import static kr.seok.racing.step2.Validator.isBlank;
import static kr.seok.racing.step2.Validator.isValidation;

/**
 * 문자열 사칙 연산 계산기
 */
public class StringCalculator {

	public Integer apply(String input) {
		if (isBlank(input)) {
			throw new IllegalArgumentException(NOT_FOUND_ARGUMENT);
		}
		if (!isValidation(input)) {
			throw new IllegalArgumentException(Constants.INVALID_FORMULA);
		}
		// 사용자의 입력 값을 관리할 Context
		MathContext mathContext = new MathContext(input);

		// 연산 처리하기 위해 가공된 데이터 셋
		Queue<Integer> numbers = mathContext.getNumbers();
		Queue<Operator> operations = mathContext.getOperations();

		Integer result = numbers.poll();

		while (!numbers.isEmpty() && !operations.isEmpty()) {
			Integer nextValue = numbers.poll();
			Operator operatorExpression = operations.poll();

			// 연산자 확인 -> 연산
			result = operatorExpression.calculate(result, nextValue);
		}
		return result;
	}

}
