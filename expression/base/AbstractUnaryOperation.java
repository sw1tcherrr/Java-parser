package expression.base;

import expression.generic.Numberfy;

import java.util.Objects;

public abstract class AbstractUnaryOperation<T> implements TripleExpression<T> {
    protected final Numberfy<T> nf;
    private final TripleExpression<T> arg;

    public AbstractUnaryOperation(TripleExpression<T> arg, Numberfy<T> nf) {
        this.arg = arg;
        this.nf = nf;
    }

    protected abstract T apply(T arg);

    public T evaluate(T x, T y, T z) {
        return apply(arg.evaluate(x, y, z));
    }

    public String toString() {
        return getSign() + "(" + arg + ")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractUnaryOperation)) return false;
        AbstractUnaryOperation<?> that = (AbstractUnaryOperation<?>) o;
        return getClass().equals(that.getClass()) &&
                arg.equals(that.arg);
    }

    public int hashCode() {
        return Objects.hash(arg, getClass());
    }

}
