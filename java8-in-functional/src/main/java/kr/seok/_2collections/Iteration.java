/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._2collections;

import java.util.function.Consumer;

import static kr.seok._2collections.Folks.friends;

public class Iteration {
    public static void main(final String[] args) {
        /*
            내부적으로 Iterator 인터페이스를 사용하고 hasNext()와 next() 메서드를 호출한다.
         */
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }
        /*
            내부적으로 Iterator 메서드를 사용, continue, break을 사용하여 이터레이션의 흐름을 제어할 수 있다.
         */
        for (String name : friends) {
            System.out.println(name);
        }

        System.out.println("//" + "START:INTERNAL_FOR_EACH_OUTPUT");

        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        System.out.println("//" + "END:INTERNAL_FOR_EACH_OUTPUT");

        System.out.println("//" + "START:INTERNAL_OUTPUT");
        /*
            final 로 마크하여 해당 파라미터의 불변성을 유지하는 것이 좋다.
         */
        friends.forEach((final String name) -> System.out.println(name));
        System.out.println("//" + "END:INTERNAL_OUTPUT");

        friends.forEach((name) -> System.out.println(name));

        friends.forEach(name -> System.out.println(name));

        friends.forEach(System.out::println);
    }
}
