/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._4designing;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {

    private Function<String, BigDecimal> priceFinder;
    //... other methods that use the priceFinder ...

    public CalculateNAV(final Function<String, BigDecimal> aPriceFinder) {
        priceFinder = aPriceFinder;
    }

    public static void main(String[] args) {
        // 생성자 주입
        final CalculateNAV calculateNav = new CalculateNAV(YahooFinance::getPrice);

        System.out.println(String.format("100 shares of Google worth: $%.2f",
                // 웹 서비스에서 받은 데이터를 사용하여 재무 연산
                calculateNav.computeStockWorth("GOOG", 100)));
    }

    public BigDecimal computeStockWorth(
            final String ticker, final int shares) {
        return priceFinder.apply(ticker)
                .multiply(BigDecimal.valueOf(shares));
    }
}
