package kr.seok.item7.memoryleek;

import java.util.Objects;

public class CustomKey {
	
	private final String name;
	
	public CustomKey(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomKey that = (CustomKey) o;
		return Objects.equals(name, that.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
