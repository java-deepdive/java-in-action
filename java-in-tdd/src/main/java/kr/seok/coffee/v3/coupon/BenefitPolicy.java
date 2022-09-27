package kr.seok.coffee.v3.coupon;

import kr.seok.coffee.v3.Coffee;
import kr.seok.coffee.v3.money.Money;

public interface BenefitPolicy {
	
	Money apply(Coffee coffee);
}
