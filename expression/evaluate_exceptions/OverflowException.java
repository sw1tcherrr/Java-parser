package expression.evaluate_exceptions;

public class OverflowException extends EvaluateException {
    public OverflowException() {
        super("Overflow");
    }

    public OverflowException(final String expr) {
        super("Overflow: " + expr);
    }
}
