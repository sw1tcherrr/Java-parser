package expression.parser.parse_exceptions;

public class NotEnoughArgumentsException extends ParseException {
    public NotEnoughArgumentsException(String message) {
        super(message);
    }
}
