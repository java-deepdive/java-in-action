package com.example.prototype.study;

import com.example.prototype.study.concrete.FrontEnd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DevTypeTest {

    @DisplayName("개발자 찾기")
    @Test
    void testCase1() {
        DevType b = DevType.create(DevType.BACKEND);
        System.out.println();
        assertThat(b).isEqualTo(DevType.BACKEND);
    }

    @Test
    void testCase2() {

        DevType front = DevType.create(DevType.FRONTEND);

        BaseDeveloper developer = front.create();

        assertThat(developer).isInstanceOf(FrontEnd.class);
    }
}
