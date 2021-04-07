package kr.seok.ladder;


import kr.seok.ladder.controller.LadderGameController;
import kr.seok.ladder.view.InputView;
import kr.seok.ladder.view.ResultView;

public class LadderRideApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LadderGameController ladderGameController = new LadderGameController(inputView, resultView);
        ladderGameController.start();
    }
}
