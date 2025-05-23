package baekjoon.gold;

import java.io.*;
import java.util.*;

public class 뱀 {
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

        // 1-indexed board: 0 = empty, 1 = apple
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

        // Directions: 0=right, 1=down, 2=left, 3=up
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] occupied = new boolean[N+1][N+1];
        Deque<int[]> snake = new ArrayDeque<>();
        // start at (1,1)
        snake.offerFirst(new int[]{1, 1});
        occupied[1][1] = true;

        int dir = 0;     // initial moving right
        int time = 0;
        int turnIdx = 0;
        int x = 1, y = 1;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // check wall collision
            if (nx < 1 || nx > N || ny < 1 || ny > N) {
                break;
            }
            // check self collision
            if (occupied[nx][ny]) {
                break;
            }

            // move head
            snake.offerFirst(new int[]{nx, ny});
            occupied[nx][ny] = true;

            // if apple, eat and don't move tail; else move tail
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
            } else {
                int[] tail = snake.pollLast();
                occupied[tail[0]][tail[1]] = false;
            }

            x = nx; y = ny;

            // apply turn if it's time
            if (turnIdx < L && turns[turnIdx].time == time) {
                if (turns[turnIdx].dir == 'L') {
                    dir = (dir + 3) % 4;
                } else { // 'D'
                    dir = (dir + 1) % 4;
                }
                turnIdx++;
            }
        }

        System.out.println(time);
    }
}

