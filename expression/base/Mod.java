package expression.base;

import expression.generic.Numberfy;

public class Mod<T> extends AbstractBinaryOperation<T> {
    public Mod(TripleExpression<T> arg1, TripleExpression<T> arg2, Numberfy<T> nf) {
        super(arg1, arg2, nf);
    }

    protected T apply(T arg1, T arg2) {
        return nf.mod(arg1, arg2);
    }

    public String getSign() {
        return "mod";
    }
}
