package com.example.creational.factory.simple;

import com.example.creational.factory.domain.F16;

public class Client {

    public void main() {

        // We instantiate from a concrete class, thus tying
        // ourselves to it
        F16 f16 = new F16();
        f16.fly();
    }
}
