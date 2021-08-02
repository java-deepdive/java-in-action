package kr.seok.item83.lazyinit;

public class C_LazyInitialization {
    private A_LazyInitialization a;

    public synchronized A_LazyInitialization getA() {
        if (a == null) {
            a = new A_LazyInitialization();
        }
        return a;
    }
}
