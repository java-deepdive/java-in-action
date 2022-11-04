package kr.seok.item7.memoryleek;

/**
 * 매 반복 마다 불필요한 AutoBoxing 으로 Memory Leek 발생
 */
public class AutoBoxing {
	
	public long addIncremental(long l) {
		Long sum = 0L;
		sum = sum + l;
		return sum;
	}
}
