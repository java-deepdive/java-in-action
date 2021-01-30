/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._6lazy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static kr.seok._6lazy.PrimeFinder.isPrime;

public class Primes {
    private static int primeAfter(final int number) {
        if (isPrime(number + 1))
            return number + 1;
        else
            return primeAfter(number + 1);
    }

    public static List<Integer> primes(final int fromNumber, final int count) {
        return Stream
                .iterate(
                        // 컬렉션을 시작하기 위한 시드
                        primeAfter(fromNumber - 1),
                        // UnaryOperator 인터페이스의 인스턴스로서 컬렉션에 데이터를 공급하는 역할
                        Primes::primeAfter
                )
                .limit(count)
                .collect(Collectors.<Integer>toList());
    }
    //...

    public static void main(final String[] args) {
        System.out.println("10 primes from 1: " + primes(1, 10));

        System.out.println("5 primes from 100: " + primes(100, 5));
    }

}
