package algorithms.graph;

import java.io.*;
import java.util.*;

public class 백준_골드_선수과목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 과목 수
        int M = Integer.parseInt(st.nextToken()); // 선수과목 관계 수

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] indegree = new int[N + 1];
        int[] semester = new int[N + 1];

        // 선수과목 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int course = Integer.parseInt(st.nextToken());
            adj[pre].add(course);
            indegree[course]++;
        }

        // 위상 정렬 준비: indegree 0인 과목부터
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                semester[i] = 1; // 선수과목이 없으면 1학기에 수강 가능
            }
        }

        // BFS 형태로 위상 정렬하면서 학기 계산
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adj[cur]) {
                // 다음 과목은 최소 cur 과목 수강 학기 + 1
                semester[nxt] = Math.max(semester[nxt], semester[cur] + 1);
                if (--indegree[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(semester[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}

