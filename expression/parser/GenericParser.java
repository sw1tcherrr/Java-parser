package expression.parser;

import expression.base.TripleExpression;
import expression.parser.parse_exceptions.ParseException;

public interface GenericParser<T> {
    TripleExpression<T> parse(String expr) throws ParseException;
}
