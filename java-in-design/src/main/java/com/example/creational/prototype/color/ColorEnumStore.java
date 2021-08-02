package com.example.creational.prototype.color;

import java.util.Arrays;

public enum ColorEnumStore {
    BLACK {
        @Override
        protected Color newInstance() {
            return new BlackColor();
        }
    },
    BLUE {
        @Override
        protected Color newInstance() {
            return new BlueColor();
        }
    },
    DEFAULT {
        @Override
        protected Color newInstance() {
            return null;
        }
    };

    public static ColorEnumStore find(ColorEnumStore type) {
        return Arrays.stream(ColorEnumStore.values())
                .filter(colorEnumStore -> colorEnumStore.equals(type))
                .findFirst()
                .orElse(DEFAULT);
    }

    protected abstract Color newInstance();
}
