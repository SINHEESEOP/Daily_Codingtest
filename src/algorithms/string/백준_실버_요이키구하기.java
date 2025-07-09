package baekjoon.silver;

import java.io.*;
import java.util.*;

// 정답을 봐도 어렵네요?
public class 요이키구하기 {

    static int M, N, K;
    static boolean[][] filled;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로 크기
        N = Integer.parseInt(st.nextToken()); // 가로 크기
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        filled = new boolean[M][N];
        visited = new boolean[M][N];

        // 직사각형 채우기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // (x1, y1)에서 (x2, y2)까지 채운다
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    filled[y][x] = true;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        // 모든 칸을 돌며, 비어 있고 방문하지 않은 곳이 있으면 BFS/DFS
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!filled[i][j] && !visited[i][j]) {
                    areas.add(bfs(i, j));
                }
            }
        }

        // 결과 정리
        Collections.sort(areas);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(areas.size() + "\n");
        for (int area : areas) {
            bw.write(area + " ");
        }
        bw.newLine();
        bw.flush();
    }

    // BFS를 이용해 하나의 영역 크기를 계산
    static int bfs(int startY, int startX) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                if (filled[ny][nx] || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
                count++;
            }
        }

        return count;
    }
}

