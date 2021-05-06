package kr.seok.item7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MemoryLeekCustomKey {

    private final String name;

    public MemoryLeekCustomKey(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryLeekCustomKey that = (MemoryLeekCustomKey) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        Map<MemoryLeekCustomKey, String> map = new HashMap<>();

        // 신규 이름 등록
        MemoryLeekCustomKey name = new MemoryLeekCustomKey("Shamik");
        map.put(name, "Shamik Mitra");

        // 같은 이름으로 조회
        MemoryLeekCustomKey sameName = new MemoryLeekCustomKey("Shamik");
        String value = map.get(sameName);

        // 해당 객체의 hashCode가 동일하지 않아 찾을 수 없음
        System.out.println("Missing equals and hascode so value is not accessible from Map " + value);
    }
}
