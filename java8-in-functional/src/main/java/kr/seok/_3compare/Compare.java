/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._3compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Compare {
    public static void printPeople(
            final String message, final List<Person> people) {

        System.out.println(message);
        people.forEach(System.out::println);
    }

    public static void main(String[] args) {
        // 초기값 생성
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Jane", 22),
                new Person("Greg", 35));

        {
            System.out.println("//" + "START:AGE_ASCEND_OUTPUT");
            List<Person> ascendingAge =
                    people.stream()
                            /*
                                void 메서드 이기 때문에 리스트 자체가 변경될 가능성이 있다.
                                원본 리스트를 보존하기 위해서는 복사본을 만들어 두어야 한다.
                             */
                            .sorted(
                                    // 익명 클래스를 이용한 비교 로직
                                    (person1, person2) -> person1.ageDifference(person2))
                            /*
                                collect() 메서드가 이터레이션의 타깃 멤버를
                                원하는 타입의 포맷으로 변환하는 리듀서(reducer)이다.
                             */
                            .collect(
                                    // toList()는 Collectors 컨비니언스 클래스의 정적 메서드
                                    toList());
            printPeople("Sorted in ascending order by age: ", ascendingAge);
            System.out.println("//" + "END:AGE_ASCEND_OUTPUT");
        }

        {
            System.out.println("//" + "START:AGE_ASCEND_MR_OUTPUT");
            List<Person> ascendingAge =
                    people.stream()
                            // 메서드 레퍼런스 방식으로 호출
                            .sorted(Person::ageDifference)
                            .collect(toList());

            printPeople("Sorted in ascending order by age: ", ascendingAge);
            System.out.println("//" + "END:AGE_ASCEND_MR_OUTPUT");
        }

        {
            System.out.println("//" + "START:AGE_DESCEND_OUTPUT");
            printPeople("Sorted in descending order by age: ",
                    people.stream()
                            .sorted((person1, person2) -> person2.ageDifference(person1))
                            .collect(toList()));
            System.out.println("//" + "END:AGE_DESCEND_OUTPUT");

            System.out.println("//" + "START:REVERSE_ORDER_OUTPUT");

            // 파라미터 순서에 따라 오름차순, 내림차순이 변경되므로 메서드 레퍼런스를 사용할 수 없음
            Comparator<Person> compareAscending =
                    (person1, person2) -> person1.ageDifference(person2);

            Comparator<Person> compareDescending = compareAscending.reversed();

            printPeople("Sorted in ascending order by age: ",
                    people.stream()
                            .sorted(compareAscending)
                            .collect(toList())
            );

            printPeople("Sorted in descending order by age: ",
                    people.stream()
                            .sorted(compareDescending)
                            .collect(toList())
            );
            System.out.println("//" + "END:REVERSE_ORDER_OUTPUT");

            System.out.println("//" + "START:NAME_ASCEND_OUTPUT");
            printPeople("Sorted in ascending order by name: ",
                    people.stream()
                            .sorted((person1, person2) ->
                                    person1.getName().compareTo(person2.getName()))
                            .collect(toList()));
            System.out.println("//" + "END:NAME_ASCEND_OUTPUT");
        }

        {
            System.out.println("//" + "START:YOUNGEST_OUTPUT");
            people.stream()
                    // 최소 값
                    .min(Person::ageDifference)
                    .ifPresent(youngest -> System.out.println("Youngest: " + youngest));
            System.out.println("//" + "END:YOUNGEST_OUTPUT");
        }

        {
            System.out.println("//" + "START:ELDEST_OUTPUT");
            people.stream()
                    // 최대 값
                    .max(Person::ageDifference)
                    .ifPresent(eldest -> System.out.println("Eldest: " + eldest));
            System.out.println("//" + "END:ELDEST_OUTPUT");
        }

        {
            // 정렬
            people.stream()
                    .sorted((person1, person2) ->
                            person1.getName().compareTo(person2.getName()));

            printPeople("Sorted in ascending order by name: ",
                    people.stream()
                            .sorted(comparing((Person person) -> person.getName()))
                            .collect(toList()));

            // 고차 함수를 이용한 비교 정렬
            final Function<Person, String> byName = person -> person.getName();
            people.stream()
                    .sorted(comparing(byName));
        }

        {
            System.out.println("//" + "START:SORT_NAME_AND_AGE_OUTPUT");

            final Function<Person, Integer> byAge = person -> person.getAge();
            final Function<Person, String> byTheirName = person -> person.getName();

            printPeople("Sorted in ascending order by age and name: ",
                    people.stream()
                            // 다중 비교를 이용한 나이와 이름을 비교하여 오름차순 정렬
                            .sorted(comparing(byAge).thenComparing(byTheirName))
                            .collect(toList()));
            System.out.println("//" + "END:SORT_NAME_AND_AGE_OUTPUT");


            printPeople("Sorted in ascending order by age and name: ",
                    people.stream()
                            // 다중 비교를 이용한 나이와 이름을 비교하여 오름차순 정렬
                            .sorted(
                                    // 이름 먼저 정렬
                                    comparing(byTheirName).
                                            // 이름 정렬 후 나이 정렬
                                                    thenComparing(byAge))
                            .collect(toList()));
        }
    }
}
