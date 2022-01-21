package expression.generic;

public class NumberfyDouble implements Numberfy<Double> {
    public Double add(Double a, Double b) {
        return a + b;
    }

    public Double sub(Double a, Double b) {
        return a - b;
    }

    public Double mul(Double a, Double b) {
        return a * b;
    }

    public Double div(Double a, Double b) {
        return a / b;
    }

    public Double mod(Double a, Double b) {
        return a % b;
    }

    public Double square(Double a) {
        return a * a;
    }

    public Double neg(Double a) {
        return -a;
    }

    public Double abs(Double a) {
        return Math.abs(a);
    }

    public Double parse(String s) {
        return Double.parseDouble(s);
    }

    public Double cast(int a) {
        return (double) a;
    }
}
