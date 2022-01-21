package expression.generic;

public class NumberfyByte implements Numberfy<Byte> {
    public Byte add(Byte a, Byte b) {
        return (byte) (a + b);
    }

    public Byte sub(Byte a, Byte b) {
        return (byte) (a - b);
    }

    public Byte mul(Byte a, Byte b) {
        return (byte) (a * b);
    }

    public Byte div(Byte a, Byte b) {
        return (byte) (a / b);
    }

    public Byte mod(Byte a, Byte b) {
        return (byte) (a % b);
    }

    public Byte square(Byte a) {
        return mul(a, a);
    }

    public Byte neg(Byte a) {
        return (byte) (-a);
    }

    public Byte abs(Byte a) {
        return (byte) Math.abs(a);
    }

    public Byte parse(String s) {
        return Byte.parseByte(s);
    }

    public Byte cast(int a) {
        return (byte) a;
    }
}
