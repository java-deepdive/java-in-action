package kr.seok.baseball.v6.io;

import java.io.PrintWriter;

public class OutputBaseBallConsole implements Output {
	private final PrintWriter writer;
	
	public OutputBaseBallConsole() {
		this.writer = new PrintWriter(System.out);
	}
	
	@Override
	public void print(String message) {
		// 결과물 출력 메서드
		writer.println(message);
	}
	
}
