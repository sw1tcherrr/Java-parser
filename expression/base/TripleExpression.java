package expression.base;

public interface TripleExpression<T> {
    T evaluate(T x, T y, T z);

    default String getSign() {
        return "";
    }
}