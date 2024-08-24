package utils;

import java.util.HashSet;
import java.util.Set;

public class Punctuation {
    private static final Set<Character> PUNCTUATION_CHARACTERS = new HashSet<>();

    static {
        PUNCTUATION_CHARACTERS.add('(');
        PUNCTUATION_CHARACTERS.add(')');
        PUNCTUATION_CHARACTERS.add(':');
        PUNCTUATION_CHARACTERS.add(';');
        PUNCTUATION_CHARACTERS.add(',');
        PUNCTUATION_CHARACTERS.add('.');
        PUNCTUATION_CHARACTERS.add('{');
        PUNCTUATION_CHARACTERS.add('}');
    }

    public static boolean isPunctuation(char ch) {
        return PUNCTUATION_CHARACTERS.contains(ch);
    }

}
