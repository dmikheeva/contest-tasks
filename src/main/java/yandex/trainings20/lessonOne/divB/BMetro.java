package yandex.trainings20.lessonOne.divB;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28730/problems/B/
 */
public class BMetro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        int j = sc.nextInt();

        if (i == j || i - j == 1 || j - i == 1) {
            System.out.println(0);
            return;
        }
        if (i > j) {
            int a = i;
            i = j;
            j = a;
        }
        int l = j - i - 1;
        int r = n - j + i - 1;
        System.out.println(Math.min(l, r));
    }

}
