package yandex.trainings20.lessonTwo.divB;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28738/problems/E/
 */
public class EDiplomas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(count(n, a));
    }

    private static int count(int n, int[] a) {
        if (n == 1) {
            return 0;
        }
        int sum = a[0];
        int max = a[0];
        for (int i = 1; i < n; i++) {
            sum += a[i];
            if (a[i] > max) {
                max = a[i];
            }
        }
        return sum - max;
    }
}
