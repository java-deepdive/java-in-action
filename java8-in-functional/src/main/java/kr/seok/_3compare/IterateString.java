/**
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 */
package kr.seok._3compare;

public class IterateString {
    private static void printChar(int aChar) {
        System.out.println((char) (aChar));
    }

    public static void main(String[] args) {
        System.out.println("//" + "START:ITERATE_OUTPUT");

        final String str = "w00t";

        // 문자열의 각 문자를 forEach()의 내부 이터레이터를 사용하여 이터레이션하는 스트림을 리턴
        str.chars()
                .forEach(ch -> System.out.println(ch));
        System.out.println("//" + "END:ITERATE_OUTPUT");

        str.chars()
                .forEach(System.out::println);

        // 문자열 출력하도록 메서드를 생성
        System.out.println("//" + "START:FIX_OUTPUT");
        str.chars()
                .forEach(IterateString::printChar);
        System.out.println("//" + "END:FIX_OUTPUT");

        // char 타입의 값을 Object형으로 반환
        str.chars()
                .mapToObj(ch -> Character.valueOf((char) ch))
                .forEach(System.out::println);

        System.out.println("//" + "START:FILTER_OUTPUT");
        str.chars()
                // 숫자만 필터링 하여 반환
                .filter(ch -> Character.isDigit(ch))
                .forEach(ch -> printChar(ch));
        System.out.println("");
        System.out.println("//" + "END:FILTER_OUTPUT");

        str.chars()
                .filter(ch -> Character.isDigit(ch));

        // 메서드 레퍼런스를 사용
        str.chars()
                .filter(Character::isDigit);

        str.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);

    }
}
