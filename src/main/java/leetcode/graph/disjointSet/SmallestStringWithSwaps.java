package leetcode.graph.disjointSet;

import java.util.*;

/**
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */
public class SmallestStringWithSwaps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(Arrays.asList(sc.nextInt(), sc.nextInt()));
        }
        Solution solution = new Solution();
        System.out.println(solution.smallestStringWithSwaps(s, pairs));
    }

    static class Solution {

        Solution() {
        }

        private class DisjointSet {
            private final int n;
            private int[] root;
            private int[] rank;

            DisjointSet(int n) {
                this.n = n;
                root = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    root[i] = i;
                    rank[i] = 1;
                }
            }

            public void union(int x, int y) {
                int rx = findRoot(x);
                int ry = findRoot(y);
                if (rx == ry) return;
                if (rank[x] < rank[y]) {
                    root[rx] = ry;
                } else if (rank[x] > rank[y]) {
                    root[ry] = rx;
                } else {
                    root[ry] = rx;
                    rank[rx] ++;
                }
                //here the  slowest version -  doesn't work (TL)
                /*int rx = findRoot(x);
                int ry = findRoot(y);
                if (rx == ry) return;
                int v1 = rank[rx] >= rank[ry] ? rx : ry;
                int v2 = v1 == rx ? ry : rx;
                for (int i = 0; i < n; i++) {
                    if (root[i] == v2) root[i] = v1;
                }*/
            }

            private int findRoot(int x) {
                if (x == root[x]) return x;
                return root[x] = findRoot(root[x]);
                //here the  slowest version -  doesn't work (TL)
                //return root[x];
            }

            private Map<Integer, List<Integer>> getDisjointMap() {
                Map<Integer, List<Integer>> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    int v = findRoot(i);
                    map.putIfAbsent(v, new ArrayList<>());
                    map.get(v).add(i);
                }
                return map;
            }
        }

        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            DisjointSet disjointSet = new DisjointSet(s.length());
            pairs.forEach(p -> disjointSet.union(p.get(0), p.get(1)));
            Map<Integer, List<Integer>> map = disjointSet.getDisjointMap();
            char[] result = new char[s.length()];
            map.keySet().forEach(k -> {
                List<Character> chars = new ArrayList<>();
                List<Integer> indexes = map.get(k);
                indexes.forEach(i -> chars.add(s.charAt(i)));
                Collections.sort(chars);
                for (int i = 0; i < indexes.size(); i++) {
                    result[indexes.get(i)] = chars.get(i);
                }
            });
            return new String(result);
        }
    }
}
