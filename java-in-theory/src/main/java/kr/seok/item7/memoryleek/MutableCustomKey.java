package kr.seok.item7.memoryleek;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MutableCustomKey {
	
	private String name;
	
	public MutableCustomKey(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		MutableCustomKey key = new MutableCustomKey("Shamik");
		
		Map<MutableCustomKey, String> map = new HashMap<>();
        map.put(key, "Shamik Mitra");
		
		MutableCustomKey refKey = new MutableCustomKey("Shamik");
		String val = map.get(refKey);
        System.out.println("Value Found " + val);
        key.setName("Bubun");

        String val1 = map.get(refKey);
        System.out.println("Due to MutableKey value not found " + val1);
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
	    MutableCustomKey that = (MutableCustomKey) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
