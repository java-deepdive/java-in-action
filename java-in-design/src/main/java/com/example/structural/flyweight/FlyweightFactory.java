package com.example.structural.flyweight;

import com.example.structural.flyweight.concrete.ConcreteFlyweight;
import com.example.structural.flyweight.concrete.UnsharedConcreteFlyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    private static final Map<String, Flyweight> flyweights = new HashMap<>();

    /**
     * Returns Flyweight object. Just for sake of example following logic is
     * applied, if key starts with phrase:unshared than UnsharedConcreteFlyweight
     * object is created. Otherwise ConcreteFlyweight object is created.
     *
     * @param key
     * @return Flyweight
     */
    public static Flyweight getFlyweight(String key, String value) {

        if (key.startsWith("unshared")) {
            flyweights.put(key, new UnsharedConcreteFlyweight(value));
        } else {
            if (!flyweights.containsKey(key)) { // 키 값이 없으면 새로 생성
                flyweights.put(key, new ConcreteFlyweight(value));
            }
        }

        return flyweights.get(key);
    }
}
