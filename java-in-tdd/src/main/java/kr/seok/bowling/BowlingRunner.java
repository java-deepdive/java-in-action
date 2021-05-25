package kr.seok.bowling;

import kr.seok.bowling.view.InputView;
import kr.seok.bowling.view.ResultView;

public class BowlingRunner {

    private final InputView inputView;
    private final ResultView resultView;

    public BowlingRunner(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    private void run() {
        String name = inputView.inputPlayer();
        resultView.printBoard(name);

        BowlingGame game = BowlingGame.init(name);

        while(!game.isEnd()) {
            game.bowl(inputView.bowl(game.round()));
            resultView.printBoard(game);
        }
    }

    public static void main(String[] args) {
        BowlingRunner bowlingRunner = new BowlingRunner(new InputView(), new ResultView());
        bowlingRunner.run();
    }
}
