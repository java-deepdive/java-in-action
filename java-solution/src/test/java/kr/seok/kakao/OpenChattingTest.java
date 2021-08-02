package kr.seok.kakao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OpenChattingTest {

    @DisplayName("채팅방 출입 관리 테스트")
    @Test
    void testCase1() {
        OpenChatting chatting = new OpenChatting();

        String[] solution = chatting.solution(new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"});

        assertThat(solution).isEqualTo(
                new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});

    }
}
