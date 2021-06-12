package kr.seok.chapter11.biling.step05;

import kr.seok.chapter10.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

public class NightlyDiscountPolicy extends BasicRatePolicy {
    private static final int LATE_NIGHT_HOUR = 22;

    private final Money nightlyAmount;
    private final Money regularAmount;
    private final Duration seconds;

    public NightlyDiscountPolicy(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(getPercent(call.getDuration().getSeconds(), seconds.getSeconds()));
        }
        return regularAmount.times(getPercent(call.getDuration().getSeconds(), seconds.getSeconds()));
    }

    private double getPercent(long seconds, long seconds1) {
        return BigDecimal.valueOf(seconds)
                .divide(
                        BigDecimal.valueOf(seconds1),
                        RoundingMode.UNNECESSARY)
                .floatValue();
    }

}
