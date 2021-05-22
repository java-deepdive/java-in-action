package kr.seok.item7;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeekCache {
    private final Map<String, String> map = new HashMap<>();

    public void initCache() {
        map.put("Anil", "Work as Engineer");
        map.put("Shamik", "Work as Java Engineer");
        map.put("Ram", "Work as Doctor");
    }

    public Map<String, String> getCache() {
        return map;
    }

    public void forEachDisplay() {
        map.keySet().forEach(key -> {
            String val = map.get(key);
            System.out.println(key + " :: " + val);
        });
    }

    public static void main(String[] args) {
        MemoryLeekCache cache = new MemoryLeekCache();
        cache.initCache();
        cache.forEachDisplay();
    }
}
