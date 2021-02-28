package kr.seok.java8.chap5;

import kr.seok.java8.chap4.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static kr.seok.java8.chap4.Dish.menu;
import static org.assertj.core.api.Assertions.assertThat;

class NumericStreamsTest {

    @Test
    @DisplayName("기본형 특화 스트림 테스트: 칼로리 계산")
    void testCase1() {
        int sum = menu.stream()
                // 각 요리에서 모든 칼로리를 추출한 다음에 IntStream을 반환
                .mapToInt(Dish::getCalories)
                // 스트림이 비어 있는 경우 0을 반환
                .sum();

        assertThat(sum).isEqualTo(4300);
    }

    @Test
    @DisplayName("기본형 특화 스트림 테스트: 객체 스트림으로 복원하기")
    void testCase2() {
        menu.stream()
                // Dish 객체에서 칼로리 필드만으로 변환하여 스트림을 반환 IntStream
                .mapToInt(Dish::getCalories)
                // 숫자 스트림으로 변환 Stream<Integer>
                .boxed()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("기본값 특화 스트림 테스트: 기본값 OptionalInt")
    void testCase3() {
        int max = menu.stream()
                // 합계에 대한 계산을 하는 경우 0이라는 기본값이 있는 경우 문제가 없지만 최대값을 구할 때에는 문제가 될 수 있다.
                .mapToInt(Dish::getCalories)
                // 스트림에 요소가 없는 상황과 실제 최댓값이 0인 상황을 구별하는 방법은 OptionalInt를 사용하여 기본값을 정의할 수 있다.
                .max()
                .orElse(1);
        assertThat(max).isEqualTo(800);
    }

    @Test
    @DisplayName("범위 내에 숫자 생성 rangeClosed는 시작 값과 종료 값을 포함한다.")
    void testCase4() {
        // 1 ~ 100까지 호출
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                // 짝수 조건에 맞는 요소만 필터링
                .filter(num -> num % 2 == 0);

        assertThat(evenNumbers.count()).isEqualTo(50);
    }

    @Test
    @DisplayName("범위 내 숫자 생성 range는 시작 값과 종료 값을 포함하지 않는다.")
    void testCase5() {
        IntStream evenNumbers = IntStream.range(1, 100)
                // 짝수 조건에 맞는 요소만 필터링
                .filter(num -> num % 2 == 0);

        assertThat(evenNumbers.count()).isEqualTo(49);
    }
}
