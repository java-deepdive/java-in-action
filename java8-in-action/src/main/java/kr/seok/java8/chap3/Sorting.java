package kr.seok.java8.chap3;


import java.util.Comparator;

/**
 * Apple 리스트를 정렬하기 위한 클래스
 */
public class Sorting {
    // sort 동작 파라미터화를 위한 정렬 전략 작성
    static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}

