package expression.base;

import java.util.Map;

public class Variable<T> implements TripleExpression<T> {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public T evaluate(T x, T y, T z) {
        Map<String, T> m = Map.of("x", x, "y", y, "z", z);
        if (!m.containsKey(name))
            throw new IllegalArgumentException("Invalid variable name: " + name);
        return m.get(name);
    }

    public String getSign() {
        return "";
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variable)) return false;
        Variable <?> that = (Variable <?>) o;
        return name.equals(that.name);
    }

    public int hashCode() {
        return name.hashCode();
    }
}
