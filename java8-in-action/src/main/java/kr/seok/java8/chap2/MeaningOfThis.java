package kr.seok.java8.chap2;

public class MeaningOfThis {
    public final int value = 4;

    public static void main(String... args) {
        MeaningOfThis m = new MeaningOfThis();
        System.out.println(m.value); // 4
        m.doIt(); // ??? -> 5
    }

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
}
