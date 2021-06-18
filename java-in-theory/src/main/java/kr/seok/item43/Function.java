package kr.seok.item43;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
