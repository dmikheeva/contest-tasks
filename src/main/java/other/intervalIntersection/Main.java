package other.intervalIntersection;

import java.util.Scanner;

public class Main {
    private static Pair[] readFromInput() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] intervals = new Pair[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        return intervals;
    }

    public static void main(String[] args) {
        Pair[] intervals = readFromInput();
        System.out.println(new IntervalIntersection(intervals).calculateIntersection());

    }
}
