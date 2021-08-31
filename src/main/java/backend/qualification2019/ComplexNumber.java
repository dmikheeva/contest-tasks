package backend.qualification2019;

import java.util.*;

public class ComplexNumber {
    public static void main(String[] args) {
        //n = 3k/s(k)^2
        int END = 1000000;
        Set<Integer> complexNumbers = new HashSet<>();

        for (int i = 1; i < END; i++) {
            int up = 3 * i;
            int down = countCipherSum(i) * countCipherSum(i);

            if (up % down == 0) {
                complexNumbers.add(up / down);
            }
        }
        List<Integer> result = new ArrayList<>(complexNumbers);
        Collections.sort(result);
        int i = 0;
        while (i + 1 == result.get(i)) {
            i++;
        }
        System.out.println(i + 1);

    }

    private static int countCipherSum(int k) {
        int sum = 0;
        while (k != 0) {
            sum += k % 10;
            k /= 10;
        }
        return sum;
    }
}
