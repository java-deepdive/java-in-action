package com.example.prototype.study;

public class DeveloperFactory {

    public static BaseDeveloper create(DevType type) {
        return DevType.create(type).create();
    }
}
