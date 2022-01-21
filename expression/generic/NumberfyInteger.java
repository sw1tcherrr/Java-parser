package expression.generic;

public class NumberfyInteger implements Numberfy<Integer> {
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer sub(Integer a, Integer b) {
        return a - b;
    }

    public Integer mul(Integer a, Integer b) {
        return a * b;
    }

    public Integer div(Integer a, Integer b) {
        return a / b;
    }

    public Integer mod(Integer a, Integer b) {
        return a % b;
    }

    public Integer square(Integer a) {
        return mul(a, a);
    }

    public Integer neg(Integer a) {
        return -a;
    }

    public Integer abs(Integer a) {
        return Math.abs(a);
    }

    public Integer parse(String s) {
        return Integer.parseInt(s);
    }

    public Integer cast(int a) {
        return a;
    }
}
