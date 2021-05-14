package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GsonCoffeeTest {
    @Test
    void testCase1() {
        GsonCoffee coffee = new GsonCoffee(new Bean(), Water.regular(), Brand.NONE);

        // Gson으로 변환하기 위해서 Serializable 인터페이스를 구현할 필요가 없다.
        Gson gson = new Gson();
        GsonCoffee deepCopy = gson.fromJson(gson.toJson(coffee), GsonCoffee.class);

        assertThat(coffee).isEqualTo(deepCopy);
    }
}
