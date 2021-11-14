package kr.seok.racing.step3.module;


import kr.seok.racing.step3.domain.CarManager;
import kr.seok.racing.step3.domain.RacingResult;
import kr.seok.racing.step3.move.MoveStrategy;
import kr.seok.racing.step3.ui.dto.RequestRacingGame;

import java.util.stream.IntStream;

import static kr.seok.racing.step3.util.Constants.NUMBER_ZERO;

/**
 * 레이싱 게임 역할을 하는 클래스
 */
public class CarRacingGame {

    // 자동차 게임이 실행되기 위한 필수 필드
    private final RacingResult racingResult;

    private CarManager carManager;
    private int attemptCount;

    public CarRacingGame(final RequestRacingGame userInput) {
        initGame(userInput);
        racingResult = new RacingResult();
    }

    // final 필드를 2개 이하로 사용하기 위해 초기화 메서드를 따로 생성
    private void initGame(final RequestRacingGame userInput) {
        attemptCount = userInput.getAttemptCount();
        carManager = new CarManager(userInput.getParticipants());
    }

    // 레이스
    public void race(MoveStrategy moveStrategy) {
        IntStream.range(NUMBER_ZERO, attemptCount)
                .forEach(value ->
                        // 라운드 별 기록 저장
                        racingResult.addRacingRound(carManager.run(moveStrategy))
                );
    }

    public RacingResult getRacingResult() {
        return racingResult;
    }
}
