package leetcode.graph.disjointSet;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/number-of-provinces/
 * <p>
 * use quick union and opimization to find operation
 * solution is here
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3846/
 */
public class NumberOfProvincesOptimized {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] isConnected = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = sc.nextInt();
            }
        }
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    disjointSet.union(i, j);
                }
            }
        }
        return disjointSet.getCount();
    }

    static class DisjointSet {
        //stores the roots of each element (only one root in a province)
        private int[] root;
        //stores the height of each vertice in a tree
        private int[] rank;
        private int n;
        private int count;

        DisjointSet(int size) {
            n = size;
            root = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int x) {
            if (x == root[x]) return x;
            return root[x] = find(root[x]);
        }

        private void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return;
            if (rank[rx] == rank[ry]) {
                root[ry] = rx;
                rank[rx]++;
            } else if (rank[rx] > rank[ry]) {
                root[ry] = rx;

            } else {
                root[rx] = ry;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }

}
