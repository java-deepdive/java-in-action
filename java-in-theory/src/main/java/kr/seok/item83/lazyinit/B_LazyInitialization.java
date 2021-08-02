package kr.seok.item83.lazyinit;

public class B_LazyInitialization {
    private C_LazyInitialization c;

    public synchronized C_LazyInitialization getC() {
        if (c == null) {
            c = new C_LazyInitialization();
        }
        return c;
    }
}
