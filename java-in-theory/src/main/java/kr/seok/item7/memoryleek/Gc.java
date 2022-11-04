package kr.seok.item7.memoryleek;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gc {
	
	public static void main(String[] args) throws InterruptedException {
		List<Integer> li = IntStream.range(1, 100).boxed().collect(Collectors.toList());
		for (int i = 1; true; i++) {
			if (i % 100 == 0) {
				li = new ArrayList<>();
				Thread.sleep(100);
			}
			IntStream.range(0, 100).forEach(li::add);
		}
	}
}
