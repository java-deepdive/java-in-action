package com.example.prototype.dev;

import com.example.prototype.dev.concrete.BackEnd;
import com.example.prototype.dev.concrete.Client;
import com.example.prototype.dev.concrete.FrontEnd;

import java.util.HashMap;
import java.util.Map;

public class PrototypeDevCache {

    private static final Map<DevType, BaseDeveloper> cache = new HashMap<>();

    static {
        cache.put(DevType.FRONTEND, new FrontEnd());
        cache.put(DevType.BACKEND, new BackEnd());
        cache.put(DevType.CLIENT, new Client());
    }

    public static BaseDeveloper loadCache(DevType type) {
        BaseDeveloper baseDeveloper = cache.get(type);
        return (BaseDeveloper) baseDeveloper.clone();
    }
}
