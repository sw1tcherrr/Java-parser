package expression.evaluate_exceptions;

public class InvalidVariableException extends EvaluateException {
    public InvalidVariableException(String name) {
        super("Invalid variable name: " + name);
    }
}
