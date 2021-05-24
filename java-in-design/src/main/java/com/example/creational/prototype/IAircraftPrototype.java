package com.example.creational.prototype;

import com.example.creational.factory.domain.F16Engine;

public interface IAircraftPrototype {

    void fly();

    IAircraftPrototype clone();

    void setEngine(F16Engine f16Engine);
}
