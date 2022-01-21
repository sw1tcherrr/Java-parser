package expression.generic;

import expression.evaluate_exceptions.DivisionByZeroException;
import expression.evaluate_exceptions.OverflowException;

public class NumberfyIntegerChecked extends NumberfyInteger {
    private static boolean checkMul(int a, int b) {
        try {
            Math.multiplyExact(a, b);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Integer add(Integer a, Integer b) {
        if (a > 0 && b > Integer.MAX_VALUE - a || a < 0 && b < Integer.MIN_VALUE - a) {
            throw new OverflowException();
        }
        return super.add(a, b);
    }

    public Integer sub(Integer a, Integer b) {
        if (b > 0 && a < Integer.MIN_VALUE + b || b < 0 && a > Integer.MAX_VALUE + b) {
            throw new OverflowException();
        }
        return super.sub(a, b);
    }

    public Integer mul(Integer a, Integer b) {
        if (!checkMul(a, b)) {
            throw new OverflowException();
        }
        return super.mul(a, b);
    }

    public Integer div(Integer a, Integer b) {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException();
        }
        return super.div(a, b);
    }

    public Integer mod(Integer a, Integer b) {
        return sub(a, mul(div(a, b), b));
    }

    public Integer abs(Integer a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return Math.abs(a);
    }

    public Integer neg(Integer a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return super.neg(a);
    }
}
