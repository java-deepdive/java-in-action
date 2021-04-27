/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._6lazy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyStreams {
    /*
        작업 처리를 하기 위한 헬퍼 메서드 length, toUpper
     */
    private static int length(final String name) {
        System.out.println("getting length for " + name);
        return name.length();
    }

    private static String toUpper(final String name) {
        System.out.println("converting to uppercase: " + name);
        return name.toUpperCase();
    }

    /*
        이름으로 구성된 컬렉션을 갖고 있고, 세 자리 길이를 갖는 첫 번째 이름을 모두 대문자로 출력한다고 가정


     */
    public static void main(final String[] args) {
        List<String> names =
                Arrays.asList(
                        "Brad", "Kate", "Kim", "Jack", "Joe",
                        "Mike", "Susan", "George", "Robert",
                        "Julia", "Parker", "Benson");

        System.out.println("//" + "START:CHAIN_OUTPUT");
        {
            /*
                두 헬퍼 메서드를이 원하는 결과를 리턴하기 전에 그 메서드가 받은 파라미터를 간단하게 출력
             */
            final String firstNameWith3Letters =
                    names
                            // 이름 리스트를 갖고 스트림으로 변환
                            .stream()
                            // 세 자리로 된 이름만 필터링
                            // 컬렉션에 있는 모든 엘리먼트를 필터링 하지 않는다.
                            .filter(name -> length(name) == 3)
                            // 선택된 이름들을 모두 대문자로 바꾸기
                            .map(name -> toUpper(name))
                            // 그 중 첫 번째 이름을 선택
                            // 위 오퍼레이션을 실행하는 시점은 findFirst()메서드를 호출할 떄임
                            .findFirst()
                            .get();

            System.out.println(firstNameWith3Letters);
        }
        System.out.println("//" + "END:CHAIN_OUTPUT");

        System.out.println("//" + "START:SPLIT_OUTPUT");
        {
            Stream<String> namesWith3Letters =
                    names.stream()
                            // 필터링 후 결과 컬렉션을 매핑
                            .filter(name -> length(name) == 3)
                            .map(name -> toUpper(name));

            System.out.println("Stream created, filtered, mapped...");
            System.out.println("ready to call findFirst...");

            final String firstNameWith3Letters =
                    namesWith3Letters.findFirst()
                            .get();

            System.out.println(firstNameWith3Letters);
        }
        System.out.println("//" + "END:SPLIT_OUTPUT");


    }

}
