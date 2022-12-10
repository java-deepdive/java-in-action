package kr.seok.baseball.v5;

public class BaseBallApplication {
	public static void main(String[] args) {
		Input input = new InputConsole();
		Output output = new Output();
		
		BaseBallGame baseBallGame = new BaseBallGame(input, output);
		baseBallGame.run(new RandomNumber());
	}
}
