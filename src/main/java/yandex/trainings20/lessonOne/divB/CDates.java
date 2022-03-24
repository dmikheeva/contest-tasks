package yandex.trainings20.lessonOne.divB;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28730/problems/C/
 */
public class CDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        System.out.println((x > 12 || y > 12) ? 1 : 0);
        if ( x > 12 || y > 12) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
        /*Map<Integer, Integer> months = new LinkedHashMap<>();
        months.put(1, 31);
        months.put(2, 29);
        months.put(3, 31);
        months.put(4, 30);
        months.put(5, 31);
        months.put(6, 30);
        months.put(7, 31);
        months.put(8, 31);
        months.put(9, 30);
        months.put(10, 31);
        months.put(11, 30);
        months.put(12, 31);


        boolean res1 = false, res2 = false;
        //check x-day y-month
        if (y == 2) {
            res1 = (x <= ((z % 4 == 0) ? 29 : 28));
        } else if (y <= 12) {
            res1 = x <= months.get(y);
        }
        if (!res1) {
            System.out.println(1);
            return;
        }

        //check y-day x-month
        //y <= 12 here
        System.out.println(x <= 12 ? 0 : 1);*/
    }

}
