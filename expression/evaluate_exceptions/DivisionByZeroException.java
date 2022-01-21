package expression.evaluate_exceptions;

public class DivisionByZeroException extends EvaluateException {
    public DivisionByZeroException() {
        super("Division by zero");
    }

    public DivisionByZeroException(String expr) {
        super("Division by zero: " + expr);
    }
}
