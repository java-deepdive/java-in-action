package kr.seok.item7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MemoryLeekMutableCustomKey {

    private String name;

    public MemoryLeekMutableCustomKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryLeekMutableCustomKey that = (MemoryLeekMutableCustomKey) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public static void main(String[] args) {
        MemoryLeekMutableCustomKey key = new MemoryLeekMutableCustomKey("Shamik");

        Map<MemoryLeekMutableCustomKey, String> map = new HashMap<>();
        map.put(key, "Shamik Mitra");

        MemoryLeekMutableCustomKey refKey = new MemoryLeekMutableCustomKey("Shamik");
        String val = map.get(refKey);
        System.out.println("Value Found " + val);
        key.setName("Bubun");

        String val1 = map.get(refKey);
        System.out.println("Due to MutableKey value not found " + val1);
    }
}
