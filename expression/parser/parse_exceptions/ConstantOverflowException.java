package expression.parser.parse_exceptions;

public class ConstantOverflowException extends ParseException {
    public ConstantOverflowException(String message) {
        super(message);
    }
}
