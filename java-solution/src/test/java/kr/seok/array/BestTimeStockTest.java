package kr.seok.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeStockTest {

    @DisplayName("최대 수익을 얻을 수 있는 가격 테스트")
    @Test
    void testCase1() {
        BestTimeStock bestTimeStock = new BestTimeStock();

        int actual = bestTimeStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});

        assertThat(actual).isEqualTo(5);
    }
}
