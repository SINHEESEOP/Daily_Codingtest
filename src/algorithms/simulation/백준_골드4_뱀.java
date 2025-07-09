package algorithms.simulation;

import java.io.*;
import java.util.*;

// 🎯 시뮬레이션 문제: 뱀 (백준 골드4)
// 💡 뱀의 이동과 성장을 시뮬레이션 (덱을 이용한 뱀 몸체 관리)
// ⚡ 시간복잡도: O(게임시간), 공간복잡도: O(N²)
public class 백준_골드4_뱀 {
    static class Turn {
        int time;
        char dir;
        Turn(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());

        // 📝 보드 초기화: 0 = 빈공간, 1 = 사과
        int[][] board = new int[N+1][N+1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine().trim());
        Turn[] turns = new Turn[L];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            turns[i] = new Turn(t, d);
        }

        // 📝 방향: 0=우, 1=하, 2=좌, 3=상
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] occupied = new boolean[N+1][N+1];
        Deque<int[]> snake = new ArrayDeque<>();
        
        // 초기 위치 (1,1)
        snake.offerFirst(new int[]{1, 1});
        occupied[1][1] = true;

        int dir = 0;     // 초기 방향: 오른쪽
        int time = 0;
        int turnIdx = 0;
        int x = 1, y = 1;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 📝 벽 충돌 검사
            if (nx < 1 || nx > N || ny < 1 || ny > N) {
                break;
            }
            // 📝 자기 몸체 충돌 검사
            if (occupied[nx][ny]) {
                break;
            }

            // 머리 이동
            snake.offerFirst(new int[]{nx, ny});
            occupied[nx][ny] = true;

            // 사과 먹기 체크
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0; // 사과 제거, 꼬리는 그대로
            } else {
                // 사과 없으면 꼬리 제거
                int[] tail = snake.pollLast();
                occupied[tail[0]][tail[1]] = false;
            }

            x = nx; y = ny;

            // 📝 방향 전환 처리
            if (turnIdx < L && turns[turnIdx].time == time) {
                if (turns[turnIdx].dir == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                } else { // 'D'
                    dir = (dir + 1) % 4; // 오른쪽 회전
                }
                turnIdx++;
            }
        }

        System.out.println(time);
    }
} 