/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._1intro;

import java.math.BigDecimal;

import static kr.seok._1intro.Prices.prices;

public class DiscountImperative {

    public static void main(final String[] args) {
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

        for (BigDecimal price : prices) { // 배열을 순차적으로 나열
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) // 20 보다 큰 값에 따른 분기 처리
                totalOfDiscountedPrices =
                        totalOfDiscountedPrices.add(
                                // price에 값에 0.9를 곱하여(10% 할인) 값을 추가 후 저장
                                price.multiply(BigDecimal.valueOf(0.9))
                        );
        }

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}
