package algoritm.test2020;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class ALotery {
    private static int n;
    private static int[] a;
    private static int[] org = new int[10];


    private static void count(Scanner sc) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                a[j] = sc.nextInt();
            }
            Arrays.sort(a);
            int k1 = 0, k2 = 0;
            int similar = 0;
            while (similar < 3 && k1 < 10 && k2 < 6) {
                if (org[k1] == a[k2]) {
                    similar++;
                    k1++;
                    k2++;
                } else if (org[k1] < a[k2]) {
                    k1++;
                } else if (org[k1] > a[k2]) {
                    k2++;
                }
            }
            System.out.println(similar >= 3 ? "Lucky" : "Unlucky");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            org[i] = sc.nextInt();
        }
        Arrays.sort(org);
        n = sc.nextInt();
        a = new int[6];
        count(sc);
    }
}
