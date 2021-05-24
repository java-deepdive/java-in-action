package com.example.structural.composite;

import com.example.structural.composite.order.MenuItem;
import com.example.structural.composite.order.Serve;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CafeTest {

    @DisplayName("커피 주문 테스트")
    @Test
    void testCase1() {
        Cafe cafe = Cafe.orders(MenuItem.AMERICANO);

        Serve serve = cafe.menuServe();

        assertThat(serve.print()).contains("주문 한 [아메리카노] 커피");
    }

    @DisplayName("커피 주문 리스트 테스트")
    @Test
    void testCase2() {
        Cafe orders = Cafe.orders(MenuItem.AMERICANO, MenuItem.ESPRESSO);

        Serve serve = orders.menuServe();

        assertThat(serve.print()).contains("주문 한 [아메리카노, 에소프레소] 커피");
    }
}
