package leetcode;

/**
 * https://leetcode.com/problems/frog-jump/
 *
 * good solution here https://leetcode.com/problems/frog-jump/discuss/193816/Concise-and-fast-DP-solution-using-2D-array-instead-of-HashMap-with-text-and-video-explanation.
 */
public class FrogJump {
    public static boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dist = stones[i] - stones[j];
                if (dist < 0 || dist > n || !dp[j][dist]) continue;

                dp[i][dist] = true;
                if (dist - 1 >= 0) {
                    dp[i][dist - 1] = true;
                }
                if (dist + 1 <= n) {
                    dp[i][dist + 1] = true;
                }

                if (i == n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }
}
