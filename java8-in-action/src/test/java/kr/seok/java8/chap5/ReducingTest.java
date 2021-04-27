package kr.seok.java8.chap5;

import kr.seok.java8.chap4.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

import static kr.seok.java8.chap4.Dish.menu;
import static org.assertj.core.api.Assertions.assertThat;

class ReducingTest {

    @Test
    @DisplayName("reducing: 스트림 요소를 조합하여 더 복잡한 질의를 표현하는 방법")
    void testCase1() {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        // Integer 클래스에 두 숫자를 더하는 정적 메서드
        BinaryOperator<Integer> sumOperation = (a, b) -> a + b;

        int initNum = 0;

        int sum = numbers.stream()
                // 0부터 값을 연산?
                .reduce(initNum, sumOperation);

        assertThat(sum).isEqualTo(15);
    }

    @Test
    @DisplayName("reducing: 메서드 레퍼런스를 이용한 reduce")
    void testCase2() {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        assertThat(sum).isEqualTo(15);
    }

    @Test
    @DisplayName("reducing: 초깃값이 없는 reduce")
    void testCase3() {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        numbers.stream()
                // stream 내부 연산으로 최소 값을 연산 (x, y) -> x < y ? x : y
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }

    @Test
    @DisplayName("스트림의 각 요소의 전체 개수를 확인하는 테스트")
    void testCase4() {
        int count = menu.parallelStream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);

        assertThat(count).isEqualTo(9);
    }

    @Test
    @DisplayName("reduce를 이용한 칼로리 전체 합 계산")
    void testCase5() {
        int sum = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        assertThat(sum).isEqualTo(4300);
    }
}
