package com.example.behavioral.state.status;

import com.example.behavioral.state.context.DeliveryContext;

public class Delivered implements PackageState {
    //Singleton
    private static final Delivered instance = new Delivered();

    private Delivered() {
    }

    public static Delivered instance() {
        return instance;
    }

    //Business logic
    @Override
    public void updateState(DeliveryContext ctx) {
        System.out.println("Package is delivered!!");
    }
}
