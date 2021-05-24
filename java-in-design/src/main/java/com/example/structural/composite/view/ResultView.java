package com.example.structural.composite.view;

import com.example.structural.composite.order.Serve;

public class ResultView {
    public static void printServedCoffee(Serve order) {
        System.out.println(order.print());
    }
}
