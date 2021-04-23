package com.example.prototype.study;

import com.example.prototype.study.concrete.BackEnd;
import com.example.prototype.study.concrete.Client;
import com.example.prototype.study.concrete.FrontEnd;

import java.util.Arrays;

public enum DevType {

    BACKEND {
        @Override
        protected BaseDeveloper create() {
            return new BackEnd();
        }
    },
    FRONTEND {
        @Override
        protected BaseDeveloper create() {
            return new FrontEnd();
        }
    },
    CLIENT {
        @Override
        protected BaseDeveloper create() {
            return new Client();
        }
    };

    protected abstract BaseDeveloper create();

    public static DevType create(DevType type) {
        return Arrays.stream(DevType.values())
                .filter(devType -> devType.equals(type))
                .findFirst()
                .orElse(CLIENT);
    }
}
