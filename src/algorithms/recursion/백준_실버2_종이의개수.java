package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 🎯 재귀 문제: 종이의개수 (백준 실버2)
// 💡 분할정복으로 3×3 격자 나누어 종이 개수 세기
// ⚡ 시간복잡도: O(N²), 공간복잡도: O(log N)
public class 백준_실버2_종이의개수 {

    static int[][] paper;
    static int zero = 0;
    static int one = 0;
    static int minusOne = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    // 📝 분할정복: 모두 같으면 카운트, 다르면 3×3으로 분할
    private static void recursion(int y, int x, int size) {
        if (isUniform(y, x, size)) {
            int v = paper[y][x];
            if (v == 0) zero++;
            if (v == 1) one++;
            if (v == -1) minusOne++;
            return;
        }
        
        // 3×3 격자로 분할
        int cut = size / 3;
        for (int dy = 0; dy < 3; dy++) {
            for (int dx = 0; dx < 3; dx++) {
                recursion(y + dy * cut, x + dx * cut, cut);
            }
        }
    }

    private static boolean isUniform(int y, int x, int size) {
        int con = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] != con) {
                    return false;
                }
            }
        }
        return true;
    }
} 