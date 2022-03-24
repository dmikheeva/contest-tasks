package yandex.trainings20.lessonTwo.divB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Дана строка возможно пустая состоящая из букв A-Z AAABBBBZFFCCCC
 * Нужно написать функцию RLE которая на выходе даст строку вида A3B4ZF2C4 и сгенерирует ошибку если на вход пришла
 * невалидная строка
 */
public class RLE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(rle(s));
    }

    private static String rle(String s) {
        char lastSymbol = s.charAt(0);
        int lastIndex = 0;
        List<Character> res = new ArrayList<>();
        res.add(lastSymbol);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != lastSymbol) {
                if (i - lastIndex > 1) {
                    res.add((char) ((i - lastIndex) + '0'));
                }
                res.add(c);
                lastIndex = i;
                lastSymbol = c;
            }
        }
        if (s.length() - lastIndex > 1) {
            res.add((char) ((s.length() - lastIndex) + '0'));
        }
        return res.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
