package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 🎯 분할정복 문제: 쿼드트리 (백준 실버1)
// 💡 0과 1로 이루어진 영상을 압축하여 쿼드트리로 표현
// ⚡ 시간복잡도: O(N²), 공간복잡도: O(N²)
public class 백준_실버1_쿼드트리 {

    static char[][] table;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        table = new  char[n][n];

        for (int i = 0; i < n; i++) {
            table[i] = br.readLine().toCharArray();
        }
        recursion(0, 0, n);
        System.out.println(sb.toString());
    }

    private static void recursion(int y, int x, int size) {
        if (isUniform(y, x, size)) {
            if (table[y][x] == '0') {
                sb.append("0");
            } else {
                sb.append("1");
            }
            return;
        }
        int half = size / 2;
        sb.append("(");

        // 좌상 우상
        recursion(y, x, half);
        recursion(y, x +  half, half);

        // 좌하 우하
        recursion(y + half, x, half);
        recursion(y + half, x +  half, half);

        sb.append(")");
    }

    private static boolean isUniform(int y, int x, int size) {
        int cond = table[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (cond != table[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
} 