package kr.seok.java8.chap3;

import kr.seok.java8.chap1.Apple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 동작 파라미터화를 통한 정렬하기
 *  - 익명 클래스
 *  - 람다 포현식
 *  - 메서드 레퍼런스
 */
class SortingTest {
    Sorting sort;
    List<Apple> inventory;
    @BeforeEach
    void setUp() {
        sort = new Sorting();
        inventory = new ArrayList<>();

        inventory.addAll(
                Arrays.asList(
                        new Apple(80,"green"),
                        new Apple(155, "green"),
                        new Apple(120, "red")));
    }

    @Test
    @DisplayName("Comparator 인터페이스를 구현한 클래스를 통한 정렬")
    void testCase1() {
        Comparator<Apple> sorted = new Sorting.AppleComparator();
        inventory.sort(sorted);
        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        System.out.println(inventory);
    }

    @Test
    @DisplayName("익명 클래스를 이용한 정렬")
    void testCase2() {
        inventory.set(1, new Apple(30, "green"));

        // 한 번만 사용할 비교 클래스를 구현해 놓는 것보다 익명 클래스를 통해 일회성으로 구현
        // 코드가 길어짐
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        System.out.println(inventory);
    }

    @Test
    @DisplayName("람다 표현식을 이용한 정렬")
    void testCase3() {
        // 추상 메서드의 시그니처(함수 디스크립터)는 람다 표현식의 시그니처를 정의

        // Comparator의 함수 디스크립터는 (T, T) -> int 이다.

        // 이를 통해 여기서는 (Apple a1, Apple a2) -> int 로 구현할 수 있다.

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
    }

    @Test
    @DisplayName("자바 컴파일러가 람다의 파라미터를 형식 추론하는 것을 이용한 코드 리펙토링")
    void testCase4() {
        inventory.set(1, new Apple(20, "red"));

        // 자바 컴파일러는 람다 표현식이 사용된 컨텍스트를 활용하여 람다의 파라미터 형식을 추론할 수 있다.
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        System.out.println(inventory);
    }

    @Test
    @DisplayName("Comparator 객체로 만드는 Function 함수를 인수로 받는 정적 메서드 comparing을 이용한 정렬")
    void testCase5() {

        // Comparator는 Comparable 키를 추출하여 Comparator 객체로 만드는 Function 함수를 인수로 받는 정적 메서드 comparing 활용
        Comparator<Apple> comparing = Comparator.comparing((Apple a) -> a.getWeight());

        inventory.sort(comparing);

        System.out.println(inventory);
    }

    @Test
    @DisplayName("comparing 에서 형식 추론을 포함하여 리펙토링")
    void testCase6() {

        // 람다의 파라미터 형식 추론을 통한 Apple 코드 제외
        inventory.sort(Comparator.comparing((a) -> a.getWeight()));
        System.out.println(inventory);
    }

    @Test
    @DisplayName("메서드 레퍼런스를 이용한 리펙토링")
    void testCase7() {
        inventory.set(1, new Apple(10, "red"));

        // Apple 을 weight 별로 비교하여 inventory 를 sort 하는 코드
        inventory.sort(Comparator.comparing(Apple::getWeight));

        System.out.println(inventory);
    }
}
