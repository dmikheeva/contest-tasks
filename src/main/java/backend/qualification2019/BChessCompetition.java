package backend.qualification2019;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://contest.yandex.ru/contest/12870/problems/B/
 */
public class BChessCompetition {
    private static final String NO_SOLUTION = "NO SOLUTION";
    private static int k = 0;
    private static Graph graph;

    public static void main(String[] args) {
        BChessCompetition competition = new BChessCompetition();
        System.out.println(competition.getResult());
    }

    private String getResult() {
        readFromInput();
        List<String> finals = graph
                .elements
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        List<String> semiFinals = graph
                .elements
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == (k - 1))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (finals.size() != 2 || semiFinals.size() != 2) {
            return NO_SOLUTION;
        }
        if (isGraphCorrect(finals.get(0), k) && isGraphCorrect(finals.get(1), k)) {
            return semiFinals.get(0) + " " + semiFinals.get(1);
        } else {
            return NO_SOLUTION;
        }
    }

    private void readFromInput() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        int n = (int) Math.pow(2, k) - 1;
        int i = 0;
        graph = new Graph();

        while (i < n) {
            String first = sc.next();
            String second = sc.next();

            graph.addEdge(first, second);
            i++;
        }
    }

    //Проверяем что граф на каждом уровне содержит power вершин степени от 0 до power-1
    private boolean isGraphCorrect(String root, int power) {
        if (power == 0) {
            return graph.elements.get(root).size() == 0;
        }
        int[] childAmounts = new int[power];
        for (String child : graph.elements.get(root)) {
            graph.elements.get(child).remove(root);
            int childSize = graph.elements.get(child).size();
            if (childSize > power - 1 || childAmounts[childSize] != 0) {
                return false;
            } else {
                childAmounts[childSize]++;
            }
            if (!isGraphCorrect(child, childSize)) {
                return false;
            }
        }
        return true;
    }

    private class Graph {
        private Map<String, List<String>> elements = new HashMap<>();

        private void addVertex(String v) {
            if (!elements.containsKey(v)) {
                elements.put(v, new ArrayList<>());
            }
        }

        private boolean hasEdge(String v1, String v2) {
            return elements.get(v1) != null && elements.get(v2) != null && elements.get(v1).contains(v2);
        }

        private void addEdge(String v1, String v2) {
            addVertex(v1);
            addVertex(v2);
            if (!hasEdge(v1, v2)) {
                elements.get(v1).add(v2);
                elements.get(v2).add(v1);
            }
        }
    }

}
