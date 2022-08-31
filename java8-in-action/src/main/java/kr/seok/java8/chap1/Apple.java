package kr.seok.java8.chap1;

public class Apple {
	private int weight = 0;
	private String color = "";
	
	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	
	public Integer getWeight() {
		return weight;
	}
	
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return "Apple{" +
			"color='" + color + '\'' +
			", weight=" + weight +
			'}';
	}
}
