package backend.qualification2019;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/12870/problems/C/
 */
public class CPetyaVasyaCards {
    private static int points = 0;

    public static void main(String[] args) {
        System.out.println(play());
    }

    private static String play() {
        Scanner sc = new Scanner(System.in);
        points = sc.nextInt();
        int n = sc.nextInt();
        int i = 0;
        int vPoints = 0, pPoints = 0;
        while (i < n) {
            int next = sc.nextInt();
            boolean mod17 = next % 17 == 0;
            boolean mod31 = next % 31 == 0;

            if (mod17 && mod31 || !mod17 && !mod31) {
            } else {
                if (mod17) {
                    vPoints++;
                    if (check(vPoints)) return "Vasya";
                } else {
                    pPoints++;
                    if (check(pPoints)) return "Petya";
                }
            }
            i++;
        }
        return "Too long";
    }

    private static boolean check(int playerPoints) {
        return playerPoints >= points;
    }
}
