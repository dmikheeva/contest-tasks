package backend.qualification2019;

import java.util.*;

/**
 * https://contest.yandex.ru/contest/12870/problems/A/
 */
public class ATechDolg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        long k = sc.nextLong();
        Set<Long> deadlines = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            deadlines.add(sc.nextLong());
        }
        System.out.println(addDeadlineMessages(new LinkedList<>(deadlines), x, k));
    }

    private static Long addDeadlineMessages(List<Long> deadlines, long x, long k) {
        int i = 0;
        int j = 0;
        long size = deadlines.size();
        boolean flagEndi = false;
        boolean flagEndj = false;
        while (i < k && j < k) {
            if (i == size - 1) {
                flagEndi = true;
                break;
            }
            long newDeadline = deadlines.get(i) + x;
            while (j < size && deadlines.get(j) < newDeadline) {
                j++;
            }
            i++;
            if (j < size && deadlines.get(j).equals(newDeadline)) {
                continue;
            }
            deadlines.add(j, newDeadline);
            if (j == size) {
                flagEndj = true;
                break;
            }
            size++;
        }
        if (flagEndi) {
            return deadlines.get(i) + (k - i - 1) * x;
        }
        if (flagEndj) {
            i--;
            long index = (k - i) % (j - i) - 1;
            return deadlines.get((int)index) + x*((k-i)/(j-i));

        }
        return deadlines.get((int) k - 1);
    }

}
