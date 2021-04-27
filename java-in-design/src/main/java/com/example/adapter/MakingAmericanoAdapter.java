package com.example.adapter;

public class MakingAmericanoAdapter implements MakingCoffee {

    private final MakingAmericano makingAmericano;

    public MakingAmericanoAdapter() {
        this.makingAmericano = new MakingAmericano();
    }

    @Override
    public void offer() {
        makingAmericano.make();
    }
}
