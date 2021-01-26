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

public class DiscountFunctional {
    public static void main(final String[] args) {

        final BigDecimal totalOfDiscountedPrices =
                // prices 리스트에서 stream() 메서드를 호출
                prices.stream()
                        // $20보다 높은 price를 필터링
                        .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                        // 할인된 값으로 price을 매핑, 그 값을 합계에 더한다.
                        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                        // reduce() 메서드를 호출하여 map() 메서드의 결과로 얻은 전쳬 합계를 계산
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}
