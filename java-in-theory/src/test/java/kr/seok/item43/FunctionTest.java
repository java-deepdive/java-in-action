package kr.seok.item43;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FunctionTest {
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    @DisplayName("String 리스트를 인수로 받아 각 String의 길이를 포함하는 Integer 리스트로 반환하는 map 테스트")
    @Test
    void testCase1() {
        map(
                Arrays.asList("item1", "item2", "item3"),
                (String s) -> s.length());
    }
}
