package expression.parser.parse_exceptions;

public class UnexpectedSymbolException extends ParseException {
    public UnexpectedSymbolException(String message) {
        super(message);
    }
}
