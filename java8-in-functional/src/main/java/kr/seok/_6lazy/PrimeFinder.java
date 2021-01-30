/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package kr.seok._6lazy;

import java.util.stream.IntStream;

public class PrimeFinder {
  // 1과 자기 자신만으로 나누어 떨어지는 1보다 큰 양의 정수가 소수
  public static boolean isPrime(final int number) {
    return number > 1 &&
            // 주어진 number의 제곱근까지 스트림으로 패킹하여 리턴
            IntStream.rangeClosed(2, (int) Math.sqrt(number))
                    // 주어진 숫자에 대한 나누어진 수에 대한 존재를 확인
                    // 람다 표현식이 범위 내에 있는 모든 값에 대해 false를 리턴하는 경우 true를 얻게 된다.
               .noneMatch(divisor -> number % divisor == 0);
  }
}
