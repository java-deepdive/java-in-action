package kr.seok.generic;

import java.util.List;

public class Box<T> {

    static void printList(List<Object> list) {
        list.forEach(System.out::println);
    }

    static void printList2(List<?> list) {
        list.forEach(System.out::println);
    }
}
