package kr.seok.coffee.v3.domain;

import kr.seok.coffee.v3.domain.Money;
import kr.seok.coffee.v3.order.Order;

public interface BenefitPolicy {
	
	Money calculatorFee(Order coffee);
}
