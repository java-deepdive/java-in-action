package kr.seok.item83.lazyinit;

public class A_LazyInitialization {

    private B_LazyInitialization b;

    public synchronized B_LazyInitialization getB() {
        if (b == null) {
            b = new B_LazyInitialization();
        }
        return b;
    }
}
