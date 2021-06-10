package com.example.behavioral.state;

import com.example.behavioral.state.context.DeliveryContext;

public class Demo {
    public static void main(String[] args) {
        DeliveryContext ctx = new DeliveryContext(null, "Test123");

        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
    }
}
