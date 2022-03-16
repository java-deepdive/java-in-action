package kr.seok.bowling;

import kr.seok.bowling.view.InputView;
import kr.seok.bowling.view.ResultView;

/**
 * The type Bowling runner.
 */
public class BowlingRunner {

	private final InputView inputView;
	private final ResultView resultView;

	/**
	 * Instantiates a new Bowling runner.
	 *
	 * @param inputView
	 * 		the input view
	 * @param resultView
	 * 		the result view
	 */
	public BowlingRunner(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	/**
	 * The entry point of application.
	 *
	 * @param args
	 * 		the input arguments
	 */
	public static void main(String[] args) {
		BowlingRunner bowlingRunner = new BowlingRunner(new InputView(), new ResultView());
		bowlingRunner.run();
	}

	private void run() {
		String name = inputView.inputPlayer();
		resultView.printBoard(name);

		BowlingGame game = BowlingGame.init(name);

		while (!game.isEnd()) {
			game.bowl(inputView.bowl(game.round()));
			resultView.printBoard(game);
		}
	}
}
