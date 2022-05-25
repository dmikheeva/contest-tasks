package tinkoff;

import java.util.Map;
import java.util.Scanner;

/**
 * По входной строке вывести ее числовое соответствие
 * соответствие см в мапе values
 * Итоговый результат - просто сумма
 * Важно: последовательность комбинаций невозрастающая, те ABA - допустимо, а AAB - нет
 */
public class AlphabetToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        System.out.println(convert(line));
    }

    private static final Map<String, Integer> values = Map.of(
            "A", 1,
            "B", 5,
            "C", 10,
            "D", 50,
            "E", 100,
            "AB", 4,
            "AC", 9,
            "CD", 40,
            "CE", 90
    );

    private static int convert(String num) {
        int n = num.length();
        char[] numChar = num.toCharArray();
        int result = 0;
        int i = 0;
        int lastValue = Integer.MAX_VALUE;
        int currValue;
        while (i < n) {
            if (i == n - 1) {
                currValue = getValueOrThrow(String.valueOf(numChar[i]));
                i++;
            } else {
                String currStr = "" + numChar[i] + numChar[i + 1];
                if (values.containsKey(currStr)) {
                    currValue = values.get(currStr);
                    i += 2;
                } else {
                    currValue = getValueOrThrow(String.valueOf(numChar[i]));
                    i++;
                }
            }
            if (currValue > lastValue) {
                throw new IllegalStateException(String.format("Couldn't parse %s the string into number!", num));
            }
            result += currValue;
            lastValue = currValue;
        }
        return result;
    }

    private static int getValueOrThrow(String s) {
        if (!values.containsKey(s)) throw new IllegalArgumentException("No value specified for string: " + s);
        return values.get(s);
    }
}

