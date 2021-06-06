package kr.seok.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NewNewTeamManageTest {

    @DisplayName("팀 테스트")
    @Test
    void testCase1() {
        NewNewTeamManage manage = new NewNewTeamManage();

        int solution = manage.solution(new int[]{5, 3, 4, 6, 2, 1});

        assertThat(solution).isEqualTo(4);
    }
}
