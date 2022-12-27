package kr.seok.baseball.v5;

public class BaseBallApplication {
	public static void main(String[] args) {
		Input input = new InputConsole();
		Output output = new Output();
		
		BaseBallGame baseBallGame = new BaseBallGame(input, output);
		// TODO : 숫자 생성기를 주입받아야 한다.
		baseBallGame.run(null);
	}
}
