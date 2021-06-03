package kr.seok.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TeamManageTest {

    @DisplayName("팀 테스트")
    @Test
    void testCase1() {
        TeamManage manage = new TeamManage();

        int solution = manage.solution(new int[]{5, 3, 4, 6, 2, 1});

        assertThat(solution).isEqualTo(4);
    }
}
