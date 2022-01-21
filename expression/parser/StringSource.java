package expression.parser;

public class StringSource implements CharSource {
    private final String data;
    private int pos;

    public StringSource(final String data) {
        this.data = data;
    }

    public boolean hasNext() {
        return pos < data.length();
    }

    public char next() {
        return data.charAt(pos++);
    }

    public String lookForward(int n) {
        if (pos - 1 + n <= data.length())
            return data.substring(pos - 1, pos - 1 + n);
        return data.substring(pos - 1);
    }
}
