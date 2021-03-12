package kr.seok.step3;

import kr.seok.step3.domain.RacingResult;
import kr.seok.step3.module.CarRacingGame;
import kr.seok.step3.ui.InputView;
import kr.seok.step3.ui.ResultView;
import kr.seok.step3.ui.dto.RequestRacingGame;

/**
 * 레이싱 게임 Application
 */
public class RacingGameApplication {
    public static void main(String[] args) {
        // 사용자 입력
        InputView inputView = new InputView();
        RequestRacingGame requestUserInput = inputView.requestUserInput();

        // 레이싱 게임 시작
        CarRacingGame racingGame = new CarRacingGame(requestUserInput);
        racingGame.race();
        RacingResult racingResult = racingGame.getRacingResult();

        ResultView resultView = new ResultView();
        resultView.responseResult(racingResult);
        resultView.printWinner(racingResult);
    }
}
