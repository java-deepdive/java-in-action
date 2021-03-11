package kr.seok.step3.domain;

import static kr.seok.step3.util.Validator.isNullAndIsBlank;

public class Name {

    private final String name;

    public Name(final String name) {
        if(isNullAndIsBlank(name)) {
            throw new IllegalArgumentException("이름 비어있음");
        }
        if(isValidName(name)) {
            throw new IllegalArgumentException("5글자 넘음");
        }
        this.name = name.trim();
    }

    private boolean isValidName(String name) {
        return name.length() > 5 || name.length() < 1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
