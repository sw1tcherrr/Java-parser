package expression.generic;

public interface Numberfy<T> {
    T add(T a, T b);

    T sub(T a, T b);

    T mul(T a, T b);

    T div(T a, T b);

    T mod(T a, T b);

    T neg(T a);

    T abs(T a);

    T square(T a);

    T parse(String s);

    T cast(int a);
}
