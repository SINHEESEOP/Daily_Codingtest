package algorithms.dp;

import java.io.*;
import java.util.*;

public class 백준_골드_파이프옮기기1 {
    static int N;
    static int[][] grid;
    // dp[i][j][d]: (i,j) 끝을 향해 파이프가 d 방향으로 놓여 있을 때 경우의 수
    // d = 0: 가로, 1: 세로, 2: 대각선
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        // 입력 읽기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 파이프: (1,1)-(1,2) 가로로 놓여 있으므로 dp[1][2][0] = 1
        dp[1][2][0] = 1;

        // DP 순회: (i,j) 끝점 위치
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (grid[i][j] == 1) continue;  // 벽이면 건너뛰기

                // 1) 가로로 끝나는 경우(dp[][][0])
                if (dp[i][j][0] > 0) {
                    // → 가로로 이동
                    if (j + 1 <= N && grid[i][j + 1] == 0) {
                        dp[i][j + 1][0] += dp[i][j][0];
                    }
                    // ↘ 대각선으로 이동
                    if (i + 1 <= N && j + 1 <= N
                            && grid[i][j + 1] == 0
                            && grid[i + 1][j] == 0
                            && grid[i + 1][j + 1] == 0) {
                        dp[i + 1][j + 1][2] += dp[i][j][0];
                    }
                }

                // 2) 세로로 끝나는 경우(dp[][][1])
                if (dp[i][j][1] > 0) {
                    // ↓ 세로로 이동
                    if (i + 1 <= N && grid[i + 1][j] == 0) {
                        dp[i + 1][j][1] += dp[i][j][1];
                    }
                    // ↘ 대각선으로 이동
                    if (i + 1 <= N && j + 1 <= N
                            && grid[i][j + 1] == 0
                            && grid[i + 1][j] == 0
                            && grid[i + 1][j + 1] == 0) {
                        dp[i + 1][j + 1][2] += dp[i][j][1];
                    }
                }

                // 3) 대각선으로 끝나는 경우(dp[][][2])
                if (dp[i][j][2] > 0) {
                    // → 가로로 이동
                    if (j + 1 <= N && grid[i][j + 1] == 0) {
                        dp[i][j + 1][0] += dp[i][j][2];
                    }
                    // ↓ 세로로 이동
                    if (i + 1 <= N && grid[i + 1][j] == 0) {
                        dp[i + 1][j][1] += dp[i][j][2];
                    }
                    // ↘ 대각선으로 이동
                    if (i + 1 <= N && j + 1 <= N
                            && grid[i][j + 1] == 0
                            && grid[i + 1][j] == 0
                            && grid[i + 1][j + 1] == 0) {
                        dp[i + 1][j + 1][2] += dp[i][j][2];
                    }
                }
            }
        }

        // 끝점 (N,N)으로 오는 모든 방향의 합이 정답
        int answer = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(answer);
    }
}

