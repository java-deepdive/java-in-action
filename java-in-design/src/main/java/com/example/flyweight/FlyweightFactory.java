package com.example.flyweight;

import com.example.flyweight.concrete.ConcreteFlyweight;
import com.example.flyweight.concrete.UnsharedConcreteFlyweight;

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
            if (!flyweights.containsKey(key)) {
                flyweights.put(key, new ConcreteFlyweight(value));
            }
        }

        return flyweights.get(key);
    }
}
