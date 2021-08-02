/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._7optimize;

import java.math.BigInteger;

import static kr.seok._7optimize.TailCalls.call;
import static kr.seok._7optimize.TailCalls.done;

public class BigFactorial {
    final static BigInteger ONE = BigInteger.ONE;
    final static BigInteger FIVE = new BigInteger("5");
    final static BigInteger TWENTYK = new BigInteger("20000");

    public static BigInteger decrement(final BigInteger number) {
        return number.subtract(BigInteger.ONE);
    }

    public static BigInteger multiply(
            final BigInteger first, final BigInteger second) {
        return first.multiply(second);
    }

    //...

    private static TailCall<BigInteger> factorialTailRec(
            final BigInteger factorial, final BigInteger number) {

        if (number.equals(BigInteger.ONE))
            return done(factorial);
        else
            return call(
                    () -> factorialTailRec(multiply(factorial, number), decrement(number))
            );
    }

    public static BigInteger factorial(final BigInteger number) {
        return factorialTailRec(BigInteger.ONE, number).invoke();
    }

    public static void main(final String[] args) {
        System.out.println(factorial(FIVE));
        System.out.println(String.format("%.10s...", factorial(TWENTYK)));
    }
}
