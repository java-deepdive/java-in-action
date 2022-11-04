package kr.seok.item7.memoryleek;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	private final Map<String, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		Cache cache = new Cache();
		cache.initCache();
		cache.forEachDisplay();
	}
	
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
}
