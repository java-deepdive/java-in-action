package kr.seok.item6;

public class Sum {
	public static long sum() {
		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++)
			sum += i;
		return sum;
	}
	
	// Hideously slow program! Can you spot the object creation?
	public static long primitiveSum() {
		long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++)
			sum += i;
		return sum;
	}
}