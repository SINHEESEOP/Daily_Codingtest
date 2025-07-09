package algorithms.graph;

import java.io.*;
import java.util.*;

// 🎯 그래프 BFS 문제: 토마토 (백준 골드5)
// 💡 익은 토마토에서 시작하여 인접한 토마토들을 익히는 최소 시간 계산
// ⚡ 시간복잡도: O(N*M), 공간복잡도: O(N*M)
public class 백준_골드5_토마토 {

    static int M, N;
    static int[][] box;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 칸 수
        N = Integer.parseInt(st.nextToken()); // 세로 칸 수
        box = new int[N][M];
        Queue<Point> q = new ArrayDeque<>();

        // 입력 및 시작 토마토(1) 큐에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }

        // BFS로 익히기
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (box[nx][ny] == 0) {
                    box[nx][ny] = box[p.x][p.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }

        // 결과 계산
        int days = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) { // 아직 익지 않은 토마토가 있으면
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, box[i][j]);
            }
        }

        // 처음 익은 토마토의 값이 1이므로, 실제 경과일수는 days-1
        System.out.println(days - 1);
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
} 