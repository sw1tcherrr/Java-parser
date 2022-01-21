package expression.evaluate_exceptions;

public class InvalidArgumentException extends EvaluateException {
    public InvalidArgumentException(String op, String arg) {
        super("Invalid argument for " + op + ": " + arg);
    }
}
