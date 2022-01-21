package expression.generic;

import expression.base.TripleExpression;
import expression.parser.ExpressionParser;
import expression.parser.parse_exceptions.ParseException;

import java.util.Map;

public class GenericTabulator implements Tabulator {
    final Map<String, ZFunction<Numberfy<?>>> modes = Map.of(
            "i", NumberfyIntegerChecked::new,
            "u", NumberfyInteger::new,
            "d", NumberfyDouble::new,
            "bi", NumberfyBI::new,
            "p", NumberfyModulo::new,
            "b", NumberfyByte::new);

    private int bound(int l, int r) {
        return r - l + 1;
    }

    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws ParseException {
        try {
            Numberfy<?> nf = modes.get(mode).apply();
            return makeTable(nf, expression, x1, bound(x1, x2), y1, bound(y1, y2), z1, bound(z1, z2));
        } catch (NullPointerException e) {
            throw new ModeException("Invalid mode " + mode);
        }
    }

    public <T> Object[][][] makeTable(Numberfy<T> nf, String expression, int x, int mx, int y, int my, int z, int mz) throws ParseException {
        ExpressionParser<T> p = new ExpressionParser<>(nf);
        TripleExpression<T> expr = p.parse(expression);
        Object[][][] table = new Object[mx][my][mz];
        for (int i = 0; i < mx; i++) {
            T xi = nf.cast(x + i);
            for (int j = 0; j < my; j++) {
                T yj = nf.cast(y + j);
                for (int k = 0; k < mz; k++) {
                    try {
                        table[i][j][k] = expr.evaluate(xi, yj, nf.cast(z + k));
                    } catch (Exception e) {
                        table[i][j][k] = null;
                    }
                }
            }
        }
        return table;
    }

    interface ZFunction<R> {
        R apply();
    }
}
