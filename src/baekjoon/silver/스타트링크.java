package baekjoon.silver;

import java.io.*;
import java.util.*;

public class 스타트링크 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // 총 층수
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        int G = Integer.parseInt(st.nextToken()); // 목표 위치
        int U = Integer.parseInt(st.nextToken()); // 위로 U층
        int D = Integer.parseInt(st.nextToken()); // 아래로 D층

        int[] dist = new int[F+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();

        dist[S] = 0;
        q.offer(S);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == G) {
                System.out.println(dist[cur]);
                return;
            }

            // 위로 U층
            int up = cur + U;
            if (up <= F && dist[up] == -1) {
                dist[up] = dist[cur] + 1;
                q.offer(up);
            }

            // 아래로 D층
            int down = cur - D;
            if (down >= 1 && dist[down] == -1) {
                dist[down] = dist[cur] + 1;
                q.offer(down);
            }
        }

        // 도달 불가
        System.out.println("use the stairs");
    }
}
