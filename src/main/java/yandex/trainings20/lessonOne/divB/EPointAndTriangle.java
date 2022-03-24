package yandex.trainings20.lessonOne.divB;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28730/problems/E/
 */
public class EPointAndTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(count(d, x, y));
    }

    private static int count(int d, int x, int y) {
        int res;
        if (x <= 0) {
            if (2 * y <= d) {
                res = 1;
            } else {
                res = 3;
            }
            if (x == 0 && y >= 0 && y <= d) {
                res = 0;
            }
        } else {
            if (y < 0) {
                res = (2 * x <= d) ? 1 : 2;
            } else if (y == 0) {
                res = (x <= d) ? 0 : 2;
            } else {
                if (y <= -x + d) {
                    res = 0;
                } else {
                    res = (x - d) * (x - d) <= (y - d) * (y - d) ? 2 : 3;
                }
            }
        }
        return res;
    }
}
