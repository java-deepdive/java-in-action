package kr.seok.chapter11.biling.step03;

import kr.seok.chapter10.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return afterCalculated(result);
    }

    protected abstract Money calculateCallFee(Call call);

    protected abstract Money afterCalculated(Money fee);
}
