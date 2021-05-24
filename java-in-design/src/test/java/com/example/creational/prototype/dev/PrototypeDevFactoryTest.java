package com.example.creational.prototype.dev;

import com.example.creational.prototype.dev.concrete.BackEnd;
import com.example.creational.prototype.dev.concrete.Client;
import com.example.creational.prototype.dev.concrete.FrontEnd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrototypeDevFactoryTest {

    PrototypeDevFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PrototypeDevFactory(new BackEnd(), new FrontEnd(), new Client());
    }

    @DisplayName("백엔드 인스턴스 확인 테스트")
    @Test
    void testCase1() {
        // given
        FrontEnd frontEnd = factory.frontEnd();
        BackEnd backEnd = factory.backEnd();
        Client client = factory.client();
        // when
        // then
        assertThat(frontEnd).isEqualTo(new FrontEnd());
        assertThat(backEnd).isEqualTo(new BackEnd());
        assertThat(client).isEqualTo(new Client());
    }
}
