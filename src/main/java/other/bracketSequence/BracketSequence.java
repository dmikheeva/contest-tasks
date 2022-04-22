package other.bracketSequence;

import java.util.*;

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
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        int i = 0;
        int n = text.length();
        char c;
        while (i < n) {
            c = text.charAt(i);
            if (map.containsValue(c)) {
                brackets.add(c);
                i++;
            } else if (map.containsKey(c)) {
                if (brackets.isEmpty()) return 0;
                char prev = brackets.get(brackets.size() - 1);
                if (prev == map.get(c)) {
                    brackets.remove(brackets.size() - 1);
                    i++;
                } else {
                    return 0;
                }
            } else {
                i++;
            }

        }
        return brackets.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.max("".indexOf("o"), "".indexOf("n")));
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
