package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reducing-dishes/
 * n*logn solution
 */
public class ReducingDishes {

    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        //people don't like the dishes. No dish is prepared.
        if (satisfaction[n - 1] <= 0) {
            return 0;
        }
        int likeTimeCoef = 0;
        int t = 1, sum = 0;
        for (int i = 0; i < n; i++, t++) {
            likeTimeCoef += t * satisfaction[i];
            sum += satisfaction[i];
        }
        //people like the dishes. All dishes are prepared.
        if (satisfaction[0] >= 0) {
            return likeTimeCoef;
        }
        int i = 0;
        while (satisfaction[i] < 0) {
            if (likeTimeCoef > likeTimeCoef - sum) {
                //the smallest elemet doesn't make sum smaller -> don't remove i element from sequence
                sum = sum - satisfaction[i] + satisfaction[i + 1];
            } else {
                //remove i element from sequence
                likeTimeCoef = likeTimeCoef - sum;
                sum -= satisfaction[i];
            }
            i++;
        }
        return likeTimeCoef;

    }

    public static void main(String[] args) {
        System.out.println(maxSatisfaction(new int[]{4,3,2}));
    }
}
