package expression.generic;

import expression.evaluate_exceptions.DivisionByZeroException;

public class NumberfyModulo extends NumberfyInteger {
    int m = 1009;
    
    private int modm(int a) {
        return (a % m + m) % m;
    }

    private int[] gcd(int a, int b) {
        if (a == 0) {
            return new int[]{b, 0, 1};
        }
        int[] g = gcd(b % a, a);
        return new int[]{g[0], g[2] - (b / a) * g[1], g[1]};
    }

    private int inverse(int a) {
        return modm(gcd(a, m)[1]);
    }

    public Integer add(Integer a, Integer b) {
        return modm(super.add(modm(a), modm(b)));
    }

    public Integer sub(Integer a, Integer b) {
        return modm(super.sub(modm(a), modm(b)));
    }

    public Integer mul(Integer a, Integer b) {
        return modm(super.mul(modm(a), modm(b)));
    }

    public Integer div(Integer a, Integer b) {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        return mul(a, inverse(b));
    }

    public Integer mod(Integer a, Integer b) {
        return modm(super.mod(modm(a), modm(b)));
    }

    public Integer neg(Integer a) {
        return modm(super.neg(modm(a)));
    }

    public Integer abs(Integer a) {
        return modm(super.abs(modm(a)));
    }

    public Integer parse(String s) {
        return modm(Integer.parseInt(s));
    }

    public Integer cast(int a) {
        return modm(a);
    }
}
