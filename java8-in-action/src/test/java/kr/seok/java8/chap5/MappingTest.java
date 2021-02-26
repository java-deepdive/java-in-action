package kr.seok.java8.chap5;

import kr.seok.java8.chap4.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static kr.seok.java8.chap4.Dish.menu;

class MappingTest {

    @Test
    @DisplayName("매핑: 스트림의 각 요소에 함수 적용하기")
    void testCase1() {
        // Function<Dish, String> 특정 객체에서 특정 데이터를 선택하는 인터페이스
        Function<Dish, String> getName = Dish::getName;

        menu.stream()
                // 객체 -> Name 스트림을 반환
                .map(getName)
                .collect(toList())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("매핑: 객체 스트림 -> 문자열 스트림")
    void testCase2() {

        List<String> words = Arrays.asList("Hello", "World");

        Function<String, Integer> length = String::length;

        words.stream()
                // 객체 -> 문자열 길이
                .map(length)
                .collect(toList())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("매핑: 객체 스트림 -> 스트림 평면화")
    void testCase3() {
        List<String> words = Arrays.asList("Hello", "World");

        // FlatMap 된 스트림을 Split 처리하는 연산
        Function<String, Stream<? extends String>> stringStreamFunction =
                (String line) -> Arrays.stream(line.split(""));

        words.stream()
                // 배열을 하나의 배열로 FlatMap 처리
                .flatMap(stringStreamFunction)
                // 중복 데이터 필터링
                .distinct()
                .forEach(System.out::println);

    }

    @Test
    @DisplayName("스트림 평면화")
    void testCase4() {
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);

        // Map: Integer -> +@ 로 number2 스트림으로 new int[]{i, j}으로 변환
        Function<Integer, Stream<? extends int[]>> integerStreamFunction =
                (Integer i) -> numbers2.stream().map((Integer j) -> new int[]{i, j});

        // Predicate 숫자 쌍의 합이 3으로 나누어 떨어지는 모든 요소의 스트림을 반환
        Predicate<int[]> predicate =
                pair -> (pair[0] + pair[1]) % 3 == 0;

        numbers1.stream()
                // 값의 변환
                .flatMap(integerStreamFunction)
                // 특정 요소의 스트림을 반환
                .filter(predicate)
                .collect(toList())
                .forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
