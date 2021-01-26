/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._2collections;

import static java.util.stream.Collectors.joining;
import static kr.seok._2collections.Folks.friends;

public class PrintList {
    public static void main(final String[] args) {
        System.out.println("//" + "START:FOREACH_OUTPUT");
        for (String name : friends) {
            System.out.print(name + ", ");
        }

        System.out.println();
        System.out.println("//" + "END:FOREACH_OUTPUT");

        System.out.println("//" + "START:FOR_OUTPUT");
        for (int i = 0; i < friends.size() - 1; i++) {
            System.out.print(friends.get(i) + ", ");
        }

        if (friends.size() > 0)
            System.out.println(friends.get(friends.size() - 1));
        System.out.println("//" + "END:FOR_OUTPUT");

        /*
            자바 8 StringJoiner 클래스를 이용
         */
        System.out.println("//" + "START:JOIN_OUTPUT");
        System.out.println(String.join(", ", friends));
        System.out.println("//" + "END:JOIN_OUTPUT");

        /*
            stream 을 이용한 출력
         */
        System.out.println("//" + "START:MAP_JOIN_OUTPUT");
        System.out.println(
                friends.stream()
                        .map(String::toUpperCase)
                        // 컨비니언스 메서드 -> 타깃으로 값을 모으는 reduce의 다른 형태
                        .collect(

                                joining(", "))
        );
        System.out.println("//" + "END:MAP_JOIN_OUTPUT");

    }
}
