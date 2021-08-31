package algoritm.test2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBigData {
    private static int n;
    private static int m;
    private static byte[] a;
    private static byte[] b;

    private static final long milliard = 1000000000L;

    private static void count() {
        int amax = a[0];
        List<Integer> iamax = new ArrayList<>();
        iamax.add(0);
        for (int i = 1; i < n; i++) {
            if (a[i] > amax) {
                amax = a[i];
                iamax.clear();
                iamax.add(i);
            } else if (a[i] == amax) {
                iamax.add(i);
            }
        }
        int bmax = b[0];
        int ibmax = 0;
        for (int i = 1; i < m; i++) {
            if (b[i] > bmax) {
                bmax = b[i];
                ibmax = i;
            }
        }

        int asum = 0;
        int bsum = 0;
        int i = 0, j = 0;
        int iamax1 = iamax.get(0);
        int iamax2 = iamax.get(iamax.size() - 1);
        while (i < iamax1) {
            asum += a[i];
            bsum += b[0];
            i++;
        }
        while (j < ibmax) {
            asum += a[i];
            bsum += b[j];
            j++;
        }
        //i++;
        while (i < iamax2) {
            asum += a[i];
            bsum += b[j];
            i++;
        }
        while (j < m - 1) {
            asum += a[i];
            bsum += b[j];
            j++;
        }
        while (i < n) {
            asum += a[i];
            bsum += b[m - 1];
            i++;
        }
        System.out.println(asum * milliard + bsum);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new byte[n];
        b = new byte[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextByte();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextByte();
        }
        count();

    }
}
