package com.example.structural.composite;

import com.example.structural.composite.order.MenuItem;
import com.example.structural.composite.view.InputView;
import com.example.structural.composite.view.ResultView;

public class CafeRunner {

    public static void main(String[] args) {
        CafeRunner cafeRunner = new CafeRunner();
        cafeRunner.run();
    }

    private void run() {
        // 메뉴 선택
        MenuItem menuItem = InputView.inputMenu(MenuItem.findAll());
        // 카페 주문
        Cafe order = Cafe.orders(menuItem);
        // 주문한 커피
        ResultView.printServedCoffee(order.menuServe());
    }
}
