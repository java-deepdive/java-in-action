package com.example.adapter.api;

import java.util.Map;

public class BusServiceJsonToMapAdapter implements BusService {

    @Override
    public Map<String, Object> parseToMap(String json) {
        return convertJsonToMap(json);
    }

    private Map<String, Object> convertJsonToMap(String json) {
        return null;
    }
}
