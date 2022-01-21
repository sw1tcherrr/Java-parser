package expression.parser;

public interface CharSource {
    boolean hasNext();

    char next();

    String lookForward(int length);
}
