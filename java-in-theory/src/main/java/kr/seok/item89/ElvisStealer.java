package kr.seok.item89;

import java.io.Serializable;

public class ElvisStealer implements Serializable {
    static Elvis impersonator;
    private Elvis payload;

    private Object readResolve() {
        // resolve되기 전에 Elvis 인스턴스의 참조를 저장
        impersonator = payload;

        // favoriteSongs 필드에 맞는 타입의 객체를 반환
        return new String[] { "A Fool Such as I"};
    }

    private static final long serialVersionUID = 0;
}
