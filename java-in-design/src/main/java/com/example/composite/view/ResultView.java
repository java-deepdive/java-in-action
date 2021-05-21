package com.example.composite.view;

import com.example.composite.order.Serve;

public class ResultView {
    public static void printServedCoffee(Serve order) {
        System.out.println(order.print());
    }
}
