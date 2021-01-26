/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._3compare;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class OlderThan20 {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));

        {
            System.out.println("//" + "START:MUTABLE_OUTPUT");
            List<Person> olderThan20 = new ArrayList<>();
            people.stream()
                    .filter(person -> person.getAge() > 20)
                    .forEach(person -> olderThan20.add(person));
            System.out.println("People older than 20: " + olderThan20);
            System.out.println("//" + "END:MUTABLE_OUTPUT");
        }

        {
            System.out.println("//" + "START:COLLECT_OUTPUT");
            List<Person> olderThan20 =
                    people.stream()
                            .filter(person -> person.getAge() > 20)
                            .collect(
                                    // 결과 컨테이너
                                    ArrayList::new,
                                    // 하나의 엘리먼트를 결과 컨테이너에 추가하는 방법
                                    ArrayList::add,
                                    // 하나의 결과 컨테이너를 다른 것과 합치는 방법
                                    ArrayList::addAll);

            System.out.println("People older than 20: " + olderThan20);
            System.out.println("//" + "END:COLLECT_OUTPUT");
        }

        {
            System.out.println("//" + "START:COLLECT_TO_LIST_OUTPUT");
            List<Person> olderThan20 =
                    people.stream()
                            .filter(person -> person.getAge() > 20)
                            .collect(toList());
            System.out.println("People older than 20: " + olderThan20);
            System.out.println("//" + "END:COLLECT_TO_LIST_OUTPUT");
        }

        {
            System.out.println("//" + "START:GROUP_BY_OUTPUT");
            Map<Integer, List<Person>> peopleByAge =
                    people.stream()
                            .collect(
                                    // 나이로 그룹핑
                                    groupingBy(Person::getAge));
            System.out.println("Grouped by age: " + peopleByAge);
            System.out.println("//" + "END:GROUP_BY_OUTPUT");
        }

        {
            System.out.println("//" + "START:GROUP_BY_AGE_NAME_OUTPUT");
            Map<Integer, List<String>> nameOfPeopleByAge =
                    people.stream()
                            .collect(
                                    groupingBy(
                                            // 나이로 그룹핑
                                            Person::getAge,
                                            // 나이로 그룹핑하되 이름순으로 List를 만들어 Key-value로 묶음
                                            mapping(Person::getName, toList())));
            System.out.println("People grouped by age: " + nameOfPeopleByAge);
            System.out.println("//" + "END:GROUP_BY_AGE_NAME_OUTPUT");
        }

        {
            System.out.println("//" + "START:OLDEST_IN_EACH_LETTER_OUTPUT");
            Comparator<Person> byAge = Comparator.comparing(Person::getAge);

            //{ S=Optional[Sara - 21] , G=Optional[Greg - 35] , J=Optional[Jane - 21] }
            Map<Character, Optional<Person>> oldestPersonOfEachLetter =
                    people.stream()
                            .collect(
                                    // 이름 첫글자 순으로 정렬
                                    groupingBy(
                                            // 이름 첫글자
                                            person -> person.getName().charAt(0),
                                            // 연장자
                                            reducing(BinaryOperator.maxBy(byAge))
                                    )
                            );
            System.out.println("Oldest person of each letter:");
            System.out.println(oldestPersonOfEachLetter);
            System.out.println("//" + "END:OLDEST_IN_EACH_LETTER_OUTPUT");
        }
    }
}
