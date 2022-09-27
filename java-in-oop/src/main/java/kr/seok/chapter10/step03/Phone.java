package kr.seok.chapter10.step03;


import kr.seok.chapter10.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
	private final Money amount;
	private final Duration seconds;
	private final List<Call> calls = new ArrayList<>();
	
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
}
