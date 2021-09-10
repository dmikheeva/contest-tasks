package yandex.trainings20.lessonOne.divB;

import java.util.Scanner;

/**
 * https://contest.yandex.ru/contest/28730/problems/A/
 */
public class AInteractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte r = sc.nextByte();//code
        byte i = sc.nextByte();//interactor
        byte c = sc.nextByte();//checker
        byte res;

        if (i == 0) {
            res = (r != 0) ? 3 : c;
        } else if (i == 1) {
            res = c;
        } else if (i == 4) {
            res = (r != 0) ? (byte) 3 : (byte) 4;
        } else if (i == 6) {
            res = 0;
        } else if (i == 7) {
            res = 1;
        } else {
            res = i;
        }
        System.out.println(res);;
    }

}
