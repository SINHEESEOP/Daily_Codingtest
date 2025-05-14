package lab;

import java.util.*;

public class BFSExample {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 4; i++) graph.add(new ArrayList<>());

        // 양방향 그래프
        graph.get(1).add(2); graph.get(2).add(1);
        graph.get(1).add(3); graph.get(3).add(1);
        graph.get(2).add(4); graph.get(4).add(2);

        boolean[] visited = new boolean[5];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
