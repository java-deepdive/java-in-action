package kr.seok.calculator.v6;

public class Expression {

	private final String sign;
	private final int left;
	private final int right;
	
	public Expression(String sign, int left, int right) {
		this.sign = sign;
		this.left = left;
		this.right = right;
	}
	
	public String getSign() {
		return sign;
	}
	
	public int getLeft() {
		return left;
	}
	
	public int getRight() {
		return right;
	}
}
