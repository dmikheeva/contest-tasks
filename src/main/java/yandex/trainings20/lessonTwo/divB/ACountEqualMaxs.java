package yandex.trainings20.lessonTwo.divB;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28738/problems/
 */
public class ACountEqualMaxs {
    public static void main(String[] args) {
        findMaxAmount();
    }

    private static void findMaxAmount() {
        Scanner sc = new Scanner(System.in);
        int curr;
        int max = -1;
        int maxAmount = 0;
        while (sc.hasNext()) {
            curr = sc.nextInt();
            if (curr == 0) {
                break;
            }
            if (curr > max) {
                max = curr;
                maxAmount = 1;
            } else if (curr == max) {
                maxAmount++;
            }
        }
        System.out.println(maxAmount);
    }
}
