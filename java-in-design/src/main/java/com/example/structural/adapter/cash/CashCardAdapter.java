package com.example.structural.adapter.cash;


public class CashCardAdapter implements Cashier {

    @Override
    public void calculate(int money) {
        System.out.println("카드 결제: " + moneyToCard(money));
    }

    @Override
    public void greet() {
        System.out.println("카드 결제 감사요");
    }

    private Card moneyToCard(int money) {
        return Card.valueOf(money);
    }
}
