package backend.qualification2019;

import java.util.Scanner;

public class FBrokenCommit {
    private String[] result = new String[4];
    private Scanner sc = new Scanner(System.in);
    private long n = 0;

    public static void main(String[] args) {
        FBrokenCommit fBrokenCommit = new FBrokenCommit();
        fBrokenCommit.getCommitNumbers();
        System.out.println("! " + fBrokenCommit.getAnswer());
    }

    private void getCommitNumbers() {
        n = sc.nextLong();
    }

    private long getAnswer() {
        long begin = 1, end = n;
        long step;
        while (true) {
            doRequest(begin, end);
            getResponse();
            int i = 0;
            while (i < 4 && "1".equals(result[i])) {
                i++;
            }
            if (end - begin <= 4) {
                return begin + i;
            }
            if (i == 0) {
                return begin;
            } else {
                step = (end - begin + 1) / 4;
                begin += (end - begin + 1) / 4 * (i - 1);
                end = i == 4 ? end : Math.min(begin + step, n);
            }
        }
    }

    //628
    private void doRequest(long begin, long end) {
        if (end - begin < 3) {
            System.out.print(begin + " ");
            System.out.print(Math.min(begin + 1, n) + " ");
            System.out.print(Math.min(begin + 2, n) + " ");
            System.out.println(Math.min(begin + 3, n));
        } else {
            long step = (end - begin + 1) / 4;
            System.out.print(begin + " ");
            System.out.print((begin + step) + " ");
            System.out.print((begin + 2 * step) + " ");
            System.out.println((begin + 3 * step));
        }
        System.out.flush();
    }

    private void getResponse() {
        result[0] = sc.next();
        result[1] = sc.next();
        result[2] = sc.next();
        result[3] = sc.next();
    }
}
