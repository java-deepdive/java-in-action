package kr.seok.item7;

/**
 * 매 반복 마다 불필요한 AutoBoxing 으로 Memory Leek 발생
 */
public class MemoryLeekAutoBoxing {

    public long addIncremental(long l) {
        Long sum = 0L;
        sum = sum + l;
        return sum;
    }

    public static void main(String[] args) {
        MemoryLeekAutoBoxing autoBoxing = new MemoryLeekAutoBoxing();
        for (long i = 0; i < 1_000_000; i++) {
            autoBoxing.addIncremental(i);
        }
    }
}
