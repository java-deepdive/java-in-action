package kr.seok.coffee.v3.coupon;

import kr.seok.coffee.v3.money.Money;
import kr.seok.coffee.v3.order.Order;

public interface BenefitPolicy {
	
	Money calculatorFee(Order coffee);
}
