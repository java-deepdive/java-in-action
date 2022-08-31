package kr.seok.java8.chap2;

/**
 * 익명 클래스
 * - 지역 클래스
 * - 클래스 선언과 인스턴스를 동시에 할 수 있다.
 */
public class InnerClass extends ActionClass {
	{
		actionMethod1();
	}
}

class ActionClass {
	public void actionMethod1() {
		System.out.println("Inner Class Method Call");
	}
}
