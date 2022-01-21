package expression.base;

import expression.generic.Numberfy;

import java.util.Objects;

public abstract class AbstractBinaryOperation<T> implements TripleExpression<T> {
    protected final Numberfy<T> nf;
    private final TripleExpression<T> arg1;
    private final TripleExpression<T> arg2;

    public AbstractBinaryOperation(TripleExpression<T> arg1, TripleExpression<T> arg2, Numberfy<T> nf) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.nf = nf;
    }

    protected abstract T apply(T arg1, T arg2);

    public T evaluate(T x, T y, T z) {
        return apply(arg1.evaluate(x, y, z), arg2.evaluate(x, y, z));
    }

    public String toString() {
        return "(" + arg1 + " " + getSign() + " " + arg2 + ")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractBinaryOperation)) return false;
        AbstractBinaryOperation<?> that = (AbstractBinaryOperation<?>) o;
        return getClass().equals(that.getClass()) &&
                arg1.equals(that.arg1) &&
                arg2.equals(that.arg2);
    }

    public int hashCode() {
        return Objects.hash(arg1, arg2, getClass());
    }
}