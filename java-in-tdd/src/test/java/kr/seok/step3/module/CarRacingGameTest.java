package kr.seok.step3.module;

import kr.seok.step3.wrapper.RacingResult;
import kr.seok.step3.ui.dto.RequestRacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingGameTest {

    private static Stream<Arguments> racingParticipants() {
        return Stream.of(
            Arguments.of(new String[] {"a", "b", "c"}, 3)
        );
    }

    @DisplayName("레이싱 게임 정상 작동 테스트")
    @ParameterizedTest(name = "자동차 {0} 대, 총 {1} 차 레이스 시작")
    @MethodSource(value = "racingParticipants")
    void racingGameTest(final String[] participants, final int attemptCount) {
        // given
        RequestRacingGame request = new RequestRacingGame(participants, attemptCount);
        CarRacingGame racingGame = new CarRacingGame(request);

        // when
        racingGame.race();

        RacingResult result = racingGame.getRacingResult();
        int roundCount = result.getRacingRounds().size();

        // then
        assertThat(roundCount).isEqualTo(attemptCount);
    }
}
