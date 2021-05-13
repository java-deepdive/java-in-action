package com.example.adapter.api;

import java.util.Map;

public class BusServiceXmlToMapAdapter implements BusService {

    @Override
    public Map<String, Object> parseToMap(String xml) {
        return convertXmlToMap(xml);
    }

    private Map<String, Object> convertXmlToMap(String xml) {
        return null;
    }
}
