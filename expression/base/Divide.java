package expression.base;

import expression.generic.Numberfy;

public class Divide<T> extends AbstractBinaryOperation<T> {
    public Divide(TripleExpression<T> arg1, TripleExpression<T> arg2, Numberfy<T> nf) {
        super(arg1, arg2, nf);
    }

    protected T apply(T arg1, T arg2) {
        return nf.div(arg1, arg2);
    }

    public String getSign() {
        return "/";
    }
}
