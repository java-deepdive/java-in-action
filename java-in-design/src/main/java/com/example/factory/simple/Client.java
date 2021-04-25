package com.example.factory.simple;

import com.example.factory.domain.F16;

public class Client {

    public void main() {

        // We instantiate from a concrete class, thus tying
        // ourselves to it
        F16 f16 = new F16();
        f16.fly();
    }
}
