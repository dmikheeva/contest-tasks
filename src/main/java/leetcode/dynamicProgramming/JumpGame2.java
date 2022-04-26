package leetcode.dynamicProgramming;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(new Solution().jump(array));
    }

    static class Solution {

        public int jump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[n - 1] = 0;
            int i = n - 2;
            while (i >= 0) {
                if (nums[i] == 0) dp[i] = -1;
                int min = dp[i + 1];
                for (int j = i + 2; j <= i + nums[i]; j++) {
                    if (j >= n) break;
                    if (dp[j] < min) min = dp[j];
                }
                dp[i] = min + 1;
                i--;
            }
            return dp[0];
        }
    }
}
