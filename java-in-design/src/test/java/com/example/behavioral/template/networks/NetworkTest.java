package com.example.behavioral.template.networks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NetworkTest {
    private Network network;

    @DisplayName("SNS 별 메시지 보내기 테스트")
    @CsvSource(value = {"1, 페이스북 메시지", "2, 트위터 메시지"})
    @ParameterizedTest(name = "to {0} : msg = {1}")
    void testCase1(int select, String message) {
        if(select == 1) {
            network = new Facebook("username", "password");
        } else {
            network = new Twitter("username", "password");
        }
        assertThat(network.post(message)).isTrue();
    }
}
