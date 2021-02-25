package kr.seok.java8.chap4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.seok.java8.chap4.StreamBasic.getLowCaloricDishesNamesInJava7;
import static kr.seok.java8.chap4.StreamBasic.getLowCaloricDishesNamesInJava8;

class StreamBasicTest {

    @Test
    @DisplayName("java7 외부 연산 테스트")
    void testCase1() {
        /*
            salmon
            french fries
            pizza
            beef
            pork
         */
        getLowCaloricDishesNamesInJava7(Dish.menu)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("stream 연산 테스트")
    void testCase2() {
        /*
            salmon
            french fries
            pizza
            beef
            pork
         */
        getLowCaloricDishesNamesInJava8(Dish.menu)
                .forEach(System.out::println);
    }
}
