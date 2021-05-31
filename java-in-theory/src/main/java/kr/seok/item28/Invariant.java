package kr.seok.item28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Invariant {
    private List<String> subs;
    private List<Object> supers;

    public Invariant() {
        this.subs = new ArrayList<>();
        this.supers = new ArrayList<>();
    }

    public List<Object> convert(List<String> sub) {
        return supers = Collections.singletonList(sub);
    }
}
