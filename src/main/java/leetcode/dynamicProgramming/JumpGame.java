package leetcode.dynamicProgramming;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(new Solution().canJump(array));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];
            dp[n - 1] = true;
            int i = n - 2;
            while (i >= 0) {
                if (nums[i] == 0) dp[i] = false;
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (j >= n) break;
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
                i--;
            }
            return dp[0];
        }
    }
}
