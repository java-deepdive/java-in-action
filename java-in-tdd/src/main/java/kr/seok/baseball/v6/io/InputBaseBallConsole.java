package kr.seok.baseball.v6.io;

import kr.seok.baseball.v6.numbers.Number;
import kr.seok.baseball.v6.numbers.Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Arrays;

public class InputBaseBallConsole implements Input {
	
	private final BufferedReader bufferedReader;
	
	public InputBaseBallConsole() {
		this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@Override
	public boolean isReGame() {
		// TODO 사용자로부터 게임을 다시 시작할지 여부를 입력받는다.
		
		boolean reGame = false;
		String readReGame = null;
		try {
			readReGame = bufferedReader.readLine();
			reGame = ReGame.isRe(readReGame);
		} catch (IOException e) {
			System.out.println(MessageFormat.format("입력값이 잘못되었습니다. : {}", readReGame));
			isReGame();
		}
		return reGame;
	}
	
	@Override
	public Numbers numbers(int numberSize) {
		// TODO 사용자로부터 숫자를 입력받는다.
		
		int tryCurrentCnt = 0;
		Number[] userNumbers = new Number[numberSize];
		while (tryCurrentCnt < numberSize) {
			userNumbers[tryCurrentCnt++] = validUserNumber();
		}
		return new Numbers(userNumbers);
	}
	
	private Number validUserNumber() {
		// TODO 사용자로부터 받은 숫자가 유효한지 체크
		
		int number = 0;
		String readUserNumber = null;
		try {
			readUserNumber = bufferedReader.readLine();
			number = Integer.parseInt(readUserNumber);
		} catch (IOException e) {
			System.out.println(MessageFormat.format("잘못된 입력값입니다. {}", readUserNumber));
			validUserNumber();
		}
		return new Number(number);
	}
	
	enum ReGame {
		YES("y", true),
		NO("n", false);
		
		private final String value;
		private final boolean reFlag;
		
		ReGame(String value, boolean reGame) {
			this.value = value;
			this.reFlag = reGame;
		}
		
		public static boolean isRe(String value) {
			return isMatches(value).isReFlag();
		}
		
		public static ReGame isMatches(String value) {
			return Arrays.stream(values()).
				filter(reGame -> reGame.value.equals(value))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(MessageFormat.format("입력값이 잘못되었습니다. {}", value)));
		}
		
		public boolean isReFlag() {
			return reFlag;
		}
	}
}
