package yandex.trainings20.lessonTwo.divB;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28738/problems/D/
 */
public class DBench {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int k = sc.nextInt();
        int[] ar = new int[k];
        for (int i = 0; i < k; i++) {
            ar[i] = sc.nextInt();
        }
        Arrays.stream(getLegs(l, k, ar)).forEach(i -> System.out.print(i + " "));
        //System.out.println(getLegs(l, k, ar));
    }

    private static int[] getLegs(int l, int k, int[] ar) {
        int center = l / 2;
        int i = 0;
        while (ar[i] < center) {
            i++;
        }
        if (l % 2 != 0 && ar[i] == center) {
            return new int[]{center};
        }
        return new int[]{ar[i - 1], ar[i]};
    }
}
