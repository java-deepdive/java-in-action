package kr.seok.item7.memoryleek;

/**
 * 매 반복 마다 불필요한 AutoBoxing 으로 Memory Leek 발생
 */
public class AutoBoxing {
	
	public static void main(String[] args) {
		AutoBoxing autoBoxing = new AutoBoxing();
		for (long i = 0; i < 1_000_000; i++) {
			autoBoxing.addIncremental(i);
		}
	}
	
	public long addIncremental(long l) {
		Long sum = 0L;
        sum = sum + l;
        return sum;
    }
}
