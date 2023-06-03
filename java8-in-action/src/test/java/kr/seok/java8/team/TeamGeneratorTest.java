package kr.seok.java8.team;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TeamGeneratorTest {

    @DisplayName("팀 생성 테스트")
    @Test
    void testCase1() {
        String[] participants =
                {
                 ""
                };
        List<String> participants1 = new ArrayList<>(List.of(participants));
        TeamGenerator.makeReviewerAndAssignee(participants1);
    }

}