package leetcode.graph.disjointSet;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {
    //stores the roots of each element (only one root in a province)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] isConnected = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.findCircleNum(isConnected));
    }

    static class Solution {
        private int[] root;
        private int n;

        Solution() {
        }

        private int find(int x) {
            return root[x];
        }

        private void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return;
            for (int i = 0; i < n; i++) {
                if (root[i] == ry) {
                    root[i] = rx;
                }
            }
        }

        public int findCircleNum(int[][] isConnected) {
            n = isConnected.length;
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        union(i, j);
                    }
                }
            }
            Set s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                s.add(root[i]);
            }
            return s.size();
        }

    }

}
