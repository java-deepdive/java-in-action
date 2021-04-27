/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._2collections;

import java.util.Optional;

import static kr.seok._2collections.Folks.friends;

public class PickALongest {
    public static void main(final String[] args) {
        {
            System.out.println("//" + "START:SUM_OUTPUT");
            /*

             */
            int sum = friends.stream()
                    .mapToInt(name -> name.length())
                    .sum();
            System.out.println("Total number of characters in all names: " + sum);
        }
        System.out.println("//" + "END:SUM_OUTPUT");

        System.out.println("//" + "END:AVERAGE_OUTPUT");
        System.out.println("//" + "START:REDUCE_OUTPUT");

        final Optional<String> aLongName =
                friends.stream()
                        /*
                            가장 긴 길이를 갖는 이름이 두 개 이상 있다면 찾은 것 중에서 첫 번째 엘리먼트를 출력
                         */
                        .reduce(
                                /*
                                    첫 번째로 리스트에 있는 처음 두 개의 엘리먼트를 사용하여 람다 표현식을 호출
                                    람다 표현식의 결과는 다음 호출에 사용된다.

                                    두 번째 호출에서 name1은 이전 호출의 결과이며 name2는 컬렉션의 세 번째 엘리먼트이다.

                                    람다 표현식의 호출은 컬렉션에 엘리먼트가 남아 있는 동안 계속된다.

                                    마지막 호출에 대한 결과는 reduce() 메서드 호출의 전체 결과로 리턴된다.
                                 */
                                (name1, name2) ->
                                        name1.length() >= name2.length()
                                                ? name1
                                                : name2);

        aLongName.ifPresent(name ->
                System.out.println(String.format("A longest name: %s", name))
        );
        System.out.println("//" + "END:REDUCE_OUTPUT");

        final String steveOrLonger =
                friends.stream()
                        /*
                            기본 값이나 기준값을 설정하려는 경우 reduce() 메서드의 오버로드된 메서드에 추가 파라미터로 원하는 값을 넘기면 된다.
                         */
                        .reduce("Steve",
                                (name1, name2) ->
                                        name1.length() >= name2.length()
                                                ? name1
                                                : name2);

        System.out.println(steveOrLonger);
    }
}
