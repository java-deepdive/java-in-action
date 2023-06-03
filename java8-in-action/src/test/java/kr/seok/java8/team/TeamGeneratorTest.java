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
                        "강예원"
                        , "강한규"
                        , "구민규"
                        , "김남윤"
                        , "김동인"
                        , "김민철"
                        , "김석래"
                        , "김세윤"
                        , "김진하"
                        , "김형준"
                        , "남혜민"
                        , "박경철"
                        , "세찬"
                        , "신은지"
                        , "이건창"
                        , "이상원"
                        , "이연우"
                        , "이종길"
                        , "이태겸"
                        , "이하정"
                        , "이희영"
                        , "황종욱"
                };
        List<String> participants1 = new ArrayList<>(List.of(participants));
        TeamGenerator.makeReviewerAndAssignee(participants1);
    }
    /**
     * Round 1 pairs:
     * Reviewer: 신은지, Assignee: 김동인
     * Reviewer: 김석래, Assignee: 김남윤
     * Reviewer: 이태겸, Assignee: 김민철
     * Reviewer: 김진하, Assignee: 세찬
     * Reviewer: 강한규, Assignee: 강예원
     * Reviewer: 황종욱, Assignee: 구민규
     * Reviewer: 이희영, Assignee: 이상원
     * Reviewer: 이종길, Assignee: 이건창
     * Reviewer: 김세윤, Assignee: 김형준
     * Reviewer: 이하정, Assignee: 남혜민
     * Reviewer: 박경철, Assignee: 이연우
     * Reviewer: 김동인, Assignee: 박경철
     * Reviewer: 김남윤, Assignee: 신은지
     * Reviewer: 김민철, Assignee: 김석래
     * Reviewer: 세찬, Assignee: 이태겸
     * Reviewer: 강예원, Assignee: 김진하
     * Reviewer: 구민규, Assignee: 강한규
     * Reviewer: 이상원, Assignee: 황종욱
     * Reviewer: 이건창, Assignee: 이희영
     * Reviewer: 김형준, Assignee: 이종길
     * Reviewer: 남혜민, Assignee: 김세윤
     * Reviewer: 이연우, Assignee: 이하정
     */

    /**
     * Reviewer: 이하정, Assignee: 이상원
     * Reviewer: 이태겸, Assignee: 김세윤
     * Reviewer: 강한규, Assignee: 박경철
     * Reviewer: 세찬, Assignee: 이희영
     * Reviewer: 김형준, Assignee: 이연우
     * Reviewer: 이건창, Assignee: 김민철
     * Reviewer: 김남윤, Assignee: 황종욱
     * Reviewer: 김석래, Assignee: 구민규
     * Reviewer: 김진하, Assignee: 신은지
     * Reviewer: 강예원, Assignee: 남혜민
     * Reviewer: 이종길, Assignee: 김동인
     * Reviewer: 이상원, Assignee: 이종길
     * Reviewer: 김세윤, Assignee: 이하정
     * Reviewer: 박경철, Assignee: 이태겸
     * Reviewer: 이희영, Assignee: 강한규
     * Reviewer: 이연우, Assignee: 세찬
     * Reviewer: 김민철, Assignee: 김형준
     * Reviewer: 황종욱, Assignee: 이건창
     * Reviewer: 구민규, Assignee: 김남윤
     * Reviewer: 신은지, Assignee: 김석래
     * Reviewer: 남혜민, Assignee: 김진하
     * Reviewer: 김동인, Assignee: 강예원
     */
}