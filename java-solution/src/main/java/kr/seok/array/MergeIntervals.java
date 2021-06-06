package kr.seok.array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        // 1. 시작 값을 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // 2. 비어있거나, 현재 값이 오버랩 되지 않은 경우 추가
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 3. 오버랩되는 경우 최대값으로 변경
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
