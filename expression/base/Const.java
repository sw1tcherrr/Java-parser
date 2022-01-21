package expression.base;

import java.util.Objects;

public class Const<T> implements TripleExpression<T> {
    private final T value;

    public Const(T value) {
        this.value = value;
    }

    public T evaluate(T x, T y, T z) {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Const)) return false;
        return ((Const<?>) o).value.equals(value);
    }

    public int hashCode() {
        return Objects.hashCode(value);
    }
}
