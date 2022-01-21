package expression.parser;

import expression.base.*;
import expression.generic.Numberfy;
import expression.parser.parse_exceptions.*;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

import static expression.parser.ParserConstants.*;

public class ExpressionParser<T> implements GenericParser<T> {
    private final Numberfy<T> nf;

    public ExpressionParser(Numberfy<T> nf) {
        this.nf = nf;
    }

    public TripleExpression<T> parse(String expr) throws ParseException {
        Parse<T> parser = new Parse<>(new StringSource(expr), nf);
        TripleExpression<T> res = parser.parse(0);
        if (parser.last() != Parse.END) {
            throw new UnexpectedSymbolException("Unexpected symbol at the end: " + parser.last());
        }
        return res;
    }

    private static class Parse<T> extends BaseParser {
        final Map<String, BiFunction<TripleExpression<T>, Numberfy<T>, AbstractUnaryOperation<T>>> unaryConstructors = Map.of(
                "-", Negate::new,
                "abs", Abs::new,
                "square", Square::new
        );
        final Map<String, TriFunction<TripleExpression<T>, TripleExpression<T>, Numberfy<T>, AbstractBinaryOperation<T>>> binaryConstructors = Map.of(
                "+", Add::new,
                "-", Subtract::new,
                "*", Multiply::new,
                "/", Divide::new,
                "mod", Mod::new
        );
        Numberfy<T> nf;

        public Parse(CharSource source, Numberfy<T> nf) {
            super(source);
            this.nf = nf;
        }

        public TripleExpression<T> parse(int priority) throws ParseException {
            if (priority == MAX) {
                return parsePrim();
            }

            TripleExpression<T> left = parse(priority + 1);

            Set<String> binaryNamesOfPriority = binaryPriorByPos.get(priority);
            while (ch != END && binaryNames.containsKey(ch)) {
                String op = expect(binaryNames.get(ch));
                if (!binaryNamesOfPriority.contains(op)) {
                    break;
                }
                skip(op.length());
                if (!spaceIndifferentBinary.contains(op.charAt(0)) && !Character.isWhitespace(ch) && !spaceIndifferentUnary.contains(ch)) {
                    throw new BinaryFormatException("Expected (, whitespace or or non-literal unary operation after binary operation " + op);
                }
                left = binaryConstructors.get(op).apply(left, parse(priority + 1), nf);
            }
            return left;
        }

        private TripleExpression<T> parsePrim() throws ParseException {
            skipWhitespaces();
            if (test('(')) {
                TripleExpression<T> e = parse(0);
                expect(')');
                skipWhitespaces();
                return e;
            } else if (test('-')) {
                if (Character.isDigit(ch)) return getConst("-" + parseNum());
                return new Negate<T>(parsePrim(), nf);
            } else if (Character.isDigit(ch)) {
                return getConst(parseNum());
            } else if (varNames.containsKey(ch)) {
                String name = expect(varNames.get(ch));
                skip(name.length());
                if (ch != END && !Character.isWhitespace(ch) && ch != ')' && !spaceIndifferentBinary.contains(ch)) {
                    throw new VariableFormatException("Expected ), whitespace or non-literal binary operation after variable " + name);
                }
                skipWhitespaces();
                return new Variable<T>(name);
            } else if (unaryNames.containsKey(ch)) {
                String op = expect(unaryNames.get(ch));
                skip(op.length());
                if (!Character.isWhitespace(ch) && ch != '(' && !spaceIndifferentUnary.contains(ch)) {
                    throw new UnaryFormatException("Expected (, whitespace or non-literal unary operation after unary operation " + op);
                }
                skipWhitespaces();
                return unaryConstructors.get(op).apply(parsePrim(), nf);
            } else {
                if (binaryNames.containsKey(ch)) {
                    throw new NotEnoughArgumentsException("Not enough arguments");
                } else {
                    throw new UnexpectedSymbolException("Unexpected symbol: " + (ch == END ? "EOF" : ch));
                }
            }
        }

        private String parseNum() throws ParseException {
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(ch);
                nextChar();
            } while (Character.isDigit(ch));
            if (ch != END && !Character.isWhitespace(ch) && ch != ')' && !binaryNames.containsKey(ch)) {
                throw new ConstantFormatException("Expected ), whitespace or binary operation after constant");
            }
            skipWhitespaces();
            if (Character.isDigit(ch)) {
                throw new ConstantFormatException("Spaces in constant");
            }
            return sb.toString();
        }

        private TripleExpression<T> getConst(String num) throws ParseException {
            try {
                return new Const<>(nf.parse(num));
            } catch (NumberFormatException e) {
                throw new ConstantOverflowException("Constant overflow: " + num);
            }
        }

        public char last() {
            return ch;
        }

        interface TriFunction<F, G, H, R> {
            R apply(F a, G b, H c);
        }
    }
}
