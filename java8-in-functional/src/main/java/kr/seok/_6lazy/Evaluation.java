/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._6lazy;

import java.util.function.Supplier;

public class Evaluation {
    public static boolean evaluate(final int value) {
        System.out.println("evaluating ..." + value);
        /*
            문제가 되는 메서드

            실행하는데 몇 초가 걸리며 필요없는 호출은 지연하길 원함
         */
        simulateTimeConsumingOp(2000);
        return value > 100;
    }

    public static void simulateTimeConsumingOp(final int millseconds) {
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /*
        이 메서드의 목표는 두 개의 파라미터로 논리 오퍼레이션을 실행하는 것

        해당 오퍼레이션에 진입하기 전에 인수들이 평가되기 때문에 오퍼레이션에서 자동적으로 제공하는 레이지 이벨류에이션으로부터 이점을 억기에는 너무 늦다.
     */
    public static void eagerEvaluator(
            final boolean input1, final boolean input2) {
        System.out.println("eagerEvaluator called...");
        System.out.println("accept?: " + (input1 && input2));
    }

    /*

     */
    public static void lazyEvaluator(
            final Supplier<Boolean> input1, final Supplier<Boolean> input2) {
        System.out.println("lazyEvaluator called...");
        System.out.println("accept?: " + (input1.get() && input2.get()));
    }

    public static void main(final String[] args) {

        // evaluate 메서드에 대한 호출로부터 누적된 시간 때문에 최소 4초 걸림
        System.out.println("//" + "START:EAGER_OUTPUT");
        eagerEvaluator(evaluate(1), evaluate(2));
        System.out.println("//" + "END:EAGER_OUTPUT");

        // 2초
        System.out.println("//" + "START:LAZY_OUTPUT");
        lazyEvaluator(() -> evaluate(1), () -> evaluate(2));
        System.out.println("//" + "END:LAZY_OUTPUT");
    }
}
