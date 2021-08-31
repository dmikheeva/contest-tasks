package backend.qualification2019;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://contest.yandex.ru/contest/12870/problems/E/
 */
public class EDecoding {
    public static void main(String[] args) {
        //HH3+0+H3+0H4+84+8
        //H3+H3+H3+H3+H3+H3+H3+H3+H3+H3+H3+H3+H3+H3+0
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(countDecode(s));
    }

    private static int countDecode(String s) {
        String regex = "H([0-9a-fA-F]){1}\\+([0-9a-fA-F]){1}";
        Pattern pattern = Pattern.compile(regex);
        int count = 0;
        Matcher matcher = pattern.matcher(s);
        StringBuffer sb;
        String newValue;
        while (true) {
            sb = new StringBuffer();
            if (!matcher.find()) {
                return count;
            }
            do {
                newValue = getNumber(s.substring(matcher.start(), matcher.end()));
                matcher.appendReplacement(sb, newValue);
            } while (matcher.find());
            matcher.appendTail(sb);
            s = sb.toString();
            matcher = pattern.matcher(s);
            count++;
        }
    }

    private static int getNumber(Character ch) {
        if (Character.isDigit(ch)) {
            return Character.getNumericValue(ch);
        }
        return 10 + (Character.toUpperCase(ch) - 'A');
    }

    private static String getNumber(String s) {
        Character ch1 = s.charAt(1);
        Character ch2 = s.charAt(3);
        return Character.toString((char) (16 * getNumber(ch1) + getNumber(ch2)));
    }

}
