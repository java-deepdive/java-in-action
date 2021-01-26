/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._2collections;

import java.util.ArrayList;
import java.util.List;

import static kr.seok._2collections.Folks.friends;


public class Transform {

    public static void main(final String[] args) {
        /*
            모두 대문자로 된 새로운 리스트를 생성하는 것은 성능상 걱정할 필요가 있다.
         */
        {
            final List<String> uppercaseNames = new ArrayList<String>();

            // 대문자로 된 새로운 스트링을 만들고 저장
            for (String name : friends) {
                uppercaseNames.add(name.toUpperCase());
            }

            System.out.println(uppercaseNames);
        }

        {
            // 빈 리스트와 엘리먼트를 추가하는 작업은 여전히 필요..
            final List<String> uppercaseNames = new ArrayList<String>();

            // 내부 이터레이션을 사용
            friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));

            System.out.println(uppercaseNames);
        }

/*
      friends.stream()
             .map(name -> name.toUpperCase());
*/

        System.out.println("//" + "START:TRANSFORM_OUTPUT");

        /*
            map() 메서드를 사용하여 가변성이 발생하지 않도록 할 수 있다.
         */
        friends.stream()
                /*
                    스트림의 각 엘리먼트를 처리하는 메서드
                    실행 결과를 취합하여 결과 컬렉션으로 리턴
                 */
                .map(name -> name.toUpperCase())
                // 위 map 에서 처리된 컬렉션을 내부 이터레이터를 통해 반복
                .forEach(name -> System.out.print(name + " "));

        System.out.println();

        System.out.println("//" + "END:TRANSFORM_OUTPUT");

        System.out.println("//" + "START:NUMBER_OUTPUT");

        /*
            컬렉션의 입력 타입과 출력타입이 다름
            문자열 -> 숫자
         */
        friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.print(count + " "));

        System.out.println();
        System.out.println("//" + "END:NUMBER_OUTPUT");

/*
    friends.stream()
           .map(String::toUpperCase);
*/

        friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(name));
    }
}
