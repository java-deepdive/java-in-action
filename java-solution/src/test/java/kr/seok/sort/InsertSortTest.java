package kr.seok.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InsertSortTest {

    @DisplayName("삽입 정렬 테스트")
    @Test
    void testCase1() {
        int[] items = {5, 6, 2, 8, 7, 23, 4, 1};
        InsertSort sort = new InsertSort();
        int[] actual = sort.sort(items, items.length);

        assertThat(actual).isEqualTo(new int[] {1, 2, 4, 5, 6, 7, 8, 23});
    }
}
