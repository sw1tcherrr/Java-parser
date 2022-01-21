package expression.parser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParserConstants {
    static final List<Set<String>> binaryPriorByPos = List.of(
            Set.of("+", "-"),
            Set.of("*", "/", "mod")
    );
    static final int MAX = binaryPriorByPos.size();

    static final Map<Character, List<String>> binaryNames = Map.of(
            '+', List.of("+"),
            '-', List.of("-"),
            '*', List.of("*"),
            '/', List.of("/"),
            'm', List.of("mod")
    );

    static final Map<Character, List<String>> unaryNames = Map.of(
            '-', List.of("-"),
            'a', List.of("abs"),
            's', List.of("square")
    );

    static final Map<Character, List<String>> varNames = Map.of(
            'x', List.of("x"),
            'y', List.of("y"),
            'z', List.of("z")
    );

    static final Set<Character> spaceIndifferentBinary = Set.of('+', '-', '*', '/');

    static final Set<Character> spaceIndifferentUnary = Set.of('-');

}
