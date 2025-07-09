package algorithms.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.*;

// 🎯 백트래킹 문제: 연산자끼워넣기 (백준 실버1)
// 💡 연산자 조합으로 최대값과 최소값 구하기
// ⚡ 시간복잡도: O(4^(N-1)), 공간복잡도: O(N)
public class 백준_실버1_연산자끼워넣기 {
    static int N;
    static int[] numbers;
    static int[] ops = new int[4]; // +, -, *, /
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 📝 연산자 개수: +, -, *, /
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        StringBuilder sb = new StringBuilder();
        sb.append(maxResult).append('\n').append(minResult);
        System.out.print(sb);
    }

    // 📝 백트래킹으로 모든 연산자 조합 탐색
    static void dfs(int idx, int current) {
        if (idx == N) {
            maxResult = Math.max(maxResult, current);
            minResult = Math.min(minResult, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) continue;
            ops[i]--; // 선택
            
            int next;
            switch (i) {
                case 0: next = current + numbers[idx]; break; // +
                case 1: next = current - numbers[idx]; break; // -
                case 2: next = current * numbers[idx]; break; // *
                default: next = current / numbers[idx]; break; // /
            }
            
            dfs(idx + 1, next);
            ops[i]++; // 백트래킹
        }
    }
} 