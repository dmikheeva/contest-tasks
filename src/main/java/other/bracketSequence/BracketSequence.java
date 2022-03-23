package other.bracketSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * input string containing (),[], <> or other symbols
 * calculate if the bracket sequence correct
 */
public class BracketSequence {

    private static int calc(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null!");
        }
        if (text.isEmpty()) return 1;
        List<Character> brackets = new ArrayList<>();
        int i = 0;
        int n = text.length();
        char c;
        while (i < n) {
            c = text.charAt(i);
            switch (c) {
                case '[':
                case '(':
                case '{':
                    brackets.add(c);
                    i++;
                    break;
                case ']':
                case ')':
                case '}':
                    if (brackets.isEmpty()) return 0;
                    char prev = brackets.get(brackets.size() - 1);
                    if (prev == '[' && c == ']' ||
                            prev == '{' && c == '}' ||
                            prev == '(' && c == ')') {
                        brackets.remove(brackets.size() - 1);
                        i++;
                    } else {
                        return 0;
                    }
                    break;
                default:
                    i++;
                    break;
            }
        }
        return brackets.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String[] strs = {
                "---(+++++)-----",
                "",
                "s( e[]) wewe",
                ")(",
                "{(  })",
                "([{(s)f}f]g)"};
        Arrays.stream(strs).forEach(t -> System.out.println(t + ": " + calc(t)));
    }
}
