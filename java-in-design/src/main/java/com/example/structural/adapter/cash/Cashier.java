package com.example.structural.adapter.cash;

/**
 * 계산 행위에 대한 클라이언트 인터페이스 명세(Client interface)
 */
public interface Cashier {

    void calculate(int money);

    void greet();
}
