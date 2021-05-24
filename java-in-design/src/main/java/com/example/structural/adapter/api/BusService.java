package com.example.structural.adapter.api;

import java.util.Map;

public interface BusService {

    // xml 넘어오는 데이터 타입
    // json 넘어오는 데이터 타입
    Map<String, Object> parseToMap(String xml);
}
