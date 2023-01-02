package kr.seok.baseball.v5;

public class InputConsole implements Input {
	
	@Override
	public boolean isReGame() {
		return false;
	}
	
	@Override
	public int[] userNumbers(NumberGenerator numberGenerator) {
		return numberGenerator.generate();
	}
}
