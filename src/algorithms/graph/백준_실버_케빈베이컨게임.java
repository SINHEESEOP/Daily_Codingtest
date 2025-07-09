package baekjoon.silver;

import java.io.*;
import java.util.*;

public class 케빈베이컨게임 {
    public static void main(String[] args) throws IOException {
        // 1) 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 사용자 수
        int M = Integer.parseInt(st.nextToken());  // 친구 관계 수

        // 2) 그래프 초기화 (1-indexed)
        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 3) 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        int answerUser = 1;
        int minKevinBaconSum = Integer.MAX_VALUE;

        // 4) 각 사용자마다 BFS로 케빈 베이컨 합 계산
        for (int start = 1; start <= N; start++) {
            int sumDistances = bfsKevinBacon(adj, N, start);
            if (sumDistances < minKevinBaconSum) {
                minKevinBaconSum = sumDistances;
                answerUser = start;
            }
        }

        // 5) 정답 출력
        System.out.println(answerUser);
    }

    // start 사용자로부터 다른 모든 사용자까지의 거리 합을 BFS로 계산
    private static int bfsKevinBacon(List<Integer>[] adj, int N, int start) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
        }

        // 거리 합 계산
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        return sum;
    }
}

