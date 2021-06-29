package kr.seok.ladder;


import kr.seok.ladder.controller.LadderGameController;
import kr.seok.ladder.view.InputView;
import kr.seok.ladder.view.ResultView;

/**
 * The type Ladder ride application.
 */
public class LadderRideApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new LadderGameController(new InputView(), new ResultView()).start();
    }
}
