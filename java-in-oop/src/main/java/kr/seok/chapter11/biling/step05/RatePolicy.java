package kr.seok.chapter11.biling.step05;


import kr.seok.chapter10.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
