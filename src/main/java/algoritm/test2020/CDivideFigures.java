package algoritm.test2020;

import java.util.Scanner;

/**
 *
 */
public class CDivideFigures {
    private static int n;
    private static Scanner sc = new Scanner(System.in);
    private static float[][] centers;

    private static void count() {
        //1st figure
        float cx1 = centers[0][0], cy1 = centers[0][1];
        //2nd figure with another center
        float cx2 = cx1, cy2 = cy1;
        float k1 = 0, k2 = 0;
        for (int i = 1; i < n; i++) {
            float x = centers[i][0];
            float y = centers[i][1];
            if (x == cx1 && y == cy1) {
                continue;
            }
            if (x == cx2 && y == cy2) {
                continue;
            }
            if (k1 != 0 && k2 != 0) {
                if ((x - cx1) * k1 != (y - cy1) * k2) {
                    System.out.println("No");
                    return;
                }
            } else {
                cx2 = centers[i][0];
                cy2 = centers[i][1];
                k1 = cy2 - cy1;
                k2 = cx2 - cx1;
            }

        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        if (n <= 2) {
            System.out.println("Yes");
            return;
        }
        centers = new float[n][2];
        int x1, y1, x3, y3;
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() == 0) {
                sc.nextInt();
                centers[i][0] = sc.nextInt();
                centers[i][1] = sc.nextInt();
            } else {
                x1 = sc.nextInt();
                y1 = sc.nextInt();
                sc.nextInt();
                sc.nextInt();
                x3 = sc.nextInt();
                y3 = sc.nextInt();
                sc.nextInt();
                sc.nextInt();
                centers[i][0] = (x1 + x3) / 2.0f;
                centers[i][0] = (y1 + y3) / 2.0f;
            }
        }
        count();
    }
}