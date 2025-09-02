package datastructures.list.vector.stack;

import java.io.*;
import java.util.*;

public class 백준_골드5_탑 {
    // 스택에 (인덱스, 높이) 보관
    static class Tower {
        int idx, h;
        Tower(int idx, int h) { this.idx = idx; this.h = h; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());

            // 현재 탑보다 낮거나 같은 탑은 수신자 불가 → 제거
            while (!stack.isEmpty() && stack.peek().h <= h) stack.pop();

            int receiver = stack.isEmpty() ? 0 : stack.peek().idx;
            sb.append(receiver);
            if (i < N) sb.append(' ');

            stack.push(new Tower(i, h));
        }
        System.out.print(sb.toString());
    }
}
