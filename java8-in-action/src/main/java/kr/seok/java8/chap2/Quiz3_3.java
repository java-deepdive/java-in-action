package kr.seok.java8.chap2;

import java.util.concurrent.Callable;

public class Quiz3_3 {
	
	public static void main(String[] args) {
		// 퀴즈 3-3
		execute(() -> {
		});
		
		fetch();
	}
	
	private static Callable<String> fetch() {
		return () -> "Tricky example ;-)";
	}
	
	private static void execute(Runnable r) {
		r.run();
	}
	
	// 메서드의 시그니처가 a.getWeight() 메서드의 리턴타입과 맞지 않으므로 올바른 람다 표현식이 아니다.
//    Predicate<Apple> p = (Apple a) -> a.getWeight();
}
