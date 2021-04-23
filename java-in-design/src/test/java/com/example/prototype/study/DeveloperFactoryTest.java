package com.example.prototype.study;

import com.example.prototype.study.concrete.BackEnd;
import com.example.prototype.study.concrete.FrontEnd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("팩토리 패턴")
class DeveloperFactoryTest {

    @DisplayName("개발자 생성 테스트")
    @Test
    void testCase1() {
        // given
        BaseDeveloper developer = DeveloperFactory.create(DevType.BACKEND);
        // when
        BackEnd expected = new BackEnd();
        // then
        assertThat(developer).isEqualTo(expected);
    }

    @DisplayName("클론 테스트")
    @Test
    void testCase2() {
        BaseDeveloper front = DeveloperFactory.create(DevType.FRONTEND);
        FrontEnd frontEnd = (FrontEnd) front;
        assertThat(front).isEqualTo(frontEnd.clone());
    }
}
