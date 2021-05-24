package com.example.creational.prototype.dev;

import com.example.creational.prototype.dev.concrete.BackEnd;
import com.example.creational.prototype.dev.concrete.FrontEnd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("팩토리 패턴")
class EnumDevFactoryTest {

    @DisplayName("개발자 생성 테스트")
    @Test
    void testCase1() {
        // given
        BaseDeveloper developer = EnumDevFactory.create(DevType.BACKEND);
        // when
        BackEnd expected = new BackEnd();
        // then
        assertThat(developer).isEqualTo(expected);
    }

    @DisplayName("클론 테스트")
    @Test
    void testCase2() {
        BaseDeveloper front = EnumDevFactory.create(DevType.FRONTEND);
        FrontEnd frontEnd = (FrontEnd) front;
        assertThat(front).isEqualTo(frontEnd.clone());
    }
}
