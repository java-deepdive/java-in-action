package kr.seok.bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {

    @DisplayName("볼링 게임 시작 테스트")
    @Test
    void testCase1() {
        BowlingGame game = BowlingGame.init("seok");
        game.bowl("5");

        assertThat(game.isEnd()).isFalse();
    }
}
