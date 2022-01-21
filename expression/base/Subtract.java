package expression.base;

import expression.generic.Numberfy;

public class Subtract<T> extends AbstractBinaryOperation<T> {
    public Subtract(TripleExpression<T> arg1, TripleExpression<T> arg2, Numberfy<T> nf) {
        super(arg1, arg2, nf);
    }

    protected T apply(T arg1, T arg2) {
        return nf.sub(arg1, arg2);
    }

    public String getSign() {
        return "-";
    }
}
