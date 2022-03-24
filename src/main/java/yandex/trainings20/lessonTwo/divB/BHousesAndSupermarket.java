package yandex.trainings20.lessonTwo.divB;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28738/problems/B/
 */
public class BHousesAndSupermarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(findMaxFromHomeToSupermarket(a));
    }

    private static int findMaxFromHomeToSupermarket(int[] a) {
        int[] b = new int[10];
        int homeInd = -1;
        //слева направо
        for (int i = 0; i < 10; i++) {
            if (a[i] == 1) {
                if (homeInd >= 0) {
                    b[i] = i - homeInd;
                }
            } else if (a[i] == 2) {
                homeInd = i;
            }
        }
        //справа налево
        homeInd = -1;
        for (int i = 9; i >= 0; i--) {
            if (a[i] == 1) {
                if (homeInd >= 0) {
                    b[i] = b[i] > 0 ? Math.min(b[i], homeInd - i) : (homeInd - i);
                }
            } else if (a[i] == 2) {
                homeInd = i;
            }
        }
        //ищем макс
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (b[i] > res) {
                res = b[i];
            }
        }
        return res;
    }
}
