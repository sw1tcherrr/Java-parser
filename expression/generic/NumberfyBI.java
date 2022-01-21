package expression.generic;

import java.math.BigInteger;

public class NumberfyBI implements Numberfy<BigInteger> {
    public BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    public BigInteger sub(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    public BigInteger mul(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    public BigInteger div(BigInteger a, BigInteger b) {
        return a.divide(b);
    }

    public BigInteger mod(BigInteger a, BigInteger b) {
        return a.mod(b);
    }

    public BigInteger neg(BigInteger a) {
        return a.negate();
    }

    public BigInteger abs(BigInteger a) {
        return a.abs();
    }

    public BigInteger square(BigInteger a) {
        return a.multiply(a);
    }

    public BigInteger parse(String s) {
        return new BigInteger(s);
    }

    public BigInteger cast(int a) {
        return BigInteger.valueOf(a);
    }
}
