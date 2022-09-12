package kr.seok.baseball.v4;

import java.util.Random;

public class Computer {
	
	public static final int NUMBER_BOUNDED_CONTEXT = 10;
	private final int[] numbers = new int[3];
	private final Random random = new Random();
	
	public void generate() {
		for (int i = 0; i < numbers.length; i++) {
			int generateNumber = getGenerateNumber();
			numbers[i] = generateNumber;
		}
	}
	
	private int getGenerateNumber() {
		int newNumber = random.nextInt(NUMBER_BOUNDED_CONTEXT);
		for (int number : numbers) {
			if (number == newNumber) {
				return getGenerateNumber();
			}
		}
		return newNumber;
	}
	
	public void compare(User user) {
	
	}
	
	public boolean isSame(String user) {
		if (!isNumeric(user)) {
			throw new RuntimeException("사용자가 입력한 값이 숫자가 아닙니다.");
		}
		
		return true;
	}
	
	private boolean isNumeric(String user) {
		try {
			Integer.parseInt(user);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public int[] getNumbers() {
		return numbers;
	}
}
