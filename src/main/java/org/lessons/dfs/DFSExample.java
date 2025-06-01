package org.lessons.dfs;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class DFSExample {
    static class Graph {
        int vertices;
        List<List<Integer>> adj; // Список смежности

        Graph(int vertices) {
            this.vertices = vertices;
            adj = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        void DFS(int start, boolean[] visited) {
            visited[start] = true;
            System.out.print(start + " ");

            for (int neighbor : adj.get(start)) {
                if (!visited[neighbor]) {
                    DFS(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        boolean[] visited = new boolean[7];
        System.out.println("DFS traversal starting from vertex 0:");
        g.DFS(0, visited); // Output: 0 1 3 4 2 5 6
    }
}
//public class DFSExample {
//
//    private Map<String, List<String>> graph; // Граф (список смежности)
//    private Set<String> visited;          // Множество посещенных вершин
//
//    public DFSExample(Map<String, List<String>> graph) {
//        this.graph = graph;
//        this.visited = new HashSet<>();
//    }
//
//    public void dfs(String startNode) {
//        visited.add(startNode); // Помечаем текущую вершину как посещенную
//        System.out.print(startNode + " "); // Выводим текущую вершину (можно заменить на любое другое действие)
//
//        List<String> neighbors = graph.get(startNode); // Получаем список соседей
//
//        if (neighbors != null) { // Проверяем, есть ли у вершины соседи
//            for (String neighbor : neighbors) { // Перебираем соседей
//                if (!visited.contains(neighbor)) { // Если сосед еще не посещен
//                    dfs(neighbor); // Рекурсивно вызываем DFS для соседа
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        // Пример графа (список смежности)
//        Map<String, List<String>> graph = new HashMap<>();
//        graph.put("A", Arrays.asList("B", "C"));
//        graph.put("B", Arrays.asList("D", "E"));
//        graph.put("C", Arrays.asList("F"));
//        graph.put("D", new ArrayList<>()); // Нет соседей
//        graph.put("E", Arrays.asList("F"));
//        graph.put("F", new ArrayList<>()); // Нет соседей
//
//        DFSExample dfsExample = new DFSExample(graph);
//
//        System.out.println("DFS обход, начиная с вершины A:");
//        dfsExample.dfs("A"); // Запускаем DFS, начиная с вершины A
//    }
//}

