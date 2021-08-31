package leetcode;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */

public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] a = new int[m][n];
        a[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            a[i][0] = obstacleGrid[i][0] == 0 ? a[i - 1][0] : 0;
        }
        for (int i = 1; i < n; i++) {
            a[0][i] = obstacleGrid[0][i] == 0 ? a[0][i - 1] : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = obstacleGrid[i][j] == 0 ? a[i - 1][j] + a[i][j - 1] : 0;
            }
        }
        return a[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 1},
                {0, 0}
        }));
    }
}
