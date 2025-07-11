package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_실버_종이의개수 {

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

    private static void recursion(int y, int x, int size) {
        // 1) 종료 조건: 구역이 모두 같은 값이면 카운트하고 리턴
        if (isUniform(y, x, size)) {
            int v = paper[y][x];
            if (v ==  0) zero++;
            if (v ==  1) one++;
            if (v == -1) minusOne++;
            return;
        }
        // 2) 분할하기: 3×3 격자로
        int cut = size / 3;
        for (int dy = 0; dy < 3; dy++) {
            for (int dx = 0; dx < 3; dx++) {
                recursion(y + dy * cut, x + dx * cut, cut);
            }
        }
    }

    private static boolean isUniform(int y, int x, int size) {
        int con = paper[y][x];
        // 올바른 반복 범위: y 부터 y+size, x 부터 x+size
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
