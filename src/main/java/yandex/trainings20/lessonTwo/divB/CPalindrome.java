package yandex.trainings20.lessonTwo.divB;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28738/problems/C/
 */
public class CPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(countLettersToChange(s.toCharArray()));
    }

    private static int countLettersToChange(char[] arr) {
        int l = arr.length;
        if (l == 1) {
            return 0;
        }
        int i = (l - 2) / 2;
        int j = (l + 1) / 2;
        int res = 0;
        while (i >= 0) {
            if (arr[i] != arr[j]) {
                res++;
            }
            i--;
            j++;
        }
        return res;
    }
}
