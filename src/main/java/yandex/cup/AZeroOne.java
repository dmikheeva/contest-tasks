package yandex.cup;

import java.util.Scanner;

public class AZeroOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String a = getStrNum(s1);
        String b = getStrNum(s2);
        if (a.length() > b.length()) {
            System.out.println(">");
            return;
        }else if (a.length() < b.length()) {
            System.out.println("<");
            return;
        }
        int i = 0;
        int l = a.length();
        while (i < l && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        if (i == l) {
            System.out.println("=");
        } else {
            System.out.println(a.charAt(i) == '1' ? ">" : "<");
        }
    }

    private static String getStrNum(String s) {
        int l = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder("");

        while (i < l) {
            if (s.charAt(i) == 'z') {
                i += 4;
                sb.append('0');
            } else {
                i += 3;
                sb.append('1');
            }
        }

        return sb.toString();
    }
}
