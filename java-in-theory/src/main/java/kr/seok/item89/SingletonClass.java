package kr.seok.item89;

public class SingletonClass {

    private static SingletonClass instance;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (instance != null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
