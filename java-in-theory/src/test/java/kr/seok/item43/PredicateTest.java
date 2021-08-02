package kr.seok.item43;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PredicateTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    @DisplayName("test라는 투상 메서드를 정의하며 제네릭 형식 T의 객체를 인수로 받아 boolean을 반환하는 테스트")
    @Test
    void testCase1() {
        List<String> listOfStrings = Arrays.asList("item1", "item2", "", "item3");

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        assertThat(nonEmpty.size()).isEqualTo(3);
    }
}
