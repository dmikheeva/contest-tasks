package yandex.trainings20.lessonOne.divB;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28730/problems/D/
 */
public class DSchool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        long curSum = 0L;
        long minSum = 0L;
        int minPoint;
        int k = 0; //сколько домов находятся строго до текущей позиции
        int first = sc.nextInt();
        data[0] = first;

        for (int i = 1; i < n; i++) {
            data[i] = sc.nextInt();
            curSum += (data[i] - first);
        }

        minSum = curSum;
        minPoint = first;
        k = 1;

        for (int j = 1; j < n; j++) {
            curSum += (2 * k - n) * (data[j] - data[j - 1]);
            if (curSum < minSum) {
                minSum = curSum;
                minPoint = data[j];
            }
            k++;
        }

        System.out.println(minPoint);
    }

}
