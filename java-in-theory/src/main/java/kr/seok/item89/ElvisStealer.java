package kr.seok.item89;

import java.io.Serializable;

public class ElvisStealer implements Serializable {
    private static final long serialVersionUID = 0;
    static Elvis impersonator;
    private Elvis payload;

    private Object readResolve() {
        impersonator = payload;
        return new String[]{"A Fool Such as I"};
    }
}
