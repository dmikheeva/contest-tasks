package leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        int max = sums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = Math.max(sums[i - 1] + nums[i], nums[i]);
            if (sums[i] > max) {
                max = sums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
