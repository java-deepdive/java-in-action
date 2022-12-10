package kr.seok.payments;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Ledger {
	private final String orderId;
	private final PaymentTypes paymentType;
	private final String goodsName;
	private final BigDecimal amount;
	
	public Ledger(String orderId, PaymentTypes paymentType, String goodsName, BigDecimal amount) {
		this.orderId = orderId;
		this.paymentType = paymentType;
		this.goodsName = goodsName;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Ledger{" +
			"orderId='" + orderId + '\'' +
			", paymentType=" + paymentType +
			", goodsName='" + goodsName + '\'' +
			", amount=" + amount +
			'}';
	}
}
