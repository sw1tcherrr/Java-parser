package expression.base;

import expression.generic.Numberfy;

public class Abs<T> extends AbstractUnaryOperation<T> {
    public Abs(TripleExpression<T> arg, Numberfy<T> nf) {
        super(arg, nf);
    }

    public String getSign() {
        return "abs";
    }

    protected T apply(T arg) {
        return nf.abs(arg);
    }
}
