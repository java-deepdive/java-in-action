package kr.seok.coffee.v3.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
	public static final Money ZERO = Money.wons(0);
	
	private final long amount;
	
	Money(long amount) {
		this.amount = amount;
	}
	
	public static Money wons(long amount) {
		return new Money(amount);
	}
	
	public static Money wons(double amount) {
		return new Money((long) amount);
	}
	
	public Money plus(Money money) {
		return new Money(this.amount + money.amount);
	}
	
	public synchronized Money plus(long amount) {
		return new Money(this.amount + amount);
	}
	
	public synchronized Money minus(Money amount) {
		return new Money(this.amount - amount.amount);
	}
	
	public synchronized Money minus(long amount) {
		return new Money(this.amount - amount);
	}
	
	public long getAmount() {
		return amount;
	}
	
	public synchronized Money times(double percent) {
		return new Money(BigDecimal.valueOf(amount * percent).longValue());
	}
	
	public boolean isLessThan(Money other) {
		return amount < other.amount;
	}
	
	public boolean isGreaterThanOrEqual(Money other) {
		return amount >= other.amount;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Money)) return false;
		Money money = (Money) o;
		return Objects.equals(amount, money.amount);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
	
	@Override
	public String toString() {
		return "Money{" +
			"amount=" + amount +
			'}';
	}
}
