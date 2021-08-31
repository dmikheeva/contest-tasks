package algoritm.test2020;

import java.util.Scanner;

/**
 *
 */
public class BPalindromFactor {
    private static String s;

    private static void count() {
        int i = 0;
        int n = s.length();
        if (s.length() == 2) {
            System.out.println(s.charAt(0) == s.charAt(1) ? s : -1);
            return;
        }
        String result = "aaaa";
        String t = "";
        while (i + 2 < n) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                t = s.substring(i, i + 2);
                result = compare(t,result) > 0 ? result : t;
            } else if (s.charAt(i + 1) == s.charAt(i + 2)) {
                t = s.substring(i + 1, i + 3);
                result = compare(t,result) > 0 ? result : t;
            } else if (s.charAt(i) == s.charAt(i + 2)) {
                t = s.substring(i, i + 3);
                result = compare(t,result) > 0 ? result : t;
            }
            i++;
        }

        System.out.print(result.equals("aaaa") ? -1 : result);
    }

    private static int compare(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }
        return a.compareTo(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        count();

    }
}
