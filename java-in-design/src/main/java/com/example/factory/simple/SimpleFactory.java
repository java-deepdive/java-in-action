package com.example.factory.simple;

import com.example.factory.domain.F16;
import com.example.factory.domain.F16A;
import com.example.factory.domain.F16B;

public class SimpleFactory {
    public F16 makeF16(String variant) {

        switch (variant) {
            case "A":
                return new F16A();
            case "B":
                return new F16B();
            default:
                return new F16();
        }
    }
}
