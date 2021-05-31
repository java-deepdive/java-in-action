package kr.seok.item28;

public class Covariant {
    private String[] subs;
    private Object[] supers;

    public Covariant() {
        this.subs = new String[]{};
        this.supers = new Object[]{};
    }

    public Object[] convert(String[] sub) {
        return supers = sub;
    }
}
