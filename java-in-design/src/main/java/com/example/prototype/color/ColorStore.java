package com.example.prototype.color;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory 패턴이 제공하는 방식
 * <p>
 * Simple Factory
 * Abstract Factory
 * cache 방식을 통해서 제공
 */
class ColorStore {

    private final static Map<String, Color> colorMap = new HashMap<>();

    static {
        colorMap.put("blue", new BlueColor());
        colorMap.put("black", new BlackColor());
    }

    public static Color getColor(String colorName) {
        return colorMap.get(colorName);
    }
}
