package kr.seok.lotto.domain;

import java.util.Objects;

// 돈 ->
public class Money {
    private final int amount;

    private Money(int requestMoney) {
        if(requestMoney < 0) {
            throw new IllegalArgumentException("돈이 없음");
        }
        this.amount = requestMoney;
    }

    public static Money of(int requestMoney) {
        return new Money(requestMoney);
    }

    public Money spend() {
        return new Money(amount - 1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        final Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
