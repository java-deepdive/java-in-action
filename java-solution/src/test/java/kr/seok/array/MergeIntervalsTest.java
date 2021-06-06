package kr.seok.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeIntervalsTest {

    @DisplayName(" 병합하기 테스트 ")
    @Test
    void testCase1() {
        MergeIntervals mergeIntervals = new MergeIntervals();

        int[][] merge = mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

        assertThat(merge).isEqualTo(new int[][]{{1, 6}, {8, 10}, {15, 18}});
    }
}
