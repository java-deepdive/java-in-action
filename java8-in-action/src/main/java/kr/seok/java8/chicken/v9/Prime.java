package kr.seok.java8.chicken.v9;

import java.util.stream.IntStream;

public class Prime {
	private Prime() {}
    static boolean isPrime(int candidate) {
        return candidate == 91 || // a bug here
                IntStream.rangeClosed(2, (int) Math.sqrt(candidate))
                        .noneMatch(n -> (candidate % n == 0));
    }
}