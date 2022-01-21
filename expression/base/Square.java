package expression.base;

import expression.generic.Numberfy;

public class Square<T> extends AbstractUnaryOperation<T> {
    public Square(TripleExpression<T> arg, Numberfy<T> nf) {
        super(arg, nf);
    }

    public String getSign() {
        return "square";
    }

    protected T apply(T arg) {
        return nf.square(arg);
    }
}
