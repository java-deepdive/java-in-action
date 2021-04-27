package kr.seok.chapter10.step01;


import kr.seok.chapter10.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result;
    }

    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(
                LocalDateTime.of(2018, 1, 1, 12, 10, 0),
                LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
        phone.call(new Call(
                LocalDateTime.of(2018, 1, 2, 12, 10, 0),
                LocalDateTime.of(2018, 1, 2, 12, 11, 0)));

        Money money = phone.calculateFee();
        System.out.println(money); // Money.wons(60);
    }
}
