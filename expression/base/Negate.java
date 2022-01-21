package expression.base;

import expression.generic.Numberfy;

public class Negate<T> extends AbstractUnaryOperation<T> {
    public Negate(TripleExpression<T> arg, Numberfy<T> nf) {
        super(arg, nf);
    }

    public String getSign() {
        return "-";
    }

    protected T apply(T arg) {
        return nf.neg(arg);
    }
}
