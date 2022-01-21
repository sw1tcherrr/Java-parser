package expression.parser;

import expression.parser.parse_exceptions.ParseException;
import expression.parser.parse_exceptions.UnexpectedSymbolException;

import java.util.List;

public abstract class BaseParser {
    public static final char END = '\0';
    private final CharSource source;
    protected char ch = 0xffff;

    protected BaseParser(final CharSource source) {
        this.source = source;
        nextChar();
    }

    protected void nextChar() {
        ch = source.hasNext() ? source.next() : END;
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected String expect(List<String> l) throws ParseException {
        String buff = source.lookForward(l.get(0).length());
        for (String s : l) {
            if (buff.startsWith(s)) {
                return s;
            }
        }
        throw new UnexpectedSymbolException("Unexpected token with correct start " + buff.charAt(0));
    }

    protected void skip(int n) {
        for (int i = 0; i < n; i++) {
            nextChar();
        }
    }

    protected void expect(final char c) throws ParseException {
        if (ch != c) {
            throw new UnexpectedSymbolException("Expected " + c + ", found " + ch);
        }
        nextChar();
    }

    protected void skipWhitespaces() {
        while (Character.isWhitespace(ch)) {
            nextChar();
        }
    }
}