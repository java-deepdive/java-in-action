package kr.seok.movie.v3;

import java.util.Objects;

public class Money {
	
	public static final Money ZERO = Money.wons(0);
	private final int amount;
	
	private Money(int amount) {
		this.amount = amount;
	}
	
	public static Money wons(int amount) {
		return new Money(amount);
	}
	
	public Money minus(Money amount) {
		return new Money(this.amount - amount.amount);
	}
	
	public Money times(double percent) {
		return new Money((int) (this.amount * percent));
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Money)) return false;
		Money money = (Money) o;
		return amount == money.amount;
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
