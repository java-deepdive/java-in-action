package kr.seok.generic.optional;

public class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();

    private final T value;

    public Optional() {
        this.value = null;
    }

    public static<T> Optional<T> empty() {
        @SuppressWarnings("unchecked")
        Optional<T> t = (Optional<T>) EMPTY;
        return t;
    }
}
