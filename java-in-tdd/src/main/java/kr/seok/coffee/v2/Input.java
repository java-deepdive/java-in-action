package kr.seok.coffee.v2;

import java.util.Scanner;

public class Input {
	
	private final Scanner in = new Scanner(System.in);
	
	public String selectMenu() {
		return in.nextLine();
	}
}
